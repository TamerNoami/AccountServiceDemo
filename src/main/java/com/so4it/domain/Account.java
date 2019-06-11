package com.so4it.domain;

import java.util.Objects;

public class Account {

    private Long id;
    private String owner;
    private Double balance;
    private Double annualInterestRate;

    public Account(Builder builder) {
        this.id = Objects.requireNonNull(builder.id,"Account number can't be null");
        this.owner = builder.owner;
        this.balance = builder.balance;
        this.annualInterestRate = builder.annualInterestRate;
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

    public void addMonthlyInterest() {
        Double monthlyInterset =  getMonthlyInterestRate()*balance;
        balance += monthlyInterset;
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

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private Long id;
        private String owner;
        private Double balance;
        private Double annualInterestRate;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withBalance(Double balance) {
            this.balance = balance;
            return this;
        }

        public Builder withAnnualInterestRate(Double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }
}
