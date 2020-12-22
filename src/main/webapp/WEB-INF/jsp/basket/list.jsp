<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>BasketService</title>
	<link rel="stylesheet" href="../../node_modules/bootstrap/dist/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="../../node_modules/bootstrap/dist/css/bootstrap-theme.min.css">
      <link rel="stylesheet" href="../../css/carousel.css">
</head>
<body>
	<div class="container">
		<h1>장바구니</h1>

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

					<c:forEach items="${basketList}" var="b">
						<tr>
						<td>${b.product.title}</td>
							<td>${b.product.content}</td>
							<td>${b.amount}</td>
							<td>${b.product.price}</td>
							<td>${b.writer.name}</td>
					</c:forEach>
				</tbody>
			</table>

			<button>주문하기</button>
		</form>
	</div>

	    <script src="../../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</body>

</html>