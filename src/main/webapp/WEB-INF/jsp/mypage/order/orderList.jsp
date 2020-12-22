<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>

<head>
<title>나의주문내역</title></head>
<jsp:include page="/header.jsp"></jsp:include>

<body>
	<h1>나의 주문내역</h1>
	<table border='1'>
		<thead>
			<tr>
			  <th>주문일자</th>
			  <th>주문번호</th>
			  <th>우편번호</th>
			  <th>배송지주소</th>
			  <th>주문항목</th>
			  <th>주문금액</th>
			  <th>상태</th>
		 	</tr>
		</thead>
		<tbody>
		<c:forEach items="${orderList}" var="o">
			<tr>
				<td>${o.orderDate}</td>
				<td>${o.orderNo}</td>
				<td>${o.postNo}</td>
				<td>${o.address} ${o.detailAddress}</td>
				<td>${o.orderLists.get(0).orderProduct.content}
					<c:if test="${o.orderLists.size() -1 > 0}">외
								${o.orderLists.size() -1} 건</c:if>
					</td>
				<td>${o.totalPrice}</td>
				<td>
					<c:choose>
						<c:when test="${o.status == 0}">
					입금확인중
						</c:when>
						<c:when test="${o.status == 1}">
					결제완료
						</c:when>
						<c:when test="${o.status == 2}">
					배송준비
						</c:when>
						<c:when test="${o.status == 3}">
					배송중
						</c:when>
						<c:when test="${o.status == 4}">
					배송완료
						</c:when>
				
					<c:otherwise>
					상태값오류
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>