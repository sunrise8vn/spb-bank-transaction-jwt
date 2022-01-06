package com.cg.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/transfers")
public class TransferController {

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
            userName = userName.substring(0, userName.indexOf("@"));
        } else {
            userName = principal.toString();
        }

        return userName;
    }

    @GetMapping
    public ModelAndView listTransfers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer/list");
        modelAndView.addObject("username", getPrincipal());
        return modelAndView;
    }

}
