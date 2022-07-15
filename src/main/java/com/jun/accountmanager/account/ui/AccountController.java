package com.jun.accountmanager.account.ui;

import com.jun.accountmanager.account.application.AccountService;
import com.jun.accountmanager.account.dto.AccountDetailRequest;
import com.jun.accountmanager.account.dto.AccountDetailResponse;
import com.jun.accountmanager.account.dto.AccountRequest;
import com.jun.accountmanager.account.dto.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/account")
    public ResponseEntity<AccountResponse> addAccount(@RequestBody @Valid AccountRequest accountRequest) {
        AccountResponse accountResponse = accountService.addAccount(accountRequest);
        return ResponseEntity.created(URI.create("/account/" + accountResponse.getId())).build();
    }

    @GetMapping("/account/list")
    public ResponseEntity<List<AccountResponse>> getAccounts() {
        List<AccountResponse> accounts = accountService.getAccounts();
        return ResponseEntity.ok().body(accounts);
    }

    @PostMapping("/account/detail")
    public ResponseEntity<AccountDetailResponse> addAccountDetail(@RequestBody AccountDetailRequest accountDetailRequest) {
        AccountDetailResponse accountDetailResponse = accountService.addAccountDetail(accountDetailRequest);
        return ResponseEntity.created(URI.create("/account/detail" + accountDetailResponse.getId())).build();
    }

    @GetMapping("/account/detail/list")
    public ResponseEntity<List<AccountDetailResponse>> getAccountDetails() {
        List<AccountDetailResponse> accountDetails = accountService.getAccountDetails();
        return ResponseEntity.ok().body(accountDetails);
    }

}
