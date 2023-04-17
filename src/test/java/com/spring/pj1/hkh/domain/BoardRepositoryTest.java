package com.spring.pj1.hkh.domain;

import com.spring.pj1.hkh.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public  void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";
/*
        boardRepository.save(Board.builder()
                .title(title)
                .content(content)
                .build());
*/
        List<Marathon> boardList = boardRepository.findAll();

        System.out.println("size = " + Integer.toString(boardList.size()));
        Marathon board = boardList.get(boardList.size()-1);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2022,6,4,0,0,0);
        boardRepository.save(Marathon.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Marathon> boardList = boardRepository.findAll();

        //then
        Marathon board = boardList.get(boardList.size()-1);

        System.out.println(">>>>>>> createDate="+board.getCreatedDate()+", modifiedDate="+board.getModifiedDate());

        assertThat(board.getCreatedDate()).isAfter(now);
        assertThat(board.getModifiedDate()).isAfter(now);
    }
}
