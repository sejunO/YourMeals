<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><title>MyPage</title>
<link rel="stylesheet" href="../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="../../../../node_modules/bootstrap/dist/css/bootstrap-theme.min.css">
    <link href="../../css/cheatsheet.css" rel="stylesheet">
</head>
<body>

    <article class="my-3" id="following">
      <div class="bd-heading sticky-xl-top align-self-start mt-5 mb-3 mt-xl-0 mb-xl-2">
        <h3>following</h3>
        <a class="d-flex align-items-center" href="/docs/5.0/content/tables/">Documentation</a>
      </div>

      <div>
        <div class="bd-example">
        <table class="table table-striped">
          <thead>
          
          <tr>
            <th scope="col">#</th>
            <th scope="col">이름</th>
            <th scope="col">닉네임</th>
            <th scope="col">Handle</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${followingList}" var="f">
          <tr>
            <th scope="row">1</th>
            <td>${f.user.name}</td>
            <td>${f.user.nick}</td>
            <td>@mdo</td>
          </tr>

          </c:forEach>
          </tbody>
        </table>
        </div>

 
      </div>
    </article>


    <script src="../../../../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

      <script src="../../../../js/cheatsheet.js"></script>
</body>
</html>


