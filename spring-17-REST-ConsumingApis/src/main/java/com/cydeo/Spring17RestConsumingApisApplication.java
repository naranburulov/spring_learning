package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients                     //pom.xml - org.springframework.cloud
public class Spring17RestConsumingApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17RestConsumingApisApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){         //one of the ways to consume api by Rest Template (soon to be depreciated - dinosaur)
        return new RestTemplate();
    }
    //next, use DTOs (here is a nice tool to do that faster:  https://www.jsonschema2pojo.org/    )


}
