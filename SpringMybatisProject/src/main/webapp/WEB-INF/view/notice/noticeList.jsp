<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
</head>
<body>
<table width = "300" border="1">
	<tr><td>번호</td><td>제목</td><td>등록일</td><td>조회수</td></tr>
	<c:forEach items="${lists }" var = "dto" varStatus="cnt">
	<tr><td>${cnt.count }</td>
		<td><a href="noticeDetail?noticeNo=${dto.noticeNo}">${dto.noticeSub }</a></td>
		<td><fmt:formatDate value="${dto.noticeDate }" type="date" pattern="yyyy-MM-dd"/></td><td>${dto.noticeCount }</td></tr>
	</c:forEach>
</table>

<a href = "noticeForm">공지사항 등록</a>
</body>
</html>