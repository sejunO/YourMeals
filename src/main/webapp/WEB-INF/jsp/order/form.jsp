<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
  href="../../node_modules/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
  href="../../node_modules/bootstrap/dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/carousel.css">
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
  href="<%=request.getContextPath()%>/test/css/mystyle.css">
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

<body>
  <form action="add" method="post">
    <div class="goods">
      <div class="goodsbox">
          <div class="in-col1">
            <div class="imgbox">
              <div class="imgin">
                <img
                  src="../../upload/${baskets.get(0).product.photo}_80x80.jpg" />
              </div>
            </div>
            <div>
              ${baskets.get(0).product.title}
              <div class="goodsinfo">
                <p class="goodstitle">
                  <c:if test="${baskets.size() -1 > 0}">외
                        ${baskets.size() -1} 건</c:if>
              </div>
            </div>
          </div>
      </div>
    </div>
    <h2 style="padding-bottom: 25px; text-align: center">배송지 정보</h2>
    <div class="container mt-6" style="align : center">
      <div class="row">
        <div class="col-sm-12">
          <div class="d-flex justify-content-center">
            <div class="col-sm-1">
              <p class="text-left" style="padding-bottom: 30px;">*이름</p>
              <p class="text-left" style="padding-bottom: 30px;">*연락처</p>
              <p class="text-left"
                style="padding-bottom: 25px; padding-left: 7px; padding-top: 10px;">
                *주소</p>
              <p class="text-left"
                style="padding-bottom: 77px; padding-left: 7px; padding-top: 10px;">
                *메모</p>
            </div>
            <div class="col-sm-7">
              <p style="padding-bottom: 10px">
                <input type="text" readonly name="userName" value='${user.name}'
                  class="form-control text-center" id="exampleFormControlInput1"
                  placeholder="이름" style="width: 500px;">
              </p>
              <p style="padding-bottom: 10px">
                <input type="text" name="tel" class="form-control text-center"
                  id="exampleFormControlInput2" placeholder="연락처"
                  style="width: 500px;">
              </p>
              <div style="margin-bottom: 10px;">
                <input type="text" class="text-center" id="postNo" name="postNo"
                  value="${user.postNo}" placeholder="우편번호" style="width: 200px">
                <input type="button" onclick="execPostCode()" value="찾기"
                  style="width: 100px"><br>
              </div>
              <div style="margin-bottom: 10px;">
                <input type="text" class="text-center" id="address"
                  name="address"
                  value="<c:if test=" ${not empty
                      user.address}">${user.address}</c:if>"
                  placeholder="주소" style="width: 300px"> <input
                  type="text" class="text-center" id="detailAddress"
                  name="detailAddress"
                  value="<c:if test=" ${not empty user.detailAddress}">${user.detailAddress}
                    </c:if>"
                  placeholder="상세주소" style="margin-left: 15px; width: 180px">
              </div>
              <div style="margin-bottom: 10px;">
                <input type="text" class="text-center" id='memo' name="memo"
                  placeholder="메모" style="width: 200px">
              </div>
            </div>
            <script>
              function execPostCode() {
                new daum.Postcode(
                    {
                      oncomplete : function(data) {
                        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                        var addr = ''; // 주소 변수
                        var extraAddr = ''; // 참고항목 변수

                        //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                          addr = data.roadAddress;
                        } else { // 사용자가 지번 주소를 선택했을 경우(J)
                          addr = data.jibunAddress;
                        }

                        // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                        if (data.userSelectedType === 'R') {
                          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                          if (data.bname !== ''
                              && /[동|로|가]$/g
                                  .test(data.bname)) {
                            extraAddr += data.bname;
                          }
                          // 건물명이 있고, 공동주택일 경우 추가한다.
                          if (data.buildingName !== ''
                              && data.apartment === 'Y') {
                            extraAddr += (extraAddr !== '' ? ', '
                                + data.buildingName
                                : data.buildingName);
                          }
                          // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                          if (extraAddr !== '') {
                            extraAddr = ' ('
                                + extraAddr
                                + ')';
                          }
                          // 조합된 참고항목을 해당 필드에 넣는다.
                          document
                              .getElementById("memo").value = extraAddr;

                        } else {
                          document
                              .getElementById("memo").value = '';
                        }

                        // 우편번호와 주소 정보를 해당 필드에 넣는다.
                        document
                            .getElementById('postNo').value = data.zonecode;
                        document
                            .getElementById("address").value = addr;
                        // 커서를 상세주소 필드로 이동한다.
                        document.getElementById(
                            "detailAddress")
                            .focus();
                      }
                    }).open();
              }
            </script>
          </div>
        </div>
      </div>
    </div>
    <div class="container mt-6">
      <div class="row">
        <div class="col-sm-12">
          <div class="curOrder">
            <h3>나의 주문내역</h3>
            <!-- 주문내역 리스트 시작 -->
            
            <ul class="list">
              <li class="thead">
                <div class="td-col1">상품정보</div>
                <div class="td-col1" style= "margin-left: 87px">수  량</div>
                <div class="td-col1">가   격</div>
                <div class="td-col1">주문금액</div>
              </li>
              <c:forEach items="${baskets}" var="b">
                <!-- 주문일자, 번호 박스 -->
                <div class="td-box">
                  <ul class="orderinfo">
                    <li class="prodinfo"><span class="basket" style= "margin-left: 87px">${b.product.title}</span>
                    </li>
                  </ul>
                </div>
                <!-- 물품 -->
                <div class="tbody">
                  <div class="goodsbox">
                    <div class="in-col1" style= "margin-left: 70px">
                      <div class="imgbox">
                        <div class="imgin">
                          <img src="../../upload/${b.product.photo}_80x80.jpg" />
                        </div>
                      </div>
                    </div>
                    <div class="in-col2">
                      <div class="goods">
                        <p class="amount">${b.product.content}</p>
                        <div class="amount">${b.amount}개</div>
                      </div>
                    </div>
                    <!-- 상품사진, 상품명, 가격 끝 -->
                    <div class="in-col2" style= "margin-left: 17px">
                      <div class="goods">
                        <p class="price">${b.product.price}원</p>
                      </div>
                    </div>
                    <!-- 배송정보 끝 -->
                    <!--  상태  -->
                    <div class="in-col2">
                      <div class="goods">
                        <p>${b.product.price * b.amount}원</p>
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
    <%-- <div class="container mt-5" style="min-height: calc(100vh - 132px); max-height: auto">
          <div class="container-fluid">
            <div class="row">
              <c:forEach items="${baskets}" var="b">
                <div class="col-3">
                  <div class="card mb-3">
                    <!-- <img src="../../upload/${product.photo}_200x200.jpg"/> -->
                    <img class="card-img-top" src=img src="../../upload/${b.product.photo}_30x30.jpg"
                      alt="Card image cap" height="50">${b.product.title}
                    <div class="card-body">
                      <p class="card-title"
                        style="text-align: left; max-height: 50px; margin-top: 11px; font-size: 16px;">${p.content}
                      </p>
                      <p class="card-text"
                        style="text-align: right; padding-top: 4px; font-weight: 500; font-size: 14px; line-height: 20px;">
                        가격 : ${b.product.price}</p>
                      <p class="card-text"
                        style="text-align: right; padding-top: 4px; font-weight: 400; font-size: 12px; line-height: 20px;">
                        수량 : ${b.amount}</p>
                      <p class="card-text"
                        style="text-align: right; padding-top: 4px; font-weight: 400; font-size: 12px; line-height: 20px;">
                        주문금액 : ${b.product.price}*${b.amount}</p>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </div>
          </div>
          </div> --%>
    <%-- <div style="margin-bottom: 10px;">
            <input type="text" class="text-center" value='' style="margin-left: 10px; width: 200px">
            제품 <input type="text" class="text-center" value='${b.product.title}'
              style="margin-left: 15px; width: 180px">
            수량 <input type="text" class="text-center" id='amount' value=''
              style="margin-top: 10px; margin-left: 15px; width: 20px"><br>
            가격 <input type="text" class="text-center" id='price' value='원'
              style="margin-left: 5px; margin-top: 10px; width: 80px">
            주문금액 <input type="text" class="text-center" id='total' value='total()'
              style="margin-top: 10px; width: 120px">
            <input type="text" class="text-center" value='${b.writer.name}' style="width: 150px">

            </div> --%>

    <%-- <table>
              <tr>
                <td>${b.product.title}</td>
                <td>${b.amount}</td>
                <td>${b.product.price}</td>
                <td>${b.writer.name}</td>
                <td></td>
                <div id="total"></div>
                </table> --%>

    <h3>결제 방법 선택</h3>
    <c:forEach items="${payments}" var="p">
      <input type="radio" name="paymentNo" value="${p.paymentNo}">${p.name}
                </c:forEach>
    <button>결제하기</button>
  </form>


  <script
    src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>

</html>