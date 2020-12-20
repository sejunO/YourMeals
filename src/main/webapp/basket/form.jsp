<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 등록</title>
	<link rel="stylesheet" href="../../node_modules/bootstrap/dist/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="../../node_modules/bootstrap/dist/css/bootstrap-theme.min.css">
      <link rel="stylesheet" href="../../css/carousel.css">
</head>
<body>
	<h1>장바구니 생성</h1>
	<form action='add' method='post'>
	수량 : <input type='int' name='amount'><br>
	<ul>
		<c:forEach items="${products}" var ="p">
		<li><input type='radio' name='productNo' value="${p.productNo}">${p.content}</li>
		</c:forEach>
	</ul>
	<button>생성</button>
	</form>
	<script src="../../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
	
</body>
</html>