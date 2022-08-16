package com.manuel.pokeapi.domain.services.imp;

import com.manuel.pokeapi.domain.services.CrecerService;
import com.manuel.pokeapi.domain.services.ErrorService;
import com.manuel.pokeapi.domain.services.ServiceException;
import com.manuel.pokeapi.domain.storage.crecer.CrecerStorage;
import com.manuel.pokeapi.domain.storage.crecer.CrecerStorageException;
import com.manuel.pokeapi.dto.ClientDto;
import com.manuel.pokeapi.dto.CrecerResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CrecerServiceImp implements CrecerService {

    @Autowired
    CrecerStorage crecerStorage;

    @Override
    public List<ClientDto> findById(String id, String path) throws ServiceException {
        try {

            return crecerStorage.findById(id, path).map(CrecerResponseDto::getCandidatos).orElse(null);

        } catch (CrecerStorageException e) {
            ErrorService error = new ErrorService("Error get person data", e.getMessage());
            log.error(error.toString());
            throw new ServiceException(error);
        }
    }

}
