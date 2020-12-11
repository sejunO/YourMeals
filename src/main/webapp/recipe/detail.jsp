<%@page import="com.oijoa.domain.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
  <head><title>레시피 보기</title></head>
  <body>

<h1>레시피 보기</h1>
<%
Recipe recipe = (recipe) request.getAttribute("recipe");
if (recipe == null) {
  response.setHeader("Refresh", "2;url=list");%>
  <p>해당 번호의 게시글이 없습니다.</p>
<%
}else {
%>

<form action='update' method='post'>
   <input type='hidden' name='recipeNo' readonly><br>

 <textarea name='recipe_content'> 
 </textarea><br>

  작성자:<input type='text' name='writer' ><br> recipe.getWriter().getNick());
  등록일:<input type='datetime' name='createdDate'><br> recipe.getCreatedDate());
  if(recipe.getModifiedDate() == null) {
    out.println("수정일: 없음<br>");
  } else {
  out.printf("수정일: %s<br>\n", recipe.getModifiedDate());
  }
  out.printf("조회수: %d<br>\n", recipe.getHits());
  out.printf("추천수: %d<br>\n", recipe.getRecommendCount());
  out.printf("난이도: <br>\n");
  for (Level l : levels) {
    out.printf("<input type='radio' name='level' value='%d' %s> %s ", l.getLevelNo(),
        checkedLevel(l, recipe.getLevelNo()), l.getLevel());
  }
  out.printf("<br>\n");
  out.printf("조리시간:  %s<br>\n", recipe.getMin());
  out.printf("카테고리: <br>\n");
  for (Category c : categorys) {
    out.printf("<input type='radio' name='category' value='%d' %s> %s ", c.getCategoryNo(),
        checkedCategory(c, recipe.getCategory()), c.getCategoryName());
  }
  out.printf("<br>\n");

  out.printf("필요한 재료: ");
//      List<Food> foodList = foodService.list(no);
//      for (Food f : foodList) {
//        out.printf("%s ", f.getName());
//      }
</ul><br>
<h3>조리순서</h3>
<table border='1'>
  <thead>
  <tr><th>순서</th>
 <th>사진</th>
 <th>내용</th></tr>
  </thead>
 <tbody>
  
  for (RecipeStep recipeStep : recipeStepService.list(no)) {
    out.printf("<tr><td>%d</td>" + "<td>%s</td>" + "<td>%s</td></tr>", recipeStep.getStep(),
        recipeStep.getPhoto(), recipeStep.getContent());
  }
  </tbody>
  </table>

  <p>
  <button>변경</button>
<button><a href='delete?recipeNo=%d'>[삭제]</a>
   </button><br>
   
 </p>
<button><a href='list'>

</a>
</button><br>");
<input type='text' name='comment'>
<button>등록</button><br>

 <p>
<h3>댓글</h3>
<table border='1'>
  <thead>
<tr><th>날짜</th>
<th>이름</th>
<th>내용</th></tr>
</thead>

<tbody>