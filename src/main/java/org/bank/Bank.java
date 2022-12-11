package org.bank;

import org.bank.account.BaseAccount;
import org.bank.account.CheckingAccount;
import org.bank.account.SavingsAccount;
import org.bank.client.Client;
import org.bank.exception.*;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<BaseAccount> bankAccounts = new ArrayList<>();
    private final ArrayList<Client> bankClients = new ArrayList<>();

    private final String bankTitle;

    public Bank(String bankTitle) {
        this.bankTitle = bankTitle;
    }

    private boolean isClientExist(int clientId) {
        return bankClients.stream().anyMatch(bankClient -> bankClient.getClientId() == clientId);
    }

    public boolean isAccountBlocked(int accountId) throws AccountNegativeException, AccountNotFoundException {
        if(accountId < 0) {
            throw new AccountNegativeException("Account id cannot be negative");
        }
        if(accountId > bankAccounts.size() - 1) {
            throw new AccountNotFoundException(String.format("Account with id %d does not exist", accountId));
        }

        return bankAccounts.stream().filter(account -> account.getAccountId() == accountId).findFirst().get().isBlocked();
    }

    public ArrayList<Client> getBankClients() { return bankClients; }
    public ArrayList<BaseAccount> getBankAccounts() { return bankAccounts; }

    public String getBankTitle() { return bankTitle; }

    public void addBankClient(Client client) throws ClientNullException {
        if (client == null) {
            throw new ClientNullException("Client must exists");
        }

        bankClients.add(client);
    }

    public Client getBankClientById(int clientId) throws ClientNegativeIdException, ClientNotFoundException {
        if (clientId < 0) {
            throw new ClientNegativeIdException("Client id must be greater than 0");
        }
        if (isClientExist(clientId)) {
            for (Client bankClient : this.bankClients) {
                if (bankClient.getClientId() == clientId) {
                    return bankClient;
                }
            }
        }
        return null;
    }

    public void createCheckingAccount(int clientId, double currentBalance, double monthlyPayments) throws ClientNotFoundException, InvalidBalanceException {
        if (!isClientExist(clientId))
            throw new ClientNotFoundException(String.format("Client with id %d doesn't exists.", clientId));
        if (currentBalance < 0)
            throw new InvalidBalanceException("Balance can't be less than 0.");
        bankAccounts.add(new CheckingAccount(clientId, currentBalance, monthlyPayments));
    }

    public void createSavingsAccount(int clientId, double currentBalance, boolean isReplenished, boolean isWithdrew) throws ClientNotFoundException, InvalidBalanceException {
        if (!isClientExist(clientId))
            throw new ClientNotFoundException(String.format("Client with id %d doesn't exists.", clientId));
        if (currentBalance < 0)
            throw new InvalidBalanceException("Balance can't be less than 0.");
        bankAccounts.add(new SavingsAccount(clientId, currentBalance, isReplenished, isWithdrew));
    }

    public void blockAccount(int accountId) throws AccountNegativeException {
        if(accountId < 0) {
            throw new AccountNegativeException("Account id cannot be negative");
        }

        for(BaseAccount bankAccount : bankAccounts) {
            if(bankAccount.getAccountId() == accountId) {
                bankAccount.blockAccount();
            }
        }
    }

    public void unblockAccount(int accountId) throws AccountNegativeException {
        if(accountId < 0) {
            throw new AccountNegativeException("Account id cannot be negative");
        }

        for(BaseAccount bankAccount : bankAccounts) {
            if(bankAccount.getAccountId() == accountId) {
                bankAccount.unblockAccount();
            }
        }
    }

    public ArrayList<BaseAccount> getClientBankAccounts(int clientId) throws ClientNegativeIdException, ClientNotFoundException {
        if(clientId < 0) {
            throw new ClientNegativeIdException("Client Id must be greater than 0");
        }
        if(!isClientExist(clientId)) {
            throw new ClientNotFoundException(String.format("Client with id %d not found", clientId));
        }

        ArrayList<BaseAccount> clientAccounts = new ArrayList<>();
        for(BaseAccount bankAccount : bankAccounts) {
            if(bankAccount.getClientId() == clientId) {
                clientAccounts.add(bankAccount);
            }
        }

        return clientAccounts;
    }

    public double getBankClientBalance(int clientId) throws ClientNegativeIdException, ClientNotFoundException {
        if(clientId < 0) {
            throw new ClientNegativeIdException("Client id must be greater than 0");
        }

        if(!isClientExist(clientId)) {
            throw new ClientNotFoundException(String.format("Clint with id %d does not exist", clientId));
        }


        double sum = 0;
        ArrayList<BaseAccount> clientAccounts = getClientBankAccounts(clientId);
        for (BaseAccount clientAccount : clientAccounts) {
            if (!clientAccount.isBlocked())
                sum += clientAccount.getCurrentBalance();
        }
        return sum;
    }
}
