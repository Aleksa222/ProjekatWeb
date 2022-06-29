package com.Projekat.Dostava.BasicController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PocetnaController {
    @RequestMapping("/pocetna")
    public ModelAndView getWelcomePageAsModel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pocetna.html");
        return modelAndView;
    }
}
