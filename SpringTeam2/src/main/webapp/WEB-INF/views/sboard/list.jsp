<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 목록</title>
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

<div class="container">
		<div class="row">
			<h1 class="jumbotron">검색 목록</h1>                
		</div>
		
		<div class="row">
			<a class="btn btn-primary" href="/board/insert">글쓰기</a>
		</div>
		
		<div class="row">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${spt.list}" var="dto">
				<tr>
					<td>${dto.bno}</td>
					<td><a href="/sboard/read/${dto.bno}?curPage=${spt.curPage}&searchType=${spt.searchType}&keyword=${spt.keyword}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td> <fmt:formatDate pattern="yyyy/MM/dd" type="date" value="${dto.updateDate}"/> </td>
					<td>${dto.viewCnt}</td>
				</tr>
			</c:forEach>
		
		</tbody>
		
		
	</table>
		</div><!-- class = row -->
		
		<div class="row">
			<nav aria-label="Page navigation">
  				<ul class="pagination">
    				<li>
      					<a href="/sboard/list/${spt.searchType}/${spt.keyword}/${spt.curPage <= 1? 1 : spt.curPage-1}" aria-label="Previous">
        					<span aria-hidden="true">&laquo;</span>
      					</a>
    				</li><!-- "<<" -->
    				
    				<c:forEach var="idx" end="${spt.stopPageNum}" begin="${spt.beginPageNum}">
    				
    					<li class="${spt.curPage == idx ? 'active':'' }"><a href="/sboard/list/${spt.searchType}/${spt.keyword}/${idx}">${idx}</a></li>
    					
    				</c:forEach>
    				<li>
				      <a href="/sboard/list/${spt.searchType}/${spt.keyword}/${spt.curPage < spt.totalPage ? spt.curPage+1 : spt.totalPage }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li><!-- ">>" -->
    				
  				</ul>
			</nav>
		</div><!--class = row  -->
		

		<hr>
	</div><!--class = container  -->


</body>
</html>