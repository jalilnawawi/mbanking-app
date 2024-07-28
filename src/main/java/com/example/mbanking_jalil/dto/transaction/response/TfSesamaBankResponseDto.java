package com.example.mbanking_jalil.dto.transaction.response;

import com.example.mbanking_jalil.model.entity.BankAccounts;
import com.example.mbanking_jalil.model.entity.Banks;
import com.example.mbanking_jalil.model.enums.TransactionsType;
import lombok.Data;

@Data
public class TfSesamaBankResponseDto {
    private String sender;
    private String receiver;
    private Double amountTransfer;
    private Double amountSenderAfterTransfer;
    private String notes;

    public TfSesamaBankResponseDto(String sender, String receiver, Double amountTransfer, Double amountSenderAfterTransfer, String notes) {
        this.sender = sender;
        this.receiver = receiver;
        this.amountTransfer = amountTransfer;
        this.amountSenderAfterTransfer = amountSenderAfterTransfer;
        this.notes = notes;
    }
}
