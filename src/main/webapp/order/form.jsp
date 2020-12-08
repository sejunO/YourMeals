
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
<%
int result = 0;%>

<h3>배송지 정보</h3>
<form action="add" method="post">
<input type="hidden" name="userNo" value='${user.userNo}'>
이름 : <input type="text" readonly name="userName" value='${user.name}'><br>
연락처 : <input type="tel" name="tel"><br>
우편번호: <input type="number" name="postno" value='${user.postNo}'><br>
기본주소: <input type="text" name="addr" value="<c:if test="${not empty user.address}">${user.address}</c:if>"><br>
상세주소: <input type="text" name="det_addr" value="<c:if test="${not empty user.detailAddress}">${user.detailAddress}</c:if>"><br>
배송 메모: <input type="text" name="memo"><br>

<h3>주문 상품 정보</h3>
<c:forEach items="${baskets}" var="b">
<table>
<tr>
<td>${b.product.content}</td>
<td>${b.amount}</td>
<td>${b.product.price}</td>
<td>${b.writer.name}</td>
<td>${b.product.price} * ${b.amount}</td>
</table>

</c:forEach>


<h3>결제 방법 선택</h3>
<c:forEach items="${payments}" var="p">
		<input type="radio" name="payment" value="${p.paymentNo}">${p.name}
</c:forEach>
<h3>결제 정보</h3>
<table border='1'>
 <thead></thead>
<tbody>
<tr>
  <td>총 상품금액</td>
  <td><%=result%></td>
  <td>결제 예상 금액</td>
  <td><%=result%></td>
</tr>
</tbody>
</table>


<button>결제하기</button>
</form>
</body>
</html>