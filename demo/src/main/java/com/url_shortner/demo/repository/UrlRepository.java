package com.url_shortner.demo.repository;

import com.url_shortner.demo.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<URL, Integer> {
    Optional<URL> findByShortCode(String shortCode);
}
