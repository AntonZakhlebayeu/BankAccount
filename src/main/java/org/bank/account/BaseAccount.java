package org.bank.account;

import org.bank.type.AccountType;

public abstract class BaseAccount {

    protected int userId;
    protected double currentBalance;
    protected boolean isBlocked;

    public BaseAccount(int userId, double currentBalance) {
        this.userId = userId;
        this.currentBalance = currentBalance;
    }

    public boolean isBlocked() { return isBlocked; }
    public void blockAccount() { this.isBlocked = true; }
    public void unblockAccount() { this.isBlocked = false; }

    public double getCurrentBalance() { return this.currentBalance; }
    public void setCurrentBalance(double currentBalance) { this.currentBalance = currentBalance; }

    public int getUserId() { return this.userId; }

    public abstract AccountType getType();
}
