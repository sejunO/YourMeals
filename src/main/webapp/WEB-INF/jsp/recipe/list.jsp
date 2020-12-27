<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>recipe list</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--=========== example 따온거 =============-->

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="<%=request.getContextPath()%>/node_modules/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/node_modules/css/bootstrap.grid.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/node_modules/vendor/icofont/icofont.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/node_modules/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/node_modules/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/node_modules/vendor/venobox/venobox.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/node_modules/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/node_modules/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<%=request.getContextPath()%>/css/recipe.css"
	rel="stylesheet">

<!-- Font Awesome Icons-->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

<!-- ============= 글상자 ================-->
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/album/">

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/node_modules/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">


</head>

<body>
	<jsp:include page="/recipeHeader.jsp"></jsp:include>

	<section id="hero" class="d-flex align-items-center img-list">
		<div
			class="container text-center position-relative aos-init aos-animate"
			data-aos="fade-in" data-aos-delay="200">
			<h1>레시피 살펴보기</h1>
			<br>
			<h2>오늘은 어떤 레시피로 요리해 볼까요?</h2>
		</div>
	</section>


	<section name="search" >
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6 show-newsletter" id="show">
					<h3 style="margin-top: 30px; margin-bottom: 50px; padding-left: 20px; font-size: 32px;
    font-weight: bold; text-transform: uppercase; font-family: ingerit;">레시피 검색</h3>
					<div class="row">
						<div class="col-md-11" style="padding-left: 36px;">
							<div class="form-inline" style="padding-left: 20px;">
							
								<select id="selectbox" name="selectbox">
									<option value="">전체</option>
									<option value="title">제목</option>
									<option value="writer">작성자</option>
									<option value="category">카테고리</option>
								</select> 
								
								<input class="form-control" type="text" id="keyword"
									name="keyword" value=""
									placeholder="검색어를 입력하세요" />
								<button id="searchBtn" class="searchBtn">검색</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
	</section>

	<section name="showlist">
		<div class="container">
			<table class="table" style="text-align: center">
				<thead>
					<tr style="background-color: rgb(250, 247, 240);">
						<th class="notice-category" style="text-align: center">번호</th>
						<th class="notice-category" style="text-align: center">사진</th>
						<th class="notice-category" style="text-align: center">제목</th>
						<th class="notice-category" style="text-align: center">작성자</th>
						<th class="notice-category" style="text-align: center">방법</th>
						<th class="notice-category" style="text-align: center">작성일</th>
						<th class="notice-category" style="text-align: center">조회</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${notices}" var="n">
						<tr>
							<td>${n.noticeNo}</td>
							<td>-</td>
							<td class="notice-title"><a
								href='detail?noticeNo=${n.noticeNo}'>${n.title}</a></td>
							<td>관리자</td>
							<td class="notice-color">공지사항</td>
							<td>${n.registeredDate}</td>
							<td>-</td>
						</tr>
					</c:forEach>
					<c:forEach items="${list}" var="recipe">
						<tr>
							<td>${recipe.recipeNo}</td>
							<td><img src='../upload/%1$s_30x30.jpg'>${recipe.photo}</td>
							<td><a href='detail?recipeNo=${recipe.recipeNo}'>${recipe.title}</a></td>
							<td>${recipe.writer.nick}</td>
							<td class="list-color'">${recipe.category.categoryName}</td>
							<td>${recipe.createdDate}</td>
							<td>${recipe.hits}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>



	<!-- 페이지 맨 밑 설명 + Back to top-->
	<footer class="text-muted">
		<div class="container">
			<p class="float-right">
				<a href="#">Back to top</a>
			</p>
			<p>Album example is &copy; Bootstrap, but please download and
				customize it for yourself!</p>
			<p>
				New to Bootstrap? <a href="https://getbootstrap.com/">Visit the
					homepage</a> or read our <a
					href="/docs/4.5/getting-started/introduction/">getting started
					guide</a>.
			</p>
		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/docs/4.5/assets/js/vendor/jquery.slim.min.js"><\/script>')
	</script>
	<script
		src="<%=request.getContextPath()%>/node_modules/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>

	<!-- Vendor JS Files -->
	<script src="<%=request.getContextPath()%>/jquery/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/jquery.easing/jquery.easing.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/waypoints/jquery.waypoints.min.js"></script>
	<script src="<%=request.getContextPath()%>/venobox/venobox.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/owl.carousel/owl.carousel.min.js"></script>
	<script src="<%=request.getContextPath()%>/aos/aos.js"></script>
	<script src="<%=request.getContextPath()%>/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
</body>

</html>