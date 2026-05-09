package com.smita.urlshortener.service;
import com.smita.urlshortener.repository.UrlMappingRepository; // going to use this to store the url
import org.springframework.stereotype.Service;

@Service
public class UrlMappingService {
    private final UrlMappingRepository urlMappingRepository; // creating object of repository, repository reference variable for this service class
    public UrlMappingService(UrlMappingRepository urlMappingRepository) { // same name as class, runs whenever the object of this class is created. the parameter will be passed when creating the object of service class.
        this.urlMappingRepository = urlMappingRepository; // assigning the variable of class, the value that is passed.
    }
}
