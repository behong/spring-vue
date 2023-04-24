package org.duckdns.jisou.repository;

import lombok.extern.log4j.Log4j2;
import org.duckdns.jisou.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    @Test
    public void testUpdate(){
        Long bno = 100L;
        Optional<Board> boardList = boardRepository.findById(bno);

        Board board = boardList.orElseThrow();

        board.chage("수정된 타이틀 "+bno,"수정된 내용 .. "+bno);

        boardRepository.save(board);
    }
    @Test
    public void testDelete(){
        Long bno = 1L;

        boardRepository.deleteById(bno);
    }
    @Test
    public void testPaging(){
        //1 page order by bno desc
        Pageable pageable = PageRequest.of(1,10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.findAll(pageable);

        log.info("total count : " + result.getTotalElements());
        log.info("total page : " + result.getTotalPages());
        log.info("total number : " + result.getNumber());
        log.info("total size : " + result.getSize());

        List<Board> list= result.getContent();
        list.forEach( board ->  log.info(board));

    }
}
