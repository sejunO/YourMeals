<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>MyPage</title>

<link rel="stylesheet" href="../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="../../../../node_modules/bootstrap/dist/css/bootstrap-theme.min.css">
    <link href="../../css/cheatsheet.css" rel="stylesheet">
    </head>
<body>

<article class="my-3" id="qna">
      <div class="bd-heading sticky-xl-top align-self-start mt-5 mb-3 mt-xl-0 mb-xl-2">
        <h3>qna</h3>
        <a class="d-flex align-items-center" href="/docs/5.0/content/tables/">Documentation</a>
      </div>

      <div>
        <div class="bd-example">
        <table class="table table-striped">
          <thead>
          
          <tr>
            <th scope="col">#</th>
            <th scope="col">제목</th>
            <th scope="col">작성일</th>
            <th scope="col">상태</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${qnaList}" var="q">
          <tr>
            <th scope="row">${q.qnaNo}</th>
  <td><a href='./qna/detail?no=${q.qnaNo}'>${q.title}</a></td>
              
  <td>${q.createdDate}</td>
  <td>${q.answerStatus}</td>
  
  
          </tr>

          </c:forEach>
          </tbody>
        </table>
        </div>
      </div>
    </article>
    <c:if test="${not empty thisqna}">
      <div class="bd-heading sticky-xl-top align-self-start mt-5 mb-3 mt-xl-0 mb-xl-2">
        <h3></h3>
      </div>
      <div>
        <div class="bd-example">
        <div class="row  row-cols-1 row-cols-md-2 g-4">
          
          <div class="col">
            <div class="card">
              <div class="card-header">
                ${thisqna.title}
              </div>
              <div class="card-body">
                <h5 class="card-title">${thisqna.title}</h5>
                <p class="card-text">${thisqna.content}</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
                
              </div>
              <div class="card-footer text-muted">
                ${thisqna.createdDate}
              </div>
            </div>
          </div>
          

        </div>
        </div>
      </div>
    </c:if>
      


    <script src="../../../../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

      <script src="../../../../js/cheatsheet.js"></script>
</body>
</html>


