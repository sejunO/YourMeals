<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../../css/carousel.css">
<title>Insert title here</title>
</head>
<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">YourMeals</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item active">
            <a class="nav-link" aria-current="page" href="app/recipe/list">recipe</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="mypage/index.html">mypage</a>
          </li>

        </ul>
        <form class="col-4 d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        
      <div class="col-4 d-flex justify-content-end align-items-center">
        <a class="btn btn-sm btn-outline-primary my-2" href="#">Sign up</a>
        <a class="btn btn-sm btn-outline-secondary my-2" href="#">log in</a>
      </div>
        
      </div>
    </div>
  </nav>
</header>


  <section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">Mypage</h1>
        <p class="lead text-muted">Something short and leading about the collection belowâits contents, the creator, etc. Make it short and sweet, but not too short so folks donât simply skip over it entirely.</p>
        <p>
          <a href="#" class="btn btn-primary my-2">Main call to action</a>
          <a href="#" class="btn btn-secondary my-2">Secondary action</a>
        </p>
      </div>
    </div>
  </section>
    
     <script src="../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</body>
</html>