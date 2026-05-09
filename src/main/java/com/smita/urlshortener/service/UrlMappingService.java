package com.smita.urlshortener.service;
import com.smita.urlshortener.entity.UrlMapping;
import com.smita.urlshortener.repository.UrlMappingRepository; // going to use this to store the url
import org.springframework.stereotype.Service;

@Service
public class UrlMappingService {
    private final UrlMappingRepository urlMappingRepository; // soring creates the object of repository, repository reference variable for this service class
    public UrlMappingService(UrlMappingRepository urlMappingRepository) { // same name as class, runs whenever the object of this class is created. the parameter will be passed when creating the object of service class.
        this.urlMappingRepository = urlMappingRepository; // assigning the variable of class, the value that is passed.
    }

    public String shortenUrl(String url){
        UrlMapping mapping = new UrlMapping();

        // create getter and setter in urlMapping to access and edit the fields


        urlMappingRepository.save(mapping);
        return "abcd";
    }
}
