<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><title>MyPage</title></head>
<body>
<h1>[My Like Recipe 목록]</h1>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>사진</th>
    <th>등록일</th>
  </tr>
</thead>

<tbody>
  <c:forEach items="${list}" var="r">
  <tr>
    <td>${r.recipeNo}</td>
    <td>${r.title}</td>
    <td>${r.photo}</td>
    <td>${r.createdDate}</td>
  </tr>
  </c:forEach>
</tbody>

</table>
<hr>

<a href=../index.html>뒤로가기</a><br>

<a href=../../index.html>홈으로</a><br>

</body>
</html>
