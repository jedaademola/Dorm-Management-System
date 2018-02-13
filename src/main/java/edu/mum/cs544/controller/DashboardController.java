package edu.mum.cs544.controller;


import edu.mum.cs544.model.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DashboardController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute("command") LoginRequest loginRequest) {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }


    @RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
    public ModelAndView loginAdmin(@ModelAttribute("command") LoginRequest loginRequest) {
        ModelAndView model = new ModelAndView();
        model.setViewName("loginAdmin");
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signUpForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("signup");
        return model;
    }


}