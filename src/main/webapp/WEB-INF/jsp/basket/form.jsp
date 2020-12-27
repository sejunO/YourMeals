<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:include page="/userHeader.jsp"></jsp:include>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>장바구니 등록</title>
      <link rel="stylesheet" href="../../node_modules/bootstrap/dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="../../node_modules/bootstrap/dist/css/bootstrap-theme.min.css">
      <link rel="stylesheet" href="../../css/carousel.css">
    </head>

    <body>
      <h1 style="text-align:center">장바구니 생성</h1>
      <form action='add' method='post'>
        <ul>
          <div class="container mt-5" style="min-height: calc(100vh - 132px); max-height: auto">
            <div class="container-fluid">
              <div class="row">
                <c:forEach items="${products}" var="p">
                  <div class="col-3">
                    <div class="card mb-4">
                      <li><input type='checkbox' name='productNo' value="${p.productNo}">${p.title}</li>
                      <!-- <img src="../../upload/${product.photo}_200x200.jpg"/> -->
                      <img class="card-img-top" src=img src="../../upload/${product.photo}_200x200.jpg"
                        alt="Card image cap" height="180">
                      <div class="card-body">
                        <h5 class="card-title" style="max-height: 50px; margin-top: 11px; font-size: 16px;">${p.content}
                        </h5>
                        <p class="card-text"
                          style="padding-top: 6px; font-weight: 700; font-size: 16px; line-height: 20px;">
                          가격 : ${p.price}</p>
                        <button type="button" class="btn btn-outline-primary">장바구니</button>
                        수량 : <input type='int' name='amount'><br>
                      </div>
                    </div>
                  </div>
                  </c:forEach>
                </div>
              </div>
            </div>
        </ul>
        <button>생성</button>
      </form>



      <script src="../../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

    </body>

    </html>