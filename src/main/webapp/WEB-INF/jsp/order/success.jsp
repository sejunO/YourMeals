<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>결제완료</title>
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
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath() %>/test/css/bootstrap.css">
<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath() %>/test/css/mystyle.css">
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/test/css/basketstyle.css">
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
        <div class="box4">Basket</div>
      </div>
    </div>
  </div>
  
 <div class="sub-container">
  <div class="vertical">
   <div class="mylist">
      <div class="headtitle"><h1 style="font-size: 50px;
       margin-bottom: 40px; text-align: center;">결제 완료</h1></div>  
   
   <div class="headtitle" style="border-bottom: 4px solid #000; padding-bottom: 10px;">배송지 정보</div>
   
   <input type='hidden' name='userNo' value='${user.userNo}'>
    
    <div class="updatebox1" style="margin-top: 20px;">
     <span class="labels" style="font-size: 17px; padding-top: -7px;">*이름:</span> 
     <input type='text' class="form-control" id="exampleFormControlInput1"
      style="margin-left: 50px;" name="userName" placeholder='${order.userNo.name}'readonly>
     </div>
           
    <div class="updatebox2">
    <span class="labels" style="font-size: 17px; padding-top: -7px;"> *연락처: </span>
     <input type='text' class="form-control" style="margin:5px 0 0 65px;"
     name="tel" id="exampleFormControlInput2" placeholder='${order.tel}'readonly>
     </div>     
            
   <div class="updatebox3">
    <span class="labels" style="font-size: 17px; padding-top: -7px; margin-left: 5px;"> 우편번호:</span>
     <input type='text'  class="form-control" id="postNo" name='postNo' value='${order.postNo}'
      style="margin:5px 0 0 80px; position: relative;"readonly>
     </div>     
     
  <div class="updatebox4">
     <span class="labels" style="font-size: 17px; padding-top: -7px; margin-left: 5px;"> 기본주소: </span>
     <input type='text' class="form-control"
       style="margin:5px 0 0 80px; position: relative;" id="address" name='address'
       value="${order.address}"readonly>
     </div>
     
  <div class="updatebox4">
     <span class="labels" style="font-size: 17px; padding-top: -7px; margin-left: 5px;">세부주소:</span>
      <input type='text'  class="form-control"
       style="margin:5px 0 0 80px; position: relative;" id="detailAddress" name='detailAddress'
       value="${order.detailAddress}" readonly>
     </div>    

<div class="headtitle" style="padding-top: 20px; padding-bottom: 10px;">주문 상품 정보</div>
        <ul class="list">
          <li class="thead">
            <div class="td-col1">상품정보</div>
            <div class="td-col3">수량</div>
            <div class="td-col3">가격</div>
          </li>
          
      <c:forEach items="${orderList}" var="ol">
        <li class="tbox">
              <!-- 물품 -->
              <div class="goods">
                <div class="goodsbox" style="justify-content: center;">
                  <div class="in-col1"
                    style="margin-left: 120px; margin-right: 100px;">
                    <div class="imgbox">
                      <div class="imgin">
                        <img src="../../upload/${ol.orderProduct.photo}_80x80.jpg">
                      </div>
                    </div>
                    <div class="goodsinfo">
                      <p class="goodstitle">
                      ${ol.orderProduct.title}</p>
                    </div>
                  </div>
                  <!-- 상품정보 끝 -->
                    
                 <div class="in-col3">
                      ${ol.amount} 
                    </div>
                    <div class="in-col3">
                      ${ol.price}원
                    </div>
                </div>
                </div>
                </li>
                </c:forEach>
                </ul>
            </div>
          </div>
      </div>

        
  <jsp:include page="/footer.jsp"></jsp:include>
  
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/jquery.1.11.1.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/bootstrap.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/SmoothScroll.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/nivo-lightbox.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/jquery.isotope.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/jqBootstrapValidation.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath() %>/test/js/main.js"></script>
</body>

</html>