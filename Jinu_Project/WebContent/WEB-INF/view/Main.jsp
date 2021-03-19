<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="root" value="${pageContext.request.contextPath}"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.slider').bxSlider({
            	slideWidth: 1200,
            	touchEnabled : (navigator.maxTouchPoints > 0)
            });
        });
    </script>

<title>Main</title>
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
                        <li>${sessionScope.id}님 환영합니다.</li>
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
            <div class="inner">
	            <div id="h_div" class="slider">
	                <div><a href="daum"><img src="${root}/image/daum.jpg"></a></div>
	                <div><a href="naver"><img src="${root}/image/naver.jpg"></a></div>
	            </div>
            </div>
        </header>
        </div>

	

</body>
</html>