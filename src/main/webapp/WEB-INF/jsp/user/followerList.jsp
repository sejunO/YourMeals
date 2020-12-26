<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/user/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
  <title>사용자 팔로워</title>
<style>
  table {
  width:60%;
  margin:auto;
  text-align:center;
  
  .user-main {
      width:60%;
      margin:auto;
      text-align:center;
      background-color:#FFFAFA;
      margin-top: 50px;
      margin-bottom: 50px;
    }
  }
</style>  
</head>
<body>
<jsp:include page="/WEB-INF/jsp/user/userHeader.jsp"></jsp:include>

	<table border='1'>
	<thead>
	<tr>
	  <th>사진</th>
	  <th>이름</th>
	  <th>닉네임</th>
	</tr>
	</thead>

	<tbody>
	<c:forEach items="${followerList}" var="fwer">
	<tr>
	  <td><img src='../../upload/${fwer.user.photo}_120x120.jpg'></td>
	  <td>${fwer.user.name}</td>
	  <td>${fwer.user.nick}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<hr>
	<div class="user-main">
	 
	</div>
	
</body>
</html>