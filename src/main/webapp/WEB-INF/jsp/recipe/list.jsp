
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<jsp:include page="/header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head><title>레시피 목록</title>
</head>
<body>



<h1>레시피 목록</h1>

<p>
<%
String keyword = request.getParameter("keyword");
%>
<form action='list' method='get'>
검색어: <input type='text' name='keyword' value='${keyword != null ? keyword : "" }'>
<button>검색</button>
</form>
</p>
<hr>

<h2>상세 검색</h2>
<p>
<%
String keywordTitle = request.getParameter("keywordTitle");
String keywordWriter = request.getParameter("keywordWriter");
String keywordCategory = request.getParameter("keywordCategory"); ;
%>
<form action='list' method='get'>
제목: <input type='text' name='keywordTitle' 
value='${keywordTitle != null ? keywordTitle : ""}'><br>
작성자: <input type='text' name='keywordWriter' 
value='${keywordTitle != null ? keywordTitle : ""}'><br>
카테고리:<input type='text' name='keywordCategory' 
value='${keywordTitle != null ? keywordTitle : ""}'><br>
<button>검색</button>
</form>
</p>
<hr>

<a href='form'>새 레시피</a><br>
<table border='1'>
<thead>
<tr>
  <th>번호</th>
  <th>사진</th>
  <th>제목</th>
  <th>작성자</th>
  <th>방법</th>
  <th>작성일</th>
  <th>조회</th>
  </tr>
</thead>

<tbody>
<c:forEach items="${list}" var="recipe">
<tr>
  <td>${recipe.recipeNo}</td>
  <td><img src='../upload/%1$s_30x30.jpg'>${recipe.photo}</td>
  <td><a href= 'recipeDetail?recipeNo=${recipe.recipeNo}'>${recipe.title}</a></td>
  <td>${recipe.writer.nick}</td>
  <td>${recipe.category.categoryName}</td>
  <td>${recipe.createdDate}</td>
  <td>${recipe.hits}</td>
</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>