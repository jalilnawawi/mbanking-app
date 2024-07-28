package com.example.mbanking_jalil.controller;

import com.example.mbanking_jalil.dto.bankAccounts.request.CreateBankAccountRequestDto;
import com.example.mbanking_jalil.dto.bankAccounts.request.GetBankAccountRequestDto;
import com.example.mbanking_jalil.dto.bankAccounts.response.GetBankAccountResponseDto;
import com.example.mbanking_jalil.model.entity.BankAccounts;
import com.example.mbanking_jalil.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("bank-account")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CreateBankAccountRequestDto createBankAccountRequestDto){
        BankAccounts bankAccounts = bankAccountService.create(createBankAccountRequestDto);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");
        response.put("data", bankAccounts);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/no-rekening")
    public ResponseEntity<Map<String, Object>> getAccount(@RequestBody GetBankAccountRequestDto getBankAccountRequestDto){
        BankAccounts getAccount = bankAccountService.getByAccountNumber(getBankAccountRequestDto);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");

        Map<String, Object> data = new HashMap<>();
        GetBankAccountResponseDto getBankAccountResponseDto = new GetBankAccountResponseDto(
                getAccount.getBankAccountsId(), getAccount.getAccountName(),
                getAccount.getAccountNumber(), getAccount.getAmount()
        );
        data.put("Bank Account Details", getBankAccountResponseDto);
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BankAccounts> getAccountbyId(@PathVariable("id") UUID accountId){
        return new ResponseEntity<>(bankAccountService.getAccountById(accountId), HttpStatus.OK);
    }
}
