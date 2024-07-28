package com.example.mbanking_jalil.service.impl;

import com.example.mbanking_jalil.dto.bankAccounts.request.CreateBankAccountRequestDto;
import com.example.mbanking_jalil.dto.bankAccounts.request.GetBankAccountRequestDto;
import com.example.mbanking_jalil.model.entity.BankAccounts;
import com.example.mbanking_jalil.repository.BankAccountRepository;
import com.example.mbanking_jalil.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public BankAccounts create(CreateBankAccountRequestDto createBankAccountRequestDto) {
        BankAccounts bankAccounts = new BankAccounts();
        bankAccounts.setBanks(createBankAccountRequestDto.getBank());
        bankAccounts.setAccountName(createBankAccountRequestDto.getAccountName());
        bankAccounts.setAccountNumber(createBankAccountRequestDto.getAccountNumber());
        bankAccounts.setAmount(createBankAccountRequestDto.getAmount());
        bankAccountRepository.save(bankAccounts);
        return bankAccounts;
    }

    @Override
    public BankAccounts getByAccountNumber(GetBankAccountRequestDto getBankAccountRequestDto) {
        BankAccounts bankAccounts = bankAccountRepository.findByAccountNumber(getBankAccountRequestDto.getAccountNumber()).get();
        return bankAccounts;
    }

    @Override
    public BankAccounts getAccountById(UUID accountId) {
        BankAccounts bankAccounts = bankAccountRepository.findById(accountId).get();
        return bankAccounts;
    }
}
