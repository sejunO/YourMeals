<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>MyPage</title></head>
<body>
<h1>[QnA 게시글 목록]</h1>
<a href='form'>새 글</a><br>
<table border='1'>
<thead>
<tr>
  <th>번호</th> 
  <th>제목</th>
  <th>등록일</th>
</tr>
</thead>

<tbody>

<c:forEach items="${qnaList}" var="q">
<tr>
  <td>${q.qnaNo}</td>
  <td><a href='detail?qnaNo=${q.qnaNo}'>${q.title}</a></td>
  <td>${q.createdDate}</td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>