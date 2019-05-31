package com.so4it.dao;

import com.so4it.AccountService;
import com.so4it.AccountServiceImpl;
import com.so4it.domain.AccountBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDaoImplTest {

    @Test
    public void testCreateAndAccount() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.createAccount(new AccountBuilder().withtId(1001L).getAccount());
        assertNotNull(accountDao.read(1001L));
    }

    @Test
    public void testBalanceAndInterset(){
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.createAccount(new AccountBuilder().withtId(10101L).withBalance(999d).withAnnualInterestRate(15d).getAccount());
        AccountService accountService = new AccountServiceImpl(accountDao);
        assertEquals(Double.valueOf(999),accountService.getBalance(10101L));
        assertEquals(Double.valueOf(15/12d),accountService.getMonthlyInterest(10101L));
    }


}