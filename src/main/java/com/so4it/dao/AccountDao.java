package com.so4it.dao;

import com.so4it.domain.Account;

import java.util.Optional;

public interface AccountDao {
    void createAccount(Account account);
    Optional<Account> read(Long id);
}
