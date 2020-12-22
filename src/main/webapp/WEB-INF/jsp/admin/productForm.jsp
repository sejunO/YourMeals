<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>
<h1>상품 등록</h1>
<form action="productAdd" method="post" enctype="multipart/form-data">
재고: <input type="text" name="stock"><br>
가격: <input type="number" name="price"><br>
할인: <input type="number" name="discount"><br>
제목: <input type="text" name="title"><br>
내용: <input type="text" name="content"><br>
사진: <input type="file" name="photoFile"><br>
<button>등록</button>
</form>
</body>
</html>