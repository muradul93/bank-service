package com.murad.transactionservice.service;

import static org.junit.jupiter.api.Assertions.*;

import com.murad.transactionservice.model.Transaction;
import com.murad.transactionservice.repository.TransactionRepository;
import com.murad.transactionservice.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testCreateTransaction() {
        Transaction transaction = transactionService.createTransaction("1234567890", "2345678901", 100.00);
        assertNotNull(transaction);
        assertEquals("1234567890", transaction.getSenderAccountNumber());
        assertEquals("2345678901", transaction.getRecipientAccountNumber());
        assertEquals(100.00, transaction.getAmount());
    }

    @Test
    public void testGetTransactionById() {
        Transaction transaction = transactionService.createTransaction("1234567890", "2345678901", 100.00);
        Transaction foundTransaction = transactionService.getTransactionById(transaction.getId());
        assertNotNull(foundTransaction);
        assertEquals(transaction.getId(), foundTransaction.getId());
    }

    @Test
    public void testGetAllTransactions() {
        transactionService.createTransaction("1234567890", "2345678901", 100.00);
        transactionService.createTransaction("2345678901", "3456789012", 200.00);
        List<Transaction> transactions = transactionService.getAllTransactions();
        assertEquals(2, transactions.size());
    }
}