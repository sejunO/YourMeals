<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>레시피 등록</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/node_modules/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/recipeForm.css"
	rel="stylesheet">
</head>

<body>

	<section id="hero" class="d-flex align-items-center img-add">
		<div
			class="container text-center position-relative aos-init aos-animate"
			data-aos="fade-in" data-aos-delay="200">
			<h1>레시피 등록하기</h1>
			<br>
			<h2>나만의 특별한 레시피를 공유해 볼까요?</h2>
		</div>
	</section>

			<form action='add' method='post' enctype='multipart/form-data'>
		<section>
		<div class="container" style="margin-bottom: 100px; margin-top: 200px;">
		    <h3 style="font-weight: bold; text-align: center;">레시피 소개하기</h3>
		    <p style="text-align: center; padding-bottom: 50px; padding-top: 20px;">
		     소개하고자 하는 레시피의 이름, 사진 그리고 간단한 설명을 
		      쓸 수 있습니다:) <br>
		      그리고 이와 알맞는 카테고리, 조리 시간, 요리의 양과 난이도를
		      선택해주세요!</p>
				<div class="input-group mb-3 " >
					<span class="input-group-text" id="basic-addon1">제목</span> <input
						type="text" class="form-control" placeholder="제목을 입력하세요."
						aria-label="제목을 입력하세요." aria-describedby="basic-addon1"
						name='title'>
				</div>


				<div class="main-file-style">
					<div class="input-group mb-3">
						<input type="file" class="form-control" id="inputGroupFile02"
							name='recipe_photo'> <label class="input-group-text"
							for="inputGroupFile02">Upload</label>
					</div>

				</div>

				<div class="input-group">
					<textarea class="form-control" aria-label="With textarea"
						name='content' rows='10' cols='10'>
  레시피 등록 규정에 따라 입력해주세요 !
  주제와 상관없는 글은 제제 대상입니다 !
  </textarea>
				</div>
				</div>
	</section>


	<section>
		<div class="container" style="margin-bottom: 100px; margin-top: 0px">
			<div class="flex-style">
				<div>
					<select class="form-select" aria-label="Default select example"
						name='categoryNo'>
						<option selected>카테고리</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.categoryNo}">${category.categoryName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="input-sm">
					<div class="input-group mb-3">
						<span class="input-group-text">걸리는 시간</span> <input type="text"
							class="form-control" placeholder="15" name="min"
							aria-label="Username"> <span class="input-group-text">분</span>
					</div>
				</div>

				<div class="input-sm">
					<div class="input-group mb-3">
						<span class="input-group-text">요리의 양</span> <input type="text"
							class="form-control" placeholder="1" aria-label="Server"
							name="serving"> <span class="input-group-text">인분</span>
					</div>
				</div>
				<div class="level-box">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name='levelNo'
							id="inlineRadio1" value="3"> <label
							class="form-check-label" for="inlineRadio1">상</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name='levelNo'
							id="inlineRadio2" value="2"> <label
							class="form-check-label" for="inlineRadio2">중</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name='levelNo'
							id="inlineRadio2" value="1"> <label
							class="form-check-label" for="inlineRadio2">하</label>
					</div>
				</div>
			</div>
		</div>
	</section>

	<hr>

	<section>
		<div class="container" style="margin-bottom: 100px; margin-top: 100px;">
			<div class="metaDiv">
				<div class="btn-center">
					<h3 style="padding-bottom: 25px; font-weight: bold;">재료 입력하기</h3>
					<br>
				</div>
				<div id="inputMetaContainer">
					<div class="inputmeta">
						<div class="meta-input-style">
							<div></div>
							<div class="meta-input-size">
								<div class="input-group mb-3 ">
									<span class="input-group-text" id="basic-addon1">재료</span> <input
										type="text" class="form-control" placeholder="양파"
										aria-label="재료입력" aria-describedby="basic-addon1"
										name='metaname'>
								</div>
							</div>
							<div class="meta-input-size">
								<div class="input-group mb-3 ">
									<span class="input-group-text" id="basic-addon1">계량</span> <input
										type="text" class="form-control" placeholder="1개"
										aria-label="재료입력" aria-describedby="basic-addon1"
										name='metaamount'>
								</div>
							</div>
							<div></div>
						</div>
					</div>
				</div>
				<div class="btn-center">
					<button id="btnAddMeta" type="button">재료 추가</button>
					<br>
				</div>
				<br>
			</div>
			</div>
			</section>

			<hr>
			
  <section>
  <div class="container" style="margin-bottom: 100px; margin-top: 100px;">
			<div id="inputStepContainer">
				<div class="btn-center">
					<h3 style="padding-bottom: 25px; font-weight: bold;">STEP 입력하기</h3>
					<br>
				</div>
				<div class="inputStep">
					<div class="step-input">
						<div>
							<span class="name">STEP 1</span>
						</div>
						<div>
							<textarea name="step" rows='10' cols='80'></textarea>
						</div>
						<div>
							<input type='file' name='step_photo'>
						</div>
					</div>
				</div>
			</div>
			<div class="btn-center">
				<button id="btnAddStep" type="button">단계 추가</button>
				<br>
			</div>
		</div>
	</section>

	<hr>

	<div class="btn-center" style="margin: 50px;">
		<p>
			<button>레시피 등록</button>
		</p>
	</div>

	</form>
	
	
	<script>
		var inputMetaContainer = document.querySelector("#inputMetaContainer");
		var inputMetaDiv = document.querySelector(".inputmeta");
		var inputStepContainer = document.querySelector("#inputStepContainer");
		var inputStepDiv = document.querySelector(".inputStep");
		var inputNameIndex = 1;
		btnAddMeta.onclick = function() {
			var e1 = inputMetaDiv.cloneNode(true);
			inputMetaContainer.appendChild(e1);
		};

		btnAddStep.onclick = function() {
			inputNameIndex++;
			var e2 = inputStepDiv.cloneNode(true);
			e2.querySelector(".name").innerHTML = "STEP " + inputNameIndex;
			inputStepContainer.appendChild(e2);
		};
	</script>

</body>

</html>