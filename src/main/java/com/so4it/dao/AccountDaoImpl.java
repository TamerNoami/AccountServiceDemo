package com.so4it.dao;

import com.so4it.domain.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountDaoImpl implements AccountDao<Account> {

    private Map<Long,Account> accounts = new HashMap<>();

    public void createAccount(Account account) {
        if(accounts.containsKey(account.getId())){
            throw new RuntimeException("Account Id already exist");
        }

        accounts.put(account.getId(),account);
    }

    @Override
    public Optional<Account> read(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    @Override
    public Map<Long, Account> realAll() {
        return accounts;
    }

    @Override
    public void deleteAccount(Long id) {
        accounts.remove(id);
    }

    @Override
    public Collection<Account> getAccountWithHighBalance(Double limit) {
        return accounts.values().stream()
                .filter(account -> account.getBalance() >= limit)
                .collect(Collectors.toSet());
    }


}
