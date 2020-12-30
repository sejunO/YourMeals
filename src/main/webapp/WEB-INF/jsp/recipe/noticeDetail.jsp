<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>레시피 보기</title>
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
<jsp:include page="/header.jsp"></jsp:include>

	<section id="hero" class="d-flex align-items-center img-detail">
		<div
			class="container text-center position-relative aos-init aos-animate"
			data-aos="fade-in" data-aos-delay="200">
			<h1>레시피 살펴보기</h1>
			<br>
			<h2>오늘은 어떤 레시피로 요리해 볼까요?</h2>
		</div>
	</section>

	<div class="container">
		<!-- 레시피 소개 -->
		<section id="about" class="about">
			<div class="container">
				<div class="row content">
				<div class="side-and-side">
				  <div id="left">
				   <a href="list" style="text-decoration: underline; padding-top: 50px;">전체 레시피 보기</a>
				  </div>
				  <div id="right">
        <c:if test="${recipe.writer.userNo == sessionScope.loginUser.userNo}">
				<div class="updateAndDelete" style="text-align: right; padding-bottom: 20px;">
				  <button class="updateBtn" onclick="location.href='beforeUpdate?recipeNo=${recipe.recipeNo}'" style="margin-right: 15px;">수정</button>
				  <button class="deleteBtn" href="delete?recipeNo=${recipe.recipeNo}" onclick="if(!confirm('삭제하시겠습니까?')){return false;}">삭제</button>
				</div>
        </c:if>
				</div>
				</div> 
					<div class="recipe-content" id="img-recipe" data-aos="fade-right"
						data-aos-delay="100">
						<div class="side-and-side">
							<div id="left">
								<h5>조회수: ${recipe.hits}</h5>
								<h5>게시물 ${recipe.recipeNo} 번</h5>
							</div>
							<div id="right">
								<c:if test='${recipe.modifiedDate == null}'>
									<h6>${recipe.createdDate}</h6>
									<h5>${recipe.category.categoryName}</h5>
								</c:if>
								<c:if test='${recipe.modifiedDate != null}'>
									<h5>${recipe.createdDate}(최종수정일:${recipe.modifiedDate})</h5>
									<h5>${recipe.category.categoryName}</h5>
								</c:if>
							</div>
						</div>
						<h2>${recipe.title}</h2>
						<img src="../../upload/${recipe.photo}_1280x720.jpg"
							class="img-thumbnail" alt="..."><br>
					</div>
					<div class="recipe-content2 text-center pt-4 pt-lg-0"
						data-aos="fade-left" data-aos-delay="200">
						<p>${recipe.content}</p>
						<br>
					</div>
					<div id="left">
						<h5>작성자: <a href='../user/recipeList?uNo=${recipe.writer.userNo}'>${recipe.writer.nick}</a></h5>
						<br>
					</div>
				</div>
				<i class="fa-user-friends:before"></i>
			</div>

		</section>






	</div>

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
	<script src="assets/js/main.js"></script>
</body>

</html>