<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장바구니 등록</title>
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
</body>
</html>