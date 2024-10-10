package com.murad.accountservice.service;

import static org.junit.jupiter.api.Assertions.*;


import com.murad.accountservice.model.CustomerAccount;
import com.murad.accountservice.repository.CustomerAccountRepository;
import com.murad.accountservice.service.CustomerAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerAccountServiceTest {

    @Mock
    private CustomerAccountRepository customerAccountRepository;

    @InjectMocks
    private CustomerAccountService customerAccountService;

    public CustomerAccountServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAccountByNumber() {
        String accountNumber = "1234567890";
        CustomerAccount account = new CustomerAccount();
        account.setAccountNumber(accountNumber);

        when(customerAccountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(account));

        Optional<CustomerAccount> foundAccount = customerAccountService.getAccountByNumber(accountNumber);

        assertTrue(foundAccount.isPresent());
        assertEquals(accountNumber, foundAccount.get().getAccountNumber());
    }

    @Test
    public void testGetAccountByNumber_NotFound() {
        String accountNumber = "1234567890";

        when(customerAccountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.empty());

        Optional<CustomerAccount> foundAccount = customerAccountService.getAccountByNumber(accountNumber);

        assertFalse(foundAccount.isPresent());
    }
}