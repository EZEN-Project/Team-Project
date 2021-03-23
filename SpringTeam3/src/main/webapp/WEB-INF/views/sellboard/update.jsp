<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 게시글 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
 src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
 <script
 src="/resources/js/upload.js" type="text/javascript"></script>
 
 <style type="text/css">
 	   .fileDrop{
      width: 100%;
      height: 200px;
      border: 1px dotted red;
      margin: auto;
   }

   .uploadedList li{
      list-style: none;
      margin-top: 20px;
   }
 
 </style>
 
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="/WEB-INF/views/header/loginHeader.jsp"></jsp:include>
       	
    </div>
<div class="container">

    <hr>
	<div class="row">
		<h1 class="jumbotron">상품 게시글 수정</h1>
	</div>
	
	<div class="row">
		<form action="/sellboard/update" method="post">
			<div class="form-group">
               <input type="hidden" value="${vo.bnum}" id="bnum" name="bnum" class="form-control" readonly>
            </div>
		
		
			<div class="input-group">
			  <span class="input-group-addon" id="title">제목</span>
			  <input  name="title" id="title" type="text" class="form-control" aria-describedby="basic-addon1" value="${vo.title }">
			</div><p>
			
			<div class="input-group">
			  <span class="input-group-addon" id="writer">작성자</span>
			  <input name="writer" id="writer" type="text" class="form-control" aria-describedby="basic-addon1" readonly value="${vo.writer }">
			</div><p>
			
			<div class="input-group">
			  <span class="input-group-addon" id="cost">원가</span>
			  <input name="cost" id="cost" type="text" class="form-control"  aria-describedby="basic-addon1" value="${vo.cost }">
			</div><p>
			
			<div class="input-group">
			  <span class="input-group-addon" id="price">판매가</span>
			  <input name="price" id="price" type="text" class="form-control"  aria-describedby="basic-addon1" value="${vo.price }">
			</div><p>
			
			<div class="input-group">
			  <span class="input-group-addon" id="bcount">상품수량</span>
			  <input name="bcount" id="bcount" type="text" class="form-control"  aria-describedby="basic-addon1" value="${vo.bcount }">
			</div><p>
			
			<div class="input-group">
			  <span class="input-group-addon" id="content">상세설명</span>
			  <textarea rows="5"  class="form-control" id="content" name="content">${vo.content }</textarea>
			</div><p>
				
		</form>
		
		
				<div class="form-group">
		            <label>썸네일파일을 올려주세요</label>
		            <div class="fileDrop"></div>  
		            <ul class="clearfix uploadedList"></ul>
				</div>
     		    
     		    
     		
				
				         <div class="form-group">
				            <button class="btn btn-warning" id="update_btn_update" type="submit">수정완료</button>
				            <button id="update_btn_back" class="btn btn-default">되돌아가기</button>
				         </div>
	</div>
	
</div>


<script type="text/javascript">
	$(document).ready(function(){

		
        $(".fileDrop").on("dragenter dragover", function(event) {
            event.preventDefault();
         });
         
         $(".fileDrop").on("drop", function(event) {
            event.preventDefault();
            
            var files = event.originalEvent.dataTransfer.files;
            var file = files[0];
            
            var formData = new FormData();
            formData.append("file", file);
            
            $.ajax({
               type : 'post',
               url : '/sellboard/upload',
               processData : false,
               contentType : false,
               data : formData,
               dataType : 'text',
               success : function(data) {
                  var str = makeHtmlCode(data);
                  
                  $(".uploadedList").append(str);
               }
            });
            
         });
		
		 $("#update_btn_update").click(function() {
			 var title = $("input[name=title]").val();
				var cost = $("input[name=cost]").val();
				var price = $("input[name=price]").val();
				var bcount = $("input[name=bcount]").val();
				var content = $("textarea[name=content]").val();
				
				
				if(!title){ 
					alert("제목을 작성해주세요.");
					$("#title").focus();
					$("#title").select();
					event.preventDefault();
					return;
				} else if (!cost) {
					alert("원가를 입력해주세요.");
					$("#cost").focus();
					$("#cost").select();
					event.preventDefault();
					return;
				} else if (cost > 100000000) {
					alert("원가는 1억이상으로 설정할 수 없습니다.");
					$("#cost").focus();
					$("#cost").select();
					event.preventDefault();
					return;
				} else if (!price) {
					$("#price").focus();
					$("#price").select(); 
					alert("판매가격을 입력해주세요.");
					event.preventDefault();
					return;
				}else if (price > 100000000) {
						alert("판매가격은 1억이상으로 설정할 수 없습니다.");
						$("#price").focus();
						$("#price").select();
						event.preventDefault();
						return;
				} else if (!bcount) {
					alert("상품수량을 입력해주세요.");
					$("#bcount").focus();
					$("#bcount").select();
					event.preventDefault();
					return;
				} else if (bcount > 100000000) {
					alert("수량은 1억이상으로 설정할 수 없습니다.");
					$("#bcount").focus();
					$("#bcount").select();
					event.preventDefault();
					return;
				} else if(!content){
					alert("상세설명을 입력해주세요.");
					$("#content").focus();
					$("#content").select();
					event.preventDefault();
					return;
				} else if(isNaN(bcount)){// 문자 입력 체크
					alert("판매개수는 숫자만 입력할 수 있습니다.");
					$("#bcount").select();
					event.preventDefault();
					return;			
				} else if(isNaN(cost)){// 문자 입력 체크
					alert("원가는 숫자만 입력할 수 있습니다.");
					$("#cost").select();
					event.preventDefault();
					return;			
				} else if(isNaN(price)){// 문자 입력 체크
					alert("판매가격은 숫자만 입력할 수 있습니다.");
					$("#price").select();
					event.preventDefault();
					return;			
				}				        
			 	 
			 
		             var str = "";
		             $(".delbtn").each(function(index) {
		                var data = $(this).attr("data-src");
		                str += "<input name= 'files["+index+"]' type = 'hidden' value='"+data+"'>";
		             });
		             
		             $("form").append(str);
		             
		             $("form").submit();
		          });
		
		 $("#update_btn_back").click(function() {
	            history.back();
	         });
		 
         $(".uploadedList").on("click", ".delbtn", function() {
             var isOk = confirm("[수정]버튼이나 [되돌아가기]버튼과 상관없이 첨부파일이 삭제됩니다.");
             
             if(isOk){
                var that = $(this);
                
                $.ajax({
                   type : 'post',
                   url : '/sellboard/deleteFile',
                   data : {
                      fileName : that.attr("data-src")
                   },
                   dataType : 'text', 
                   success : function(result) {
                      if(result == 'o'){
                         that.parent().parent().parent().remove();
                         
                         $.ajax({
                            type : 'post',
                            url : '/board/deleteFile',
                            data : {
                               fileName : that.attr("data-src")
                            },
                            dataType : 'text',
                            success : function(result) {
                               alert(result);
                            }
                         });         
                         
                      }else{
                         alert("삭제 실패했습니다.");
                      }
                   }          
                });
             }
             
          });
		
         
	});
	
	
	

</script>
</body>
</html>