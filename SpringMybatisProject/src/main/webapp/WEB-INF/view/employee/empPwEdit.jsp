<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empPwEdit.jsp</title>
</head>
<body>
	<form action="empPwUpdate" method="post">
	비밀번호 입력 : <input type = "password" name = "empPw" />
	<span>${errPw }</span>
	<input type = "submit" value="비밀번호 확인"/>
	</form>
</body>
</html>