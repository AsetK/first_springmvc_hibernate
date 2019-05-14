package com.epam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.service.TakeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TakeController {

    @RequestMapping("/take")
    public ModelAndView take(HttpServletRequest request, HttpServletResponse responce)
    {
        int i = Integer.parseInt(request.getParameter("t1"));
        int j = Integer.parseInt(request.getParameter("t2"));

        TakeService takeService = new TakeService();
        int k = takeService.take(i,j);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("display.jsp");
        mv.addObject("result",k);

        return mv;
    }
}
