<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/user/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
  <title>사용자 팔로잉</title>
<style>
  table {
  width:60%;
  margin:auto;
  text-align:center;
  }
</style>  
</head>
<body>
<jsp:include page="/WEB-INF/jsp/user/userHeader.jsp"></jsp:include>

	<table border='1'>
	<thead>
	<tr>
	  <th>번호</th>
	  <th>이름</th>
	  <th>닉네임</th>
	</tr>
	</thead>

	<tbody>
	<c:forEach items="${followinglist}" var="fwing">
	<tr>
	  <td>${fwing.user.userNo}</td>
	  <td>${fwing.user.name}</td>
	  <td>${fwing.user.nick}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>