<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 화면</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
 src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script src="/resources/js/upload.js" type="text/javascript"></script>
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
   
   p.oriName{
      margin-top: 10px;
   }
   
   .delbtn{
      cursor: pointer;
   }
</style>


</head>
<body>
   <div class="container">
      <div class="row">
         <h1 class="jumbotron">수정 화면</h1>
      </div><!--class="row"  -->
      
      <div class="row">
         <form action="/board/update" method="post">
            <div class="form-group">
               <label for="bno">글번호</label>
               <input value="${vo.bno}" id="bno" name="bno" class="form-control" readonly>
            </div>
            
            <div class="form-group">
               <label for="writer">작성자</label>
               <input value="${vo.writer}" id="writer" name="writer" class="form-control">
            </div>
            
            <div class="form-group">
               <label for="title">제목</label>
               <input value="${vo.title}" id="title" name="title" class="form-control">
            </div>
            
            <div class="form-group">
               <label for="content">내용</label>
               <textarea id="content" name="content" class="form-control">${vo.content }</textarea>
            </div>
         
         </form>
         
         <div class="form-group">
            <label>업로드할 파일을 드랍하세요</label>
            <div class="fileDrop">
            
            </div>
            
            <ul class="clearfix uploadedList">
            <!-- 
               <li class="col-xs-3">
                  <div>
                     <a href="/board/list"><img src="/resources/esc.png"></a>
                     <p class="oriName"><span data-src='data' class="glyphicon glyphicon-trash delbtn" aria-hidden="true"></span> 기타파일</p>
                  </div>
               </li>
                -->
            </ul>
            
         </div>
         
         
         <div class="form-group">
            <button class="btn btn-warning" id="update_btn_update">수정</button>
            <button id="update_btn_back" class="btn btn-default">되돌아가기</button>
         </div>
         
         
      </div><!--class="row"  -->
      
      
   </div><!--class="container"  -->
   <script type="text/javascript">
      $(document).ready(function() {
         var bno = ${vo.bno};
         
         
         $(".uploadedList").on("click", ".delbtn", function() {
            var isOk = confirm("[수정]버튼이나 [되돌아가기]버튼과 상관없이 첨부파일이 삭제됩니다.");
            
            if(isOk){
               var that = $(this);
               
               $.ajax({
                  type : 'post',
                  url : '/deleteFile',
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
         
         
         $.getJSON("/board/getAttaches/"+bno, function(result) {
            var str = '';
            
            $(result).each(function() {
               var data = this;
               str += makeHtmlCode(data);
            });
            
            $(".uploadedList").html(str);
            
         });
         
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
               url : '/ajaxtest',
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
      });
   
   
   </script>

</body>
</html>