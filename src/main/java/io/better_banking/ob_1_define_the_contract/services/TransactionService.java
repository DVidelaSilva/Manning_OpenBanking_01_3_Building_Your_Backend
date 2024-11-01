package io.better_banking.ob_1_define_the_contract.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.better_banking.ob_1_define_the_contract.entity.Transaction;
import io.better_banking.ob_1_define_the_contract.repositories.TransactionRepository;



@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    // Constructor
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    
    public List<Transaction> findByAccountNumber(String accountNumber){
        return transactionRepository.findByAccountNumber(accountNumber);
    }   

    

}
