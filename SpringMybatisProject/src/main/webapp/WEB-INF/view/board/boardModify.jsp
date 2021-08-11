<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardModify.jsp</title>
</head>
<body>
<form action="boardModify" method="post">

글 번호 : <input type = "text" value = "${dto.noticeNo }" name="noticeNo" readonly="readonly"/><br />
글 제목 : <input type = "text" value = "${dto.noticeSub }" name="noticeSub"/> <br />
글 내용 : <textarea rows="5" cols="35" name="noticeCon">${dto.noticeCon }</textarea><br />
등록일 : <fmt:formatDate value="${dto.noticeDate }" type="date" pattern="yyyy-MM-dd"/><br />
종류 : ${dto.noticeKind }<br />
조회수 : ${dto.noticeCount }<br />
등록한 사원번호: ${dto.employeeId }<br />
<input type="submit" value="수정 완료" />
<input type="button" value="게시글 삭제" onclick="javascript:location.href='boardDel?boardNo=${dto.noticeNo }'"/>
</form>
</body>
</html>