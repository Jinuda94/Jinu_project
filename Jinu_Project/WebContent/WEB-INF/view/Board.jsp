<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<style>
tr, th, td {
	text-align: center;
	padding: 10px;
}

tr {
	border-bottom: 1px solid rgb(199, 188, 188);
}

.b_top {
	border-top: 2px solid #3c4790;
	border-bottom: 1px solid #3c4790;
}

.n1 {
	width: 3%;
}

.n2 {
	width: 40%;
}

.n3, .n4 {
	width: 10%;
}

.n5 {
	width: 5%;
}

.paging {
	text-align: center;
}

.paging>ul {
	display: table;
	margin-left: auto;
	margin-right: auto;
}

.paging>ul>li {
	float: left;
	margin: 10px;
}

.search {
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<header>
			<nav id="menu1">
				<div class="inner">
					<p>진우의 만화세상</p>
					<c:if test="${sessionScope.User ne 1}">
						<ul>
							<li><a href="join">회원가입</a></li>
							<li><a href="login">로그인</a></li>
						</ul>
					</c:if>
					<c:if test="${sessionScope.User eq 1}">
						<ul>
							<li>${sessionScope.id}님환영합니다.</li>
							<li><a href="logout">로그아웃</a></li>
						</ul>
					</c:if>
				</div>
			</nav>
			<nav class="menu2">
				<div class="inner">
					<ul class="nav_li">
						<li><a href="main">Main</a></li>
						<li><a href="board">BOARD</a></li>
						<li><a href="naver">NAVER WEBTOON</a></li>
                        <li><a href="daum">DAUM WEBTOON</a></li>
					</ul>
				</div>
			</nav>
		</header>

		<section class="s_board inner">

			<!-- list -->

			<table class="board">
				<tr class="b_top">
					<th class="n1">번호</th>
					<th class="n2">제목</th>
					<th class="n3">작성자</th>
					<th class="n4">작성일</th>
					<th class="n5">조회수</th>
				</tr>
				<c:forEach var="n" items="${list}" varStatus="t">
					<tr>
						<th class="n1">${n.id}</th>
						<td class="n2"><a
							href="detail?id=${n.id}&f=${param.f}&q=${param.q}&p=${param.p}">${n.title}</a></td>
						<td class="n3">${n.writerID}</td>
						<td class="n4"><fmt:formatDate value="${n.regdate}"
								pattern="yyyy.MM.dd." /></td>
						<td class="n5"><fmt:formatNumber value="${n.hit}"
								type="number" pattern="###,###" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="button" onClick="writer('${sessionScope.User}')"
				value="글쓰기" />
			<script>		
					function writer(User){
						if(User == 1){
							location.href='write';
						}else{
							alert("로그인 후 글쓰기를 진행 할 수 있습니다.");
							location.href='login';
						}
					}	
				</script>
			<!-- 변수 선언 -->
			<c:set var="page" value="${empty param?1:param.p}"></c:set>
			<!-- param == 파라미터 -->
			<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
			<c:set var="lastNum"
				value="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>
			<!-- Math.ceil로 올림 substring으로 소수점 짜르기 -->

			<div class="paging">

				<!-- 페이지 이동 -->
				<ul>


					<!-- Prev 버튼 -->
					<li><c:if test="${startNum > 1}">
							<a href="?p=${startNum-1}&f=${param.f}&q=${param.q}">Prev</a>
							<!-- p:페이지 f:필드(타이틀) q:query(검색내용) -->
						</c:if> <c:if test="${startNum <= 1}">
							<a href="#" onclick="alert('첫번째 페이지 입니다.');">Prev</a>
						</c:if></li>
					<!-- 페이징 -->


					<c:forEach var="i" begin="0" end="4">
						<!-- 현재 보고있는 페이지 색깔변경 -->
						<c:if test="${param.p == (startNum+i)}">
							<c:set var="style" value="font-weight:bold; color:red;" />
						</c:if>
						<c:if test="${param.p != (startNum+i)}">
							<c:set var="style" value="" />
						</c:if>
						<c:if test="${(startNum+i) == 1 && param.p==null}">
							<c:set var="style" value="font-weight:bold; color:red;" />
						</c:if>

						<c:if test="${(startNum+i)<=lastNum}">
							<li><a style="${style}"
								href="?p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}</a></li>
						</c:if>

					</c:forEach>


					<!-- Next 버튼 -->
					<li><c:if test="${startNum+5 < lastNum}">
							<a href="?p=${startNum+5}&f=${param.f}&q=${param.q}">Next</a>
						</c:if> <c:if test="${startNum+5 >= lastNum}">
							<a href="#" onclick="alert('마지막 페이지 입니다.');">Next</a>
						</c:if></li>
				</ul>

			</div>
			<hr>
			<!--검색-->
			<div class="search">
				<form id="searchform">
					<select name="f">
						<option ${(param.f == "title")?"selected":""} value="title">제목</option>
						<option ${(param.f == "writer_id")?"selected":""}
							value="writer_id">글쓴이</option>
					</select> <label>검색어</label> <input type="text" name="q" value="${param.q}" />
					<input type="submit" value="Search" />
				</form>
			</div>

		</section>
	</div>

</body>
</html>