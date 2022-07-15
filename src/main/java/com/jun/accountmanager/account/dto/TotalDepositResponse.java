package com.jun.accountmanager.account.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class TotalDepositResponse {

    private BigDecimal totalAmount;

    public TotalDepositResponse() {
    }

    public TotalDepositResponse(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
