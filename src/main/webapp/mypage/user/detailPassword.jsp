<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>MyPage</title>
</head>
<body>
	<h1>[비밀번호변경]</h1>
	<form action='update' method='post'>

    <input type='hidden' name='userNo' value='${user.userNo}'>
		비밀번호: <input type='password' name='password'><br>
		<br>
		<p>
		<button>변경</button>
		<button type="button" onclick="location.href='../../../mypage/index.html'">취소</button>
		</p>
	</form>
	
	<hr>
	<a href='../../../mypage/index.html'>뒤로가기</a>
	<br>
	<a href='../../../index.jsp'>홈으로</a>
	<br>

</body>
</html>
