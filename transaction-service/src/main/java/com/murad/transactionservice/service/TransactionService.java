package com.murad.transactionservice.service;

import com.murad.transactionservice.client.AccountClient;
import com.murad.transactionservice.model.CustomerAccount;
import com.murad.transactionservice.model.Transaction;
import com.murad.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountClient accountClient;

    public Transaction createTransaction(String senderAccountNumber, String recipientAccountNumber, Double amount) {
        CustomerAccount sender = accountClient.getAccountByNumber(senderAccountNumber);
        CustomerAccount recipient = accountClient.getAccountByNumber(recipientAccountNumber);

        if (!"Active".equals(sender.getAccountStatus()) || !"Active".equals(recipient.getAccountStatus())) {
            throw new RuntimeException("Both accounts must be active for the transfer");
        }

        if (sender.getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        sender.setBalance(sender.getBalance().subtract(BigDecimal.valueOf(amount)));
        recipient.setBalance(recipient.getBalance().add(BigDecimal.valueOf(amount)));

        accountClient.updateAccount(sender);
        accountClient.updateAccount(recipient);

        Transaction transaction = new Transaction();
        transaction.setSenderAccountNumber(senderAccountNumber);
        transaction.setRecipientAccountNumber(recipientAccountNumber);
        transaction.setAmount(BigDecimal.valueOf(amount));
        transaction.setTransactionDate(new Date());
        return transactionRepository.save(transaction);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}