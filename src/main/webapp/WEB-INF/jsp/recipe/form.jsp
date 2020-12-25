<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
     
          <c:forEach items="${categoryList}" var="category">
            <input type='radio' name='categoryNo' value='${category.categoryNo}'/>${category.categoryName}<br>
          </c:forEach>

          <h3>필요한 재료</h3><br>
          <c:forEach items="${materialList}" var="material">
            <input type='radio' name='materialList' value='${material.materialNo}'/>${material.name}<br>
          </c:forEach>
  
        <br>

         <div id="inputNameContainer">
          <div class="inputName">
            <span class="name">step1</span>: <textarea name="step1"></textarea>
            사진: <input type='file' name='step_photo1'>
          </div>
        </div>

        <div id="inputNameContainer">
          <div class="inputName">
            <span class="name">step2</span>: <textarea name="step2"></textarea>
            사진: <input type='file' name='step_photo2'>
          </div>
        </div>

        <div id="inputNameContainer">
          <div class="inputName">
            <span class="name">step3</span>: <textarea name="step3"></textarea>
            사진: <input type='file' name='step_photo3'>
          </div>
        </div>

        <div id="inputNameContainer">
          <div class="inputName">
            <span class="name">step4</span>: <textarea name="step4"></textarea>
            사진: <input type='file' name='step_photo4'>
          </div>
        </div>

        <div id="inputNameContainer">
          <div class="inputName">
            <span class="name">step5</span>: <textarea name="step5"></textarea>
            사진: <input type='file' name='step_photo5'>
          </div>
        </div>


        <p><button>등록</button></p>

      </form>



    </body>

    </html>