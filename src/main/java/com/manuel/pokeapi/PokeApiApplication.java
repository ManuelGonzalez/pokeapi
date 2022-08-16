package com.manuel.pokeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PokeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokeApiApplication.class, args);
    }

}
