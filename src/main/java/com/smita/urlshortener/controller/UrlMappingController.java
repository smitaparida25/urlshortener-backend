package com.smita.urlshortener.controller;

import com.smita.urlshortener.dto.ShortenRequest;
import com.smita.urlshortener.service.UrlMappingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UrlMappingController {
    private final UrlMappingService urlMappingService; // injecting service
    public UrlMappingController(UrlMappingService urlMappingService){
        this.urlMappingService = urlMappingService;
    }

    @PostMapping("/shorten") // string needs quotes
    public String shortenUrl(@RequestBody ShortenRequest shortenRequest){ // take string parameter from url
        return "http://localhost:8080/" + urlMappingService.shortenUrl(shortenRequest);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode, HttpServletRequest request) {

        try {
            String ip = request.getRemoteAddr();
            String url = urlMappingService.getOriginalUrl(shortCode, ip);

            return ResponseEntity
                    .status(302)
                    .header("Location", url)
                    .build();

        } catch (RuntimeException ex) {

            if ("Link expired".equals(ex.getMessage())) {
                return ResponseEntity
                        .status(HttpStatus.GONE)
                        .build();
            }

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/stats/{shortCode}")
    public Map<String, Long> getStats(@PathVariable String shortCode){
        return urlMappingService.getStats(shortCode);
    }


}
