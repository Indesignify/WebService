package ru.spb.iac.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView startingPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView adminLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("persons");
        return modelAndView;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView personsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("persons");
        return modelAndView;
    }
}
