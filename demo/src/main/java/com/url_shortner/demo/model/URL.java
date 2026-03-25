package com.url_shortner.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "url_shortner")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "original_url")
    private String originalUrl;
    @Column(name = "short_code")
    private String shortCode;
    @Column(name = "click_count")
    private Long clickCount;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
