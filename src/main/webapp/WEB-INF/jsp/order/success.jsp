<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

배송지정보

<div>${order.userNo.name} </div>
<div>${order.address} </div>
<div>${order.detailAddress} </div>
<div>${order.memo} </div>
<div>${order.totalPrice} </div>

				<div>${orderList.get(0).orderProduct.title}
					<c:if test="${orderList.size() -1 > 0}">외
								${orderList.size() -1} 건</c:if>
					</div>


 주문 상품 정보
<c:forEach items="${orderList}" var="ol">
	<div>
		<span>${ol.orderProduct.title}</span>
		<span>${ol.amount}</span>
		<span>${ol.price}</span>
	</div>
</c:forEach>
</body>

</html>