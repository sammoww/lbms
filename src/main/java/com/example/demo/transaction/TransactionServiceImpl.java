package com.example.demo.transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepo transactionRepo;

    TransactionServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public Transaction addRecord(Transaction transaction) {
//        Account addAcc = new Account();
//
//        = account.getBook().getId();

        return transactionRepo.save(transaction);
    }

    @Override
    public Transaction readRecord(int id) {
        return transactionRepo.findById(id).orElseThrow();
    }

    @Override
    public Transaction updateRecord(int id, Transaction transaction) {
        Transaction acc = transactionRepo.findById(id).orElseThrow();
        acc.setBook(transaction.getBook());
        acc.setUser(transaction.getUser());
        return transactionRepo.save(acc);
    }

    @Override
    public void deleteRecord(int id) {
        transactionRepo.deleteById(id);
    }

    @Override
    public List<Transaction> getAllRecords() {
        return transactionRepo.findAll();
    }


}
