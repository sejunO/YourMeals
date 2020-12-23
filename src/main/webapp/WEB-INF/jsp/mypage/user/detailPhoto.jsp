<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>MyPage</title>
</head>
<body>
  <h1>[회원사진변경]</h1>
  <form action='updatePhoto' method='post' enctype='multipart/form-data'>
      <input type='hidden' name='userNo' value='${user.userNo}'><br>
      <a href='../../../upload/${user.photo}'> 
      <img src='../../../upload/${user.photo}_120x120.jpg'></a><br> 
      <input type='file' name='photoFile'>
    <p>
      <button>변경</button>
    </p>
  </form>
  
</body>
</html>