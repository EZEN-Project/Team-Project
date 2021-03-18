<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
	h1{
		text-align: center;
	}
	.navbar-brand{
		text-align: center;
	}

</style>
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="/WEB-INF/views/header/loginHeader.jsp"></jsp:include>
       	
    </div>
    <hr>
<div class="container">
	<div class="row">
		<h1 class="jumbotron">메인 페이지</h1>
	</div>
	<hr>
	<nav class="navbar navbar-default">
  <div class="container-fluid">
      <div class="navbar-header">

      <a class="navbar-brand" href="/sellboard/list">상품</a>
      <a class="navbar-brand" href="/qaboard/list">Q&A</a>
 
    </div>


  </div><!-- /.container-fluid -->
</nav>
<!-- carousel를 구성할 영역 설정 -->
<div style="width: 800px; padding-left: 350px;">
<!-- carousel를 사용하기 위해서는 class에 carousel와 slide 설정한다. -->
<!-- carousel는 특이하게 id를 설정해야 한다.-->
<div id="carousel-example-generic" class="carousel slide" >
<!-- carousel의 지시자 -->
<!-- 지시자라고는 하는데 ol태그의 class에 carousel-indicators를 넣는다. -->
<ol class="carousel-indicators">
<!-- li는 이미지 개수만큼 추가하고 data-target은 carousel id를 가르킨다. -->
<!-- data-slide-to는 순서대로 0부터 올라가고 0은 active를 설정한다. -->
<!-- 딱히 이 부분은 옵션별로 설정하게 없다. -->
<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
<li data-target="#carousel-example-generic" data-slide-to="1"></li>
</ol>
<!-- 실제 이미지 아이템 -->
<!-- class는 carousel-inner로 설정하고 role은 listbox에서 설정한다. -->
<div class="carousel-inner" role="listbox">
<!-- 이미지의 개수만큼 item을 만든다. 중요한 포인트는 carousel-indicators의 li 태그 개수와 item의 개수는 일치해야 한다. -->
<div class="item active">
<!-- 아미지 설정- -->
<img src="http://www.lamb.international/news/photo/201904/176_79_2716.jpg" style="width:100%">
<!-- 캡션 설정 (생략 가능) -->
<!-- 글자 색은 검은색 -->
<div class="carousel-caption" style="color:black;">

</div>
</div>
<div class="item">
<img src="https://img1.daumcdn.net/thumb/R720x0/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fliveboard%2Fwhatisthis%2Fec97bc77c1cd4be08d6267462c247713.JPG" style="width:100%">
<div class="carousel-caption" style="color:black;">

</div>
</div>
</div>
<!-- 왼쪽 화살표 버튼 -->
<!-- href는 carousel의 id를 가르킨다. -->
<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
<!-- 왼쪽 화살표 -->
<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
</a>
<!-- 오른쪽 화살표 버튼 -->
<!-- href는 carousel의 id를 가르킨다. -->
<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
<!-- 오른쪽 화살표 -->
<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
</a>
</div>
</div>
<script>
$(function(){
// 이미지 슬라이드 컨트롤를 사용하기 위해서는 carousel를 실행해야한다.
$('#carousel-example-generic').carousel({
// 슬리아딩 자동 순환 지연 시간
// false면 자동 순환하지 않는다.
interval: 3000,
// hover를 설정하면 마우스를 가져대면 자동 순환이 멈춘다.
pause: "hover",
// 순환 설정, true면 1 -> 2가면 다시 1로 돌아가서 반복
wrap: true,
// 키보드 이벤트 설정 여부(?)
keyboard : true
});
});
</script>




</div>
</body>
</html>