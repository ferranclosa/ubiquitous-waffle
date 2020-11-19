package com.closa.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.closa.global.*",  "com.closa.data.*", "com.closa.global.trace.*"})
@EntityScan(basePackages = {"com.closa.global.status.model", "com.closa.data.model", "com.closa.global.trace.model"})
@EnableJpaRepositories(basePackages = {"com.closa.global.status.dao", "com.closa.data.dao", "com.closa.global.trace.dao"})
@EnableEurekaClient
public class DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

}
