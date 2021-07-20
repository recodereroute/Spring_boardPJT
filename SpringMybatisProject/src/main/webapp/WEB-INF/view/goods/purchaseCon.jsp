<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>purchaseCon.jsp</title>
</head>
<body>
<table border = 1 width = "800">
	<tr><td>주문일(결제번호)</td>
		<td>상품명/주문번호</td>
		<td>판매자</td>
		<td>주문상태</td></tr>
<c:forEach items="${list }" var="dto">
<!-- 이미지깨짐 , dto.paymentApprNum 안뜸 -->
	<tr><td>${dto.purchaseDate } / ${dto.paymentApprNum }</td>
		<td rowspan="2">
		<img width = "50" src="../goods/upload/${dto.prodImage.split(',')[0] }"/>
		<!-- src 시작위치는 웹페이지의 주소로 확인. 이 경우 특별히 들어와있는 위치가 없어서 웹컨텐츠로 해석 -->
		${dto.prodName} / ${dto.purchaseNum }</td>
		<td rowspan="2">${dto.prodSupplyer }</td>
		<td rowspan="2"><c:if test = "${dto.paymentApprNum == null}">
		<a href="paymentOk?purchNo=${dto.purchaseNum }&payPrice=${dto.purchaseTotPrice }">결제하기</a></c:if>
						<c:if test = "${dto.paymentApprNum != null}">결제완료<br />
							<c:if test="${dto.reviewContent == null }">
							<a href="goodsReview?purchaseNum=${dto.purchaseNum }&prodNum=${dto.prodNum}">리뷰작성</a>
							</c:if>
							<c:if test="${dto.reviewContent != null }">
								<a href="goodsReviewUpdate?purchaseNum=${dto.purchaseNum }&prodNum=${dto.prodNum}">리뷰수정</a>
							</c:if>
						</c:if>
		</td>
	</tr>
	<tr><td>결제금액 : ${dto.purchaseTotPrice }</td></tr>
</c:forEach>
</table>
</body>
</html>