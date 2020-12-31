<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>레시피 보기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/test/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/node_modules/bootstrap/dist/css/bootstrap-grid.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<%=request.getContextPath()%>/css/recipe.css"
	rel="stylesheet">


<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/album/">

<link
	href="<%=request.getContextPath()%>/test/css/bootstrap.min.css">

    

  <script src="<%=request.getContextPath()%>/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

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
				   <a href="list" style="text-decoration: underline; padding-top: 50px;">레시피 목록으로 돌아가기</a>
				  </div>
				  <div id="right">
        <c:if test="${recipe.writer.userNo == sessionScope.loginUser.userNo}">
				<div class="updateAndDelete" style="text-align: right; padding-bottom: 20px;">
				  <button class="updateBtn" onclick="location.href='beforeUpdate?recipeNo=${recipe.recipeNo}'" style="margin-right: 15px;">수정</button>
				  <a href="delete?recipeNo=${recipe.recipeNo}" id="btnDeleteRecipe"
				  onclick="if(!confirm('삭제하시겠습니까?')){return false;}">삭제</a>
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

		<section id="info" class="services">
			<div id="col-icon2">
				<div class="col-icon d-flex align-items-stretch">
					<div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
						<div class="icon">
							<i class="bx bxl-dribbble"></i>
						</div>
						<h4>${recipe.serving}인분</h4>
					</div>
				</div>

				<div class="col-icon d-flex align-items-stretch">
					<div class="icon-box" data-aos="zoom-in" data-aos-delay="200">
						<div class="icon">
							<i class="bx bx-file"></i>
						</div>
						<h4>${recipe.min}분</h4>
					</div>
				</div>

				<div class="col-icon d-flex align-items-stretch">
					<div class="icon-box" data-aos="zoom-in" data-aos-delay="300">
						<div class="icon">
							<i class="bx bx-tachometer"></i>
						</div>
						<h4>
						
						<c:choose>
							<c:when test="${recipe.levelNo} == 1">하</c:when>
							<c:when test="${recipe.levelNo} == 2">중</c:when>
							<c:otherwise>상</c:otherwise>
						</c:choose>
						</h4>
					</div>
				</div>
			</div>
		</section>
		<hr>
		<!-- 재료 -->
		<section id="recipe-material" class="contact">
			<div class="container-material recipe-step-bg">
				<div class="row">
					<div class="col-lg-8" data-aos="fade-up" data-aos-delay="100">
						<div class="col-lg-4" data-aos="fade-right">
							<div class="section-title">
								<h2>재료</h2>
							</div>
						</div>

						<table class="table table-borderless">
							<thead>
								  <tr class="table-secondary">
									<th><h5>이름</h5></th>
									<th><h5>계량</h5></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items='${foods}' var='f'>
							  <tr>
									<td><h5>${f.name}</h5></td>
									<td><h5>${f.amount}</h5></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>

						<div class="album py-5">

							<div class="php-email-form">
								<div class="text-center">
									<button type="submit"  onclick="location.href='../basket/form'">부족한 재료 주문하기</button>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</section>



		<!-- 조리 순서 -->
		<section id="recipe-step" class="contact">
			<div class="container-material recipe-step-bg">
				<div class="row">
					<div class="col-lg-4" data-aos="fade-right">
						<div class="section-title">
							<h2>조리 순서</h2>
						</div>
					</div>
					<div class="info">
						<c:forEach items="${recipeSteps}" var="rs">
							<div style="padding-top: 10px;">
								<i class="icofont-envelope"></i>
								<h4>STEP${rs.step}</h4>
								<div class="recipe-step-con">
									<div>
										<img src="../../upload/${rs.photo}_500x500.jpg"
											class="img-thumbnail" alt="...">
									</div>
									<div style="padding-left: 100px">${rs.content}</div>
									<div></div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</section>

		<section id="boardlike" class="services">
			<div id="col-icon2">
				<div class="col-icon d-flex align-items-stretch">
					<div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
						<div class="icon">
							<i class="bx bxl-dribbble"></i>
						</div>
						<h4>${recipe.recommendCount}</h4>
					</div>
				</div>

				<div class="col-icon d-flex align-items-stretch">
					<div class="icon-box" data-aos="zoom-in" data-aos-delay="200">
						<div class="icon">
							<i class="bx bx-file"></i>
						</div><br>
						<h4>스크랩</h4>
					</div>
				</div>
			</div>
		</section>


		<!-- 댓글 -->
		<section id="comment" class="contact">
			<div class="container-marterial">
				<div class="row">
					<div class="col-lg-4" data-aos="fade-right">
						<div class="section-title">
							<h2>댓글</h2>
						</div>
					</div>
					<div class="php-email-form mt-4">
						<div class="form-group" style="padding-bottom: 8px; margin-right: 250px">
							<textarea id="commentText" class="form-control" rows="5"
								placeholder="댓글을 입력하세요."></textarea>
						</div>
						<div class="text-center" style="margin:0px; float:left">
							<button id="commentBtn" type="button">입력</button>
						</div>
					</div>
					
					 <div id="listComment" class="col-lg-4" style="background: #f1f0f2; width: 100%; padding: 30px;">
					   <c:forEach items="${comments}" var="c">
					     <div class="side-and-side">
                <div id="left">
                  <h5><a href='../user/recipeList?uNo=${c.writer.userNo}'>${c.writer.nick}</a></h5>
                </div>
                <div id="right">
                  <c:if test="${recipe.modifiedDate == null}">
                    ${recipe.createdDate}
                  </c:if>
                  <c:if test="${recipe.modifiedDate != null}">
                     ${recipe.createdDate}(수정일: ${recipe.modifiedDate})
                  </c:if>
              </div>
            </div>
            <div style="text-align: left; padding-top: 15px">
              <p style="margin: 0px 15px 10px;">${c.content}</p>
              </div>   
              <div id="right">
                <h5><a href="">수정</a>&nbsp;&nbsp;<a href="">삭제</a></h5>
                </div>
              <hr style="border: 0; height: 2px; width: 100%; background: #d8ddd1; margin: 50px 0;">
					   </c:forEach>					   
					 </div>
				</div>
			</div>
		</section>
	</div>

<jsp:include page="footer.jsp"></jsp:include>


<!--   댓글  -->
		<script>
	 	 $(document).ready(function(){
	 		 
	 		listComment();
	 		
	 	   $("#commentBtn").click(function(){
	 	         var content = $("#commentText").val();
	 	         var recipeNo = "${recipe.recipeNo}";
	 	         if("${loginUser}" == undefined || "${loginUser}" == ""){
	 	        	 alert("로그인이 필요합니다.");
	 	        	 location.href="/YourMeals/app/auth/login";
	 	         } 
	 	         $.ajax({
	 	           type: "post",
	 	           url: "/YourMeals/app/recipe/comment/insert",
	 	           data: {content: content, recipeNo: recipeNo},
	 	           success : function() {
	 	             alert("댓글이 등록되었습니다.");
	 	           },
	 	           error : function() {
	 	        	  location.reload();
	 	               }
	 	         });
	 	       });
	 	 });
	 	 
// 	 	 Controller 방식
  	 function listComment(){
  		$.ajax({
  			 type: "get",
  			 url: "/YourMeals/app/recipe/comment/list?recipeNo=${recipe.recipeNo}",
  				success: function(result){
  					$("#listComment").html(result);
  				}
  		});
}
	 	 
 	 	 
	 	 function changeDate(date){
	 		 date = new Date(parseInt(date));
	 		 year = date.getFullYear();
	 		 month = date.getMonth();
	 		 day = date.getDate();
	 		 hour = date.getHours();
	 		 minute = date.getMinutes();
	 		 second = date.getSeconds();
	 		 strDate = year + "-" + month + "-" + day + "-" + hour + ":" + minute + ":" + second;
	 		 return strDate;
	 	 }
	 	 
		</script>
			

 <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
		 <script>
  $(function(){
     $("#recommendCountBtn").on("click",function(){
        var userNo = $("#userNo").val();
        var recipeNo = $("#recipeNo").val();
        console.log(userNo);
        console.log(recipeNo);
        $.ajax({
           url:"updateRecommendCount",
           type:"post",
           data: {recipeNo: recipeNo},
           success: function(data) {
               if (data == 'ok') {
                 var count = ${recipe.recommendCount};
                 $("#recommendCount").text("추천수: ");
                 $("#recommendCount").text(count + 1);
                 
               }
               console.log("정보 가져오기 성공");
    },
      error: function () {
        console.log("정보를 가져오기 실패");
      }
        });
     });
  });
 </script> 
		
</body>

</html>