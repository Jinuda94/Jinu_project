<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/login.css">
<title>Insert title here</title>
<script type="text/javascript" src="${root}/js/signUp.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
.menu2 .nav_li li{
	color:white;
}
#wrap{
	background-image: url(image/bg2.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
.form-wrap{
	border:1px solid #fff;
	border-radius: 50px;
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
        <section class="inner">
            <div class="form-wrap">
                <div class="button-wrap">
                    <div id="btn"></div>
                    <button type="button" class="togglebtn" onclick="login()">LOG IN</button>
                    <button type="button" id="sign" class="togglebtn" onclick="register()">REGISTER</button>
                    <c:if test="${jf eq 1}">
                    	<script>
							jQuery(function(){
							   jQuery('#sign').click();
							});
						</script>
                    </c:if>
                </div>
                <div class="social-icons">
                    <img src="image/facebook_icon-icons.com_53612.png" alt="facebook">
                    <img src="image/kakaotalk_logo_icon_147272.png" alt="twitter">
                    <img src="image/naver_icon-icons.com_61634.png" alt="google">
                </div>
                <form id="login" action="login" class="input-group"  method="post">
                    <input type="text" class="input-field" name="UserID" placeholder="User ID" required>
                    <input type="password" class="input-field" name="UserPassword" placeholder="Enter Password" required>
                    <input type="submit" class="submit" value="Login">
                </form>
                <form id="register" name="joinform" class="input-group" action="join" method="post" onsubmit="return createFrom(this)">
                    <input type="text" class="input-field" name="UserID" placeholder="User ID(only English and num)" required>
                    <button type="button" class="submit" onclick="idCheck(joinform, '${root}')" >중복확인</button>  
                    <input type="password" class="input-field" name="UserPassword" placeholder="Enter Password" required>
                    <input type="password" class="input-field" name="UserPasswordCheck" placeholder="Re Enter Password" required>
                    <input type="text" class="input-field" name="UserName" placeholder="Your Name" required>
                    <input type="email" class="input-field" name="UserEmail" placeholder="Your Email" required>
                    <input type="tel" class="input-field" name="UserTel" placeholder="Your tel  ex)010-0000-0000" required>
                    <label class="gender" for="UserGender">
                        <input type="radio" name="UserGender" value="male" checked> male
                    </label>
                    <label class="gender" for="UserGender">
                        <input type="radio" name="UserGender" value="female"> female
                    </label>
                    <p class="under"></p>
                    <input type="submit" class="submit" value="Sign up">
                </form>
              </div>
        </section>
    </div>
    <script>
        var x = document.getElementById("login");
        var y = document.getElementById("register");
        var z = document.getElementById("btn");
    
        function login(){
            x.style.left = "50px";
            y.style.left = "450px";
            z.style.left = "0";
        }

        function register(){
            x.style.left = "-400px";
            y.style.left = "50px";
            z.style.left = "110px";
        }
    </script>
</body>
</html>