package com.example.mbanking_jalil.service;

import com.example.mbanking_jalil.dto.bank.CreateBankRequestDto;
import com.example.mbanking_jalil.model.entity.Banks;

public interface BankService {
    Banks create(CreateBankRequestDto createBankRequestDto);
}
