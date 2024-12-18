package com.example.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/effectuer")
    public Transaction effectuerTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @GetMapping("/historique/{numeroCompte}")
    public List<Transaction> historiqueCompte(@PathVariable String numeroCompte) {
        return transactionRepository.findAll().stream()
                .filter(t -> t.getNumeroCompte().equals(numeroCompte))
                .toList();
    }
}
