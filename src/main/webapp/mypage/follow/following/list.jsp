<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><title>MyPage</title></head>
<body>
<h1>[My Following 목록]</h1>
<table border='1'>
<tr>
<th>번호</th>
<th>이름</th>
<th>닉네임</th></tr>


<c:forEach items="${list}" var="f">
<tr>
	<td>${f.user.userNo}</td>
	<td>${f.user.name}</td>
	<td>${f.user.nick}</td>
</tr>
</c:forEach>
</table>
<hr>

<a href=../index.html>뒤로가기</a><br>

<a href=../../index.html>홈으로</a><br>

</body>
</html>
