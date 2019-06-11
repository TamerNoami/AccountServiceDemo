package com.so4it.dao;

import com.so4it.domain.Account;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface AccountDao<T> {
    void createAccount(T t);
    Optional<T> read(Long id);
    Map<Long,T> realAll();
    void deleteAccount(Long id);
    Collection<T> getAccountWithHighBalance(Double limit);

}
