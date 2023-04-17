package com.spring.pj1.hkh.dto;

import com.spring.pj1.hkh.domain.Marathon;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String name;

    @Builder
    public BoardSaveRequestDto(String title, String content, String author, String name) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.name = name;
    }

    public Marathon toEntity() {
        return Marathon.builder()
                .title(title)
                .content(content)
                .author(author)
                .name(name)
                .build();
    }
}