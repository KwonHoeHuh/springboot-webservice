package com.spring.pj1.hkh.dto;

import com.spring.pj1.hkh.domain.Marathon;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String name;
    private LocalDateTime modifiedDate;
    private String youyou;

    public BoardListResponseDto(Marathon entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.name = entity.getName();
    }

    public void setYouyou(String youyou) {
        this.youyou = youyou;
    }
}
