package com.smita.urlshortener.controller;

import com.smita.urlshortener.service.UrlMappingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
        return "http://localhost:8080/" + urlMappingService.shortenUrl(url);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String url = urlMappingService.getOriginalUrl(shortCode, ip);

        return ResponseEntity
                .status(302)
                .header("Location", url)
                .build();
    }

}
