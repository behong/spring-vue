package org.duckdns.jisou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JisouApplication {

    public static void main(String[] args) {
        SpringApplication.run(JisouApplication.class, args);
    }

}
