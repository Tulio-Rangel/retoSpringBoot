package com.sophos.retoSpringBoot.controller;

import com.sophos.retoSpringBoot.entity.Movement;
import com.sophos.retoSpringBoot.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MovementController {
    @Autowired
    MovementService movementService;

    @GetMapping("/movement/{movementId}")
    @ResponseBody
    public ResponseEntity<Movement> readMovement(@PathVariable("movementId") Long movementId) {
        Movement response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = movementService.readMovement(movementId);
            if (response != null) {
                status = HttpStatus.OK;
                message = "Movimiento encontrado satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "El movimiento con el id " +movementId+ " no se encuentra registrado";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/movement/account/{accountId}")
    @ResponseBody
    public ResponseEntity<Movement> readAllMovementByAccountId(@PathVariable String account, @PathVariable Long accountId) {
        Movement response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = movementService.readAllMovementByAccountId(accountId);
            if (response != null) {
                status = HttpStatus.OK;
                message = "Lista de movimientos encontrada satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "No se pudo encontrar ningun cmovimiento asociado con el id " +accountId+ " de la cuenta";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/movement")
    @ResponseBody
    public ResponseEntity<Movement> createMovement(@RequestBody Movement movement) {
        Movement response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = movementService.createMovement(movement);
            if (response != null) {
                status = HttpStatus.CREATED;
                message = "Movimiento creado satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "El movimiento no pudo ser creado";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/movement/{movementId}")
    @ResponseBody
    public ResponseEntity<Movement> deleteMovement(@PathVariable("movementId") Long movementId) {
        Movement response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = movementService.readMovement(movementId);
            if (response != null) {
                movementService.deleteMovement(movementId);
                status = HttpStatus.ACCEPTED;
                message = "Movimiento eliminado satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "El movimiento con el id " +movementId+ " no pudo ser eliminado";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/movement/{movementId}")
    @ResponseBody
    public ResponseEntity<Object> updateMovement(@PathVariable(name = "movementId") Long movementId, @RequestBody Movement movement) {

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
            movement.setMovementId(movementId);
            Movement movementNew = this.movementService.updateMovement(movement);
            if(movementNew != null)
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(movementNew);
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("Bad Request data"));
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(ex.getMessage()));
        }

    }
}
