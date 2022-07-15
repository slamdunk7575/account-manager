package com.jun.accountmanager.account.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountDepositResponse {
    // 계좌번호
    private String accountNumber;

    // 잔고
    private BigDecimal balance;

    public AccountDepositResponse(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
