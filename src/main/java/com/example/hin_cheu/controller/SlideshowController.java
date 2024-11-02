package com.example.hin_cheu.controller;

import com.example.hin_cheu.models.Slideshow;
import com.example.hin_cheu.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
//@RequestMapping("/admin")
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    @GetMapping("/slideshow")
    public String slideshowManagement(Model model) {
        model.addAttribute("slides", slideshowService.getAllSlides());
        model.addAttribute("newSlide", new Slideshow());
        return "admin/slideshow";
    }

    @PostMapping("/slideshow/add")
    public String addSlideshow(@ModelAttribute Slideshow slideshow,
                               @RequestParam("image") MultipartFile imageFile) {
        try {
            slideshowService.saveSlide(slideshow, imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/slideshow";
    }

    @PostMapping("/slideshow/delete/{id}")
    public String deleteSlideshow(@PathVariable Long id) {
        slideshowService.deleteSlide(id);
        return "redirect:/slideshow";
    }
}