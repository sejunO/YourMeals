<%@page import="com.oijoa.domain.Basket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>BasketService</title></head>
<body><h1>장바구니</h1>

<% List<Basket> list = (List<Basket>) request.getAttribute("basketList");
   int result = 0;%>
<p>[장바구니 목록]</p>
<a href='form'>장바구니 등록</a><br>
<form action="../order/form" method="post">
<table border='1'>
	<thead>
	 <tr>
		<th>상품정보</th>
		<th>수량</th>
		<th>가격</th>
		<th>회원이름</th>
		<th>총 가격</th>
	 </tr>
	</thead>
<tbody>

<%for(Basket b : list) { %>
<tr>
<td><%=b.getProduct().getContent() %></td>
<td><%=b.getAmount() %></td>
<td><%=b.getProduct().getPrice() %></td>
<td><%=b.getWriter().getName() %></td>
<td><%=b.getProduct().getPrice()*b.getAmount() %></td>
<% result += b.getProduct().getPrice()*b.getAmount();%>
<%} %>
</tbody>
</table>
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
<button>주문하기</button>
</form>

</body>
</html>
