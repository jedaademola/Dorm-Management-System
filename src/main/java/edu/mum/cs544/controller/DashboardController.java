package edu.mum.cs544.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DashboardController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signUpForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("signup");
        return model;
    }

    @RequestMapping(value = "/studentForm", method = RequestMethod.GET)
    public ModelAndView studentForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("forms");
        return model;
    }

    @RequestMapping(value = "/series", method = RequestMethod.GET)
    public ModelAndView series() {
        ModelAndView model = new ModelAndView();
        model.setViewName("single");
        return model;
    }

    @RequestMapping(value = "/complaint", method = RequestMethod.GET)
    public ModelAndView complaintForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("complaint");
        return model;
    }

}