package com.spring.pj1.hkh.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateDto {
    private String title;
    private String content;
    private String name;

    @Builder
    public BoardUpdateDto(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }
}
