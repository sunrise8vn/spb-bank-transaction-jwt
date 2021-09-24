package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/list");
        return modelAndView;
    }

}
