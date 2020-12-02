package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oijoa.domain.Qna;
import com.oijoa.domain.Recipe;
import com.oijoa.service.RecipeService;

@WebServlet("/mypage/myrecipe/list")
public class MyRecipeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    RecipeService recipeService = (RecipeService) ctx.getAttribute("recipeService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>MyPage</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>[My Recipe 목록]</h1>");

      // 로그인부분 추가 => Mapper findMy uno(=1) 고정부분 수정해야함.
      
      List<Recipe> list = recipeService.myList();
      Recipe[] recipeArray = new Recipe[3];

      out.println("<table border='1'><tr>");
      
      int recipeCount = 0;
      
      for (Recipe recipe : list) {
        recipeArray[recipeCount] = recipe;
        recipeCount++;
        
        if(recipeCount % 3 == 0) {
          out.printf("<td>%s</td>", recipeArray[0].getPhoto());
          out.printf("<td>%s</td>", recipeArray[1].getPhoto());
          out.printf("<td>%s</td></tr><tr>", recipeArray[2].getPhoto());
          
          out.printf("<td>%d</td>", recipeArray[0].getRecipeNo());
          out.printf("<td>%d</td>", recipeArray[1].getRecipeNo());
          out.printf("<td>%d</td></tr><tr>", recipeArray[2].getRecipeNo());
          
          out.printf("<td>%s</td>", recipeArray[0].getTitle());
          out.printf("<td>%s</td>", recipeArray[1].getTitle());
          out.printf("<td>%s</td></tr>", recipeArray[2].getTitle());
          recipeCount=0;
        }
        
      }
//      for (Recipe recipe : list) {
//        recipeCount++;
//        out.println(recipeCount);
//        out.printf("<td>%s</td>",recipe.getTitle());
//        if(recipeCount%3 == 0) {
//          out.println("</tr><tr>");
//        }
//      }
      out.println("</table></body></html>");
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