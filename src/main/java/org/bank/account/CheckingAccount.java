package org.bank.account;

import org.bank.type.AccountType;

public class CheckingAccount extends BaseAccount{
    private double monthlyPayments;
    public CheckingAccount(int userId, double currentBalance, double monthlyPayments) {
        super(userId, currentBalance);
        this.monthlyPayments = monthlyPayments;
    }

    public double getMonthlyPayments() { return monthlyPayments; }
    public void setMonthlyPayments(double monthlyPayments) { this.monthlyPayments = monthlyPayments; }

    @Override
    public AccountType getType() { return AccountType.CHECKING; }
}
