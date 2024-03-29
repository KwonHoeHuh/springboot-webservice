package com.spring.pj1.hkh.controller;

import com.spring.pj1.hkh.config.auth.LoginUser;
import com.spring.pj1.hkh.config.auth.dto.SessionUser;
import com.spring.pj1.hkh.dto.BoardResponseDto;
import com.spring.pj1.hkh.dto.BoardListResponseDto;
import com.spring.pj1.hkh.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final BoardService boardService;
//    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            List<BoardListResponseDto> responseDtos = boardService.findAllDesc();

            for(BoardListResponseDto responseDto : responseDtos) {
                if(responseDto.getAuthor().equals(user.getName())) {
                    responseDto.setYouyou("YOU");
                    model.addAttribute("Exist","exist");
                }
            }

            model.addAttribute("board", responseDtos);
            model.addAttribute("userName", user.getName());
        }
        else
            model.addAttribute("board", boardService.findAllDesc());

        return "index";
    }

    @GetMapping("/board/save")
    public String boardSave(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("board", boardService.findAllDesc());

        if(user != null)
            model.addAttribute("userName", user.getName());

        return "board-save";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Model model) {
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);

        return "board-update";
    }
}
