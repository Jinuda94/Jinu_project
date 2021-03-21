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
<title>daum</title>
<style>
.comment_main{
	margin-top: 10px;
	border-top: 2px solid #3c4790;
	border-bottom: 2px solid #3c4790;
	padding: 10px;
	text-align:center;
}
.c_box{
	border-bottom: 2px solid #eee;
}

.c_writer{
	float:left;
	padding: 5px 5px 10px 5px;
}
.c_txt{
	float:left;
	padding: 5px;
}
.c_date{
	float:right;
	padding: 5px;
}
.comment_write{
	margin-top: 10px;
	border-top: 2px solid #3c4790;
	border-bottom: 2px solid #3c4790;
}
.form_box{
	margin:10px;
}
.comment_write textarea{
	width: 70%;
	height: 100px;
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
				<!-- 댓글 -->
				<div id="comment" class="inner">
					<div class="comment_main">
						<c:set var="cnt" value="${count}" />
						<c:if test="${cnt == 0}">
							<p>댓글이 없습니다.</p>
						</c:if>
						<c:if test="${cnt != 0}">
							<c:forEach var="n" items="${w_list}">
								<div class="c_box">
									<div class="c_writer"><span>${n.UserID}</span></div>
									<div class="c_txt"><p>${n.comment}</p></div>
									<div class="c_date"><span>${n.regdate}</span></div>
									<hr>
								</div>
							</c:forEach>
						</c:if>
					</div>
					<div class="comment_write">
						<form id="c_form" action="detail" method="post">
							<div class="form_box">
								<input type="hidden" name="pageID" value="${param.id}" /> 
								<c:if test="${sessionScope.User eq 1}">
									<span>${sessionScope.id}</span>
								</c:if>
								<c:if test="${sessionScope.User ne 1}">
									<span>로그인이 필요합니다.</span>
								</c:if>
								<textarea id="txtArea" name="comment" style="resize: none;" onkeypress="onTestChange();"></textarea>
								<script>
									function onTestChange() {
									    var key = window.event.keyCode;
									
									    // If the user has pressed enter
									    if (key === 13) {
									        document.getElementById("txtArea").value = document.getElementById("txtArea").value";
									        return false;
									    }
									    else {
									        return true;
									    }
									}
								</script>
								<button type="button" onclick="c_button('${sessionScope.User}')" >등록</button>
								<script>
									function c_button(User){
										if(User==1){
											document.getElementById("c_form").submit();
										}else{
											alert("로그인 후 등록가능합니다.")
										}
									}
								</script>
							</div>
						</form>
					</div>
				</div>
		</section>
	</div>
</body>
</html>