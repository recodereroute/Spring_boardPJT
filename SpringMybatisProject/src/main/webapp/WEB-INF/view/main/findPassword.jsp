<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findPassword.jsp</title>
</head>
<body>
<form action="findPasswordPro" method="post" name = "frm">
	아이디 : <input type = "text" name="memId"/><br />
	이메일 : <input type = "email" name="memEmail"/><br />
	<input type = "submit" value = "비밀번호 찾기"/>
</form>
</body>
</html>