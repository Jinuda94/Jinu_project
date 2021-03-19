<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<title>naver</title>
<style>
.col{
float:left;
width:150px;
border: 1px solid #f4f4f4;
text-align:center;
}
.col ul li{
  margin-bottom: 7px;
}
section a{
	font-size:13px;
}
section a span{
  display:block;
  overflow: hidden; 
  text-overflow: ellipsis;
  white-space: nowrap; 
  width: 150px;
}
</style>
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
		<section>
			<div class="list_con inner">
				<div class="col">
					<div class="col_inner">
						<h4>월요웹툰</h4>
						<ul>
							<c:forEach var="n" items="${m_list}" varStatus="t">
								<li>
									<div class="thumb">
										<a href="https://comic.naver.com${n.href}"><img src="${root}/naver/${n.img}" alt="${n.title}"> <span class="mask">${n.title}</span>
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col">
					<div class="col_inner">
						<h4>화요웹툰</h4>
						<ul>
							<c:forEach var="n" items="${tu_list}" varStatus="t">
								<li>
									<div class="thumb">
										<a href="https://comic.naver.com${n.href}"><img src="${root}/naver/${n.img}" alt="${n.title}"> <span class="mask">${n.title}</span>
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col">
					<div class="col_inner">
						<h4>수요웹툰</h4>
						<ul>
							<c:forEach var="n" items="${w_list}" varStatus="t">
								<li>
									<div class="thumb">
										<a href="https://comic.naver.com${n.href}"><img src="${root}/naver/${n.img}" alt="${n.title}"> <span class="mask">${n.title}</span>
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col">
					<div class="col_inner">
						<h4>목요웹툰</h4>
						<ul>
							<c:forEach var="n" items="${th_list}" varStatus="t">
								<li>
									<div class="thumb">
										<a href="https://comic.naver.com${n.href}"><img src="${root}/naver/${n.img}" alt="${n.title}"> <span class="mask">${n.title}</span>
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col">
					<div class="col_inner">
						<h4>금요웹툰</h4>
						<ul>
							<c:forEach var="n" items="${f_list}" varStatus="t">
								<li>
									<div class="thumb">
										<a href="https://comic.naver.com${n.href}"><img src="${root}/naver/${n.img}" alt="${n.title}"> <span class="mask">${n.title}</span>
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col">
					<div class="col_inner">
						<h4>토요웹툰</h4>
						<ul>
							<c:forEach var="n" items="${sa_list}" varStatus="t">
								<li>
									<div class="thumb">
										<a href="https://comic.naver.com${n.href}"><img src="${root}/naver/${n.img}" alt="${n.title}"> <span class="mask">${n.title}</span>
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col">
					<div class="col_inner">
						<h4>일요웹툰</h4>
						<ul>
							<c:forEach var="n" items="${su_list}" varStatus="t">
								<li>
									<div class="thumb">
										<a href="https://comic.naver.com${n.href}"><img src="${root}/naver/${n.img}" alt="${n.title}"> <span class="mask">${n.title}</span>
										</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>