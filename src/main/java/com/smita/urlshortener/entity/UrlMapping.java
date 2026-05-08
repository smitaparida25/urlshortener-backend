package com.smita.urlshortener.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UrlMapping {
    @Id // primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // annotation for generating id with the auto increment/identity feature
    private Long id;

    private String longUrl;

    private String shortCode;
}
