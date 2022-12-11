package org.bank.account;

import org.bank.type.AccountType;

public abstract class BaseAccount {
    private static int amountOfAccounts = 0;
    protected int clientId;

    protected double currentBalance;
    protected boolean isBlocked;
    protected int accountId;

    public BaseAccount(int clientId, double currentBalance) {
        amountOfAccounts++;

        this.clientId = clientId;
        this.currentBalance = currentBalance;
        this.accountId = amountOfAccounts - 1;
    }

    public boolean isBlocked() { return isBlocked; }
    public void blockAccount() { this.isBlocked = true; }
    public void unblockAccount() { this.isBlocked = false; }

    public double getCurrentBalance() { return this.currentBalance; }
    public void setCurrentBalance(double currentBalance) { this.currentBalance = currentBalance; }

    public int getClientId() { return this.clientId; }
    public int getAccountId() { return this.accountId; }

    public abstract AccountType getType();
}
