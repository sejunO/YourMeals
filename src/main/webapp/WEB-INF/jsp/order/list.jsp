<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>OrderList</title></head>
<body><h1>주문항목목록</h1>
주문항목 목록
<table border='1'>
<thead><tr><th>주문항목</th><th>상품명</th><th>가격</th><th>할인율</th><th>사용자</th></tr></thead>
<tbody>
<c:forEach items="${list}" var="o">
<tr>
<td>${o.orderListNo}</td>
<td>${o.orderProduct.title}</td>
<td>${o.price}</td>
<td>${o.discount}</td>
<td>${o.orderNo.userNo.name}</td></tr>
</c:forEach>
</tbody>
</table>
</body>
</html>