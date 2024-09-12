package com.web.spartaspring2.service;

import com.web.spartaspring2.dto.CommentResponseDto;
import com.web.spartaspring2.dto.CommentSaveRequestDto;
import com.web.spartaspring2.dto.CommentSaveResponseDto;
import com.web.spartaspring2.entity.Board;
import com.web.spartaspring2.entity.Comment;
import com.web.spartaspring2.repository.BoardRepository;
import com.web.spartaspring2.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public CommentSaveResponseDto saveComment(Long boardId, CommentSaveRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("보드가 없어요"));

        Comment newComment = new Comment(requestDto.getName(), requestDto.getComments(), board);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(),
                savedComment.getName(), savedComment.getComments(), savedComment.getCreatedAt(), savedComment.getModifiedAt());

    }

    public List<CommentResponseDto> getComment(Long boardId) {
        List<Comment> commentList = commentRepository.findAllByBoardId(boardId);

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentResponseDto dto = new CommentResponseDto(comment.getId(), comment.getName(), comment.getComments());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
