<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="/recipeHeader.jsp"></jsp:include>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <title>exampke</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">

      <!--=========== example 따온거 =============-->

      <!-- Google Fonts -->
      <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

      <!-- Vendor CSS Files -->
      <link href="<%=request.getContextPath() %>/node_modules/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="<%=request.getContextPath() %>/node_modules/vendor/icofont/icofont.min.css" rel="stylesheet">
      <link href="<%=request.getContextPath() %>/node_modules/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
      <link href="<%=request.getContextPath() %>/node_modules/vendor/remixicon/remixicon.css" rel="stylesheet">
      <link href="<%=request.getContextPath() %>/node_modules/vendor/venobox/venobox.css" rel="stylesheet">
      <link href="<%=request.getContextPath() %>/node_modules/vendor/owl.carousel/assets/owl.carousel.min.css"
        rel="stylesheet">
      <link href="<%=request.getContextPath() %>/node_modules/vendor/aos/aos.css" rel="stylesheet">

      <!-- Template Main CSS File -->
      <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">

      <!-- Font Awesome Icons-->
      <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

      <!-- ============= 글상자 ================-->
      <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/album/">

      <!-- Bootstrap core CSS -->
      <link href="<%=request.getContextPath() %>/node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    </head>

    <body>

	
      <!-- 상단 이미지 -->
      <section id="hero" class="d-flex align-items-center">
        <div class="container text-center position-relative aos-init aos-animate" data-aos="fade-in"
          data-aos-delay="200">
          <h1>레시피 살펴보기</h1><br>
          <h2>오늘은 어떤 레시피로 요리해 볼까요?</h2>
        </div>
      </section>

      <!-- 레시피 소개 -->
      <section id="about" class="about">
        <div class="container">
          <div class="row content">
            <div class="recipe-content" id="img-recipe" data-aos="fade-right" data-aos-delay="100">
              <div class="side-and-side">
                <div id="left">
                  <h5>게시물 ${recipe.recipeNo} 번</h5>
                </div>
                <div id="right">
                  <c:if test='${recipe.modifiedDate == null}'>
                    <h6>등록일: ${createdDate}</h6>
                  </c:if>
                  <c:if test='${recipe.modifiedDate != null}'>
                    <h5>등록일: ${createdDate}</h5>
                    <h5>수정일: ${modifiedDate}</h5>
                  </c:if>
                </div>
              </div>
              <h2>${recipe.title}</h2>
              <img src="../../upload/${recipe.photo}.jpg" width="50%"><br>
            </div>
            <div class="recipe-content2 text-center pt-4 pt-lg-0" data-aos="fade-left" data-aos-delay="200">
              <p>${recipe.content}</p><br>
            </div>
            <div id="left">
              <h5>작성자: ${recipe.writer.nick}</h5><br>
            </div>
          </div>
          <i class="fa-user-friends:before"></i>
        </div>
        <hr>
      </section>

      <section id="info" class="services">
        <div id="col-icon2">
          <div class="col-icon d-flex align-items-stretch">
            <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
              <div class="icon"><i class="bx bxl-dribbble"></i></div>
              <h4>${recipe.serving}인분</h4>
            </div>
          </div>

          <div class="col-icon d-flex align-items-stretch">
            <div class="icon-box" data-aos="zoom-in" data-aos-delay="200">
              <div class="icon"><i class="bx bx-file"></i></div>
              <h4>${recipe.min}분</h4>
            </div>
          </div>

          <div class="col-icon d-flex align-items-stretch">
            <div class="icon-box" data-aos="zoom-in" data-aos-delay="300">
              <div class="icon"><i class="bx bx-tachometer"></i></div>
              <h4>${levelNo}단계</h4>
            </div>
          </div>
        </div>
      </section>


      <!-- 재료 -->
      <section id="recipe-material" class="contact">
        <div class="container">
          <div class="row">
            <div class="col-lg-8" data-aos="fade-up" data-aos-delay="100">
              <div class="col-lg-4" data-aos="fade-right">
                <div class="section-title">
                  <h2>재료</h2>
                </div>
              </div>
              <form action="forms/contact.php" method="post" role="form" class="php-email-form mt-4 middle">
                <div class="form-row">
                  <div class="col-md-6 form-group">
                    <ul>
                      <li><input type="text" name="name" class="form-control" id="name" placeholder="재료"
                          data-rule="minlen:4" data-msg="Please enter at least 4 chars" /></li>

                    </ul>
                    <div class="validate"></div>
                  </div>
                  <div class="col-md-6 form-group">
                    <ul>
                      <li><input type="email" class="form-control" name="email" id="email" placeholder="계량"
                          data-rule="email" data-msg="Please enter a valid email" /></li>

                    </ul>
                    <div class="validate"></div>
                  </div>
                </div>
                <!-- <div class="mb-3">
              <div class="loading">로딩중</div>
              <div class="error-message"></div>
              <div class="sent-message">전송 성공</div>
            </div> -->
                <div class="album py-5 bg-light">
                  <div class="container">
                    <div class="row">
                      <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                          <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                            xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false"
                            role="img" aria-label="Placeholder: recipe-photo">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c" /><text x="50%" y="50%" fill="#eceeef"
                              dy=".3em"><a href="">재료사진</a></text>
                          </svg>
                          <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                              additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                          <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                            xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false"
                            role="img" aria-label="Placeholder: recipe-photo">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c" /><text x="50%" y="50%" fill="#eceeef"
                              dy=".3em"><a href="">재료사진</a></text>
                          </svg>
                          <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                              additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                          <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                            xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false"
                            role="img" aria-label="Placeholder: recipe-photo">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c" /><text x="50%" y="50%" fill="#eceeef"
                              dy=".3em"><a href="">재료사진</a></text>
                          </svg>
                          <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                              additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="text-center"><button type="submit">부족한 재료 주문하기</button></div>
              </form>
            </div>
          </div>
        </div>

      </section>

      <!-- 조리 순서 -->
      <section id="recipe-step" class="contact">
        <div class="container-material reicpe-step-bg">
          <div class="col-lg-4" data-aos="fade-right">
            <div class="section-title">
              <h2>조리 순서</h2>
            </div>
          </div>
          <div class="row">
            <div class="php-email-form mt-4">
              <div class="info">
                <i class="icofont-envelope"></i>
                <h4>STEP 1</h4>
                <div class="container">
                  <div class="recipe-step-con">
                    <div class="form-group">
                      <textarea class="form-control" name="content" rows="5" data-rule="required"
                        data-msg="Please write something for us" placeholder="조리 내용"></textarea>
                      <div class="validate"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <section id="boardlike" class="services">
        <div id="col-icon2">
          <div class="col-icon d-flex align-items-stretch">
            <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
              <div class="icon"><i class="bx bxl-dribbble"></i></div>
              <h4>${recipe.recommendCount}</h4>
              <h4>추천</h4>
            </div>
          </div>

          <div class="col-icon d-flex align-items-stretch">
            <div class="icon-box" data-aos="zoom-in" data-aos-delay="200">
              <div class="icon"><i class="bx bx-file"></i></div>
              <h4>스크랩</h4>
            </div>
          </div>
        </div>
      </section>


      <!-- 댓글 -->
      <section id="comment" class="contact">
        <div class="container">
          <div class="row">
            <div class="col-lg-4" data-aos="fade-right">
              <div class="section-title">
                <h2>댓글</h2>
              </div>
            </div>

            <form action="forms/contact.php" method="post" role="form" class="php-email-form mt-4">
              <div class="form-row">

                <div class="form-group">
                  <input type="text" class="form-control" name="subject" id="nickname" placeholder="사용자 이름"
                    data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                  <div class="validate"></div>
                </div>
                <div class="col-md-6 form-group">
                  <input type="text" name="name" class="form-control" id="content" placeholder="메세지를 입력하세요"
                    data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                  <div class="validate"></div>
                </div>

                <div class="mb-3">
                  <div class="loading">전송중</div>
                  <div class="error-message"></div>
                  <div class="sent-message">완료!</div>
                </div>
                <div class="text-center"><button type="submit">전송</button></div>
              </div>
            </form>
          </div>
        </div>
      </section>
      <!-- 페이지 맨 밑 설명 + Back to top-->
      <footer class="text-muted">
        <div class="container">
          <p class="float-right">
            <a href="#">Back to top</a>
          </p>
          <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
          <p>New to Bootstrap? <a href="https://getbootstrap.com/">Visit the homepage</a> or read our <a
              href="/docs/4.5/getting-started/introduction/">getting started guide</a>.</p>
        </div>
      </footer>

      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.5/assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
      <script src="/docs/4.5/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

      <script type="text/javascript" src="../test/js/jquery.1.11.1.js"></script>
      <script type="text/javascript" src="../test/js/bootstrap.js"></script>
      <script type="text/javascript" src="../test/js/SmoothScroll.js"></script>
      <script type="text/javascript" src="../test/js/nivo-lightbox.js"></script>
      <script type="text/javascript" src="../test/js/jquery.isotope.js"></script>
      <script type="text/javascript" src="../test/js/jqBootstrapValidation.js"></script>
      <script type="text/javascript" src="../test/js/contact_me.js"></script>
      <script type="text/javascript" src="../test/js/main.js"></script>
    </body>

    </html>