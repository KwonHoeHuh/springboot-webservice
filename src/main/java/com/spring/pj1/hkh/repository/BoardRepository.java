package com.spring.pj1.hkh.repository;

import com.spring.pj1.hkh.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT p FROM Board p ORDER BY p.id DESC")
    List<Board> findAllDesc();
}
/*
    public void create(Board board) {
        Board elem = new Board();

        elem.setNo(board.getNo());
        elem.setTitle(board.getTitle());
        elem.setContext(board.getContext());
    }

    public Board read(int id) {
        Board elem;


        return elem;
    }

    public void update(Board board) {

    }

    public void delete(int id) {

    }
}
*/