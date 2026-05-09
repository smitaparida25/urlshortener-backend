package com.smita.urlshortener.controller;

import com.smita.urlshortener.service.UrlMappingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlMappingController {
    private final UrlMappingService urlMappingService; // injecting service
    public UrlMappingController(UrlMappingService urlMappingService){
        this.urlMappingService = urlMappingService;
    }

    @PostMapping("/shorten") // string needs quotes
    public String shortenUrl(@RequestParam String url){ // take string parameter from url
        return urlMappingService.shortenUrl(url);
    }


}
