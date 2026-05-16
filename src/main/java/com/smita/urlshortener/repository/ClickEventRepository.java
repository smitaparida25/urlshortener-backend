package com.smita.urlshortener.repository;

import com.smita.urlshortener.entity.ClickEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {
    long countByIpAddressAndTimestampAfter(
            String ipAddress,
            LocalDateTime timestamp
    );

    long countByShortCode(String shortCode);

    long countDistinctIpAddressByShortCode(String shortCode);

}
