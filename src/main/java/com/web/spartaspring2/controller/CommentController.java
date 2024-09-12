package com.web.spartaspring2.controller;

import com.web.spartaspring2.dto.CommentResponseDto;
import com.web.spartaspring2.dto.CommentSaveRequestDto;
import com.web.spartaspring2.dto.CommentSaveResponseDto;
import com.web.spartaspring2.entity.Comment;
import com.web.spartaspring2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 저장
    @PostMapping("/boards/{boardId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long boardId, @RequestBody CommentSaveRequestDto requestDto) {
        return commentService.saveComment(boardId, requestDto);
    }

    //전체 조회
    @GetMapping("/boards/{boardId}/comments")
    public List<CommentResponseDto> getComments(@PathVariable Long boardId) {
        return commentService.getComment(boardId);
    }

    //단건 조회
//    @GetMapping("/boards/{boardId}/comment/{commentId}")

}
