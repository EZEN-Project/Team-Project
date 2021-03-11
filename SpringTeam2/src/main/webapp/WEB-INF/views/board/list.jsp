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
	<div class="container-fluid">
		<div class="row text-right">
		<c:choose>
			<c:when test="${empty login}">
			<a href="/member/login">로그인</a>
			</c:when>
			<c:otherwise>
			<span>${login.id}님, 환영합니다.</span><a href="/member/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
			
		</div>
	</div>
	<hr>
	<div class="container">
		<div class="row">
			<h1 class="jumbotron">게시글 목록</h1>                
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
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bno}</td>
					<td><a href="/board/read/${dto.bno}?curPage=${to.curPage}">${dto.title} [${dto.replyCnt}]</a></td>
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
      					<a href="/board/list/${to.curPage <= 1? 1 : to.curPage-1}" aria-label="Previous">
        					<span aria-hidden="true">&laquo;</span>
      					</a>
    				</li><!-- "<<" -->
    				
    				<c:forEach var="idx" end="${to.stopPageNum}" begin="${to.beginPageNum}">
    				
    					<li class="${to.curPage == idx ? 'active':'' }"><a href="/board/list/${idx}">${idx}</a></li>
    					
    				</c:forEach>
    				<li>
				      <a href="/board/list/${to.curPage < to.totalPage ? to.curPage+1 : to.totalPage }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li><!-- ">>" -->
    				
  				</ul>
			</nav>
		</div><!--class = row  -->
		
		<div class="row">
			<div class="input-group">
				<span class="input-group-addon">
					<select id="searchSel">
						<optgroup label="검색 기준">
							<option value="writer">작성자</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
						</optgroup>
					</select>
				</span>
				
		        <input id="keyword" type="text" class="form-control" placeholder="검색어를 입력하세요">
		        
		        <span class="input-group-btn">
		           <button id="searchBtn" class="btn btn-default" type="button">검색</button>
		        </span>
	   		 </div><!-- /input-group -->
			
		</div><!--class = row  -->
		<hr>
	</div><!--class = container  -->
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#searchBtn").click(function() {
				var searchType = $("#searchSel option:selected").val();
				var keyword = $("#keyword").val();
				var url = "/sboard/list/"+searchType+"/"+keyword+"/1";
				window.open(url);
			});
		});
	</script>
	
</body>
</html>