package com.cg.controller;

import com.cg.utils.AppUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/transfers")
public class TransferController {

    @GetMapping
    public ModelAndView listTransfers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer/list");
        modelAndView.addObject("username", AppUtils.getPrincipalUsername());
        return modelAndView;
    }

}
