package com.example.hin_cheu.models;

import jakarta.persistence.*;

@Entity(name = "TempImage")
@Table(name = "temp_image")
public class TempImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Change to IDENTITY
    private Long id;

    @Column(
            nullable = false,
            name = "name"
    )
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
