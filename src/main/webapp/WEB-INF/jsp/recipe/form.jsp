<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
    <!DOCTYPE html>
    <html>

    <head>
      <title>..</title>

    </head>

    <body>
    <jsp:include page="/recipeHeader.jsp"></jsp:include>
        
			<div class="container">
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
        <h3>양</h3>
        <input type='number' name='serving'>분<br>
        <br>
        <h3>카테고리 </h3><br>

        <c:forEach items="${categoryList}" var="category">
          <input type='radio' name='categoryNo' value='${category.categoryNo}' />${category.categoryName}<br>
        </c:forEach>

        <h3>재료</h3><br>
        <div id="inputMetaContainer">
          <div class="inputmeta">
            <span class="name">재료</span>: <input type="text" name="metaname"><br>
            <span class="name">양</span>: <input type="text" name="metaamount"><br>
          </div>
        </div>
        <button id="btnAddMeta" type="button">추가</button><br>

        <br>

        <div id="inputStepContainer">
          <div class="inputStep">
            <span>step1</span>: <textarea name="step"></textarea>
            사진: <input type='file' name='step_photo'>
          </div>
        </div>
        <button id="btnAddStep" type="button">추가</button><br>

        <p><button>등록</button></p>

      </form>
</div>
      <script>
        var inputMetaContainer = document.querySelector("#inputMetaContainer");
        var inputMetaDiv = document.querySelector(".inputmeta");
        var inputStepContainer = document.querySelector("#inputStepContainer");
        var inputStepDiv = document.querySelector(".inputStep");

        btnAddMeta.onclick = function () {
          var e1 = inputMetaDiv.cloneNode(true);
          inputMetaContainer.appendChild(e1);
        };

        btnAddStep.onclick = function () {
          var e2 = inputStepDiv.cloneNode(true);
          inputStepContainer.appendChild(e2);
        };

      </script>

    </body>

    </html>