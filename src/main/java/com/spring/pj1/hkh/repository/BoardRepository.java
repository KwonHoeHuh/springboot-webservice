package com.spring.pj1.hkh.repository;

import com.spring.pj1.hkh.domain.Marathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Marathon, Long> {
    @Query("SELECT p FROM Marathon p ORDER BY p.id DESC")
    List<Marathon> findAllDesc();
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