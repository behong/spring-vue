package org.duckdns.jisou;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA 에서 데이터 추가 할때 시간데이터 자동 추가 /domain/BaseEntity 에서 설정
@SpringBootTest
class JisouApplicationTests {

    @Test
    void contextLoads() {
    }

}
