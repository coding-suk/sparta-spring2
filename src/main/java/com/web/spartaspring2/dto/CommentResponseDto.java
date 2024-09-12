package com.web.spartaspring2.dto;

import lombok.Getter;

@Getter
public class CommentResponseDto {

    private final Long id;
    private final String name;
    private final String comments;

    public CommentResponseDto(Long id, String name, String comments) {
        this.id = id;
        this.name = name;
        this.comments = comments;
    }
}
