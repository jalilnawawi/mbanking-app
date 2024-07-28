package com.example.mbanking_jalil.controller;

import com.example.mbanking_jalil.dto.bank.CreateBankRequestDto;
import com.example.mbanking_jalil.model.entity.Banks;
import com.example.mbanking_jalil.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("bank")
public class BankController {
    @Autowired
    BankService bankService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CreateBankRequestDto createBankRequestDto){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");
        Banks bank = bankService.create(createBankRequestDto);
        response.put("data", bank);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
