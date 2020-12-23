<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/test/css/bootstrap.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/test/css/mystyle.css">
</head>

<body>

<div id="login">
		<div class="back">
			<div class="main">
			<form class="form-signin" action="login" method="post">
				<div class="log">
        			<span class="box"><h7>로그인</h7></span>
        				<a class="findpassword" href="">비밀번호를 잊어버리셨나요?</a>
        		</div>
	        <label for="inputEmail" class="sr-only">이메일</label>
	        <input type="email" value='${email}' id="inputEmail" name="email" class="form-control" placeholder="이메일(example@gmail.com)"  autofocus>
	        <label for="inputPassword" class="sr-only">비밀번호</label>
	        <input type="password" id="inputPassword" name="password"class="form-control" placeholder="비밀번호" required>
        <div class="check">
        	<span>
          		<label>
           			 <input type="checkbox" name="saveEmail" checked>
         		</label>
        	</span>
        		<span class="email"> 이메일 저장 </span>
        </div>
        <button class="btn" type="submit">로그인</button>
   	 </form>
   	 </div>
   	 </div>
</div>

</body>
</html> 