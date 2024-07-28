package com.example.mbanking_jalil.service.impl;

import com.example.mbanking_jalil.dto.transaction.request.TfSesamaBankRequestDto;
import com.example.mbanking_jalil.model.entity.BankAccounts;
import com.example.mbanking_jalil.model.entity.Transactions;
import com.example.mbanking_jalil.model.enums.TransactionsType;
import com.example.mbanking_jalil.repository.BankAccountRepository;
import com.example.mbanking_jalil.repository.BankRepository;
import com.example.mbanking_jalil.repository.TransactionRepository;
import com.example.mbanking_jalil.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public Transactions transferSesamaBank(TfSesamaBankRequestDto tfSesamaBankRequestDto) {
        Transactions transaction = new Transactions();
        transaction.setBankAccounts(tfSesamaBankRequestDto.getFromBankAccountId());
        transaction.setType(TransactionsType.SESAMA_BANK);
        transaction.setToAccountNumber(tfSesamaBankRequestDto.getToAccountNumber());
        transaction.setBanks(tfSesamaBankRequestDto.getToBankId());
        transaction.setAmountTransfer(tfSesamaBankRequestDto.getAmountTransfer());
        transaction.setNotes(tfSesamaBankRequestDto.getNotes());
        transactionRepository.save(transaction);

        if (tfSesamaBankRequestDto.getAmountTransfer() > 0){
            BankAccounts sender = bankAccountRepository.findById
                    (tfSesamaBankRequestDto.getFromBankAccountId().getBankAccountsId()).get();
            sender.setAmount(sender.getAmount() - tfSesamaBankRequestDto.getAmountTransfer());
            bankAccountRepository.save(sender);

            BankAccounts receiver = bankAccountRepository.findByAccountNumber
                    (tfSesamaBankRequestDto.getToAccountNumber()).get();
            receiver.setAmount(receiver.getAmount() + tfSesamaBankRequestDto.getAmountTransfer());
            bankAccountRepository.save(receiver);
        }
        return transaction;
    }
}
