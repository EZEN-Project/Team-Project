<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax를 이용한 파일업로드 구현</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
 src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
 
 <style type="text/css">
 	.fileDrop{
 		width: 100%;
 		height: 200px;
 		border: 1px dotted red;
 	}
 	small{
 		cursor: pointer;
 	}
 
 </style>
 
</head>
<body>
<h1>Ajax를 이용한 파일업로드 구현</h1>
<div class="fileDrop"></div>
<div class="uploadedList">

</div>

<form action="">
	<input type="file">

</form>

<script type="text/javascript">
	$(document).ready(function() {
				
		$(".uploadedList").on("click", "small", function(event) {
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
						that.parent().parent().remove();
					}else{
						alert("삭제에 실패했습니다");
					}
				}
			});
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
			console.log(formData);
			
			$.ajax({
				type : 'post',
				url : 'ajaxtest',
				processData : false,
				contentType : false,
				data : formData,
				dataType : 'text',
				success : function(data) {
					var str = "";
					
					if(checkImgType(data)){
						str += "<div><a target='_blank' href='/displayFile?filename="+getImageLink(data)+"'><img src='/resources/upload"+data+"'></a>"
					}else{
						str+="<div><a href='/displayFile?filename="+getImageLink(data)+"'><img src='/resources/esc.png'></a>"
					}
					
					str += "<p>"+"<small data-src='"+data+"'>X</small> "+getOriginalName(data)+"</p>";
					str += "</div>";
					$(".uploadedList").append(str);
				}
			});
			
			
		});
		
		function getImageLink(data) {
			if(checkImgType(data)){
				var pre = data.substring(0, 12);
				var suf = data.substring(14);
				
				return pre + suf;
			}else{
				return data;
			}
		}
		
		function getOriginalName(data) {
			/* data로부터 원본파일명을 추출하여 반환하는 기능 */
			if(checkImgType(data)){
				var idx = data.indexOf("_");/*첫 번째 _의 인덱스  */
				idx = data.indexOf("_", idx+1)+1;/*첫 번째 _의 인덱스 다음부터 검색했을 때 나오는 _의 인덱스에 _ 다음에 있는 글자의 인덱스  */
				return data.substring(idx);
			}else{
				var idx = data.indexOf("_")+1;
				return data.substring(idx);
			}
		}
		
		function checkImgType(data) {
			var idx = data.lastIndexOf(".") + 1
			var type = data.substring(idx).toUpperCase();
			if(type == "PNG" || type == "JPG" || type == "JPEG" || type == "GIF"){
				return true;
			}else{
				return false;
			}
		}
		
		
	});


</script>
</body>
</html>