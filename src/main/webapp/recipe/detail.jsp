<%@page import="com.oijoa.domain.Recipe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/header.jsp"></jsp:include>

<!DOCTYPE html>
<html>

<head>
  <title>레시피 보기</title>
</head>

<body>

  <h1>레시피</h1>

  <c:if test='${recipe == null}'>
    <p>레시피가 존재하지 않습니다.</p>
  </c:if>
  <form action='update' method='post'>
    <input type='hidden' name='recipeNo' value='${recipe.recipeNo}' readonly/><br>
    <input type='hidden' name='userNo' value='${recipe.writer.userNo}' readonly/><br>
    제목: <input type='text' name='title' value='${recipe.title}'/><br>
    내용: <textarea name='content'>${recipe.content}</textarea><br>
    작성자: ${recipe.writer.nick}<br>
    등록일: ${recipe.createdDate}<br>
    <c:if test='${recipe.modifiedDate == null}'>
      수정일: 없음<br>
    </c:if>
    <c:if test='${recipe.modifiedDate != null}'>
      수정일: ${recipe.modifiedDate}<br>
    </c:if>
    조회수: ${recipe.hits}<br>
    추천수: ${recipe.recommendCount} 
            <c:if test = '${sessionScope.loginUser != null 
            and sessionScope.loginUser != recipe.writer}'>
            <button type = 'button' id = 'recommendCount'>추천</button></c:if><br>
    난이도: <c:forEach items='${levels}' var='l'>
      <input type='radio' name='levelNo' value='${l.levelNo}' 
      <c:if test="${recipe.levelNo == l.levelNo}">checked</c:if>
      /> ${l.level}
    </c:forEach><br>
    조리시간: <input type='text' name='min' value='${recipe.min}'/>분<br>
    카테고리: <c:forEach items='${categorys}' var='c'>
      <input type='radio' name='categoryNo' value='${c.categoryNo}' 
      <c:if test="${recipe.category.categoryName == c.categoryName}">checked</c:if>
      /> ${c.categoryName}
    </c:forEach><br>


    <h3>조리순서</h3>
    <table border='1'>
      <thead>
        <tr>
          <th>순서</th>
          <th>사진</th>
          <th>내용</th>
        </tr>
      </thead>

      <tbody>
        <c:forEach items='${recipeSteps}' var='rs'>
          <tr>
            <td>${rs.step}</td>
            <td>${rs.photo}</td>
            <td>${rs.content}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <p>
      <button>변경</button>
      <button><a href='delete?recipeNo=${recipe.recipeNo}'>삭제 </a></button><br>
    </p>
    <button><a href='list'>레시피 목록 보기</a></button><br>


    <p>
    <h3>댓글</h3>
    댓글: <input type='text' name='comment'>
    <button>등록</button><br>
    <table border='1'>
      <thead>
        <tr>
          <th>날짜</th>
          <th>이름</th>
          <th>내용</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items='${comments}' var='cm'>
          <tr>
            <td>${cm.createdDate}</td>
            <td>${cm.writer.nick}</td>
            <td>${cm.content}</td>
          </tr>
        </c:forEach>
        </p>
      </tbody>
    </table>
  </form>
</body>

</html>
</form>