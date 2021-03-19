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
<title>Insert title here</title>
</head>
<body>
	<div>
	zzzzzzzzzzzzz
		<table border="1">
			<c:forEach var="p" items="${plist}">
				<tr>
					<th>pid</th>
					<td>${p.pid}</td>
				</tr>
				<tr>
					<th>pname</th>
					<td>${p.pname}</td>
				</tr>
				<tr>
					<th>path</th>
					<td><a href="view?pid=${p.pid}">
					<img src="${root}${p.path}"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>