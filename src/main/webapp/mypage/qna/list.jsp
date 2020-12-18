<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><title>MyPage</title></head>
<body>
<h1>[Q&A 게시글 목록]</h1>
<table border='1'>
<thead>
<tr>
  <th>번호</th> 
  <th>제목</th>
  <th>등록일</th>
  <th>진행상태</th>
</tr>
</thead>

<tbody>
<c:forEach items="${list}" var="q">
<tr>
  <td>${q.qnaNo}</td>
  <td><a href='../qna/detail?no=${q.qnaNo}'>${q.title}</a></td>
  <td>${q.createdDate}</td>
  <td>${q.answerStatus}</td>
</tr>
</c:forEach>
</tbody>
</table>
<button type="button" onclick="location.href='form.html'">글쓰기</button><br>
<hr>

<a href=../index.html>뒤로가기</a><br>

<a href=../../index.html>홈으로</a><br>

</body>
</html>