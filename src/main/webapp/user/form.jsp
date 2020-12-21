<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원가입</title>
</head>
<body>
  <h1>회원가입</h1>
  <form action="join" method="post">
    이름:<input type="text" name="name"><br>
    닉네임:<input type="text" name="nick"><br>
    이메일:<input type="email" name="email"><br>
    비밀번호:<input   type="password" name="password"><br>
    <button>회원가입</button>
  </form>
</body>
</html>