<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shop</title>
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon"
  href="<%=request.getContextPath()%>/test/img/favicon.ico"
  type="image/x-icon">
<link rel="apple-touch-icon"
  href="<%=request.getContextPath()%>/test/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
  href="<%=request.getContextPath()%>/test/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
  href="<%=request.getContextPath()%>/test/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/test/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/test/css/shopstyle.css">
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/test/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/test/css/nivo-lightbox/default.css">
<link
  href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700"
  rel="stylesheet">
<link
  href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
  rel="stylesheet">
<link
  href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700"
  rel="stylesheet">
</head>

<body id="userpage">
  <div class="main-container">
    <div class="box1">
      <div class="box2">
        <header><jsp:include page="/header.jsp"></jsp:include></header>
        <div class="box3"></div>
        <div class="box4">Shop</div>
      </div>
    </div>
  </div>
  
      <div class="content-main" style="min-height: calc(100vh - 132px); max-height: auto; ">
        <div class="content-main-container">
        <div class="headtitle">상품 담기</div>
          <div class="content-main-cell"> 
            <c:forEach items="${products}" var="p">
              <div class="content-main-cell-col"> 
                <div class="card mb-3">
              <form action='add' method='post'>
                  <input type='radio' name='productNo' value="${p.productNo}">  ${p.title}<br>
                  <img
                    class="card-img-top" 
                    src="../../upload/${p.photo}_200x200.jpg"
                    alt="Card image cap" height="180">
                    <%-- <img
                    class="card-img-top" 
                    src="<%=request.getContextPath()%>/upload/default.png"
                    alt="Card image cap" height="180"> --%>
                  <div class="card-body">
                    <h5 class="card-title">${p.content}</h5>
                    <p class="card-text">가격 : ${p.price}원</p>
                      <p class="card-text">수량 : <input type='number' name='amount' style="width: 30%;height: 25px">
                    <button class="btn-outline-primary">추가</button></p>
                  </div>
             </form>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>

  <script
    src="../../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
    crossorigin="anonymous"></script>
  <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>