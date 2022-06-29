package com.Projekat.Dostava.BasicController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestoranController {
    @RequestMapping("/restoran")
    public ModelAndView getWelcomePageAsModel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restoran.html");
        return modelAndView;
    }
}
