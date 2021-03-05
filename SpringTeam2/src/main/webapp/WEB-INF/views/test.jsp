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

<h1>1. 부트스트랩의 기본 구조</h1>

<div class="container-fluid">
	<div class="row">
		<h1>header에 주로 사용되는 구조: class= container-fluid</h1>
		<h1>world</h1>
	</div>
</div>
<hr>
<div class="container">
	<div class="row">
		<h1>본문에 주로 사용되는 구조: class= container</h1>
		<h1>world</h1>
	</div>
	
	<div class="row">
		<h1>hello</h1>
		<h1>world</h1>
	</div>
</div>

<hr>

<h1>2. grid system에 대한 설명</h1>

<h3>row는 12 칸으로 나누어진 한 줄이다.</h3>
<h3>저의 생일은 몇 월일까요?</h3>
<hr>
<h3>grid system에서는 디스플레이를 4 가지로 나눕니다.</h3>
<h3>분류 기준: 단말기의 크기</h3>
<h4>xs, sm, md, lg </h4>
<hr>
<div class="container">
	<div class="row">
		<input class="col-xs-6">
	</div>
</div>






</body>
</html>