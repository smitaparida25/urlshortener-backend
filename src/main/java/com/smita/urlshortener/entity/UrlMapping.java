package com.smita.urlshortener.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UrlMapping {
    @Id // primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // annotation for generating id with the auto increment/identity feature
    private Long id;

    private String longUrl;

    private String shortCode;

    private long clicks;

    //Long → object → default null
    //long → primitive → default 0
}
