package com.jun.accountmanager.account.ui;

import com.jun.accountmanager.account.application.AccountDepositService;
import com.jun.accountmanager.account.dto.AccountDepositResponse;
import com.jun.accountmanager.account.dto.TotalDepositResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 예치금 관련 API
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class DepositController {

    private final AccountDepositService accountDepositService;

    @GetMapping("/deposit/member")
    public ResponseEntity<List<AccountDepositResponse>> getDepositByUser(@PathVariable long id) {
        List<AccountDepositResponse> depositByUser = accountDepositService.getDepositByUser(id);
        return ResponseEntity.ok().body(depositByUser);
    }

    @GetMapping("/deposit")
    public ResponseEntity<TotalDepositResponse> getYearTotalDeposit(@RequestParam int year) {
        TotalDepositResponse totalDepositByYear = accountDepositService.getTotalDepositByYear(year);
        return ResponseEntity.ok().body(totalDepositByYear);
    }

}
