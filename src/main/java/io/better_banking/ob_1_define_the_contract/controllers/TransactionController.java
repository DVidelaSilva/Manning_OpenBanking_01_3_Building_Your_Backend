package io.better_banking.ob_1_define_the_contract.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.better_banking.ob_1_define_the_contract.dto.TransactionDto;
import io.better_banking.ob_1_define_the_contract.entity.Transaction;
import io.better_banking.ob_1_define_the_contract.services.TransactionService;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions/{accountNumber}")
    public List<TransactionDto> getTransactionsByAccountNumber(@PathVariable String accountNumber){
        List<Transaction> transactions = transactionService.findByAccountNumber(accountNumber);
        return transactions.stream()
            .map(transaction -> new TransactionDto(
                transaction.getType(),
                transaction.getDate(),
                transaction.getAccountNumber(),
                transaction.getCurrency(),
                transaction.getAmount(),
                transaction.getMerchantName(),
                transaction.getMerchantLogo()
            ))
            .collect(Collectors.toList());
    }

}
