<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><title>사용자 목록</title></head>
<body>
<h1>[사용자 목록]</h1>
<table border='1'>
<thead>
<tr>
  <th>번호</th> 
  <th>이름</th>
  <th>닉네임</th>
  <th>정보보기</th>
</tr>
</thead>

<tbody>
<c:forEach items="${list}" var="u">
<tr>
  <td>${u.userNo}</td>
  <td>${u.name}</td>
  <td>${u.nick}</td>
  <td><a href='info?userNo=${u.userNo}'>[${u.name}의 정보]</a></td>
</tr>
</c:forEach>
</tbody>
</table>

<form action='list' method='get'>
검색어: <input type='text' name='keyword' value=''>
<button>검색</button>
</form>

<hr>

<a href=../../index.html>뒤로가기</a><br>

<a href=../../index.html>홈으로</a><br>

</body>
</html>