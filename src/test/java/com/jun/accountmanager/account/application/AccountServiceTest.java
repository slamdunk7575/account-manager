package com.jun.accountmanager.account.application;

import com.jun.accountmanager.account.dto.AccountDetailRequest;
import com.jun.accountmanager.account.dto.AccountDetailResponse;
import com.jun.accountmanager.account.dto.AccountRequest;
import com.jun.accountmanager.account.dto.AccountResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @DisplayName("계좌를 추가할 수 있다.")
    @Test
    void addAccount() {
        // given
        AccountRequest accountRequest = new AccountRequest(22L, "1000-75");

        // when
        AccountResponse accountResponse = accountService.addAccount(accountRequest);

        // then
        assertThat(accountResponse.getId()).isNotNull();
        assertThat(accountResponse.getAccountNumber()).isEqualTo("1000-75");
    }

    @DisplayName("계좌 목록을 조회할 수 있다.")
    @Test
    void getAccounts() {
        // given & when
        List<AccountResponse> accounts = accountService.getAccounts();

        // then
        assertThat(accounts).isNotEmpty();
    }

    @DisplayName("계좌 내역을 추가할 수 있다.")
    @Test
    void addAccountDetail() {
        // given
        AccountDetailRequest accountDetailRequest = AccountDetailRequest.builder()
                .status("Y")
                .accountNumber("1000-75")
                .tradeAmount(BigDecimal.valueOf(100_000_000L))
                .tradeDate(LocalDateTime.of(2022, 07, 12, 14, 00, 00))
                .build();

        // when
        AccountDetailResponse accountDetailResponse = accountService.addAccountDetail(accountDetailRequest);

        // then
        assertThat(accountDetailResponse.getId()).isNotNull();
        assertThat(accountDetailResponse.getAccountNumber()).isEqualTo("1000-75");
    }

    @DisplayName("계좌 내역 목록을 조회할 수 있다.")
    @Test
    void getAccountDetails() {
        // given & when
        List<AccountDetailResponse> accountDetails = accountService.getAccountDetails();

        // then
        assertThat(accountDetails).isNotEmpty();
    }
}
