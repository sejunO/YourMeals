<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!doctype html>
    <html lang="en">

    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
      <meta name="generator" content="Hugo 0.79.0">
      <title>Dashboard Template · Bootstrap v5.0</title>

      <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/">



      <!-- Bootstrap core CSS -->
      <link href="<%=request.getContextPath() %>/node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

      <!-- Favicons -->
      <link rel="apple-touch-icon" href="/docs/5.0/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
      <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
      <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
      <link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
      <link rel="mask-icon" href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
      <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
      <meta name="theme-color" content="#7952b3">


      <style>
        .bd-placeholder-img {
          font-size: 1.125rem;
          text-anchor: middle;
          -webkit-user-select: none;
          -moz-user-select: none;
          user-select: none;
        }

        @media (min-width: 768px) {
          .bd-placeholder-img-lg {
            font-size: 3.5rem;
          }
        }
      </style>


      <!-- Custom styles for this template -->
      <link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
    </head>

    <body>

      <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="../index">YOURMEALS</a>
      </header>
      
 

      <div class="container-fluid">
        <div class="row">
          <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
              <ul class="nav flex-column">
                <li class="nav-item">
                  <a class="nav-link" href="userList">
                    <span data-feather="users"></span>
                    user
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="productList">
                    <span data-feather="shopping-cart"></span>
                    Product
                  </a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="orderList">
                    <span data-feather="file"></span>
                    Order
                  </a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="qnaList">
                    <span data-feather="bar-chart-2"></span>
                    Qna
                  </a>
                </li>
                
                <li class="nav-item">
                  <a class="nav-link" href="noticeList">
                    <span data-feather="file-text"></span>
                    Notice
                  </a>
                </li>
                
              </ul>
            </div>
          </nav>






          <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div
              class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
              <h1 class="h2">회원관리</h1>
              <div class="btn-toolbar mb-2 mb-md-0">
              </div>
            </div>
            <c:if test="${not empty thisUser}">
            <form action="userUpdate" method="post">
              <div class="row">
              <h6>회원정보</h6>
              <input type="hidden" name="userNo" value="${thisUser.userNo}"/>
                <div class="col input-group mb-3">
                <span class="input-group-text" id="basic-addon1">이름</span>
                   <input type="text" class="form-control" name="name" aria-label="First name" value="${thisUser.name}">
                </div>
                <div class="col input-group mb-3">
                <span class="input-group-text" id="basic-addon1">닉네임</span>
                  <input type="text" class="form-control" name="nick" aria-label="First name" value="${thisUser.nick}">
                </div>
                <div class="col input-group mb-3">
                <span class="input-group-text" id="basic-addon1">이메일</span>
                  <input type="email" class="form-control" name="email" aria-label="First name" value="${thisUser.email}">
                </div>
                <div class="col input-group mb-3">
                <span class="input-group-text" id="basic-addon1">권한</span>
                  <input type="text" class="form-control" name="userTypeNo" aria-label="First name" value="${thisUser.userTypeNo}">
                </div>
                <div class="col input-group mb-3">
                  <button class="btn btn-dark indexBtn">변경</button>
                </div>
              </div>
            </form>
            </c:if>
            
            <div class="table-responsive">
              <table class="table table-striped table-sm">
                <thead>
                  <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>닉네임</th>
                    <th>이메일</th>
                    <th>권한</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="#{userList}" var='u'>
                    <tr class="form-tr" onclick="location.href='userDetail?no=${u.userNo}'">
                      <td>${u.userNo}</td>
                      <td>${u.name}</td>
                      <td>${u.nick}</td>
                      <td>${u.email}</td>
                      <td>${u.userTypeNo}</td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </main>
        </div>
      </div>


      <script src="<%=request.getContextPath() %>/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
        integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
        integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
        crossorigin="anonymous"></script>
      <script src="<%=request.getContextPath() %>/js/dashboard.js"></script>
    </body>

    </html>