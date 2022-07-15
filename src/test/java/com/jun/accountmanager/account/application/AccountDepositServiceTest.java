package com.jun.accountmanager.account.application;

import com.jun.accountmanager.account.dto.AccountDepositResponse;
import com.jun.accountmanager.account.dto.TotalDepositResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountDepositServiceTest {

    @Autowired
    private AccountDepositService accountDepositService;

    @DisplayName("사용자를 입력받아 사용자의 계좌별 예치금을 확인할 수 있다.")
    @Test
    void getDepositByUser() {
        // given
        long memberId = 11L;

        // when
        List<AccountDepositResponse> balanceByAccountNumber = accountDepositService.getDepositByUser(memberId);

        // then
        assertThat(balanceByAccountNumber.size()).isEqualTo(3);
        assertThat(balanceByAccountNumber.get(0).getAccountNumber()).isEqualTo("1000-01");
        assertThat(balanceByAccountNumber.get(0).getBalance().intValue()).isEqualTo(3244500);
    }

    @DisplayName("년도를 입력받아 해당 년도의 예치금 총액을 구할 수 있다.")
    @Test
    void getTotalDepositByYear() {
        // given
        int year = 2020;

        // when
        TotalDepositResponse totalDepositByYear = accountDepositService.getTotalDepositByYear(year);

        // then
        assertThat(totalDepositByYear.getTotalAmount().intValue()).isEqualTo(145748500);
    }

}
