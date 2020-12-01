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
import com.oijoa.domain.Category;
import com.oijoa.service.CategoryService;


@WebServlet("/recipe/form")
public class RecipeAddFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    CategoryService categoryService =
        (CategoryService) ctx.getAttribute("categoryService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>레시피 생성</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>레시피 등록</h1>");
      out.println("<form action='add' method='post'enctype='multipart/form-data'>");
      out.println("제목:  <input type='text' name='title'><br>");
      out.println("만드는 시간:  <input type='number' name='min'<br>");
      out.println("<h3>난이도</h3>");
      out.println("<input type='radio' name='level' value='1'>☆");
      out.println("<input type='radio' name='level' value='2'>☆☆");
      out.println("<input type='radio' name='level' value='3'>☆☆☆");

      out.println("<br>카테고리: <br>");
      out.println("<ul>");
      List<Category> list = categoryService.list();
      for (Category c : list) {
        out.printf("<li><input type='radio' name='category' value='%d'>%s</li><br>", c.getCategoryNo(),c.getCategoryName());
      }
      out.println("</ul><br>");
      out.println("내용: <textarea name='content' rows='10' cols='60'></textarea><br>");
      out.println("사진: <input type='file' name='photo'><br>");
      out.println("<button>프로젝트 등록</button>");
      out.println("</form>");

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
