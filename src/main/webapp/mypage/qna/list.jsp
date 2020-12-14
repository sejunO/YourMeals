<%@page import="com.oijoa.domain.Qna"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>게시글목록</title></head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<h1>게시글 목록</h1>

<%
List<Qna> list = (List<Qna>) request.getAttribute("list");
%>

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
<%for (Qna qna : list) {%>
<tr>
	<td><%=qna.getQnaNo()%></td>
	<td><a href='detail?no=<%=qna.getQnaNo()%>'><%=qna.getTitle()%></a></td>
	<td><%=qna.getCreatedDate()%></td>
	<td><%=qna.getAnswerStatus()%></td>
</tr>
<%} %>
</tbody>
</table>
<button><a href='form.html'>글쓰기</a></button><br>
<p>
<a href=../index.html>뒤로가기</a><br>
<a href=../../index.html>홈으로</a><br>
</p>
</body>
</html>