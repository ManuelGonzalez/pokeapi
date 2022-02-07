package com.credicoop.pitagora.application.controller;

import com.credicoop.pitagora.domain.services.CrecerService;
import com.credicoop.pitagora.domain.services.ServiceException;
import com.credicoop.pitagora.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * RestController for client entity
 */
@RestController
@RequestMapping(path = "/clients")
public class CrecerController {

    @Autowired
    CrecerService crecerService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ClientDto>> getClientById(@PathVariable("id") String id) throws ServiceException {
        return new ResponseEntity<List<ClientDto>>(this.crecerService.findById(id), HttpStatus.OK);
    }

}
