<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Userpage</title>
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
	href="<%=request.getContextPath()%>/test/css/userstyle.css">
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
				<div class="box4">UserPage</div>
			</div>
		</div>
	</div>

	<div class="main-content">
		<div class="content-container">
			<section name="search" id="show">
				<div class="search-container">
					<h3 style="font-weight: bold; padding-bottom: 30px;">회원 검색</h3>
					<form action="list" method="get">
						<div class="form-inline">
							<input class="form-control" type="text" id="keyword"
								name="keyword" placeholder="검색어를 입력하세요" />
							<button class="searchBtn">검색</button>
						</div>
					</form>
				</div>
			</section>
			<div class="content-main">
				<table class="content-table" style="text-align: center">
					<thead>
						<tr class="content-table-tr">
							<th class="content-table-th">번호</th>
							<th class="content-table-th">닉네임</th>
							<th class="content-table-th">사용자 정보</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${list}" var="u">
							<tr>
								<td>${u.userNo}</td>
								<td>${u.nick}</td>
								<td><a href='recipeList?uNo=${u.userNo}'>[${u.name}님의	정보]</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		    <div>
				<c:if test="${prevPageNo == currPageNo}">
				  [이전]
				</c:if>
				<c:if test="${prevPageNo < currPageNo}">
				  <a href="?keyword=${keyword}&pageNo=${prevPageNo}&pageSize=${pageSize}">[이전]</a>
				</c:if>
				<span> ${currPageNo} </span>
				<c:if test="${nextPageNo == currPageNo}">
				  [다음]
				</c:if>
				<c:if test="${nextPageNo > currPageNo}">
				  <a href="?keyword=${keyword}&pageNo=${nextPageNo}&pageSize=${pageSize}">[다음]</a>
				</c:if>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>