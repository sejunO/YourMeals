<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/header.jsp"></jsp:include>

<!DOCTYPE html>
<html>

<head>
  <title>레시피 등록</title>
</head>

<body>

  <h1>레시피 등록</h1>

  <form action='add' method='post' enctype='multipart/form-data'>

    사진: <input type='file' name='recipe_photo'><br>
    제목: <input type='text' name='title'><br>
    내용: <textarea name='content' rows='10' cols='60'></textarea><br>

    <h3>난이도</h3>

    <input type='radio' name='levelNo' value='1'>☆"
    <input type='radio' name='levelNo' value='2'>☆☆"
    <input type='radio' name='levelNo' value='3'>☆☆☆<br>
    <h3>만드는 시간</h3>
    <input type='number' name='min'>분<br>

    <br>
    <h3>카테고리 </h3><br>
    <ul>
      <c:forEach items="${categoryList}" var="category">
        <li><input type='radio' name='categoryNo' value=${category.categoryNo}>${category.categoryName}</li><br>
      </c:forEach>

      <h3>필요한 재료</h3><br>
      <c:forEach items="${materialList}" var="material">
        <li><input type='radio' name='materialList' value=${material.materialNo}>${material.name}</li><br>
      </c:forEach>
    </ul>
    <br>

    <h3>조리순서</h3>
    사진: <input type='file' name='step_photo'><br>
    내용: <textarea name='step_content' rows='10' cols='30'></textarea><br>
    <p><button>등록</button></p>


  </form>

</body>

</html>