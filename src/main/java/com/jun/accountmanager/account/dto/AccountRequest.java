package com.jun.accountmanager.account.dto;

import com.jun.accountmanager.account.domain.Account;
import com.jun.accountmanager.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountRequest {

    @NotBlank
    private Long memberId;

    @NotBlank
    @Size(min = 5)
    private String accountNumber;

    public AccountRequest(Long memberId, String accountNumber) {
        this.memberId = memberId;
        this.accountNumber = accountNumber;
    }

    public Account toAccount(Member member) {
        return Account.builder()
                .member(member)
                .number(accountNumber)
                .build();
    }
}
