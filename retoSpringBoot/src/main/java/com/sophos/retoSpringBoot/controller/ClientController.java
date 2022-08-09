package com.sophos.retoSpringBoot.controller;

import com.sophos.retoSpringBoot.entity.Client;
import com.sophos.retoSpringBoot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/{clientId}")
    @ResponseBody
    public ResponseEntity<Client> readClient(@PathVariable("clientId") Long clientId) {
        Client response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = clientService.readClient(clientId);
            if (response != null) {
                status = HttpStatus.OK;
                message = "Cliente encontrado satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "El cliente con el id " +clientId+ " no se encuentra registrado";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = clientService.createClient(client);
            if (response != null) {
                status = HttpStatus.CREATED;
                message = "Cliente creado satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "El cliente no pudo ser creado";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }
}
