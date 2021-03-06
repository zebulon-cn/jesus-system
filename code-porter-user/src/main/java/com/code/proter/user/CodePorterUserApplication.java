package com.code.proter.user;

import com.code.proter.common.base.redis.model.RedisOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CodePorterUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodePorterUserApplication.class, args);
    }

    @Bean // Redis
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisOptions buildRedisOptions() {
        return new RedisOptions();
    }
}
