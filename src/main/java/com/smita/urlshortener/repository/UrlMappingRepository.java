package com.smita.urlshortener.repository;

import com.smita.urlshortener.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> { // Spring provides the implementation for this interface
    
}
