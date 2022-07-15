package com.jun.accountmanager.account.dao;

import com.jun.accountmanager.account.domain.AccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail, Long> {
}
