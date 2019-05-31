package com.so4it.dao;

import com.so4it.domain.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {

    private Map<Long,Account> accounts = new HashMap<>();

    public void createAccount(Account account) {
        accounts.put(account.getId(),account);
    }

    @Override
    public Optional<Account> read(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }
}
