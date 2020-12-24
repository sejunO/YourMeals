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
      <link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
    </head>

    <body>

      <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company name</a>
        <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse"
          data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false"
          aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
        <ul class="navbar-nav px-3">
          <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Sign out</a>
          </li>
        </ul>
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
                    Products
                  </a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="orderList">
                    <span data-feather="file"></span>
                    Orders
                  </a>
                </li>


                <li class="nav-item">
                  <a class="nav-link" href="#">
                    <span data-feather="bar-chart-2"></span>
                    Reports
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    <span data-feather="layers"></span>
                    Integrations
                  </a>
                </li>
              </ul>

              <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                <span>Saved reports</span>
                <a class="link-secondary" href="#" aria-label="Add a new report">
                  <span data-feather="plus-circle"></span>
                </a>
              </h6>
              <ul class="nav flex-column mb-2">
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    <span data-feather="file-text"></span>
                    Current month
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    <span data-feather="file-text"></span>
                    Last quarter
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    <span data-feather="file-text"></span>
                    Social engagement
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    <span data-feather="file-text"></span>
                    Year-end sale
                  </a>
                </li>
              </ul>
            </div>
          </nav>






          <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div
              class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
              <h1 class="h2">주문관리</h1>
              <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">
                </div>
              </div>
            </div>
            <c:if test="${not empty thisOrder}">
              <form action="orderUpdate" method="post">
                <div class="row">
                  <h6>주문정보</h6>
                  <input type="hidden" name="orderNo" value="${thisOrder.orderNo}" />

                  <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">사용자</span>
                    <input type="text" class="form-control" value="${thisOrder.userNo.name}" readonly
                      aria-label="Username" aria-describedby="basic-addon1">
                  </div>

                  <div class="input-group mb-3">
                    <span class="input-group-text">주소</span>
                    <input type="text" class="form-control" placeholder="Username" name="postNo"
                      value="${thisOrder.postNo}" aria-label="Username">
                    <input type="text" class="form-control" placeholder="Username" name="address"
                      value="${thisOrder.address}" aria-label="Username">
                    <input type="text" class="form-control" placeholder="Username" name="detailAddress"
                      value="${thisOrder.detailAddress}" aria-label="Username">
                    <span class="input-group-text">주문 상태</span>
                    <div class="col-auto">
                      <label class="visually-hidden" for="autoSizingSelect">Preference</label>
                      <select class="form-select" id="autoSizingSelect" name="status" >
                        <option selected>선택</option>
                        <option value="0">입금확인중</option>
                        <option value="1">결제완료</option>
                        <option value="2">배송준비</option>
                        <option value="3">배송중</option>
                        <option value="4">배송완료</option>
                        <option value="11">취소신청</option>
                        <option value="12">취소진행중</option>
                        <option value="13">취소(환불)완료</option>
                        <option value="21">반품신청</option>
                        <option value="22">반품진행중</option>
                        <option value="23">반품(환불)완료</option>
                        <option value="31">교환신청</option>
                        <option value="32">교환진행중</option>
                        <option value="33">교환완료</option>
                      </select>
                    </div>
                  </div>
                  <div class="col input-group">
                    <button class="btn btn-dark indexBtn float-right">변경</button>
                  </div>
                </div>
              </form>
            </c:if>
            
            <div class="table-responsive">
              <table class="table table-striped table-sm">
                <thead>
                  <tr>
                    <th>번호</th>
                  </tr>
                </thead>
                <tbody>

                  <c:forEach items="${orderList}" var="o">
                    <tr class="form-tr" onclick="location.href='orderDetail?no=${o.orderNo}'">
                      <td>${o.userNo.name}</td>
                      <td>${o.orderDate}</td>
                      <td>${o.totalPrice}</td>

                      <td>
                        <c:choose>
                          <c:when test="${o.status == 0}">
                            입금확인중
                          </c:when>
                          <c:when test="${o.status == 1}">
                            결제완료
                          </c:when>
                          <c:when test="${o.status == 2}">
                            배송준비
                          </c:when>
                          <c:when test="${o.status == 3}">
                            배송중
                          </c:when>
                          <c:when test="${o.status == 4}">
                            배송완료
                          </c:when>
                          <c:when test="${o.status == 11}">
                            취소신청
                          </c:when>
                          <c:when test="${o.status == 12}">
                            취소진행중
                          </c:when>
                          <c:when test="${o.status == 13}">
                            취소(환불)완료
                          </c:when>
                          <c:when test="${o.status == 21}">
                            반품신청
                          </c:when>
                          <c:when test="${o.status == 22}">
                            반품진행중
                          </c:when>
                          <c:when test="${o.status == 23}">
                            반품(환불)완료
                          </c:when>
                          <c:when test="${o.status == 31}">
                            교환신청
                          </c:when>
                          <c:when test="${o.status == 32}">
                            교환진행중
                          </c:when>
                          <c:when test="${o.status == 33}">
                            교환완료
                          </c:when>
                          <c:otherwise>
                            상태값오류
                          </c:otherwise>
                        </c:choose>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>

              </table>
            </div>
          </main>
        </div>
      </div>


      <script src="<%=request.getContextPath() %>node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
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