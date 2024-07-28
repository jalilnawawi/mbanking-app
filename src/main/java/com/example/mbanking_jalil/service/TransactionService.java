package com.example.mbanking_jalil.service;

import com.example.mbanking_jalil.dto.transaction.request.TfSesamaBankRequestDto;
import com.example.mbanking_jalil.model.entity.Transactions;

public interface TransactionService {
    Transactions transferSesamaBank(TfSesamaBankRequestDto tfSesamaBankRequestDto);
}
