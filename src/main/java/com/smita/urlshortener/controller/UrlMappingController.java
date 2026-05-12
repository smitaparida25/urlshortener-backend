package com.smita.urlshortener.controller;

import com.smita.urlshortener.service.UrlMappingService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UrlMappingController {
    private final UrlMappingService urlMappingService; // injecting service
    public UrlMappingController(UrlMappingService urlMappingService){
        this.urlMappingService = urlMappingService;
    }

    @PostMapping("/shorten") // string needs quotes
    public String shortenUrl(@RequestBody String url){ // take string parameter from url
        return urlMappingService.shortenUrl(url);
    }

    @GetMapping("/{shortCode}")
    public String getOriginalUrl(@PathVariable String shortCode){
        return urlMappingService.getOriginalUrl(shortCode);
    }

}
