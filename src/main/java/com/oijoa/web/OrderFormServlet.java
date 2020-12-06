package com.oijoa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oijoa.domain.Basket;
import com.oijoa.domain.User;
import com.oijoa.service.BasketService;

@WebServlet("/order/form")
public class OrderFormServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    ServletContext ctx = request.getServletContext();
    BasketService basketService = (BasketService) ctx.getAttribute("basketService");

    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("loginUser");
    try {
      List<Basket> baskets = basketService.myList(user.getUserNo());





      request.setAttribute("baskets", baskets);
      request.setAttribute("user", user);
      request.getRequestDispatcher("/order/form.jsp").include(request, response);
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

  }


}
