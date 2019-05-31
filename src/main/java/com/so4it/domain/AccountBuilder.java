package com.so4it.domain;

public class AccountBuilder {

    private Long id;
    private String owner;
    private Double balance;
    private Double annualInterestRate;

    public AccountBuilder withtId(Long id) {
        this.id = id;
        return this;
    }

    public AccountBuilder withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public AccountBuilder withBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public AccountBuilder withAnnualInterestRate(Double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
        return this;
    }

    public Account getAccount(){
        return new Account(id,owner,balance,annualInterestRate);
    }
}
