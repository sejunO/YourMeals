<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>userHeader</title>
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/test/img/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="<%=request.getContextPath()%>/test/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="<%=request.getContextPath()%>/test/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="<%=request.getContextPath()%>/test/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/test/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/test/css/mystyle.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/test/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/test/css/nivo-lightbox/default.css">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700"
	rel="stylesheet">
</head>
<body>
  <div class="sidebox">
      <div class="categoryname">
      마이페이지
      </div>
      <div class="profilebox">
        <span class="profilephoto">
        <img class="profile" src='<%=request.getContextPath()%>/upload/${user.photo}_120x120.jpg'></span>
        <div class="profileinfo">
        <h4>${user.nick} 님</h4>
        <p>${user.email}</p></div>
        <div class="profileupdate">
        <a href="<%=request.getContextPath()%>/app/mypage/user/detail"><button class="btn">정보 수정</button></a></div>
      </div>
      <div class="category">
    <div class="contenttitle"><strong>MY 주문내역</strong>
    <ul>
        <li><a href="<%=request.getContextPath()%>/app/mypage/order/orderList">나의 주문내역</a></li>
        <li><a href="<%=request.getContextPath()%>/app/mypage/order/updateList">나의 취소/교환/환불내역</a></li>
    </ul>
    </div>
    <div class="contenttitle"><strong>MY 레시피</strong>
     <ul>
        <li><a href="<%=request.getContextPath()%>/app/mypage/recipe/list">나의 레시피</a></li>
        <li><a href="<%=request.getContextPath()%>/app/mypage/recipe/likeList">내가 좋아한 레시피</a></li>
        <li><a href="<%=request.getContextPath()%>/app/mypage/recipe/commentList">나의 댓글</a></li>
    </ul>
    </div>
    <div class="contenttitle"><strong>MY Q&A</strong>
    <ul>
        <li><a href="<%=request.getContextPath()%>/app/mypage/qna/list">QnA 게시판</a></li>
    </ul> 
    </div>
    <div class="contenttitle"><strong>MY FOLLOWING</strong>
    <ul>
        <li><a href="<%=request.getContextPath()%>/app/mypage/user/followingList">나의 팔로잉</a></li>
        <li><a href="<%=request.getContextPath()%>/app/mypage/user/followerList">내 팔로워</a></li>
    </ul>
    </div>
    </div>
    </div>
</body>
</html>