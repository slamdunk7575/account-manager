package com.jun.accountmanager.account.dto;

import com.jun.accountmanager.account.domain.AccountDetail;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountDetailRequest {

    // 입출금여부
    private String status;
    // 거래금액
    private String accountNumber;
    private BigDecimal tradeAmount;
    // 거래날짜
    private LocalDateTime tradeDate;
    // 계좌번호

    @Builder
    public AccountDetailRequest(String status, BigDecimal tradeAmount,
                                LocalDateTime tradeDate, String accountNumber) {
        this.status = status;
        this.tradeAmount = tradeAmount;
        this.tradeDate = tradeDate;
        this.accountNumber = accountNumber;
    }

    public AccountDetail toEntity() {
        return AccountDetail.builder()
                .status(this.status)
                .tradeAmount(this.tradeAmount)
                .tradeDate(this.tradeDate)
                .accountNumber(this.accountNumber)
                .build();
    }

}
