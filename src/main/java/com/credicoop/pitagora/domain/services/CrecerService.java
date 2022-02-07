package com.credicoop.pitagora.domain.services;

import com.credicoop.pitagora.dto.ClientDto;

import java.util.List;

public interface CrecerService {

    List<ClientDto> findById(String id) throws ServiceException;

}
