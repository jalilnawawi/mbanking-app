package com.example.mbanking_jalil.dto.qrCode;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateQRCodeRequestDto {
    private UUID userId;
    private String senderAccountNum;
    private String recipientAccountNum;
    private String bankCode;
    private Double nominal;
}
