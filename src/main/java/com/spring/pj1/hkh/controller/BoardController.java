package com.spring.pj1.hkh.controller;

import com.spring.pj1.hkh.domain.Board;
import com.spring.pj1.hkh.dto.BoardResponseDto;
import com.spring.pj1.hkh.dto.BoardSaveRequestDto;
import com.spring.pj1.hkh.dto.BoardUpdateDto;
import com.spring.pj1.hkh.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", boardService.list());

        return "boardlist";
    }

    @GetMapping("/view")
    public String view(Model model, Long id) {
        model.addAttribute("board", boardService.read(id));

        return "boardview";
    }

    @GetMapping("/write") // localhost:8080/write
    public String writeform() {

        return "boardwrite";
    }

    @PostMapping("/create")
    public String create(Board board, Model model) {
        boardService.write(board);

        return "boardwrite";
    }

    @GetMapping("/delete")
    public String delete(Long id, Model model) {
        boardService.delete(id);

        return "redirect:/list";
    }

    @GetMapping("/modify/{id}")
    public String boardModify(@PathVariable("id") Long id,
                              Model model) {

        model.addAttribute("board", boardService.read(id));

        return "boardmodify";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Board board) {
        Board boardTmp = boardService.read(id);

        boardTmp.setTitle(board.getTitle());
        boardTmp.setContent(board.getContent());
        boardTmp.setAuthor(board.getAuthor());

        boardService.write(boardTmp);

        return "redirect:/list";
    }

    @PostMapping("/api/board")
    public Long save(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }
    @PutMapping("/api/update/{id}")
    public Long/*String*/ update(@PathVariable Long id, @RequestBody BoardUpdateDto requestDto, Model model) {
        return boardService.update(id, requestDto);
/*
        model.addAttribute("board", requestDto);

        return "boardapiview";*/
    }

    @DeleteMapping("/api/update/{id}")
    public Long delete(@PathVariable Long id) {
        boardService.delete(id);

        return id;
    }

    @GetMapping("/api/update/{id}")
    public String findById (@PathVariable Long id, Model model) {
        BoardResponseDto responseDto = boardService.findById(id);

        model.addAttribute("board", responseDto);

        return "boardview";
    }
}
