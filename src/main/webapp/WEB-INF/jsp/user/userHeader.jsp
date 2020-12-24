<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>user-header</title>
<style>
    .user-header {
      width:60%;
      margin:auto;
      text-align:center;
      background-color:#FFFAFA;
      margin-top: 50px;
      margin-bottom: 50px;
    }
    .user-container {
      display:flex;
      padding: 10px 0px 10px 0px;
    }
    .image-box {
      width:20%;
      padding: 20px 0px 0px 0px;
    }
    img {
      border-radius: 180px;
      max-width: 100%; 
      height: auto;
    }
    .info-box {
      display:block;
      width:20%;
    }
    .recipe-box {
      display:block;
      width:20%;
      border-radius: 15px;
      background-color:#FCDFDF;
    }
    .follower-box {
      display:block;
      width:20%;
      border-radius: 15px;
      background-color:#F5F5F5;
    }
    .following-box {
      display:block;
      width:20%;
      border-radius: 15px;
      background-color:#F5F5F5;
    }
    <%--수평 중앙정렬 css--%>
    .modal-table{display:table;position:relative;width:100%;height:100px;}
    .modal-cell{display:table-cell;vertical-align:middle;}
    .box{display:block;margin:0 auto;padding:10px;width:100px}
  </style>
</head>
<body>
	<div class="user-header">
	<div class="user-container">
	  <div class="image-box">
	    <img src='../../upload/${user.photo}_120x120.jpg'>
	  </div>
	  <div class="info-box">
	  
	  
	  <div class="modal-table"><div class="modal-cell"><div class="box">
	    <div class="element-label">
	    <h2>${user.nick}</h2></div>
	    <div class="element-label">
	    ${user.email}</div>
	  </div></div></div>
	  
	  
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	    <button onclick="location.href='follow'">팔로우</button>
	    </div></div></div>
	  </div>
	  </div>
	  <div class="recipe-box">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	          레시피</div></div></div>
	  </div>
	  <div class="element-size">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	    ${recipeSize}</div></div></div>
	  </div>
	  </div>
	  <div class="follower-box">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	          팔로워</div></div></div>
	  </div>
	  <div class="element-size">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	    ${followerSize}</div></div></div>
	  </div>
	  </div>
	  <div class="following-box">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	          팔로잉</div></div></div>
	  </div>
	  <div class="element-size">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	    ${followingSize}</div></div></div>
	  </div>
	  </div>
	</div>
	</div>
</body>
</html>