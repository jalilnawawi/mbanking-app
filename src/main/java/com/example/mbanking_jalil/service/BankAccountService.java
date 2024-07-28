package com.example.mbanking_jalil.service;

import com.example.mbanking_jalil.dto.bankAccounts.request.CreateBankAccountRequestDto;
import com.example.mbanking_jalil.dto.bankAccounts.request.GetBankAccountRequestDto;
import com.example.mbanking_jalil.model.entity.BankAccounts;

import java.util.UUID;

public interface BankAccountService {
    BankAccounts create(CreateBankAccountRequestDto createBankAccountRequestDto);
    BankAccounts getByAccountNumber(GetBankAccountRequestDto getBankAccountRequestDto);
    BankAccounts getAccountById(UUID accountId);
}
