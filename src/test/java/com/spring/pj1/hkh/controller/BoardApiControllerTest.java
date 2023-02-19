package com.spring.pj1.hkh.domain;

import com.spring.pj1.hkh.dto.BoardUpdateDto;
import com.spring.pj1.hkh.repository.BoardRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void Board_수정하기() throws Exception {
        // given
        Board savedBoard = boardRepository.save(Board.builder()
                .title("title")
                .content("content")
                .build());

        Long updateId = savedBoard.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        BoardUpdateDto requestDto = BoardUpdateDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/update/" + updateId;

        HttpEntity<BoardUpdateDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Board> boardList = boardRepository.findAll();
        assertThat(boardList.get(boardList.size()-1).getTitle()).isEqualTo(expectedTitle);
        assertThat(boardList.get(boardList.size()-1).getContent()).isEqualTo(expectedContent);
    }
}
