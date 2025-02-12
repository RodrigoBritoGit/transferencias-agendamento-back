package com.example.transferencias.configs;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        // Cria e configura o ObjectMapper
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd")) // Formato de data para todo o JSON
                .build();

        // Configura o Jackson para não tratar datas como Timestamps, mas no formato desejado
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return objectMapper;
    }
}
