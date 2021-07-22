<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/includeTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>libModify.jsp</title>
</head>
<body>
<form action="libModify" method="post" name="frm">
	<input type="hidden" value="${dto.noticeNo }" name ="noticeNo"/>
	글 번호 : ${dto.noticeNo }<br />
	제목 : <input type = "text" value = "${dto.noticeSub }" name = "noticeSub"/><br />
	내용 : <textarea rows="5" cols="35" name="noticeCon">${dto.noticeCon }</textarea><br />
	
	등록일 : ${dto.noticeDate }<br />
	조회수 : ${dto.noticeCount }<br />
	작성자 : ${dto.employeeId }<br />
	<input type = "submit" value = "수정 완료" />
	<input type = "button" value = "삭제" 
		onclick = "javascript:location.href='libDel?noticeNo=${dto.noticeNo}'"/>
</form>
</body>
</html>