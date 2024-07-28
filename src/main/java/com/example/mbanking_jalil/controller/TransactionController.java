package com.example.mbanking_jalil.controller;

import com.example.mbanking_jalil.dto.transaction.request.TfSesamaBankRequestDto;
import com.example.mbanking_jalil.dto.transaction.response.TfSesamaBankResponseDto;
import com.example.mbanking_jalil.model.entity.BankAccounts;
import com.example.mbanking_jalil.model.entity.Transactions;
import com.example.mbanking_jalil.repository.BankAccountRepository;
import com.example.mbanking_jalil.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @PostMapping("tf-sesama-bank")
    public ResponseEntity<Map<String, Object>> tfSesamaBank(@RequestBody TfSesamaBankRequestDto tfSesamaBankRequestDto){
        Transactions tfSesamaBank = transactionService.transferSesamaBank(tfSesamaBankRequestDto);
        BankAccounts sender = bankAccountRepository.findById(tfSesamaBankRequestDto.getFromBankAccountId().getBankAccountsId()).get();
        BankAccounts receiver = bankAccountRepository.findByAccountNumber(tfSesamaBank.getToAccountNumber()).get();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "transfer success");

        Map<String, Object> data = new HashMap<>();
        TfSesamaBankResponseDto tfSesamaBankResponseDto = new TfSesamaBankResponseDto(
                sender.getAccountName(), receiver.getAccountName(), tfSesamaBank.getAmountTransfer(),
                sender.getAmount(), tfSesamaBankRequestDto.getNotes()
        );
        data.put("Transfer Details", tfSesamaBankResponseDto);
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
