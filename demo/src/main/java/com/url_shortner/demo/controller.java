package com.url_shortner.demo;

import com.url_shortner.demo.service.UrlService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    private final UrlService service;

    public controller(UrlService service) {
        this.service = service;
    }
}
