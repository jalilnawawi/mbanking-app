package com.example.mbanking_jalil.dto.bankAccounts.request;

import com.example.mbanking_jalil.model.entity.Banks;
import lombok.Data;

@Data
public class CreateBankAccountRequestDto {
    private Banks bank;
    private String accountName;
    private String accountNumber;
    private Double amount;
}
