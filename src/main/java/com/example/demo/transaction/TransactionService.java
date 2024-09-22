package com.example.demo.transaction;

import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    Transaction addRecord(Transaction transaction);
    Transaction readRecord(int id);
    Transaction updateRecord(int id, Transaction transaction);
    void deleteRecord(int id);
}
