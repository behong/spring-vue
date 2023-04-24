package org.duckdns.jisou.domain;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
//spring jpa AuditingEntityListener 에서 가져옴
// 해당 클래스가 적용되면 엔티티가 데이터베이스에 추가 / 변경될 때 자동으로 시간 값을 저장
// AuditingEntityListener 활성화 하기 위해 프로젝트 설정( jisouApplication )에 @EnableJpaAuditing 추가 해야함
@Getter
public class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;


}
