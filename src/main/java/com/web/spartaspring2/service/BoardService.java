package com.web.spartaspring2.service;

import com.web.spartaspring2.dto.CommentSimpleResponseDto;
import com.web.spartaspring2.dto.board.response.BoardSimpleResponseDto;
import com.web.spartaspring2.dto.board.request.BoardSaveRequestDto;
import com.web.spartaspring2.dto.board.request.BoardUpdateRequestDto;
import com.web.spartaspring2.dto.board.response.BoardDetailResponseDto;
import com.web.spartaspring2.dto.board.response.BoardSaveResponseDto;
import com.web.spartaspring2.dto.board.response.BoardUpdateResponseDto;
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
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public BoardSaveResponseDto saveBoard(BoardSaveRequestDto requestDto) {
        Board newBoard = new Board(requestDto.getTitle(), requestDto.getContents());
        Board savedBoard = boardRepository.save(newBoard);

        return new BoardSaveResponseDto(
                savedBoard.getId(),
                savedBoard.getTitle(),
                savedBoard.getContents(),
                savedBoard.getCreatedAt(),
                savedBoard.getModifiedAt());
    }

    public List<BoardSimpleResponseDto> getBoard() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardSimpleResponseDto> dtoList = new ArrayList<>();
        for (Board board : boardList) {
            List<Comment> commentList = commentRepository.findByBoardId(board.getId());

            List<CommentSimpleResponseDto> commentDtoList = new ArrayList<>();
            for (Comment comment : commentList) {
                commentDtoList.add(new CommentSimpleResponseDto(comment.getId(), comment.getName(), comment.getComments()));
            }

            BoardSimpleResponseDto dto = new BoardSimpleResponseDto(
                    board.getId(),
                    board.getTitle(),
                    board.getContents(),
                    commentDtoList,
                    board.getCreatedAt(),
                    board.getModifiedAt()
            );
            dtoList.add(dto);
        }
        return dtoList;
    }

    public BoardDetailResponseDto detailBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("보드 없어요"));

        return new BoardDetailResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

    public BoardUpdateResponseDto updateBoard(Long boardId, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("보드 없어요"));

        board.update(requestDto.getTitle(), requestDto.getContents());

        return new BoardUpdateResponseDto(board.getId(), board.getTitle(), board.getContents());
    }


}
