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
        <form action="#" class="domain-form">
            <div class="form-group d-md-flex"> <input type="text" class="form-control px-4" placeholder="Enter your domain name..."> <input type="submit" class="search-domain btn btn-primary px-5" value="Search Domain"> </div>
        </form>
        <p class="domain-price text-center"><span><small>.com</small>10.75</span> <span><small>.net</small>19.90</span> <span><small>.biz</small>$5.95</span> <span><small>.gov</small>$3.95</span></p>
    </div>
</div>
    
    <script src='./js/bg.js'></script>
    <script src="https://kit.fontawesome.com/f72a7ce790.js" crossorigin="anonymous"></script>
</body>
</html>