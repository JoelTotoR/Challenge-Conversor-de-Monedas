package com.alurachallenge.models;

public class Calculate {
    private double amount;
    private double rate;
    private double finalAmount;

    public Calculate(double amount, double rate) {
        this.amount = amount;
        this.rate = rate;
        this.finalAmount = rate*amount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }
}
