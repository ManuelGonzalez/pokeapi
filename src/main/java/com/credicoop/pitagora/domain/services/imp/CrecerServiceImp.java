package com.credicoop.pitagora.domain.services.imp;

import com.credicoop.pitagora.domain.services.CrecerService;
import com.credicoop.pitagora.domain.services.ErrorService;
import com.credicoop.pitagora.domain.services.ServiceException;
import com.credicoop.pitagora.domain.storage.ErrorStorage;
import com.credicoop.pitagora.domain.storage.crecer.CrecerStorage;
import com.credicoop.pitagora.domain.storage.crecer.CrecerStorageException;
import com.credicoop.pitagora.dto.ClientDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CrecerServiceImp implements CrecerService {

    @Autowired
    CrecerStorage crecerStorage;

    @Override
    public List<ClientDto> findById(String id) throws ServiceException {
        try {

            return crecerStorage.findById(id).orElse(null);

        } catch (CrecerStorageException e) {
            ErrorService error = new ErrorService("Error get person data", e.getMessage());
            log.error(error.toString());
            throw new ServiceException(error);
        }
    }

}
