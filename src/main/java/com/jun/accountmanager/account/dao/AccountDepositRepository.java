package com.jun.accountmanager.account.dao;

import com.jun.accountmanager.account.dto.AccountDepositResponse;
import com.jun.accountmanager.account.dto.TotalDepositResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jun.accountmanager.account.domain.QAccount.account;
import static com.jun.accountmanager.account.domain.QAccountDetail.accountDetail;

@Repository
public class AccountDepositRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public AccountDepositRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<AccountDepositResponse> getDepositByUser(long memberId) {
        return jpaQueryFactory
                .from(account)
                .leftJoin(account.accountDetails, accountDetail)
                .where(account.member.id.eq(memberId))
                .groupBy(account.number)
                .select(Projections.bean(
                        AccountDepositResponse.class,
                        account.number.as("accountNumber"),
                        accountDetail.tradeAmount.sum().as("balance")
                ))
                .fetch();
    }


    public TotalDepositResponse getTotalDepositByYear(int year) {
        return jpaQueryFactory.from(accountDetail)
                .where(accountDetail.tradeDate.year().eq(year))
                .groupBy(accountDetail.tradeDate.year())
                .select(Projections.bean(
                        TotalDepositResponse.class,
                        accountDetail.tradeAmount.sum().as("totalAmount")
                ))
                .fetchOne();
    }

}
