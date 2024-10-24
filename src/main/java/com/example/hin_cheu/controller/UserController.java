package com.example.hin_cheu.controller;

import com.example.hin_cheu.models.User;
import com.example.hin_cheu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/signup")
//    public String showSignUpForm(Model model) {
//        model.addAttribute("user", new User());
//        return "admin/sign_up";  // Name of the signup HTML template
//    }

//    @PostMapping("/api/users/signup")
//    public String signUp(User user) {
//        // Save the user to the database
//        userService.saveUser(user);
//        return "redirect:/signin";  // Redirect to the sign-in page
//    }

    @GetMapping("/signin")
    public String showSignInForm() {
        return "admin/sign_in";  // Name of the sign-in HTML template
    }

    @PostMapping("/api/users/signin")
    public String signIn(String email, String password) {
        User user = userService.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/admin";  // Redirect to the admin page
        }
        return "redirect:/signin?error";  // Redirect back to sign-in with an error
    }

//    @PostMapping("/api/users/signin")
//    public String signIn(String email, String password, Model model) {
//        User user = userService.findByEmail(email);
//        if (user != null && user.getPassword().equals(password)) {
//            // Successfully authenticated
//            model.addAttribute("user", user); // Add user to the model if needed
//            return "redirect:/admin";  // Redirect to the admin page
//        }
//        // Authentication failed, add an error message to the model
//        model.addAttribute("error", "Invalid email or password");
//        return "admin/sign_in";  // Return to the sign-in page with an error message
//    }

}
