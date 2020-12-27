<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>user-header</title>
<style>
    
  </style>
</head>
<body>
	<div class="user-header">
	<div class="user-container">
	  <div class="image-box">
	    <img class="user-img" src='../../upload/${user.photo}_120x120.jpg'>
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
	    <button class="modal-cell-btn" onclick="location.href='follow?followUserNo=${user.userNo}'">팔로우</button>
	    <button class="modal-cell-btn" onclick="location.href='unfollow?unfollowUserNo=${user.userNo}'">언팔로우</button>
	    </div></div></div>
	  </div>
	  </div>
	  <div class="recipe-box">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	         <a href="recipeList?userNo=${user.userNo}">레시피</a>
	    </div></div></div>
	  </div>
	  <div class="element-size">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	    ${recipeSize}</div></div></div>
	  </div>
	  </div>
	  <div class="follower-box">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	          <a href="followerList?userNo=${user.userNo}">팔로워</a>
	    </div></div></div>
	  </div>
	  <div class="element-size">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
	    ${followerSize}</div></div></div>
	  </div>
	  </div>
	  <div class="following-box">
	  <div class="element-label">
	    <div class="modal-table"><div class="modal-cell"><div class="box">
            <a href="followingList?userNo=${user.userNo}">팔로잉</a>
      </div></div></div>
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