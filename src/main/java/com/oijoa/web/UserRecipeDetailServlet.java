package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.RecipeStep;
import com.oijoa.service.RecipeService;
import com.oijoa.service.RecipeStepService;

@WebServlet("/user/detail")
public class UserRecipeDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)

      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService =
        (RecipeService) ctx.getAttribute("recipeService");
    RecipeStepService recipeStepService =
        (RecipeStepService) ctx.getAttribute("recipeStepService");

    int no = Integer.parseInt(request.getParameter("recipeNo"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>레시피보기</title></head>");
    out.println("<body>");

    try {
      out.println("<h1>레시피  보기</h1>");

      Recipe recipe = recipeService.get(no);

      if (recipe == null) {
        out.println("해당 번호의 게시글이 없습니다.");
        return;
      }
      out.println("<form action='update' method='post'>");
      out.printf("번호: <input type='text' name='recipeNo' value='%d' readonly><br>\n",
          recipe.getRecipeNo());
      out.printf("제목: <input type='text' name='title' value='%s'><br>\n",
          recipe.getTitle());
      out.printf("내용: <textarea name='recipe_content'>%s</textarea><br>\n",
          recipe.getContent());
      out.printf("작성자: %s<br>\n", recipe.getWriter().getName());
      out.printf("등록일: %s<br>\n", recipe.getCreatedDate());
      out.printf("수정일: %s<br>\n", recipe.getModifiedDate());
      out.printf("조회수: %d<br>\n", recipe.getHits());
      out.printf("난이도: %s<br>\n", recipe.getLevelNo());
      out.printf("시간:  %s<br>\n", recipe.getMin());
      out.printf("카테고리: %s<br>\n", recipe.getCategory().getCategoryName());
      out.println("</ul><br>");
      out.println("<h3>조리순서</h3>");
      out.println("<table border='1'>");
      out.println("<tr><th>순서</th>");
      out.println("<th>사진</th>");
      out.println("<th>내용</th></tr>");
      for(RecipeStep recipeStep : recipeStepService.findByRecipeNo(no)) {
        out.printf("<tr><td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td></tr>",
            recipeStep.getStep(), recipeStep.getPhoto(), recipeStep.getContent());
      }
      out.println("</table>");
      out.println("</form>");
      out.println("<hr>\n");
      out.println("<a href=list>뒤로가기</a><br>\n");
      out.println("<a href=../index.html>홈으로</a><br>\n");

    } catch (Exception e) {
      out.println("<h2>작업 처리 중 오류 발생!</h2>");
      out.printf("<pre>%s</pre>\n", e.getMessage());

      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));
      out.println("<h3>상세 오류 내용</h3>");
      out.printf("<pre>%s</pre>\n", errOut.toString());
    }
    out.println("</body>");
    out.println("</html>");
  }
}




