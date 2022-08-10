package com.sophos.retoSpringBoot.controller;

import com.sophos.retoSpringBoot.entity.Account;
import com.sophos.retoSpringBoot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/account/{accountId}")
    @ResponseBody
    public ResponseEntity<Account> readAccount(@PathVariable("accountId") Long accountId) {
        Account response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = accountService.readAccount(accountId);
            if (response != null) {
                status = HttpStatus.OK;
                message = "Cuenta encontrada satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "La cuenta con el id " +accountId+ " no se encuentra registrada";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/account/client/{clientId}")
    @ResponseBody
    public ResponseEntity<Account> readAllAccountByClientId(@PathVariable String client, @PathVariable Long clientId) {
        Account response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = accountService.readAllAccountByClientId(clientId);
            if (response != null) {
                status = HttpStatus.OK;
                message = "Lista de cuentas encontrada satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "No se pudo encontrar ninguna cuenta asociada con el id " +clientId+ " del cliente";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/account")
    @ResponseBody
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = accountService.createAccount(account);
            if (response != null) {
                status = HttpStatus.CREATED;
                message = "Cuenta creada satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "La cuenta no pudo ser creada";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/account/{accountId}")
    @ResponseBody
    public ResponseEntity<Account> deleteAccount(@PathVariable("accountId") Long accountId) {
        Account response = null;
        HttpStatus status = null;
        String message = null;
        try {
            response = accountService.readAccount(accountId);
            if (response != null) {
                accountService.deleteAccount(accountId);
                status = HttpStatus.ACCEPTED;
                message = "Cuenta eliminada satisfactoriamente";
                return ResponseEntity.status(status).body(response);
            } else {
                status = HttpStatus.BAD_REQUEST;
                message = "La cuenta con el id " +accountId+ " no pudo ser eliminada";
                return ResponseEntity.status(status).body(response);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/account/{accountId}")
    @ResponseBody
    public ResponseEntity<Object> updateAccount(@PathVariable(name = "accountId") Long accountId, @RequestBody Account account) {

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
            account.setAccountId(accountId);
            Account accountNew = this.accountService.updateAccount(account);
            if(accountNew != null)
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountNew);
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("Bad Request data"));
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(ex.getMessage()));
        }

    }
}
