package com.manuel.pokeapi.application.controller;

import com.manuel.pokeapi.domain.services.PokemonService;
import com.manuel.pokeapi.domain.services.ServiceException;
import com.manuel.pokeapi.dto.PokemonDto;
import com.manuel.pokeapi.dto.PokemonMinDto;
import com.manuel.pokeapi.dto.PokemonResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * RestController for client entity
 */
@RestController
@RequestMapping(path = "/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping("/{id}")
    @Cacheable(value = "pokemon")
    public ResponseEntity<PokemonDto> getClientById(@PathVariable("id") String id) throws ServiceException {
        return new ResponseEntity<>(this.pokemonService.findById(id), HttpStatus.OK);
    }

    @GetMapping("")
    @Cacheable(value = "pokemon")
    public ResponseEntity<PokemonResponseDto> getClientById(
            @RequestParam(value = "limit", required = false) String limit,
            @RequestParam(value = "offset", required = false) String offset
    ) throws ServiceException {
        return new ResponseEntity<>(this.pokemonService.findAll(limit, offset), HttpStatus.OK);
    }

}
