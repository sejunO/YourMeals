<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

배송지정보

<div>${order.userNo.name} </div>
<div>${order.address} </div>
<div>${order.detailAddress} </div>
<div>${order.memo} </div>


 주문 상품 정보
<c:forEach items="${orderList}" var="ol">
	<div>
		<span>${ol.productNo.content}</span>
		<span>${ol.amount}</span>
		<span>${ol.price}</span>
	</div>
</c:forEach>
</body>

</html>