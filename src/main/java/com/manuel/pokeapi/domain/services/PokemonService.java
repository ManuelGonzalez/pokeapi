package com.manuel.pokeapi.domain.services;

import com.manuel.pokeapi.dto.ClientDto;

import java.util.List;

public interface CrecerService {

    List<ClientDto> findById(String id, String path) throws ServiceException;

}
