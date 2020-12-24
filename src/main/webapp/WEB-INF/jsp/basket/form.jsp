<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <h1>장바구니 생성</h1>
      <form action='add' method='post'>
        수량 : <input type='int' name='amount'><br>
        <ul>
          <c:forEach items="${products}" var="p">
            <li><input type='radio' name='productNo' value="${p.productNo}">${p.title}</li>
          </c:forEach>
        </ul>
        <button>생성</button>
      </form>
      <div class="container mt-5" style="min-height: calc(100vh - 132px); max-height: auto">
        <div class="container-fluid">
                    <h3>김복순 하루야채</h3>
          <div class="row">
            <div class="col-4">
              <div class="card mb-3">
              
              
              <!-- <img src="../../upload/${product.photo}_200x200.jpg"/> -->
              
                <img class="card-img-top"
                  src="https://steptohealth.co.kr/wp-content/uploads/2018/05/art-1-24-768x519.jpg" alt="Card image cap"
                  height="229">
                <div class="card-body">
                  <h5 class="card-title" style="max-height: 50px; margin-top: 11px; font-size: 16px;">[김복순
                    하루야채]강원도 고랭지 시금치</h5>
                  <p class="card-text" style="padding-top: 6px; font-weight: 700; font-size: 16px; line-height: 20px;">
                    4,700원</p>
                  <button type="button" class="btn btn-outline-primary">장바구니</button>
                </div>
              </div>
            </div>
          </div>
          
          
        </div>
      </div>




      <script src="../../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

    </body>

    </html>