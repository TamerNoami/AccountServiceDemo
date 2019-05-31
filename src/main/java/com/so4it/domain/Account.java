package com.so4it.domain;

public class Account {

    private Long id;
    private String owner;
    private Double balance;
    private Double annualInterestRate;

    public Account(Long id, String owner, Double balance, Double annualInterestRate) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }


    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Double getMonthlyInterestRate() {
        return annualInterestRate/12;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                '}';
    }
}
