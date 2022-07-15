package com.jun.accountmanager.account.application;

import com.jun.accountmanager.account.dao.AccountDetailRepository;
import com.jun.accountmanager.account.dao.AccountRepository;
import com.jun.accountmanager.account.dto.AccountDetailRequest;
import com.jun.accountmanager.account.dto.AccountDetailResponse;
import com.jun.accountmanager.account.dto.AccountRequest;
import com.jun.accountmanager.account.dto.AccountResponse;
import com.jun.accountmanager.member.dao.MemberRepository;
import com.jun.accountmanager.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;
    private final MemberRepository memberRepository;
    private final AccountDetailRepository accountDetailRepository;

    public AccountResponse addAccount(AccountRequest accountRequest) {
        Member member = memberRepository.findById(accountRequest.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
        return AccountResponse.of(accountRepository.save(accountRequest.toAccount(member)));
    }

    @Transactional(readOnly = true)
    public List<AccountResponse> getAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(AccountResponse::of)
                .collect(Collectors.toList());
    }

    public AccountDetailResponse addAccountDetail(AccountDetailRequest accountDetailRequest) {
        return AccountDetailResponse.of(accountDetailRepository.save(accountDetailRequest.toEntity()));
    }

    @Transactional(readOnly = true)
    public List<AccountDetailResponse> getAccountDetails() {
        return accountDetailRepository.findAll()
                .stream()
                .map(AccountDetailResponse::of)
                .collect(Collectors.toList());
    }

}
