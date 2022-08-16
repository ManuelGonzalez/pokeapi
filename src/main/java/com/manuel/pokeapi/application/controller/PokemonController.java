package com.manuel.pokeapi.application.controller;

import com.manuel.pokeapi.domain.services.CrecerService;
import com.manuel.pokeapi.domain.services.ServiceException;
import com.manuel.pokeapi.dto.ClientDto;
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

    @GetMapping("/{path}/{id}")
    public ResponseEntity<List<ClientDto>> getClientById(@PathVariable("id") String id, @PathVariable("path") String path) throws ServiceException {
        return new ResponseEntity<List<ClientDto>>(this.crecerService.findById(id, path), HttpStatus.OK);
    }

}
