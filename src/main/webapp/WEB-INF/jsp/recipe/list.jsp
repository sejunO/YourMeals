<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>레시피 목록</title>
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


<style>
body {
	font-family: "Open Sans", sans-serif;
/* 	color: #444444; */
}
</style>

</head>

<body>
	<jsp:include page="/header.jsp"></jsp:include>

	<section id="hero" class="d-flex align-items-center img-list">
		<div
			class="container text-center position-relative aos-init aos-animate"
			data-aos="fade-in" data-aos-delay="200">
			<h1>YOUR MEALS</h1>
			<br>
			<h2>여러분만의 레시피를 공유해 보세요!</h2>
		</div>
	</section>
<


	<section name="search" >
		<div class="container" id="show">
			 <h3 style="font-weight: bold; padding-bottom: 20px; padding-left: 50px">레시피 검색</h3>
				<form action="list" method="get" style="padding-left: 30px;">
					<div class="form-inline" style="padding-left: 20px; display: flex;">
						<select id="selectbox" name="option">
							<option value="all">전체</option>
							<option value="title">제목</option>
							<option value="writer">작성자</option>
							<option value="category">카테고리</option>
						</select> <input class="form-control" type="text" id="keyword"
							name="keyword" placeholder="검색어를 입력하세요" />
						<button class="searchBtn">검색</button>						
					</div>
					  <div class="right">
        <a href="list" style="text-decoration: underline;">전체 레시피 보기</a>
      </div>
				</form>
		</div>
	</section>


	<section name="showlist" style="padding-bottom: 500px;">
		<div class="container" >
		<div class="side-and-side" style="padding-bottom: 30px;" >	  
		   <div id="left">
		    <a href="form"><button class="addRecipeBtn">새 레시피 만들기</button></a>
	     </div>
	     <div id="right">
	     <a href='list'>최신순 &nbsp;|&nbsp;</a>
	     <a href='list?sort=recommendCount'>추천순 &nbsp;|&nbsp;</a>
	     <a href='list?sort=hits'>조회순 </a>
	     </div>
		</div>
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
							<td><a href='../user/recipeList?uNo=${recipe.writer.userNo}'>${recipe.writer.nick}</a></td>
							<td class="list-color'">${recipe.category.categoryName}</td>
							<td>${recipe.createdDate}</td>
							<td>${recipe.hits}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>

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
	<script src="js/main.js"></script>
</body>

</html>