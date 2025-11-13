package com.example.interview_prep.hard.dto;

import java.time.LocalDate;

public class Transaction {
    private String id;
    private LocalDate date;
    private double amount;

    public Transaction(String id, LocalDate date, double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public String getId() { return id; }
    public LocalDate getDate() { return date; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', date=" + date + ", amount=" + amount + "}";
    }
}
