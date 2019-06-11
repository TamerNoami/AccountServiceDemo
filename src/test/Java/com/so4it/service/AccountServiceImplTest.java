package com.so4it.service;

import com.so4it.dao.AccountDao;
import com.so4it.dao.AccountDaoImpl;
import com.so4it.domain.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountServiceImplTest {

    @Test
    public void testBalanceAndInterset(){
        AccountDao accountDao = new AccountDaoImpl();
        Account account = Account.builder().withId(10101L).withBalance(1000d).withAnnualInterestRate(0.15d).build();
        accountDao.createAccount(account);
        AccountService accountService = new AccountServiceImpl(accountDao);
        assertEquals(Double.valueOf(1000d),accountService.getBalance(10101L));
        assertEquals(Double.valueOf(1000d*account.getMonthlyInterestRate()),accountService.getMonthlyInterest(10101L));
    }
}