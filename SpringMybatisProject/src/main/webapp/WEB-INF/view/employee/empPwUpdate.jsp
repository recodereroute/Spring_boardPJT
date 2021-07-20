<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empPwUpdate.jsp</title>
</head>
<body>
	<form:form action="empPwUpdateOk" method="post" modelAttribute="EmployeeCommand">
		현재 비밀번호 : <input type="password" name="oldPw"/>
					<form:errors path = "oldPW"/><br />
		변경 비밀번호 : <input type="password" name="empPw"/>
					<form:errors path = "empPw"/><br />
		변경 비밀번호 확인 : <input type="password" name="empPwCon"/>
						<form:errors path = "empPwCon"/><br />
		<input type="submit" value="비밀번호 변경"/>
	</form:form>
</body>
</html>