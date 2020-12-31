<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>나의취소/교환/환불내역</title>
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon" href="<%=request.getContextPath() %>/test/img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="<%=request.getContextPath() %>/test/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="<%=request.getContextPath() %>/test/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="<%=request.getContextPath() %>/test/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/test/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/css/nivo-lightbox/default.css">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700" rel="stylesheet">

</head>
<body id="mypage">
  <div class="main-container">
  <div class="box1">
    <div class="box2">
      <header><jsp:include page="/header.jsp"></jsp:include></header>
      <div class="box3"></div>
      <div class="box4">MyPage</div>
    </div>
  </div>
  
  <!--  본문 -->
  <div class="sub-container">
  <div class="vertical">
  <!--  사이드 바 -->
    <jsp:include page="../mySidebar.jsp"></jsp:include>
    <!-- 사이드 바 종료-->
    
    <!--  나의 구매내역 본문 -->
  <div class="mycontainer">
  <!-- 유저 헤더 -->
    <div class="myheader">
    <jsp:include page="../myHeader.jsp"></jsp:include>
    </div>
  <!-- 유저 헤더 종료 -->
  
      
      <div class="mylist">
        <h3>나의 취소/교환/환불내역</h3>
        <!-- 주문내역 리스트 시작 -->
        <ul class="list">
          <li class="thead">
            <div class="td-col1">상품정보</div>
            <div class="td-col2">배송정보</div>
            <div class="td-col3">상태</div>
          </li>
        <c:forEach items="${updateList}" var="o">
          <li class="tbox">
          <!-- 주문일자, 번호 박스 -->
            <div class="td-box">
              <ul class="order-num">
              
                <li class="order-date">
                <span>주문일자</span>
                <span class="order">${o.orderDate}</span>
                </li>
                
                <li class="ordernum">
                <span>주문번호</span>
                <span class="order">${o.orderNo}</span>
                </li>
                </ul>
                </div>
              <!-- 물품 -->
                <div class="goods">
                  <div class="goodsbox">
                    <div class="in-col1">
                      <div class="imgbox"> 
                        <div class="imgin">
                          <img src="<%=request.getContextPath()%>/upload/${o.orderLists.get(0).orderProduct.photo}_80x80.jpg"/>
                        </div>
                      </div>
                      <div class="goodsinfo">
                        <p class="goodstitle">
                  ${o.orderLists.get(0).orderProduct.title}
                    <c:if test="${o.orderLists.size() -1 > 0}">외
                  ${o.orderLists.size() -1} 건</c:if></p>
                        <div class="price">${o.totalPrice} 원</div>
                      </div>
                    </div>
                    <!-- 상품사진, 상품명, 가격 끝 -->
                    <!-- 배송정보 -->
                    <div class="in-col2">
                      <div class="delivery">
                      <p class="pfont">(${o.postNo})</p>
                      <p class="pfont">${o.address}</p>
                      <p class="pfont">${o.detailAddress}</p>     
                      </div>
                    </div>
                    <!-- 배송정보 끝 -->
                    <!--  상태  -->
                    <div class="in-col3">
                      <div class="status"><strong>
                      <c:choose>
                        <c:when test="${o.status == 11}">
                      취소신청
                        </c:when>
                        <c:when test="${o.status == 12}">
                      취소진행중
                        </c:when>
                        <c:when test="${o.status == 13}">
                      취소(환불)완료
                        </c:when>
                        <c:when test="${o.status == 21}">
                      반품신청
                        </c:when>
                        <c:when test="${o.status == 22}">
                      반품진행중
                        </c:when>
                        <c:when test="${o.status == 23}">
                      반품(환불)완료
                        </c:when>
                        <c:when test="${o.status == 31}">
                      교환신청
                        </c:when>
                        <c:when test="${o.status == 32}">
                      교환진행중
                        </c:when>
                        <c:when test="${o.status == 33}">
                      교환완료
                        </c:when>
                    
                      <c:otherwise>
                      상태값오류
                      </c:otherwise>
                    </c:choose>
                  </strong>           
                  </div>
                </div>
              </div>
            </div>
                </c:forEach>
              </ul>
            </div>
        </div>
      </div>
      </div>
    
    <!--  내용 종료 -->
      </div>  
    <jsp:include page="/footer.jsp"></jsp:include>
     
 <script type="text/javascript" src="<%=request.getContextPath() %>/test/js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/bootstrap.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/SmoothScroll.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/nivo-lightbox.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/jquery.isotope.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/jqBootstrapValidation.js"></script> 
<%--<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/contact_me.js"></script>--%>
<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/main.js"></script>

</body>
</html>