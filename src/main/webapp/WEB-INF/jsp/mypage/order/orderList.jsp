<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>나의주문내역</title>
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
 			<header><jsp:include page="/mypageHeader.jsp"></jsp:include></header>
 			<div class="box3"></div>
 			<div class="box4">MyPage</div>
 		</div>
	</div>
	
	<!--  본문 -->
	<!--  사이드 바 -->
	
	<div class="sub-container">
	<div class="vertical">
		<div class="sidebox">
			<div class="categoryname">
			마이페이지
			</div>
			<div class="profilebox">
				<span class="profilephoto">
				<img class="profile" src='../../../upload/${user.photo}_120x120.jpg'></span>
				<div class="profileinfo">
				<h4>${user.nick} 님</h4>
				<p>${user.email}</p></div>
    		<div class="profileupdate">
    		<a href="/app/mypage/user/update"><button class="btn">정보 수정</button></a></div>
   		</div>
   		<div class="category">
   	<ul>
   			<li><a href="../app/basket/list">장바구니</a></li>
    		<li><a href="../app/mypage/order/buyList">나의 주문내역</a></li>
    		<li><a href="../app/mypage/order/updateList">나의 취소/교환/환불내역</a></li>
   	</ul>
   	 <ul>
   			<li><a href="../app/myrecipe/list">나의 레시피</a></li>
    		<li><a href="../app/mypage/recipe/likeList">내가 좋아한 레시피</a></li>
    </ul>
    <ul>
    		<li><a href="../app/qna/list">QnA 게시판</a></li>
   			<li><a href="../app/mypage/commentList">나의 댓글</a></li>
    </ul>	
    <ul>
    		<li><a href="../app/mypage/following/list">나의 팔로잉</a></li>
    		<li><a href="../app/mypage/follower/list">내 팔로워</a></li>
   	</ul>
    </div>
    </div>
    <!-- 사이드 바 종료-->
    
    <!--  나의 구매내역 본문 -->
  <div class="mybuy-container">
  <!-- 유저 헤더 -->
  	<div class="userheader">
  	<jsp:include page="userHeader.jsp"></jsp:include>
  	</div>
  <!-- 유저 헤더 종료 -->
  
  		
  		<div class="mybuylist">
				<h3>나의 주문내역</h3>
				<ul class="list">
					<li class="thead">
						<div class="td-col1">상품정보</div>
						<div class="td-col2">배송정보</div>
						<div class="td-col3">상태</div>
					</li>
					<li class="tbox">
						<div class="td-box">
							<ul class="order-num">
								<li class="order-date">
								<span>주문일자</span>
								<span class="orderdate">${o.orderDate}</span>
							</ul>
						</div>
					</ul>
			<!-- 		
				</thead>
			<tr>
			  <th>주문일자</th>
			  <th>주문번호</th>
			  <th>우편번호</th>
			  <th>배송지주소</th>
			  <th>주문항목</th>
			  <th>주문금액</th>
			  <th>상태</th>
		 	</tr>
		</thead>
		<tbody>
		<c:forEach items="${orderList}" var="o">
			<tr>
				<td>${o.orderDate}</td>
				<td>${o.orderNo}</td>
				<td>${o.postNo}</td>
				<td>${o.address} ${o.detailAddress}</td>
				<td>${o.orderLists.get(0).orderProduct.content}
					<c:if test="${o.orderLists.size() -1 > 0}">외
								${o.orderLists.size() -1} 건</c:if>
					</td>
				<td>${o.totalPrice}</td>
				<td>
					<c:choose>
						<c:when test="${o.status == 0}">
					입금확인중
						</c:when>
						<c:when test="${o.status == 1}">
					결제완료
						</c:when>
						<c:when test="${o.status == 2}">
					배송준비
						</c:when>
						<c:when test="${o.status == 3}">
					배송중
						</c:when>
						<c:when test="${o.status == 4}">
					배송완료
						</c:when>
				
					<c:otherwise>
					상태값오류
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>-->
    </div>
    	</div>
      </div>
    
    <!--  내용 종료 -->
      </div>  
   </div>
    <jsp:include page="/mypageFooter.jsp"></jsp:include>
    </div>
     
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