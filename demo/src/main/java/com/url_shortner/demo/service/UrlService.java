package com.url_shortner.demo.service;

import com.url_shortner.demo.dto.ShortenRequest;
import com.url_shortner.demo.dto.ShortenResponse;
import com.url_shortner.demo.model.URL;
import com.url_shortner.demo.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UrlService {
    private final UrlRepository urlRepo;

    public UrlService(UrlRepository urlRepo) {
        this.urlRepo = urlRepo;
    }

    public ShortenResponse shorten(ShortenRequest request){
        String shortCode = UUID.randomUUID().toString().substring(0,8);
        String shortUrl = "http://localhost:8080/" + shortCode;
        URL url = new URL();
        url.setShortCode(shortCode);
        url.setOriginalUrl(request.getOriginalUrl());
        url.setClickCount(0L);
        url.setCreatedAt(LocalDateTime.now());
        urlRepo.save(url);
        ShortenResponse response = new ShortenResponse(shortUrl,request.getOriginalUrl());
        return response;
    }

    public String redirect(String shortCode){
        Optional<URL> url = urlRepo.findByShortCode(shortCode);
        if(url.isPresent()){
            URL urlEntity = url.get();
            urlEntity.setClickCount(urlEntity.getClickCount()+1);
            urlRepo.save(urlEntity);
            return urlEntity.getOriginalUrl();
        }
        else {
            throw new RuntimeException("No URL with shortCode " + shortCode);
        }
    }
}
