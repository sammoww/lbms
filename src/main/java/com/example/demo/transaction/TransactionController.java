package com.example.demo.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService
        ;
    }

    @PostMapping("/saveRecord")
    public ResponseEntity<Transaction> addAccount(@RequestBody Transaction transaction){
        System.out.println("controller called");
        return new ResponseEntity<>(transactionService.addRecord(transaction), HttpStatus.OK);
    }

    @GetMapping("/getHistory/{id}")
    public Transaction readRecord(@PathVariable Integer id){
        return transactionService.readRecord(id);
    }

    @DeleteMapping("/deleteRecord/{id}")
    public void deleteRecord(@PathVariable Integer id){
        transactionService.deleteRecord(id);
    }

    @PutMapping("/updateRecord/{id}")
    public Transaction updateRecord(@PathVariable Integer id, @RequestBody Transaction transaction){
        return transactionService.updateRecord(id,transaction);
    }

    @GetMapping("/getTransactions")
    public List<Transaction> getTransactions(){
        return transactionService.getAllRecords();
    }
}
