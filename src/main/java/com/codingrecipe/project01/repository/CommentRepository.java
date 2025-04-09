package com.codingrecipe.project01.repository;

import com.codingrecipe.project01.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final SqlSessionTemplate sql ;
    public void save(CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);
        sql.insert("Comment.save", commentDTO);

    }
}
