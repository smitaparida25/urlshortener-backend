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
        UrlMapping mapping = new UrlMapping(); // object
        // save long url first.
        mapping.setLongUrl(url);
        urlMappingRepository.save(mapping);

        Long id = mapping.getId();
        String shortCode = encodeBase62(id);
        mapping.setShortCode(shortCode);
        urlMappingRepository.save(mapping);

        return shortCode;
    }
    public static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String encodeBase62(Long id){
        StringBuilder shortCode = new StringBuilder();

        while(id>0){
            int remainder = (int) (id%62);
            shortCode.append(BASE62.charAt(remainder));
            id = id / 62;
        }
        return shortCode.reverse().toString();
    }
}
