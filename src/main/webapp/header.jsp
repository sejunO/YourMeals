<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <link rel="stylesheet" href="./css/bootstrap.min.css"> 
    <link rel="stylesheet" href="./css/bootstrap-theme.min.css">
    <link href="./css/carousel.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
     <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.jsp">YOURMEALS</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="../index.jsp">Home</a></li>
                <li><a href="../recipe/list">recipe</a></li>
                <li><a href="../mypage/index.html">mypage</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">Nav header</li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
              </ul>
          <ul class="nav navbar-nav navbar-right">
            <li role="presentation"><a href="../auth/login.jsp">로그인</a></li>
            <li role="presentation"><a href="../auth/logout">로그아웃</a></li>
            <li role="presentation"><a href="#">회원가입</a></li>
            
          </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>
    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
       <script src="./js/vendor/holder.js"></script>
    <script src="./js/ie10-viewport-bug-workaround.js"></script>
    <script src="./js/jquery-3.1.1.min.js"></script> 
    <script src="./js/bootstrap.min.js"></script>
</body>
</html>