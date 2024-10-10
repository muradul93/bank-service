package com.murad.transactionservice.client;

import com.murad.transactionservice.model.CustomerAccount;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PutExchange;


public interface AccountClient {
    @GetExchange("/accounts/{accountNumber}")
    CustomerAccount getAccountByNumber(@PathVariable String accountNumber);

    @PutExchange("/accounts")
    void updateAccount(CustomerAccount account);
}