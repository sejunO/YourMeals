<%@page import="com.oijoa.domain.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head><title>레시피 목록</title></head>
<body>

<h1>레시피 목록</h1>

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
<%for (Recipe recipe : list) {%>
<tr>
  <td><%=recipe.getRecipeNo()%></td>
  <td><img src='../upload/%1$s_30x30.jpg'><%=recipe.getPhoto()%></td>
  <td><a href='detail?recipeNo=<%=recipe.getRecipeNo%>'><%recipe.getTitle()%></a></td>
  <td><%=recipe.getWriter().getNick()%></td>
  <td><%=recipe.getCategory().getCategoryName()%></td>
  <td><%=recipe.get.getCreatedDate()%></td>
  <td><%=recipe.getHits()%></td>
</tr>
</tbody>
</table>
<%}%>