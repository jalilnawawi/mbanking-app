package com.example.mbanking_jalil.repository;

import com.example.mbanking_jalil.model.entity.BankAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccounts, UUID> {
//    @Query(value = "select id_user , account_name , account_number , amount  from bank_accounts ba where account_number = ?", nativeQuery = true)
    Optional<BankAccounts> findByAccountNumber(String accountNumber);
}
