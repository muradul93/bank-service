package com.murad.accountservice.controller;

import com.murad.accountservice.model.CustomerAccount;
import com.murad.accountservice.service.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class CustomerAccountController {
    @Autowired
    private CustomerAccountService service;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<CustomerAccount> getAccountByNumber(@PathVariable String accountNumber) {
        return service.getAccountByNumber(accountNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}