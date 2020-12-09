<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
        <link rel="stylesheet" href="../node_modules/jquery-ui-dist/jquery-ui.css">
  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.min.css">
<!--      <link rel="stylesheet" href="../css/bootstrap.min.css"> 
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">--> 
    <link href="../css/signin.css" rel="stylesheet">
</head>
<body>
<%
String email = "";

Cookie[] cookies = request.getCookies();
if (cookies != null) {
  for (Cookie cookie : cookies) {
    if (cookie.getName().equals("email")) {
      email = cookie.getValue();
      break;
    }
  }
}
%>
<jsp:include page="../header.jsp"/>
    <div class="container">

      <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" value="<%=email%>" id="inputEmail" name="email" class="form-control" placeholder="Email address"  autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password"class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" name="saveEmail" checked> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->

    <script src="../js/jquery-3.1.1.min.js"></script> 
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>