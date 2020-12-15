<%@page import="com.oijoa.domain.Order" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>나의주문내역</title></head>

<body>
<jsp:include page="/header.jsp"></jsp:include>

<h1>나의 주문내역</h1>
<%
List<Order> list = (List<Order>) request.getAttribute("list");
%>
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
<%! 
int totalPrice;
String orderStatus;
%>

<%for (Order order : list) {

  totalPrice = 0;
  for (OrderList orderlist : order.getOrderLists()) {
    totalPrice += (orderlist.getPrice() - orderlist.getDiscount()) * orderlist.getAmount();
  }

  switch (order.getStatus()) {
    case 0: orderStatus = "입금확인중"; break;
    case 1: orderStatus = "결제완료"; break;
    case 2: orderStatus = "배송준비"; break;
    case 3: orderStatus = "배송중"; break;
    case 4: orderStatus = "배송완료"; break;

    default:
      orderStatus = "상태값오류";
  }
  %>
  
<tr>
  <td><%=order.getOrderDate()%></td>
  <td><%=order.getOrderNo()%></td>
  <td><%=order.getPostNo()%></td>
  <td><%=order.getAddress()%><br>
      <%=order.getDetailAddress()%></td>
  <td><%=order.getOrderLists().get(0).getOrderProduct().getContent()%>외
      <%=order.getOrderLists().size() - 1%>건</td>
  <td><%=totalPrice%></td>
  <td><%=orderStatus%></td>
</tr>

</tbody>
</table>
</body>
</html>