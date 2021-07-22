<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardPost.jsp</title>
</head>
<body>
<form action="boardWrite" method="post" name = "frm">
	<table>
	<tr><td>제목</td><td><input type="text" name="noticeSub" /></td></tr>
	<tr><td>내용</td><td><textarea rows="6" cols="30" name="noticeCon" ></textarea></td></tr>
	<tr><td colspan=2>
		<input type="submit" value = "등록" />
		<input type="reset" value = "초기화" />
	</td></tr>
	</table>
</form>
</body>
</html>