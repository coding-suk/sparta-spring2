package com.web.spartaspring2.dto;

import lombok.Getter;

@Getter
public class CommentSimpleResponseDto {

    private final Long id;
    private final String name;
    private final String comments;

    public CommentSimpleResponseDto(Long id, String name, String comments) {
        this.id = id;
        this.name = name;
        this.comments = comments;
    }
}
