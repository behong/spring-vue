package org.duckdns.jisou.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity {
    //BaseEntity 에서 전체 적용 되는 데이터베이스 값을 가져온다

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // GenerationType.IDENTITY 데이터 베이스에 위임-auto_increment (mysql/maria)
    private Long bno;

    @Column(length = 500 , nullable = false) //컬럼 길이와 null  허용 여부
    private String title;

    @Column(length = 2000 , nullable = false)
    private String content;

    @Column(length = 50 , nullable = false)
    private String writer;

}
