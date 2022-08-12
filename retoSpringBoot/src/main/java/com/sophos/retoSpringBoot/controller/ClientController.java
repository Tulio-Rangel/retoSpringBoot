package com.sophos.retoSpringBoot.controller;

import com.sophos.retoSpringBoot.entity.Client;
import com.sophos.retoSpringBoot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/client/{clientId}")
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

    @PostMapping("/client")
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

    @DeleteMapping("/client/{clientId}")
    @ResponseBody
    public ResponseEntity deleteClient(@PathVariable("clientId") Long clientId) {
        try {
            if (clientService.deleteClient(clientId)) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("El cliente con id " +clientId+ " fue eliminado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El cliente con el id " +clientId+ " no pudo ser eliminado");
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/client/{clientId}")
    @ResponseBody
    public ResponseEntity<Object> updateClient(@PathVariable(name = "clientId") Long clientId, @RequestBody Client client) {
        class Error {
            public String message;
            public Error(String message) {
                this.message = message;
            }
            public String getMessage() {
                return message;
            }
        }

        try {
            client.setClientId(clientId);
            Client clientNew = this.clientService.updateClient(client);
            if(clientNew != null)
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientNew);
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("Bad Request data"));
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(ex.getMessage()));
        }
    }
}
