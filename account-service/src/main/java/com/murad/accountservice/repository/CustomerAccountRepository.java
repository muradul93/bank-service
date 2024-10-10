package com.murad.accountservice.repository;

import com.murad.accountservice.model.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
    Optional<CustomerAccount> findByAccountNumber(String accountNumber);
}