package com.example.hin_cheu.repository;

import com.example.hin_cheu.models.Slideshow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlideshowRepository extends JpaRepository<Slideshow, Long> {
    List<Slideshow> findByActiveOrderByOrderAsc(Boolean active);
}