package org.duckdns.jisou.repository;

import lombok.extern.log4j.Log4j2;
import org.duckdns.jisou.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach( i ->{
            Board board = Board.builder()
                    .title("제목 ... "+i)
                    .content("내용 ... "+ i)
                    .writer("user"+(i%10))
                    .build();
            Board result = boardRepository.save(board);
            log.info("BNO : " + result.getBno());
        });
    }

    @Test
    public void testSelect(){
        Long bno = 100L;
        Optional<Board> boardList = boardRepository.findById(bno);

        Board board = boardList.orElseThrow();
        log.info(" 셀렉트한 보드 "+board);
    }
}
