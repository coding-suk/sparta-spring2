package com.web.spartaspring2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveResponseDto {

    private final Long id;
    private final String name;
    private final String comments;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentSaveResponseDto(Long id, String name, String comments, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.comments = comments;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
