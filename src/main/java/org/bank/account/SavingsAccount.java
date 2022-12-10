package org.bank.account;

import org.bank.type.AccountType;

public class SavingsAccount extends BaseAccount{
    private boolean isWithdrew;
    private boolean isReplenished;

    public SavingsAccount(int userId, double currentBalance, boolean isWithdrew, boolean isReplenished) {
        super(userId, currentBalance);
        this.isWithdrew = isWithdrew;
        this.isReplenished = isReplenished;
    }

    public boolean isReplenished() { return isReplenished; }
    public void setReplenished(boolean replenished) { isReplenished = replenished; }

    public boolean isWithdrew() { return isWithdrew; }
    public void setWithdrew(boolean withdrew) { isWithdrew = withdrew; }


    @Override
    public AccountType getType() { return AccountType.SavingsAccount; }
}
