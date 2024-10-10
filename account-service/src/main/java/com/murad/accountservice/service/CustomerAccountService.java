package com.murad.accountservice.service;

import com.murad.accountservice.model.CustomerAccount;
import com.murad.accountservice.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerAccountService {
    @Autowired
    private CustomerAccountRepository repository;

    public Optional<CustomerAccount> getAccountByNumber(String accountNumber) {
        return repository.findByAccountNumber(accountNumber);
    }
}