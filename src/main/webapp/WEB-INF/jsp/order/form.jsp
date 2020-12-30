<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>주문</title>
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
        <div class="box4">Order</div>
      </div>
    </div>
    </div>
  
    <div class="sub-container">
  <div class="vertical">
   <div class="mylist">
       <div class="headtitle"><h1 style="font-size: 50px;
       margin-bottom: 40px; text-align: center;">주문</h1></div>
       
   <div class="headtitle">주문내역</div>
   <ul class="list">
          <li class="thead">
            <div class="td-col1">상품정보</div>
            <div class="td-col3">수량</div>
            <div class="td-col3">가격</div>
            <div class="td-col3">총금액</div>
          </li>
          
          
        <c:forEach items="${baskets}" var="b">
          <li class="tbox">
          
              <!-- 물품 -->
                <div class="goods">
                  <div class="goodsbox" style="justify-content: center;">
                    <div class="in-col1"
                     style="margin-left: 120px; margin-right: 100px;">
                      <div class="imgbox"> 
                        <div class="imgin">
              <img src="../../upload/${b.product.photo}_80x80.jpg" alt="...">
                         </div>
                      </div>
                      <div class="goodsinfo">
                        <p class="goodstitle">
                          ${b.product.title}  </p>
                       </div>
                    </div>
                    
                    <!-- 상품정보 끝 -->
                    
                    <!--  내용 -->
                    <div class="in-col3">
                      ${b.amount}  
                    </div>
                    <div class="in-col3">
                      ${b.product.price}원
                    </div>
                    <div class="in-col3">
                      ${b.product.price * b.amount}원
                    </div>
                </div>
                </div>
                </li>
                </c:forEach>
                </ul>
            </div>
          </div>
       
            <!--  배송지 정보 -->
    <form action="add" method="post">
          <h2 class="headtitle"
         style="border-bottom: 4px solid #000; padding-bottom: 10px;"> 배송지 정보</h2>
    <input type='hidden' name='userNo' value='${user.userNo}'>
    
    <div class="updatebox1">
     <span class="labels" style="font-size: 17px; padding-top: -7px;">*이름:</span> 
     <input type='text' class="form-control" id="exampleFormControlInput1"
      style="margin-left: 50px;" name="userName" placeholder='${user.name}'  readonly>
     </div>
           
    <div class="updatebox2">
    <span class="labels" style="font-size: 17px; padding-top: -7px;"> *연락처: </span>
     <input type='text' class="form-control" style="margin:5px 0 0 65px;"
     name="tel" id="exampleFormControlInput2" placeholder='ex)000-0000-0000'>
     </div>     
            
   <div class="updatebox3">
    <span class="labels" style="font-size: 17px; padding-top: -7px; margin-left: 5px;"> 우편번호:</span>
     <input type='text'  class="form-control" id="postNo" name='postNo' value='${user.postNo}'
      style="margin:5px 0 0 80px; position: relative;">
     <input type="button" onmouseout="change2(this)" onmouseover="change1(this)"
     onclick="execPostCode()" class="userbtn" style="margin: 5px 0 0 5px; position: relative;" value="우편번호 찾기">
     </div>     
     
  <div class="updatebox4">
     <span class="labels" style="font-size: 17px; padding-top: -7px; margin-left: 5px;"> 기본주소: </span>
     <input type='text' class="form-control"
       style="margin:5px 0 0 80px; position: relative;" id="address" name='address'
       value="<c:if test=" ${not empty user.address}">${user.address}</c:if>">
     </div>
     
  <div class="updatebox4">
     <span class="labels" style="font-size: 17px; padding-top: -7px; margin-left: 5px;">세부주소:</span>
      <input type='text'  class="form-control"
       style="margin:5px 0 0 80px; position: relative;" id="detailAddress" name='detailAddress'
       value="<c:if test=" ${not empty user.detailAddress}">${user.detailAddress}</c:if>">
     </div>    
           
  <div class="updatebox4">
     <span class="labels" style="font-size: 17px; padding-top: -7px; margin-left: 37px;">메모:</span>
      <input type='text' class="form-control" id="memo" name='memo'
      style="margin:5px 0 0 80px; placeholder="메모">
     </div>
     </form>
     
  <h2 class="headtitle"
         style="border-bottom: 4px solid #000; padding-bottom: 10px; margin-top: 50px;"> 결제</h2>
    <div class="payment">
    <c:forEach items="${payments}" var="p">
      <input type="radio" name="paymentNo" value="${p.paymentNo}">${p.name}
      </c:forEach>
     </div> 
     
    <button class="userbtn" onmouseout="change2(this)" onmouseover="change1(this)"
    style="margin: 20px 0 70px 0;" onclick="location.href='success'">
    결제하기</button>
    </div>
   
   
   
    <jsp:include page="/footer.jsp"></jsp:include>
    
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

    
    
    <!--  스크립트  -->
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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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