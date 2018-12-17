package com.pawel.Schronisko_Spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/mainPage")
    public String mainPage(Model model)
    {
        return "mainPage";
    }

//    @RequestMapping("/review")
//    public String reviewPage(Model model)
//    {
//        return "review";
//    }

    @RequestMapping("/about")
    public String aboutPage(){
        return"about";
    }

    @RequestMapping("/contact")
    public String contactPage()
    {
        return "contact";
    }
}
