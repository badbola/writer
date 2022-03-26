package com.natwest.writer.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Divyanshu Singh on 26-03-2022
 */

@Data
public class TransactionCreateRequest {

    private String accountNumber;

    private String type;

    private BigDecimal amount;

    private String currency;

    private String accountForm;
}
