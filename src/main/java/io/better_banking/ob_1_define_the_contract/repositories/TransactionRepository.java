package io.better_banking.ob_1_define_the_contract.repositories;


import java.util.List;


import org.springframework.stereotype.Repository;

import io.better_banking.ob_1_define_the_contract.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountNumber(String accountNumber);
}
