package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oijoa.domain.Notice;
import com.oijoa.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeServlet {

  @Autowired
  NoticeService noticeService;

  @RequestMapping("/list")
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    List<Notice> list = noticeService.list();
    ModelAndView mv = new ModelAndView();
    mv.addObject("list", list);
    mv.setViewName("/notice/list.jsp");
    return mv;
  }

  @RequestMapping("add")
  protected String add(Notice notice) throws Exception {

    noticeService.add(notice);
    return "redirect:list";
  }

}
