package com.jun.accountmanager.account.dto;

import com.jun.accountmanager.account.domain.AccountDetail;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountDetailResponse {

    private long id;
    private String status;
    private String accountNumber;
    private BigDecimal tradeAmount;
    private LocalDateTime tradeDate;

    @Builder
    public AccountDetailResponse(long id, String status, BigDecimal tradeAmount,
                                 LocalDateTime tradeDate, String accountNumber) {
        this.id = id;
        this.status = status;
        this.accountNumber = accountNumber;
        this.tradeAmount = tradeAmount;
        this.tradeDate = tradeDate;
    }

    public static AccountDetailResponse of(AccountDetail accountDetail) {
        return AccountDetailResponse.builder()
                .id(accountDetail.getId())
                .status(accountDetail.getStatus())
                .accountNumber(accountDetail.getAccountNumber())
                .tradeAmount(accountDetail.getTradeAmount())
                .tradeDate(accountDetail.getTradeDate())
                .build();
    }
}
