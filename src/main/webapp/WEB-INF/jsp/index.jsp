<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>YourMeals</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons
    ================================================== -->
<link rel="shortcut icon"
	href="<%=request.getContextPath() %>/test/img/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="<%=request.getContextPath() %>/test/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="<%=request.getContextPath() %>/test/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="<%=request.getContextPath() %>/test/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/test/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/test/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/test/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/test/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/test/css/nivo-lightbox/default.css">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<header><jsp:include page="/header.jsp"></jsp:include></header>
	<!-- Header -->
	<header id="header">
		<div class="intro">
			<div class="overlay">
				<div class="container">
					<div class="row">
						<div class="intro-text">
							<h1>YourMeals</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- About Section -->
	<div id="about">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-6 ">
					<div class="about-img">
						<img src="<%=request.getContextPath() %>/test/img/about.jpg"
							class="img-responsive">
					</div>
				</div>
				<div class="col-xs-12 col-md-6">
					<div class="about-text">
						<hr>
						<p>
							<b>YOUR MEALS</b>
						</p>
						<p>
							냉장고에 있는 재료만으로 적당한 레시피가 떠오르지 않을때,<br> 나가기는 싫고 부족한 재료를 빠르게
							배송받고 싶을 때,<br> 나만의 레시피를 남들에게 공유하고 싶을 때,<br> <b>YourMeals</b>와
							함께 요리합시다!
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Restaurant Menu Section -->
	<div id="restaurant-menu">
		<div class="section-title text-center center">
			<div class="overlay">
				<hr>
				<h2>Recipe Category</h2>
			</div>
		</div>
		<!-- Portfolio Section -->
		<div id="portfolio">
			<div class="container">
				<div class="row">
					<div class="categories">
						<ul class="cat">
							<li>
								<ol class="type">
									<li><a href="#" data-filter="*" class="active">All</a></li>
									<c:forEach items="${categoryList}" var="c">
										<li><a href="#" data-filter=".${c.categoryNo}">${c.categoryName}</a></li>
									</c:forEach>
								</ol>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="row">
					<div class="portfolio-items">
						<c:forEach items="${recipeList}" var="r">
							<div class="col-sm-6 col-md-4 col-lg-4 ${r.category.categoryNo}">
								<div class="portfolio-item">
									<div class="hover-bg">
										<a href="./recipe/detail?recipeNo=${r.recipeNo}" title="Dish Name" data-lightbox-gallery="gallery1">
											<div class="hover-text">
												<h4>${r.title}</h4>
											</div> 
											<img src="../upload/${r.photo}_360x240.jpg" class="img-responsive" alt="Project Title">
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../../footer.jsp"></jsp:include>

	<script type="text/javascript"
		src="<%=request.getContextPath() %>/test/js/jquery.1.11.1.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/test/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/test/js/SmoothScroll.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/test/js/nivo-lightbox.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/test/js/jquery.isotope.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/test/js/jqBootstrapValidation.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/test/js/contact_me.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/test/js/main.js"></script>
</body>
</html>
