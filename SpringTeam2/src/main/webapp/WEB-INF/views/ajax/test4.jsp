<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.domain.UserVO"%>
<%@page import="java.util.List"%>
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
	
<button>ajax를 이용해서 List타입 데이터 전송</button>

<%
	List<UserVO> list = new ArrayList<UserVO>();
	list.add(new UserVO("m001", "p001", "a"));
	list.add(new UserVO("m002", "p002", "b"));
	list.add(new UserVO("m003", "p003", "c"));
	
	ObjectMapper mapper = new ObjectMapper();
	String strList = mapper.writeValueAsString(list);
	pageContext.setAttribute("strList", strList);
%>


<script type="text/javascript">
	$(document).ready(function() {
		$("button").click(function() {
			
			$.ajax({
				type : "post",
				url : "/ajax/test4",
				data : {
					list : JSON.stringify(${strList})
				},
				dataType : "text",
				success : function(result) {
					var arr = JSON.parse(result);
					
					for(var i=0 ; i < arr.length ; i++){
						var obj = arr[i];
						
						for(x in obj){
							console.log(x, obj[x]);
						}
						
					}
				}
			});
			
		});
	});


</script>





</body>
</html>