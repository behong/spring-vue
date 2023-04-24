package org.duckdns.jisou.repository;

import org.duckdns.jisou.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// spring jpa data 이용할 때 JpaRepository 인터페이스를 이용해서
// 인터페이스 선언만으로 데이터 베이스 기본 작업 CRUD 와 페이징 처리가 가능하다.

public interface BoardRepository extends JpaRepository<Board, Long> {}
