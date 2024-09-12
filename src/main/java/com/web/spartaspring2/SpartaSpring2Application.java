package com.web.spartaspring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaSpring2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpring2Application.class, args);
    }

}
