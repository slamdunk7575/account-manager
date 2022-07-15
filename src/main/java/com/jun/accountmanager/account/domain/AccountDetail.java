package com.jun.accountmanager.account.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("입출금여부 Y:입금, N:출금")
    private String status;

    @Comment("계좌번호")
    @Column(nullable = false)
    private String accountNumber;

    @Comment("금액")
    private BigDecimal tradeAmount;

    @Comment("입출금날짜")
    private LocalDateTime tradeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Builder
    public AccountDetail(String status, BigDecimal tradeAmount,
                         LocalDateTime tradeDate, String accountNumber) {
        this.status = status;
        this.tradeAmount = tradeAmount;
        this.tradeDate = tradeDate;
        this.accountNumber = accountNumber;
    }
}
