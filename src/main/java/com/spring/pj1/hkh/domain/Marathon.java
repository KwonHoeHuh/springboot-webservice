package com.spring.pj1.hkh.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Marathon extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    private String name;
    private Integer confirm;

    @Builder
    public Marathon(String title, String content, String author, String name) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.name = name;
    }

    public void update(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }
}
