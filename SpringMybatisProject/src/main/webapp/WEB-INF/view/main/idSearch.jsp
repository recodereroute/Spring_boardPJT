<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idSearch.jsp</title>
</head>
<body>
<form action="idFindFinish" method="post">
	이름 : <input type = "text" name = "memName"/><br />
	이메일 : <input type = "email" name = "memEmail"/><br />
	연락처 : <input type = "text" name = "memPhone"/><br />
	<input type = "submit" value = "아이디 찾기"/>
</form>
</body>
</html>