<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 없이 ajax 효과 내는 파일 업로드</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>ajax 없이 ajax 효과 내는 파일 업로드</h1>

	<form id="form1" target="zeroFrame" enctype="multipart/form-data"
		action="noajax" method="post">

		<input name="id"> <br> 
		<input type="file" name="file"><br> 
		<input type="submit">

	</form>

	<iframe name="zeroFrame"></iframe>


<script type="text/javascript">

	
	function addFilePath(msg) {
		alert(msg);
		//$("#form1").reset();
		document.getElementById("form1").reset();
	}


</script>



</body>
</html>