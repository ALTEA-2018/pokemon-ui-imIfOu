package com.miage.altea.tp.pokemon_ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class RestConfiguration {

    @Value("${trainer.service.username}")
    private String username;

    @Value("${trainer.service.password}")
    private String password;

    @Bean(name = "trainerApiRestTemplate")
    RestTemplate trainerApiRestTemplate(){
        BasicAuthenticationInterceptor basicAuthenticationInterceptor = new BasicAuthenticationInterceptor(username,password);
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(basicAuthenticationInterceptor);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean(name = "pokemonTypeRestTemplate")
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}