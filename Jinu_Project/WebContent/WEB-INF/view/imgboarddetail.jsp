<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>pid</th>
			<td>${ibo.pid}</td>
		</tr>
		<tr>
			<th>pname</th>
			<td>${ibo.pname}</td>
		</tr>
		<tr>
			<th>content</th>
			<td>${ibo.content}</td>
		</tr>
		<tr>
			<th>category</th>
			<td>${ibo.category}</td>
		</tr>
		<tr>
			<th>price</th>
			<td>${ibo.price}</td>
		</tr>
		<tr>
			<th>regdate</th>
			<td>${ibo.regdate}</td>
		</tr>
		<tr>
			<th>delFlag</th>
			<td>${ibo.delFlag}</td>
		</tr>
		<tr>
			<th>path</th>
			<td><img src="${root}${ibo.path}" />
				<p>${ibo.content}</p></td>
		</tr>
	</table>
	<br>
	<br>
	<c:if test="${comCount ne 0}">
		<table>
			<c:forEach var="c" items="${clist}">
			<tr>
				<td>${c.userid}</td>
				<td>${c.regdate}</td>
				<td>${c.comment}</td>
				<td>${c.score}</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
		<c:if test="${comCount eq 0}">
		<p>댓글이 없습니다.</p>
	</c:if>

	<form action="view" method="post">
		<div class="comment">
			<input type="text" name="comment" /> 
			<input type="hidden" name="pid" value="${param.pid}"/>
			<select name="s">
				<option ${(param.s=="5" )?"selected":""} value="5">5</option>
				<option ${(param.s=="4" )?"selected":""} value="4">4</option>
				<option ${(param.s=="3" )?"selected":""} value="3">3</option>
				<option ${(param.s=="2" )?"selected":""} value="2">2</option>
				<option ${(param.s=="1" )?"selected":""} value="1">1</option>
			</select>
			<input type="submit" value="입력" />
		</div>
	</form>

</body>
</html>