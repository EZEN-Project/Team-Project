<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기(검색)</title>
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

	<form action="/sboard/delete" method="post">
		<input type="hidden" name="bno" value="${vo.bno}">
		<input type="hidden" name="curPage" value="${spt.curPage}">
		<input type="hidden" name="searchType" value="${spt.searchType}">
		<input type="hidden" name="keyword" value="${spt.keyword}">
				
	</form>

	<div class="container">
		<div class="row">
			<h1 class="jumbotron">글 자세히 보기(검색)</h1>
		</div>
		
		<div class="row">
			<div class="form-group">
				<label for="title">제목</label>
				<input class="form-control" readonly id="title" name="title" value="${vo.title}">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input class="form-control" readonly id="writer" name="writer" value="${vo.writer}">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="content">${vo.content}</textarea>
			</div>
		</div>
		
		<div class="row">
			<button id="read_btn_update" class="btn btn-warning">수정</button>
			<button id="read_btn_delete" class="btn btn-danger">삭제</button>
			<button class="btn">댓글</button>
			<button id="read_btn_list" class="btn btn-info">목록</button>
		</div><!--class=row  -->
		<hr>
	</div><!--class=container  -->
	<script type="text/javascript">
		$(document).ready(function() {
			$("div.row").on("click", "#read_btn_list", function() {
				location.assign("/sboard/list/${spt.searchType}/${spt.keyword}/${spt.curPage}");
			});
			
			$("div.row").on("click", "#read_btn_update", function() {
				location.assign("/sboard/update/${vo.bno}?searchType=${param.searchType}&keyword=${param.keyword}&curPage=${param.curPage}")
			});
			
			$("div.row").on("click", "#read_btn_delete", function() {
				$("form").submit();
			});
			
		});
	</script>
	
	
</body>
</html>