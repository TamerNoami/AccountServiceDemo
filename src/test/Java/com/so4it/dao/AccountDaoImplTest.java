package com.so4it.dao;

import com.so4it.domain.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDaoImplTest {

    @Test
    public void testCreateAccount() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.createAccount(Account.builder().withId(1001L).build());
        assertNotNull(accountDao.read(1001L));
    }


    @Test
    public void testReadAndDelete(){
        AccountDao accountDao = new AccountDaoImpl();
        Account account = Account.builder().withId(10101L).build();
        accountDao.createAccount(account);
        assertEquals(1,accountDao.realAll().size());
        Account otherAccount = Account.builder().withId(10102L).build();
        accountDao.createAccount(otherAccount);
        assertEquals(2,accountDao.realAll().size());
        accountDao.deleteAccount(10101L);
        assertEquals(1,accountDao.realAll().size());

    }

    @Test
    public void testReadAll() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.createAccount(Account.builder().withId(1001L).withBalance(10000d).build());
        accountDao.createAccount(Account.builder().withId(1002L).withBalance(11000d).build());
        accountDao.createAccount(Account.builder().withId(1003L).withBalance(19000d).build());
        accountDao.createAccount(Account.builder().withId(1004L).withBalance(9000d).build());
        assertEquals(4, accountDao.realAll().size());
    }


    @Test
    public void testgetAccountWithHighBalance() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.createAccount(Account.builder().withId(1001L).withBalance(10000d).build());
        accountDao.createAccount(Account.builder().withId(1002L).withBalance(11000d).build());
        accountDao.createAccount(Account.builder().withId(1003L).withBalance(19000d).build());
        accountDao.createAccount(Account.builder().withId(1004L).withBalance(9000d).build());
        assertEquals(3, accountDao.getAccountWithHighBalance(9999d).size());
    }
}