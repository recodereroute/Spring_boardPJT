<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test ="${n == 1}">
<div id = "op1">
	<table>
		<tr><th>ID(성별, 연령)</th><th>이력서</th><th>경력</th><th>학력</th></tr>
		<tr><td>AAa</td><td>AAa</td><td>AAa</td><td>AAa</td></tr>
	</table>
</div>
</c:if>
<c:if test ="${n == 2}">
<div id = "op2">
	<table>
		<tr><th>ID(성별, 연령)</th><th>이력서</th><th>경력</th><th>학력</th></tr>
		<tr><td>BBb</td><td>BBb</td><td>BBb</td><td>BBb</td></tr>
	</table>
</div>
</c:if>
<c:if test ="${n == 3}">
<div id = "op3">
	<table>
		<tr><th>ID(성별, 연령)</th><th>이력서</th><th>경력</th><th>학력</th></tr>
		<tr><td>CCc</td><td>CCc</td><td>CCc</td><td>CCc</td></tr>
	</table>
</div>
</c:if>