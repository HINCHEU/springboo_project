package com.example.hin_cheu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @GetMapping("/")
    public String sayHello() {
        return "eshopper/home";
    }
    @GetMapping("/index1")
    public String home(Model model) {
        model.addAttribute("title", "Home | E-Shopper");
        return "eshopper/home";
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";  // This refers to the hi.html template
    }
    @GetMapping("/check_out")
    public  String chekOut(){
        return "eshopper/checkout";
    }
    @GetMapping("/cart")
    public  String cart(){
        return "eshopper/cart";
    }
    @GetMapping("/blog")
    public  String blog(){
        return "eshopper/blog";
    }
    @GetMapping("/contactus")
    public  String contact(){
        return "eshopper/contact";
    }
    @GetMapping("/login")
    public  String login(){
        return "eshopper/login";
    }
    @GetMapping("/productdetail")
    public  String productdetail(){
        return "eshopper/productdetail";
    }
    @GetMapping("/shop")
    public  String shop(){
        return "eshopper/shop";
    }

}
