package com.code.proter.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CodePorterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodePorterServerApplication.class, args);
    }

}
