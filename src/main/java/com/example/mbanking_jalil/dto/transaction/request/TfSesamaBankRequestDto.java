package com.example.mbanking_jalil.dto.transaction.request;

import com.example.mbanking_jalil.model.entity.BankAccounts;
import com.example.mbanking_jalil.model.entity.Banks;
import com.example.mbanking_jalil.model.enums.TransactionsType;
import lombok.Data;

@Data
public class TfSesamaBankRequestDto {
    private BankAccounts fromBankAccountId;
    private TransactionsType type;
    private String toAccountNumber;
    private Banks toBankId;
    private Double amountTransfer;
    private String notes;
}
