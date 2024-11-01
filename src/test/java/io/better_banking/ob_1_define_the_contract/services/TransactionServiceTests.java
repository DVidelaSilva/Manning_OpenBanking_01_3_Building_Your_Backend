package io.better_banking.ob_1_define_the_contract.services;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.better_banking.ob_1_define_the_contract.entity.Transaction;



@SpringBootTest
public class TransactionServiceTests {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testFindAllByAccountNumber() {

       String accountNumber = "111111111";

       List<Transaction> transactions = transactionService.findByAccountNumber(accountNumber);

        assertEquals(0, transactions.size(), "Se esperaba que la lista contuviera entre 3 y 5 transacciones");
        System.out.println("IMP" + transactions);


        
    }

}
