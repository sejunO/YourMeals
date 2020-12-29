<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>정보수정</title>
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon" href="<%=request.getContextPath() %>/test/img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="<%=request.getContextPath() %>/test/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="<%=request.getContextPath() %>/test/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="<%=request.getContextPath() %>/test/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/fonts/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/test/css/bootstrap.css">
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
	<!--  사이드 바 -->
  
  <div class="sub-container">
  <div class="vertical">
    <jsp:include page="../mySidebar.jsp"></jsp:include>

		<!--  사이드 바 종료 -->
		
		<!--  본문 시작 -->
	 <div class="updatemycontainer">
			<h2>정보 수정</h2>
		<div class="updatebox">
  <form action='update' method='post'>
    <input type='hidden' name='userNo' value='${user.userNo}'>
    
    <div class="updatebox1">
     <span class="labels">이름:</span> <input type='text' class="form-control"
      style="margin-left: 40px;" name='name' placeholder='${user.name}'  readonly>
     </div>
     
     <div class="updatebox2">
    <span class="labels"> 이메일: </span> <input type='text' class="form-control"
     style="margin:5px 0 0 55px;" name='email' placeholder='${user.email}' readonly>
     </div>
     
     <div class="updatebox2">
    <span class="labels"> 닉네임: </span> <input type='text' class="form-control"
     style="margin:5px 0 0 55px;" name='nick' value='${user.nick}'>
     </div>
     
     <div class="updatebox3">
    <span class="labels"> 우편번호:</span> <input type='text'  class="form-control"
      style="margin:5px 0 0 70px; position: relative; "id="postNo" name='postNo' value='${user.postNo}'>
   	 <input type="button" onclick="execPostCode()" class="userbtn" 
   	 style="margin: 5px 0 0 5px; position: relative;" value="우편번호 찾기">
     </div>
     
     <div class="updatebox4">
	   <span class="labels"> 기본주소: </span> <input type='text'  class="form-control"
	     style="margin:5px 0 0 70px; position: relative; id="address" name='address' value='${user.address}'>
	   </div>
	   
	   <div class="updatebox4">
	   <span class="labels">세부주소:</span> <input type='text'  class="form-control"
	     style="margin:5px 0 0 70px; position: relative" id="detailAddress" name='detailAddress'
	     value='${user.detailAddress}'>
     </div>
    
    <div class="userbtnbox">
    <%--메모: <input type="text" id='memo' name="memo"><br> --%>
    <%--비밀번호: <input type='text' name='password' value='${user.password}' readonly><br> --%>
    <button type="button" class="userbtn" onclick="location.href='detailPhoto'">회원사진변경</button>
     
    <button type="button" class="userbtn" style="margin-top: 10px;"
    onclick="location.href='detailPassword'">비밀번호변경</button>
    
    <%--<button type="button" onclick="location.href='deleteMyUser'">회원탈퇴</button><br> --%>
    </div>
   
   <div class="button2">
    <button style="margin-right: 10px;">변경</button>
    <button type="button" onclick="location.href='<%=request.getContextPath() %>/app/mypage/index'">취소</button>
	</div>
  </form>
  </div>
  					</div>
  				</div>
  			</div>
      </div>
    <jsp:include page="/footer.jsp"></jsp:include>
  
  
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execPostCode() {
        new daum.Postcode({
            oncomplete: function(data) {
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
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    <%--document.getElementById("memo").value = extraAddr;--%>
                
                } else {
                  <%--document.getElementById("memo").value = '';--%>
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postNo').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
</script>
   
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
