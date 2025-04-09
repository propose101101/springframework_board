package com.codingrecipe.project01.controller;

import com.codingrecipe.project01.dto.BoardDTO;
import com.codingrecipe.project01.dto.PageDTO;
import com.codingrecipe.project01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        int saveResult = boardService.save(boardDTO);
        if (saveResult > 0) {
            return "redirect:/board/";
        } else {
            return "save";
        }
    }


    @GetMapping("/")
    public String findAllBoards(Model model) {
        List<BoardDTO> boardList = boardService.findAllBoards();
        model.addAttribute("boardList", boardList);
        return "list";
    }

    @GetMapping
    public String findById(@RequestParam Long id, Model model) {

        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "details";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam Long id) {
        boardService.delete(id);
        return "list";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam Long id, Model model) {
        // 데이터 불러오기
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);

        return "update";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO,Model model) {
        //update
        boardService.update(boardDTO);
        //data get
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "details";
        //return "redirect:/board/?id=" + boardDTO.getId();

    }

    //페이징
    @GetMapping("/paging")
    public String paging(Model model,
                         @RequestParam(value ="page", required = false,defaultValue = "1") int page) {
        System.out.println("model = " + model + ", page = " + page);

        List<BoardDTO> pagingList = boardService.pagingList(page);
        System.out.println("pagingList = " + pagingList);

        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "paging";
    }



}
