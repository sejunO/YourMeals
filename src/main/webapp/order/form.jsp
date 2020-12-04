<%@page import="java.util.List"%>
<%@page import="com.oijoa.domain.Product"%>
<%@page import="com.oijoa.domain.User"%>
<%@page import="com.oijoa.domain.Basket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Basket> list = (List<Basket>) request.getAttribute("baskets");
User user = (User) request.getAttribute("user");
int result = 0;%>

<h3>배송지 정보</h3>
<form action="add" method="post">
<input type="hidden" name="userNo" value=<%=user.getUserNo() %>>
이름 : <input type="text" readonly name="userName" value=<%=user.getName() %>><br>
연락처 : <input type="tel" name="tel"><br>
우편번호: <input type="number" name="postno" value=<%=user.getPostNo() %>><br>
기본주소: <input type="text" name="addr" value=<%=user.getAddress() %>><br>
상세주소: <input type="text" name="det_addr" value=<%=user.getDetailAddress() %>><br>

<h3>주문 상품 정보</h3>
<%for (Basket b : list) { %>
<table>
<tr>
<td><%=b.getProduct().getContent() %></td>
<td><%=b.getAmount() %></td>
<td><%=b.getProduct().getPrice() %></td>
<td><%=b.getWriter().getName() %></td>
<td><%=b.getProduct().getPrice() * b.getAmount() %></td>
<% result += b.getProduct().getPrice() * b.getAmount();%>
</table>
<%} %>

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