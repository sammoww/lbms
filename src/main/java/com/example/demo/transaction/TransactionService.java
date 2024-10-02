package com.example.demo.transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    Transaction addRecord(Transaction transaction);
    Transaction readRecord(int id);
    Transaction updateRecord(int id, Transaction transaction);
    void deleteRecord(int id);
    List<Transaction> getAllRecords();
}
