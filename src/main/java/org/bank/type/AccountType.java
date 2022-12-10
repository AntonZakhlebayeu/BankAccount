package org.bank.type;

public enum AccountType {
    CHECKING("Checking bank account"),
    SavingsAccount("Savings account");

    AccountType(String name) { this.name = name; }
    private final String  name;

    @Override
    public String toString() {
        return name;
    }
}