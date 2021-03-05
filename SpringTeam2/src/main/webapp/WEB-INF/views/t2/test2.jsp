<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<button>click</button>
		
	<script type="text/javascript">
		$(document).ready(function() {
			$("button").click(function() {
				$.ajax({
					type : 'post',
					url : "/rest/test2",
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'post'
					},
					
					data : JSON.stringify({
						test1 : "hello",
						test2 : "world",
						test3 : "good"
					}),
					dataType : 'text',
					success : function(result) {
						console.log(result);
						
						var obj = JSON.parse(result);
						console.log(obj["test3"]);
					}
				});
			});
		});
	
	
	
	</script>

</body>
</html>