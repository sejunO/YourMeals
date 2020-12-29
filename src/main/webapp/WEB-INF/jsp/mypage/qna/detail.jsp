<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Q&A</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<body id="mypage">
  <div class="main-container">
    <div class="box1">
      <div class="box2">
        <header><jsp:include page="/header.jsp"></jsp:include></header>
        <div class="box3"></div>
        <div class="box4">MyPage</div>
      </div>
    </div>

    <div class="sub-container">
      <div class="vertical">
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
            <h3>QnA 게시판</h3>
					<form action='update' class="qnabox" method='post'>
					
							<div class="qnalist">
						<div class="qnanobox">
									<strong><div>번호</div></strong>
								<div class="qnano">
									${qna.qnaNo}
								</div>
								
								 <strong><div style="padding-left: 100px;">등록일</div></strong>
								<div class="qnano">
										${qna.createdDate}
								</div>
						</div>	
					</div>
						
						<div class="qnatitlebox">
									<strong><div style="padding-top: 3px;">제목</div></strong>
								<div class="qnano">
									<input type='text' class="titlebox" name='title' value="${qna.title}">
						</div>	
					</div>
							
						<div class="contentbox">
						<textarea name='content' class="incontentbox">${qna.content}</textarea>
						</div>	
						<input type="hidden" name="qnaNo" value="${qna.qnaNo}"/>
						<div class="qnabtn">
						<a href='delete?qnaNo=${qna.qnaNo}'> 
						<button class="btn" type="button" style="margin-top: 20px; background: rgb(224, 156, 119);">삭제</button></a>
						<button class="btn" style="margin-top: 20px;
						 margin-right: 5px;  width: 55px; margin-left: 550px; padding-right: 20px;"> 변경</button>
						<a href='list'>
						<button class="btn" type="button" style="margin-top: 20px; background: white; color: black;">취소</button></a>
						</div>
	    			</form>
						
    			</div>
        </div>
      </div>

  <!--  내용 종료 -->
    </div>
  </div>
  <jsp:include page="/footer.jsp"></jsp:include>

<!-- 
<form action='update' method='post'>
번호: <input type='text' name='qnaNo' value="${qna.qnaNo}" readonly><br>
제목: <input type='text' name='title' value="${qna.title}"><br>
내용: <textarea name='content'>${qna.content}</textarea><br>
등록일: ${qna.createdDate}<br>
<button>변경</button>
<a href='delete?qnaNo=${qna.qnaNo}'>삭제</a>
</form> -->


<script type="text/javascript"
    src="<%=request.getContextPath()%>/test/js/jquery.1.11.1.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath()%>/test/js/bootstrap.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath()%>/test/js/SmoothScroll.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath()%>/test/js/nivo-lightbox.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath()%>/test/js/jquery.isotope.js"></script>
  <script type="text/javascript"
    src="<%=request.getContextPath()%>/test/js/jqBootstrapValidation.js"></script>
  <%--<script type="text/javascript" src="<%=request.getContextPath() %>/test/js/contact_me.js"></script>--%>
  <script type="text/javascript"
    src="<%=request.getContextPath()%>/test/js/main.js"></script>

</body>
</html>
