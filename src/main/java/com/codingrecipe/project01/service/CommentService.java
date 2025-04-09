package com.codingrecipe.project01.service;

import com.codingrecipe.project01.dto.CommentDTO;
import com.codingrecipe.project01.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentDTO commentDTO) {
        commentRepository.save(commentDTO);
    }
}
