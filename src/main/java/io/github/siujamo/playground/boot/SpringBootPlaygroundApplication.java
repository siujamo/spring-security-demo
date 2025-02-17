package io.github.siujamo.playground.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("io.github.siujamo.playground.boot.repository")
@SpringBootApplication
public class SpringBootPlaygroundApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootPlaygroundApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPlaygroundApplication.class, args);
    }

}
