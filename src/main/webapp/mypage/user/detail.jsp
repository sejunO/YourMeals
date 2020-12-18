<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>MyPage</title>
</head>
<body>
	<h1>[정보수정]</h1>
	<form action='update' method='post'>

    <input type='hidden' name='userNo' value='${user.userNo}'>
		이름: <input type='text' name='name' value='${user.name}' readonly><br>
		닉네임: <input type='text' name='nick' value='${user.nick}'><br>
		이메일: <input type='text' name='email' value='${user.email}' readonly><br>
		<%--비밀번호: <input type='text' name='password' value='${user.password}' readonly><br> --%>
		우편번호: <input type='text' name='postNo' value='${user.postNo}'><br>
		기본주소: <input type='text' name='address' value='${user.address}'><br>
		세부주소: <input type='text' name='detailAddress' value='${user.detailAddress}'><br>
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
