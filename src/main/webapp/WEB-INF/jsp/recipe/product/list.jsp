<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head><title>회원목록</title></head>
<body>

<a href='form'>새 회원</a><br>

<table border='1'>
<thead><tr><th>번호</th><th>이름</th><th>이메일</th><th>전화</th><th>등록일</th></tr></thead>
<tbody>
<c:forEach items="${list}" var="p">
<tr>
  <td>${p.productNo}</td>
  <td>><img src='../../upload/${p.photo}_200x200.jpg' alt='사진'>${p.title}</a></td>
  <td>${p.content}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
