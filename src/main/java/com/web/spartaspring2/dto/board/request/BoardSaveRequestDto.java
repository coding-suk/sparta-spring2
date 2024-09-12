package com.web.spartaspring2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardSaveRequestDto {

    private Long id;
    private String title;
    private String contents;

}
