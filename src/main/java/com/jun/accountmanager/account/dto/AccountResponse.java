package com.jun.accountmanager.account.dto;

import com.jun.accountmanager.account.domain.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResponse {
    private long id;
    private long memberId;
    private String accountNumber;

    private AccountResponse(long id, long memberId, String accountNumber) {
        this.id = id;
        this.memberId = memberId;
        this.accountNumber = accountNumber;
    }

    public static AccountResponse of(Account account) {
        return new AccountResponse(account.getId(), account.getMemberId(), account.getNumber());
    }
}
