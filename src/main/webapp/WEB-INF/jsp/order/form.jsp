<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/header.jsp"></jsp:include>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
    </head>

    <body>

      <h2>배송지 정보</h2>
      <form action="add" method="post">
        <div class="container mt-5">
          <div class="row">
            <div class="col-sm-12">
              <div class="d-flex justify-content-center">
                <div class="col-sm-2">
                  <p class="text-left" style="padding: 7px;">
                    <font class="required-star">*</font>이름
                  </p>
                  <p class="text-left" style="padding: 7px;">
                    <font class="required-star">*</font>연락처
                  </p>
                  <p class="text-left" style="padding-bottom: 77px; padding-left: 7px; padding-top: 5px;">
                    <font class="required-star">*</font>주소
                  </p>
                </div>
                <div class="col-sm-6">
                  <p>
                    <input type="text" readonly name="userName" value='${user.name}' class="form-control text-center"
                      id="exampleFormControlInput1" placeholder="이름" style="width: 500px">
                  </p>
                  <p>
                    <input type="text" name="tel" class="form-control text-center" id="exampleFormControlInput2"
                      placeholder="연락처" style="width: 500px">
                  </p>
                  <div style="margin-bottom: 10px;">
                    <input type="text" class="text-center" name="postNo" value='${user.postNo}' placeholder="우편번호"
                      style="width: 200px">
                    <input type="button" onclick="execPostCode()" value="찾기" style="width: 100px"><br>
                  </div>
                  <div style="margin-bottom: 10px;">
                    <input type="text" class="text-center" id="address" name="address" value="<c:if test=" ${not empty
                      user.address}">${user.address}</c:if>"
                    placeholder="주소" style="width: 300px"> <input type="text" class="text-center" id="detailAddress"
                      name="detailAddress" value="<c:if test=" ${not empty user.detailAddress}">${user.detailAddress}
                    </c:if>"
                    placeholder="상세주소" style="margin-left: 15px; width: 180px">
                  </div>
                  <div style="margin-bottom: 10px;">
                    <input type="text" class="text-center" id='memo' name="memo" placeholder="메모" style="width: 200px">
                  </div>
                </div>
                <script>
                  function execPostCode() {
                    new daum.Postcode(
                      {
                        oncomplete: function (data) {
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
        </div>

        <h3>주문 상품 정보</h3>
        <c:forEach items="${baskets}" var="b">
          <div style="margin-bottom: 10px;">
            제품 <input type="text" class="text-center" value='${b.product.title}'
              style="margin-left: 15px; width: 180px">
            수량 <input type="text" class="text-center" value='${b.amount}' style="margin-top: 10px; margin-left: 15px; width: 20px"><br>
            가격 <input type="text" class="text-center" value='${b.product.price}원' style="margin-left: 5px; margin-top: 10px; width: 80px">
            주문금액 <input type="text" class="text-center" value='${b.product.price}*${b.amount}' style="margin-top: 10px; width: 120px">
            <input type="text" class="text-center" value='${b.writer.name}' style="width: 150px">
          </div>

          <table>
            <tr>
              <td>${b.product.title}</td>
              <td>${b.amount}</td>
              <td>${b.product.price}</td>
              <td>${b.writer.name}</td>
              <td>${b.product.price}*${b.amount}</td>
          </table>

        </c:forEach>


        <h3>결제 방법 선택</h3>
        <c:forEach items="${payments}" var="p">
          <input type="radio" name="paymentNo" value="${p.paymentNo}">${p.name}
        </c:forEach>
        <button>결제하기</button>
      </form>

      <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    </body>

    </html>