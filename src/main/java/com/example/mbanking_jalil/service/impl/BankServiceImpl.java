package com.example.mbanking_jalil.service.impl;

import com.example.mbanking_jalil.dto.bank.CreateBankRequestDto;
import com.example.mbanking_jalil.model.entity.Banks;
import com.example.mbanking_jalil.repository.BankRepository;
import com.example.mbanking_jalil.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankRepository bankRepository;

    @Override
    public Banks create(CreateBankRequestDto createBankRequestDto) {
        Banks bank = new Banks();
        bank.setBankCode(createBankRequestDto.getBankCode());
        bank.setBankName(createBankRequestDto.getBankName());
        bankRepository.save(bank);
        return bank;
    }
}
