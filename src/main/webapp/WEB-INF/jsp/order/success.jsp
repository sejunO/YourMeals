<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="../../node_modules/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
  href="../../node_modules/bootstrap/dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/carousel.css">
<title>Insert title here</title>
</head>
<body>
  <div> ${orderList.get(0).orderProduct.title}
  <img class="card-img-top" src="../../upload/${ol.orderProduct.photo}_80x80.jpg"
                      alt="Card image cap" height="80">
    <c:if test="${orderList.size() -1 > 0}">외
                ${orderList.size() -1} 건</c:if>
  </div>
  <div class="container mt-5">
    <div class="row">
      <div class="col-sm-12">
            <h4 style="text-align:left; padding-left: 250px; padding-bottom: 50px;">배송지 정보</h4>
        <div class="d-flex justify-content-center">
            <div class="col-sm-2">
            <p class="text-left" style="padding: 7px;">*이름</p>
            <p class="text-left" style="padding: 7px;">*연락처</p>
            <p class="text-left" style="padding-bottom: 25px; padding-left: 7px; padding-top: 5px;">*주소</p>
            <p class="text-left" style="padding-bottom: 77px; padding-left: 7px; padding-top: 5px;">*메모</p>
          </div>  
          <div class="col-sm-6">
            <p>
              <input type="text" readonly name="userName"
                value='${order.userNo.name}' class="form-control text-center"
                id="exampleFormControlInput1" placeholder="이름"
                style="width: 500px">
            </p>
            <p>
              <input type="text" name="tel" value='${order.tel}'class="form-control text-center"
                id="exampleFormControlInput2" placeholder="연락처"
                style="width: 500px">
            </p>
            <div style="margin-bottom: 10px;">
              <input type="text" class="text-center" id="postNo" name="postNo"
                value='${order.postNo}' placeholder="우편번호" style="width: 200px">
            </div>
            <div style="margin-bottom: 10px;">
              <input type="text" class="text-center" id="address" readonly
                name="address" value="${order.address}" placeholder="주소"
                style="width: 300px"> <input type="text"
                class="text-center" id="detailAddress" name="detailAddress"
                value="${order.detailAddress}" placeholder="상세주소"
                style="margin-left: 15px; width: 180px">
            </div>
            <div style="margin-bottom: 10px;">
              <input type="text" class="text-center" id='totalPrice'
                name="totalPrice" value="${order.totalPrice}" placeholder="총 금액"
                style="width: 200px">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>



  <h3>주문 상품 정보</h3>
  <div class="container mt-5" style="min-height: calc(100vh - 132px); max-height: auto">
          <div class="container-fluid">
            <div class="row">
              <c:forEach items="${orderList}" var="ol">
                <div class="col-3">
                  <div class="card mb-3">
                    <!-- <img src="../../upload/${product.photo}_200x200.jpg"/> -->
                    <div class="card-body">
                    ${ol.orderProduct.title}<img class="card-img-top" src="../../upload/${ol.orderProduct.photo}_80x80.jpg"
                      alt="Card image cap" height="80">
                      <p class="card-title"
                        style="text-align: left; max-height: 50px; margin-top: 11px; font-size: 16px;">${ol.orderProduct.content}</p>
                      <p class="card-text"
                        style="text-align: right; padding-top: 2px; font-weight: 500; font-size: 14px; line-height: 10px;">
                        가격 : ${ol.price}</p>
                      <p class="card-text"
                        style="text-align: right; padding-top: 2px; font-weight: 400; font-size: 12px; line-height: 10px;">
                        수량 : ${ol.amount}</p>
                    </div>
                  </div>
                </div>
              </c:forEach>
                <p style="text-align: right"> 주문금액 : ${order.totalPrice}</p>
            </div>
          </div>
        </div>
  
  
  <a href="../../index.jsp">홈으</a>
</body>

</html>