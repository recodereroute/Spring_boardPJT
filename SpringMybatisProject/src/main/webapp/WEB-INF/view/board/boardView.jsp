<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeView.jsp</title>
</head>
<body>
글 번호 : ${dto.noticeNo }<br />
글 제목 : ${dto.noticeSub }<br />
글 내용 : ${dto.noticeCon }<br />
등록일 : <fmt:formatDate value="${dto.noticeDate }" type="date" pattern="yyyy-MM-dd"/><br />
종류 : ${dto.noticeKind }<br />
조회수 : ${dto.noticeCount }<br />
등록한 사원번호: ${dto.employeeId }<br />
<a href = "boardUpdate?boardNo=${dto.noticeNo }">수정</a>
</body>
</html>