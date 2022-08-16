package com.manuel.pokeapi.domain.services.imp;

import com.manuel.pokeapi.domain.services.PokemonService;
import com.manuel.pokeapi.domain.services.ErrorService;
import com.manuel.pokeapi.domain.services.ServiceException;
import com.manuel.pokeapi.domain.storage.pokemon.PokemonStorage;
import com.manuel.pokeapi.domain.storage.pokemon.PokemonStorageException;
import com.manuel.pokeapi.dto.PokemonDto;
import com.manuel.pokeapi.dto.PokemonMinResponseDto;
import com.manuel.pokeapi.dto.PokemonResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PokemonServiceImp implements PokemonService {

    @Autowired
    PokemonStorage pokemonStorage;

    @Override
    public PokemonResponseDto findAll(String limit, String offset) throws ServiceException {
        try {

            Optional<PokemonMinResponseDto> response = pokemonStorage.findAllBasicInfo(limit, offset);

            if (response.isEmpty()) {
                String message = "Not records found";
                log.error(message);
                throw new ServiceException(message);
            }

            List<PokemonDto> pokemons = response.get().getResults().stream().map(pokemonMinDto -> {
                PokemonDto pokemonDto = PokemonDto.builder().build();
                try {
                    pokemonDto = pokemonStorage.findByUrl(pokemonMinDto.getUrl()).orElse(null);
                } catch (PokemonStorageException e) {
                    ErrorService error = new ErrorService("Error get pokemon data", e.getMessage());
                    log.error(error.toString());
                }
                return pokemonDto;
            }).collect(Collectors.toList());

            return PokemonResponseDto.builder()
                    .count(response.get().getCount())
                    .results(pokemons)
                    .build();

        } catch (PokemonStorageException e) {
            ErrorService error = new ErrorService("Error get pokemon data", e.getMessage());
            log.error(error.toString());
            throw new ServiceException(error);
        }
    }

    @Override
    public PokemonDto findById(String id) throws ServiceException {
        try {

            return pokemonStorage.findById(id).orElse(null);

        } catch (PokemonStorageException e) {
            ErrorService error = new ErrorService("Error get pokemon data", e.getMessage());
            log.error(error.toString());
            throw new ServiceException(error);
        }
    }

}
