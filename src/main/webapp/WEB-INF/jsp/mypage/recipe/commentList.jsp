<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><title>MyPage</title></head>
<body>
<h1>[My Comment 목록]</h1>
<table border='1'>
<thead>
<tr>
  <th>댓글</th>
  <th>작성일</th>
  <th>레시피</th></tr>
</thead>

<tbody>
<c:forEach items="${commentList}" var="c">
<tr>
	<td>${c.content}</td>
	<td>${c.createdDate}</td>
	<td><a href= '../../recipe/detail?recipeNo=${c.recipeNo}'>[원본글 보기]</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
