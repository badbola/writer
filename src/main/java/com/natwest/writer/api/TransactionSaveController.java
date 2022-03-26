package com.natwest.writer.api;

import com.natwest.writer.request.TransactionSaveCreateRequest;
import com.natwest.writer.service.TransactionSaveService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Divyanshu Singh on 26-03-2022
 */
@Api(tags = "Transaction Save Controller")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/saveTransaction")
public class TransactionSaveController {

    private final TransactionSaveService transactionSaveService;


    @PostMapping
    public ResponseEntity<String> saveEncryptedTransaction(@RequestBody @Validated TransactionSaveCreateRequest request){

       return ResponseEntity.ok(transactionSaveService.saveEncryptedTransaction(request));
    }
}
