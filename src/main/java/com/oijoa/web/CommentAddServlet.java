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
import javax.servlet.http.HttpSession;

import com.oijoa.domain.Comment;
import com.oijoa.service.CommentService;

@WebServlet("/comment/add")
public class CommentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext ctx = req.getServletContext();
		CommentService commentService = (CommentService) ctx.getAttribute("commentService");
		res.setCharacterEncoding("UTF-8");	
		
		Comment comment = new Comment();
		req.setCharacterEncoding("UTF-8");
		comment.setContent(req.getParameter("content"));
		HttpSession session = req.getSession();
		
		res.setContentType("text/html;charset=UTF-8");		
		PrintWriter out = res.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Refresh' content='1;url=list'>");
		out.println("<title>게시물 등록</title>");
		out.println("</head>");
		out.println("<body>");
		
		try {
			out.println("<h1>게시물 등록 </h1>");

			//User loginUser = (User) session.getAttribute("loginUser");
			

			commentService.add(comment);

			out.println("<p>게시글을 등록하였습니다.</p>");

		} catch (Exception e) {
			out.printf("<p>작업 처리 중 오류 발생! - %s</p>\n", e.getMessage());
			
			StringWriter errOut = new StringWriter();
			e.printStackTrace(new PrintWriter(errOut));
			out.printf("<pre>%s</pre>\n",errOut.toString());
		}
		out.println("</body>");
		out.println("</html>");
	}

}
