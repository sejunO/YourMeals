<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Basket</title>
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
  
  <script>
  function change1(obj){
    obj.style.background = 'rgb(193, 212, 209)';
    obj.style.color = 'rgb(0, 0, 0)';
  }
  
  function change2(obj){
    obj.style.background = 'rgb(193, 212, 209)';
    obj.style.color = 'rgb(255, 255, 255)';
  }
</script>

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
        <div class="headtitle">장바구니</div>
        <!-- 장바구니 리스트 시작 -->
        
    <form action="../order/form" method="post">
        <ul class="list">
          <li class="thead">
            <div class="td-col1">상품정보</div>
            <div class="td-col2">내용</div>
            <div class="td-col3">수량</div>
            <div class="td-col3">가격</div>
            <div class="td-col3">총가격</div>
          </li>
          
          
        <c:forEach items="${basketList}" var="b">
          <li class="tbox">
          
              <!-- 물품 -->
                <div class="goods">
                  <div class="goodsbox">
                    <div class="in-col1">
                      <div class="imgbox"> 
                        <div class="imgin">
							<img src="../../upload/${b.product.photo}_80x80.jpg" 
							class="figure-img img-fluid rounded" alt="...">
							           </div>
							        </div>
                      <div class="goodsinfo">
                        <p class="goodstitle">
                          ${b.product.title}  </p>
                   <!--  <c:if test="${o.orderLists.size() -1 > 0}">외
                  ${b.orderLists.size() -1} 건</c:if></p>
                        <div class="price">${o.totalPrice} 원</div> -->
                        </div>
                    </div>
                    <!-- 상품사진, 품명 -->
                    <!-- 내용 -->
                    <div class="in-col2">
                          ${b.product.content}
                    </div>
                    <!-- 내용 끝 -->
                    <!--  수량  -->
                    <div class="in-col3">
                    ${b.amount}  
                    </div>
                     <div class="in-col3">
                      ${b.product.price}
                      </div>
                      <div class="in-col3">
                        ${b.amount * b.product.price}
                        </div>
                </div>
                </div>
                </li>
                </c:forEach>
                </ul>
            <div class="userbtnbox">
                <button type="button" class="userbtn" onmouseout="change2(this)"
                onmouseover="change1(this)" onclick="location.href='form'">
                  장바구니 채우기</button>
                      
               <button class="userbtn" onmouseout="change2(this)" 
                onmouseover="change1(this)">주문하기</button>
                </div>
                </form>
            </div>
            </div>
            </div>
    
    
    
    
    
    
    
    
    
    
  
  
  
  
  
  
  
  

      




<!-- 
        <a href='form'>장바구니 등록</a><br>
        <form action="../order/form" method="post">
          <table class="table table-striped" border='2'>
            <thead>
              <tr>
                <th>상품</th>
                <th>정보</th>
                <th>수량</th>
                <th>가격</th>
                <th>총 가격</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${basketList}" var="b">
                <tr>
                  <td>
                  <figure class="figure">
  <img src="../../upload/${b.product.photo}_80x80.jpg" class="figure-img img-fluid rounded" alt="...">
  <figcaption class="figure-caption text-end">${b.product.title}</figcaption>
                  </td>
                  <td>${b.product.content}</td>
                  <td>${b.amount}</td>
                  <td>${b.product.price}</td>
                  <td>${b.amount * b.product.price}</td>
              </c:forEach>
            </tbody>
          </table>

          <button>주문하기</button>
        </form>
-->









    <jsp:include page="/footer.jsp"></jsp:include>
    
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/bootstrap.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/SmoothScroll.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/nivo-lightbox.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/jquery.isotope.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/jqBootstrapValidation.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/contact_me.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/main.js"></script>

</body>
</html>