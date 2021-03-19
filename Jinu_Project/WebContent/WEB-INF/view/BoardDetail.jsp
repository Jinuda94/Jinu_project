<%@ page import="beans.Board"%>
<%@page import="java.util.List"%>
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
<c:set var="root" value="${pageContext.request.contextPath}"/>
<style>
.view_head{
	border-bottom: 1px solid #eee;
	width:99%;
	height:50px;
}
.view_head .fl{
	float:left;
}
.view_head .fr{
	float:right;
}
.view_head .writer,.view_head .count,.view_head .reply{
	border-right: 1px solid #eee;
	padding:0px 10px 0px 0px;
}
.view_content{
	border-bottom: 1px solid #eee;
	margin: 10px 0px 10px 0px;
	padding: 10px;
}
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
.view_content .con_img{
	width:100%;
	overflow:visible;
	
}
.view_content .con_img img{
	magin: 0 auto;
}

</style>
<title>BoardDetail</title>
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
			<div class="inner">
				<div class="view_head">
					<h3>${bo.title}</h3>
					<div class="fl">
						<span class="writer">${bo.writerID}</span>
						<span class="date"><fmt:formatDate value="${bo.regdate}"
									pattern="yyyy.MM.dd. hh:mm" /></span>
					</div>
					<div class="fr">
						<span class="count">조회 <fmt:formatNumber value="${bo.hit}" type="number"
									pattern="###,###" /></span>
						<span class="reply">추천</span>
						<span class="comment"><a href="#comment">댓글 ${count}</a></span>
					</div>
				</div>
				<hr>
				<div class="view_content">
					<div>
						<c:forTokens var="fileName" items="${bo.files}" delims="," varStatus="t">
							<div class="con_img">
								<img src="${root}/photo/${fileName}">
							</div>
						</c:forTokens>
						<p>${bo.content}</p>
						<form action="detail">
							<input type="hidden" value="${sessionScope.id}"/>
							<button type="button">추천</button>
						</form>
					</div>
				</div>
				<!-- 목록 버튼 -->
				<input type="button"
					onclick="location.href='board?f=${param.f}&q=${param.q}&p=${empty param.p?1:param.p}'"
					value="목록">

				<!-- 글삭제 버튼 -->
				<script>
					function checkYN() {
						let yn = confirm("정말 삭제하시겠습니까?");
						console.log(yn);
						if (yn == true) {
							alert('글이 삭제되었습니다.');
							document.getElementById("delite").submit();
						} else {
							alert('글삭제를 취소합니다.');
						}
					}
				</script>
				<c:if test="${sessionScope.id == (bo.writerID)}">
					<input type="button" onclick="checkYN()" value="글삭제" />
				</c:if>
				<form id="delite" action="board">
					<input type="hidden" name="id" value="${id}" />
				</form>

				<!-- 댓글 -->
				<div id="comment">
					<div class="comment_main">
						<c:set var="cnt" value="${count}" />
						<c:if test="${cnt == 0}">
							<p>댓글이 없습니다.</p>
						</c:if>
						<c:if test="${cnt != 0}">
							<c:forEach var="n" items="${bc}">
								<div class="c_box">
									<div class="c_writer"><span>${n.writerID}</span></div>
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
			</div>
		</section>
	</div>
</body>
</html>