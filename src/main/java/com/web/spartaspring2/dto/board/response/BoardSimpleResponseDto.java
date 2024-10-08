package com.web.spartaspring2.dto.board.response;

import com.web.spartaspring2.dto.CommentSimpleResponseDto;
import com.web.spartaspring2.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BoardSimpleResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final List<CommentSimpleResponseDto> comments;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public BoardSimpleResponseDto(Long id, String title, String contents, List<CommentSimpleResponseDto> comments, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.comments = comments;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
