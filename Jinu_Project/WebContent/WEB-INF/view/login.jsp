<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
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
					</ul>
				</div>
			</nav>
		</header>
	
			<form action="login" method="post">
			
				아이디: <input type="text" name="UserID"><br> 비밀번호: <input
					type="text" name="UserPassword"> <input type="submit"
					value="로그인">
			
			</form>
	
	</div>
</body>
</html>