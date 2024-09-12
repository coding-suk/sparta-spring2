package com.web.spartaspring2.dto.board.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardSaveResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public BoardSaveResponseDto(Long id, String title, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }


}
