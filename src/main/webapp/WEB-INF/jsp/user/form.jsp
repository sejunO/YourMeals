<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원가입</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/test/css/bootstrap.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/test/css/mystyle.css">
</head>
<body>

<div id="signup">
	<div class="back">
		<div class="main">
		<form class="form-signin" action="add" method="post">
			<div class="sign"><h7>회원가입</h7></div>
			
			<label for="inputEmail" class="sr-only">이메일</label>
			<input type="email" value='${email}' id="sign-inputEmail" 
			name="email" class="form-control" placeholder="이메일(example@gmail.com)" required>
			
			<label for="inputPassword" class="sr-only">비밀번호</label>
			<input type="password" id="sign-inputPassword" 
			name="password" class="form-control" placeholder="비밀번호" style="margin:0;" required>
			
			<label for="inputName" class="sr-only">이름</label>
			<input type="text" id="sign-inputName" 
			name="name" class="form-control" placeholder="이름" required>
			
			<label for="inputNick" class="sr-only">닉네임</label>
			<input type="text" id="sign-inputNick" 
			name="nick" class="form-control" placeholder="닉네임" required>
		
		<button class="btn" type="submit" style="margin-top: 10px;">계정 생성</button>
		</form>
		</div>
	</div>
</div>

</body>
</html>
