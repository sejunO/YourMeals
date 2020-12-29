<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>YourName</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='./css/main.css'>
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link
	href="<%=request.getContextPath()%>/node_modules/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
  

  <div class="row justify-content-center padding">
    <div class="col-md-8 ftco-animate fadeInUp ftco-animated">
        <form action="app/recipe/list" class="domain-form">
            <div class="form-group d-md-flex"> <input type="hidden" name="option" value="all"></input><input type="text" name="keyword" class="form-control px-4" placeholder="재료를 입력하세요 ! "> <input type="submit" class="search-domain btn btn-primary px-5" value="검색"> </div>
        </form>
        <a href="index.jsp"><p class="domain-price text-center">메인 화면으로 가기</p></a>
    </div>
</div>
    
    <script src='./js/bg.js'></script>
    <script src="https://kit.fontawesome.com/f72a7ce790.js" crossorigin="anonymous"></script>
</body>
</html>

