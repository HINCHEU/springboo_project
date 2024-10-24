package com.example.hin_cheu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {
    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("activeLink", "home");
        return "eshopper/home";
    }

    @GetMapping("/index1")
    public String home(Model model) {
        model.addAttribute("title", "Home | E-Shopper");
        model.addAttribute("activeLink", "home");
        return "eshopper/home";
    }

    @GetMapping("/contactus")
    public String contact(Model model) {
        model.addAttribute("activeLink", "contactus");
        return "eshopper/contact";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("activeLink", "shop");
        return "eshopper/shop";
    }

    // Other methods...
}

