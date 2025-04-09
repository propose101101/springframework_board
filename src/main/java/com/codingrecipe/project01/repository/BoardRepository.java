package com.codingrecipe.project01.repository;

import com.codingrecipe.project01.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql ;
    public int save(BoardDTO boardDTO) {
        return sql.insert("Board.save", boardDTO);
    }
}
