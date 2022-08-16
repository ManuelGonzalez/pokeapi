package com.manuel.pokeapi.domain.services;

import com.manuel.pokeapi.dto.PokemonDto;
import com.manuel.pokeapi.dto.PokemonMinDto;
import com.manuel.pokeapi.dto.PokemonResponseDto;

import java.util.List;

public interface PokemonService {

    PokemonResponseDto findAll(String limit, String offset) throws ServiceException;

    PokemonDto findById(String id) throws ServiceException;

}
