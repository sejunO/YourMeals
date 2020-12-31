<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>나의 팔로잉</title>
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

		<!--  본문 -->
		<!--  사이드 바 -->

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
						<h3>나의 팔로잉</h3>
						<div class="content-main">
							<table class="content-table" style="text-align: center">
								<thead>
									<tr class="content-table-tr">
										<th class="content-table-th">사용자사진</th>
										<th class="content-table-th">닉네임</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${followingList}" var="fwng">
										<tr>
											<td><img class="user-img"
												src='../../../upload/${fwng.user.photo}_120x120.jpg'></td>
											<td><a href='../../user/recipeList?uNo=${fwng.user.userNo}' style="font-size: 30px">${fwng.user.nick}</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<!--  내용 종료 -->
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
	</div>

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