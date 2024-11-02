package com.example.hin_cheu.service;

import com.example.hin_cheu.models.Slideshow;
import com.example.hin_cheu.repository.SlideshowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class SlideshowService {

    @Autowired
    private SlideshowRepository slideshowRepository;

    private final String UPLOAD_DIRECTORY = "src/main/resources/static/uploads/slideshow/";

    public List<Slideshow> getAllSlides() {
        return slideshowRepository.findAll();
    }

    public List<Slideshow> getActiveSlides() {
        return slideshowRepository.findByActiveOrderByOrderAsc(true);
    }

    public Slideshow saveSlide(Slideshow slideshow, MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIRECTORY + fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, imageFile.getBytes());
            slideshow.setImageUrl("/uploads/slideshow/" + fileName);
        }
        return slideshowRepository.save(slideshow);
    }

    public void deleteSlide(Long id) {
        slideshowRepository.deleteById(id);
    }
}