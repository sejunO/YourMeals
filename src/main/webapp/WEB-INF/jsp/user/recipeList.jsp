<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head><title>사용자 레시피</title></head>
<body>
<%
String userNick = request.getParameter("userNick");
%>
<h1>[${userNick}님의 레시피]</h1>
<table border='1'>
<thead>
<tr>
  <th>번호</th>
  <th>제목</th>
  <th>사진</th>
  <th>등록일</th></tr>
</thead>

<tbody>
<c:forEach items="${recipeList}" var="r">
<tr>
  <td>${r.recipeNo}</td>
  <td><a href='../recipe/detail?recipeNo=${r.recipeNo}'>${r.title}</a></td>
  <td>${r.photo}</td>
  <td>${r.createdDate}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>