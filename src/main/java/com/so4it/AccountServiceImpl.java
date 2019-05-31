package com.so4it;

import com.so4it.dao.AccountDao;
import com.so4it.domain.Account;

import java.util.Objects;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = Objects.requireNonNull(accountDao,"accountDao can't be null");
    }


    public Double getBalance(Long id) {
        Optional<Account> account = accountDao.read(id);
        return account.get().getBalance();
    }

    public Double getMonthlyInterest(Long id) {
        Optional<Account> account = accountDao.read(id);
        return account.get().getMonthlyInterestRate();
    }
}
