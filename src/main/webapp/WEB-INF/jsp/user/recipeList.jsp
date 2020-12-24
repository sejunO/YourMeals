<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head><title>사용자 레시피</title></head>
<body>
<h1>[${user.nick}님의 레시피]</h1>
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

<hr>

<style>
  .user-header {
    width:60%;
    margin:auto;
    text-align:center;
    background-color:#FFFAFA;
    border: solid 1px red;
  }
  .user-container {
    display:flex;
    padding: 10px 0px 10px 0px;
  }
  .image-box {
    width:20%;
    padding: 20px 0px 0px 0px;
    border: solid 1px red;
  }
  img {
    border-radius: 180px;
    max-width: 100%; 
    height: auto;
  }
  .info-box {
    display:block;
    width:20%;
    border: solid 1px red;
  }
  .recipe-box {
    display:block;
    width:20%;
    border-radius: 15px;
    background-color:white;
    border: solid 1px red;
  }
  .follower-box {
    display:block;
    width:20%;
    border-radius: 15px;
    background-color:white;
    border: solid 1px red;
  }
  .following-box {
    display:block;
    width:20%;
    border-radius: 15px;
    background-color:white;
    border: solid 1px red;
  }
  .element-label {
    border: solid 1px red;
  }
  .element-size {
    border: solid 1px red;
  }
  <%--수평 중앙정렬 css--%>
  .modal-table{display:table;position:relative;width:100%;height:120px;}
  .modal-cell{display:table-cell;vertical-align:middle;}
  .box{display:block;margin:0 auto;padding:10px;width:120px}
</style>

<div class="user-header">
<div class="user-container">
  <div class="image-box">
    <img src='../../upload/${user.photo}_120x120.jpg'>
  </div>
  <div class="info-box">
  
  
  <div class="modal-table"><div class="modal-cell"><div class="box">
    <div class="element-label">
    <h3>${user.nick}</h3></div>
    <div class="element-label">
    ${user.email}</div>
  </div></div></div>
  
  
  <div class="element-label">
    <div class="modal-table"><div class="modal-cell"><div class="box">
    <button>팔로워</button>
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