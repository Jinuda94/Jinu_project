<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 체크</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	<c:if test="${check ne 0}">
		<div align="center"> 
			이미 사용중인 아이디입니다.
			<form action="IDcheck" method="get">
				<input type="text" name="UserID"/>
				<input type="submit" value="확인"/>
			</form>
		</div>
	</c:if>

	<c:if test="${check eq 0}">
		<div align="center"> 
			사용 가능한 아이디입니다.
		</div>
		<script type="text/javascript">
			opener.joinform.UserID.value="${id}";
		</script>	
	</c:if>
	
	<div align="center">
		<a href="javascript:self.close();">닫기</a>
	</div>
</body>
</html>