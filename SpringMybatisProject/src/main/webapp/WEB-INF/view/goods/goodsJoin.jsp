<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파일전송할때는 무조건 post -->
<!-- enctype 설정 안하면 기본적으로 www 형식으로 날라감. -->
<form:form action="goodsJoin" method="post" name="frm" enctype="multipart/form-data" modelAttribute="goodsCommand">
	<table border = 1 align = "center">
		<tr><th>상품 번호</th>
			<td><select name = "ctgr">
					<option value = "wear">의류</option>
					<option value="cosmetic">화장품</option>
					<option value= "food">음식</option>
					<option value = "car">자동차용품</option>
				</select>
				<input type = "text" name ="prodNum" value = "${prodNum }" readonly="readonly">
				</td></tr>
		<tr><th>상품명</th>
			<td><input type = "text" name ="prodName"/></td></tr>
		<tr><th>가격</th>
			<td><input type = "text" name ="prodPrice"/></td></tr>
		<tr><th>용량</th>
			<td><input type = "text" name ="prodCapacity"/></td></tr>
		<tr><th>공급처</th>
			<td><input type = "text" name ="prodSupplyer"/></td></tr>
		<tr><th>배송비</th>
			<td><input type = "number" name ="prodDelFee" min="0" step="1"/></td></tr>
		<tr><th>추천여부</th>
			<td>
				<input type = "radio" name ="recommend" value="Y" checked/>추천
				<input type = "radio" name ="recommend" value="N"/>비추천
			</td></tr>
		<tr><th>내용</th>
			<td><textarea rows="6" cols="50" name="prodDetail"></textarea></td></tr>
		<tr><th>파일</th>
			<td><input type = "file" name ="prodImage" multiple="multiple"/><br />
			</td></tr>
		<tr><th colspan="2">
			<input type="submit" value="상품등록"/>
			<input type="reset" value="취소"/>
			<input type="button" value="홈으로"
				onclick="javascript:location.href='main'"/>
			</th></tr>
	</table>
</form:form>
</body>
</html>