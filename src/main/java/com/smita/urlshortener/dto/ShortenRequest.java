package com.smita.urlshortener.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortenRequest {
    private String originalUrl;
    private int expiryDays;
}

// made this dto class to make the management of input easy.
