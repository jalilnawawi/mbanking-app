package com.example.mbanking_jalil.dto.bankAccounts.response;

import lombok.Data;

import java.util.UUID;

@Data
public class GetBankAccountResponseDto {
    UUID bankAccountId;
    String accountName;
    String accountNumber;
    Double amount;

    public GetBankAccountResponseDto(UUID bankAccountId, String accountName, String accountNumber, Double amount) {
        this.bankAccountId = bankAccountId;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}
