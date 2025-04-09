package com.codingrecipe.project01.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class CommentDTO {
    private int id;
    private String commentWriter;
    private String commentContents;
    private Long boardId;
    private Timestamp commentCreateDate;
}
