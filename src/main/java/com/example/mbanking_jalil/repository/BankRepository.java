package com.example.mbanking_jalil.repository;

import com.example.mbanking_jalil.model.entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<Banks, UUID> {
}
