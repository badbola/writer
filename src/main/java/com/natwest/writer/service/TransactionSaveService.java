package com.natwest.writer.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natwest.writer.entity.Transaction;
import com.natwest.writer.repository.TransactionRepository;
import com.natwest.writer.request.TransactionCreateRequest;
import com.natwest.writer.request.TransactionSaveCreateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;

/**
 * @author Divyanshu Singh on 26-03-2022
 */
@Service("transactionSaveService")
@RequiredArgsConstructor
public class TransactionSaveService {

    private final ModelMapper modelMapper;
    private final TransactionRepository transactionRepository;

    public String saveEncryptedTransaction(TransactionSaveCreateRequest request){

        byte[] decodedByte = Base64.getDecoder().decode(request.getEncryptedRequest());

        String decodedString = new String(decodedByte);

        TransactionCreateRequest transactionCreateRequest = new Gson().fromJson(decodedString,TransactionCreateRequest.class);

        Transaction transaction = modelMapper.map(transactionCreateRequest,Transaction.class);

        transactionRepository.save(transaction);

        return "Transaction Created Successfully";
    }
}
