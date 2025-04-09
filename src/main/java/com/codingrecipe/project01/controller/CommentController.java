package com.codingrecipe.project01.controller;

import com.codingrecipe.project01.dto.CommentDTO;
import com.codingrecipe.project01.repository.CommentRepository;
import com.codingrecipe.project01.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/save")
    @ResponseBody
    public String saveComment(@ModelAttribute CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);
        commentService.save(commentDTO);
        return null ;
    }
}
