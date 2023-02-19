package com.spring.pj1.hkh.service;

import com.spring.pj1.hkh.domain.Board;
import com.spring.pj1.hkh.dto.BoardListResponseDto;
import com.spring.pj1.hkh.dto.BoardResponseDto;
import com.spring.pj1.hkh.dto.BoardSaveRequestDto;
import com.spring.pj1.hkh.dto.BoardUpdateDto;
import com.spring.pj1.hkh.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }

    public Board read(Long id) {
        return boardRepository.findById(id).get();
    }

    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        boardRepository.delete(board); //ById(id);
    }

    @Transactional
    public Long update(Long id, BoardUpdateDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        board.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new BoardResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllDesc() {
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId();
    }
}
