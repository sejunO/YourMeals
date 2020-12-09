<%@page import="com.oijoa.domain.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
  <td>${recipe.recipeNo}></td>
  <td><img src='../upload/%1$s_30x30.jpg'><${recipe.photo}></td>
  <td><a href='detail?recipeNo=${recipe.recipeNo}>'><${recipe.title}></a></td>
  <td><${recipe.writer.vick}></td>
  <td><${recipe.category.categoryName}></td>
  <td><${recipe.createdDate}></td>
  <td><${recipe.hits}></td>
</tr>
</tbody>
</table>
<%}%>