package com.paulovieira.jwtdemo;

import com.paulovieira.jwtdemo.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.*;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class JwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }

}
