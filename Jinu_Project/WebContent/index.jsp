<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

$(function () {

$('#btn-upload').click(function (e) {

e.preventDefault();

$('#file').click();

});

});

    

   

</script>



<style type="text/css">

#file { display:none; } 

</style>

<title>Insert title here</title>
</head>
<body>

<div>

<input type="file" id="file" name="file" onchange="changeValue(this)"/>

<button type="button" id="btn-upload">Image</button>

</div>
<a href="https://comic.naver.com/webtoon/list.nhn?titleId=759641&weekday=sun">오늘밤만재워줘</a>

</body>
</html>