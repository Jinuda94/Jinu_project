<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<style>
section{
		text-align:center;
}
section table{
	border: 1px solid black;
	margin: 10px auto;
}
th,tr,td{
	border: 1px solid black;
	padding: 10px;
}
th{
	width:5%;
}
td{
	width:50%;
}
.i_title{
	border: none;
	width:100%;
}
.content{
	width:100%;
	height:450px;
}
tr:last-child{
	height:500px;
}
.left{
	text-align:left;
}

</style>
<title>글쓰기</title>
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


		<!-- --------------------------- main --------------------------------------- -->
		<section>
			<div class="inner">
			<h2 class="title">글쓰기</h2>
			<!-- <form method="post" action ="reg" enctype="application/x-www-form-urlencoded"> -->
			<form method="post" action="write" enctype="multipart/form-data" id="con">
				<table>
					<tbody>
						<tr>
							<th>제목</th>
							<td colspan="3"><input type="text" name="title" class="i_title" /></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td  class="left" colspan="3"><input type="file" name="file" id="fileid"
								accept="image/*" onchange="setThumbnail(event);"/> <input type="hidden"
								name="file_flag" id="flag" value="1"></td>

						</tr>
						<tr>
							<th>첨부파일</th>
							<td  class="left" colspan="3"><input type="file" name="file" id="fileid"
								accept="image/*" onchange="setThumbnail(event);"/></td>
						</tr>
						
						<tr>
							<td colspan="4"><textarea id="txtArea" style="resize: none;" class="content" name="content" onkeypress="onTestChange();"></textarea>							
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
							</script></td>

						</tr>
					</tbody>
				</table>
				<input type="button" onclick="fileCheck()" value="등록" /> <a href="board">취소</a>
						<script>
							function fileCheck(){

								var fileCheck = document.getElementById("fileid").value;
								if (!fileCheck) {
									document.getElementById("flag").value = "2";
									document.getElementById("con").submit();
								}else{
									document.getElementById("con").submit();
								}
							}
							
							function setThumbnail(event) { 
								var reader = new FileReader();
							 
								reader.onload = function(event) { 
									var img = document.createElement("img"); 
									img.setAttribute("src", event.target.result);
									document.querySelector("div#image_container").appendChild(img); 
								}; 
								
								reader.readAsDataURL(event.target.files[0]); 
							}
						</script>
			</form>
			</div>
		</section>

	</div>
</body>
</html>