<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script src="/resources/js/cart.js?vs=0.36" type="text/javascript"></script>
</head>
<body>
	<div class="row text-right">
		<c:choose>
			<c:when test="${empty login}">
				<a href="/member/login">로그인</a>
			</c:when>
			<c:otherwise>
				<span><a href="/member/read">${login.name}</a> 님, 환영합니다.</span>
				<a href="/member/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
<!-- 장바구니 버튼 -->
		<a href="/cart/list">
		<button class="btn btn-primary btn-md goCart" type="button">
			<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
		 	 장바구니 <span id="cartCount" class="badge"></span>
		</button></a>
<!-- 마이페이지 버튼 -->		

		<a href="#"><button class="btn btn-primary btn-md" type="button">
			<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
		 	 마이페이지
		</button></a>	
	
	</div><!-- row -->
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="/">HOME</a></li>
		  	<li><a href="/sellboard/list">쇼핑</a></li>
			<li class="${empty login ? 'hidden' : ''}"><a onclick="addPoint()">포인트추가(추후삭제)</a></li>
			<li class="${empty login ? 'hidden' : ''}"><a href="">구매내역</a></li>
		</ol>
	</div>

<script type="text/javascript">
	$(document).ready(function() {
		var name ='${login.name}';
		console.log(name);
		if(name != ""){
			getCartCount();
		}
		
		// 포인트 충전(Test)
		function addPoint(){
			var point = prompt("충전 포인트입력");
			if(!isNaN(point)){	// 숫자입력값인지 검사
				$.getJSON("/member/addPoint/"+ point, function(map){
					alert("현재 포인트: "+map.point);
					console.log(map.point);
				});
			}else{
				alert("공백/음수/문자는 입력불가");
			}
		}// 나중에 삭제
	});

</script>

</body>
</html>