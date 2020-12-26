<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/userHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Userpage</title>
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon" href="<%=request.getContextPath() %>/test/img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="<%=request.getContextPath() %>/test/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="<%=request.getContextPath() %>/test/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="<%=request.getContextPath() %>/test/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/test/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/css/nivo-lightbox/default.css">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700" rel="stylesheet">
</head>

<body id="mypage">
  <div class="main-container">
  <div class="box1">
    <div class="box2">
      <header><jsp:include page="/userHeader.jsp"></jsp:include></header>
      <div class="box3"></div>
      <div class="box4">UserPage</div>
    </div>
  </div>
<jsp:include page="/WEB-INF/jsp/user/header.jsp"></jsp:include>

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