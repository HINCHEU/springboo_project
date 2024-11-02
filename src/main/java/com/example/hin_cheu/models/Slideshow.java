package com.example.hin_cheu.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "slideshows")
public class Slideshow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @Column(name = "display_order")
    private Integer order;

    private Boolean active = true;

    @Column(name = "button_text")
    private String buttonText;

    @Column(name = "button_link")
    private String buttonLink;
}