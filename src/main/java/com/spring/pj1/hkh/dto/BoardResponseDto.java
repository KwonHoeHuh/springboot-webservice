package com.spring.pj1.hkh.dto;

import com.spring.pj1.hkh.domain.Marathon;
import lombok.Getter;
import org.springframework.beans.factory.support.ManagedArray;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String name;

    public BoardResponseDto(Marathon entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.name = entity.getName();
    }
}
