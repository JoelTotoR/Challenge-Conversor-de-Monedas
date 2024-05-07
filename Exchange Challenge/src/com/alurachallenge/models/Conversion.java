package com.alurachallenge.models;

public class Conversion {
    private String originalCurrency;
    private String finalCurrency;
    private double exchangeRate;
    private  double amount;

    public Conversion(ExchangeApi exchangeApi, double amount) {
        this.originalCurrency = exchangeApi.base_code();
        this.finalCurrency = exchangeApi.target_code();
        this.exchangeRate = exchangeApi.conversion_rate();
        this.amount = amount;
    }

    public String getOriginalCurrency() {
        return this.originalCurrency;
    }

    public String getFinalCurrency() {
        return this.finalCurrency;
    }

    public double getExchangeRate() {
        return this.exchangeRate;
    }

    public double getAmount() {
        return amount;
    }

    public double getFinalAmount() {
        return getAmount()*this.getExchangeRate();
    }

    @Override
    public String toString() {
        return ("(" + getAmount() + " "+ getOriginalCurrency() + " -> " + getFinalCurrency()
        + " : " + getFinalAmount() +")");
    }
}
