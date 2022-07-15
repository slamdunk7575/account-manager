package com.jun.accountmanager.account.application;

import com.jun.accountmanager.account.dao.AccountDepositRepository;
import com.jun.accountmanager.account.dto.AccountDepositResponse;
import com.jun.accountmanager.account.dto.TotalDepositResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 예치금 관련 서비스
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountDepositService {
    private final AccountDepositRepository accountDepositRepository;

    public List<AccountDepositResponse> getDepositByUser(long memberId) {
        return accountDepositRepository.getDepositByUser(memberId);
    }

    public TotalDepositResponse getTotalDepositByYear(int year) {
        return accountDepositRepository.getTotalDepositByYear(year);
    }

}
