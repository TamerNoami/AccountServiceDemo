package com.so4it.domain;

import com.so4it.dao.AccountDao;
import com.so4it.dao.AccountDaoImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account account;

    @Before
    public void setUp() throws Exception {
        account = Account.builder().withId(10101L).withOwner("Tamer Alnoami").withBalance(50000d).withAnnualInterestRate(0.12d).build();

    }

    @Test
    public void getId() {
        assertEquals(Long.valueOf(10101),account.getId());
    }

    @Test
    public void getOwner() {
        assertEquals("Tamer Alnoami",account.getOwner());
    }

    @Test
    public void getBalance() {
        assertEquals(Double.valueOf(50000),account.getBalance());
    }

    @Test
    public void getAnnualInterestRate() {
        assertEquals(Double.valueOf(0.12),account.getAnnualInterestRate());
    }

    @Test
    public void getMonthlyInterestRate() {
        assertEquals(Double.valueOf(0.01),account.getMonthlyInterestRate());
    }

    @Test
    public void addMonthlyInterest() {
        account.addMonthlyInterest();
        assertEquals(Double.valueOf(50500),account.getBalance());
    }
}