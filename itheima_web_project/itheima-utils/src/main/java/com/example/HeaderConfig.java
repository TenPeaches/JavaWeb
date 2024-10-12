package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    @Bean
    //@ConditionalOnMissingBean
    @ConditionalOnProperty(name="name", havingValue="itheima")
    //@ConditionalOnClass(name = "io.jsonwebtoken.JwtBuilder")
    public HeaderParser headerParser(){
        return new HeaderParser();
    }

    @Bean
    public HeaderGenerator headerGenerator(){
        return new HeaderGenerator();
    }
}
