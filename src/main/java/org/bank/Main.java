package org.bank;

import org.bank.client.Client;
import org.bank.exception.ClientNegativeIdException;
import org.bank.exception.ClientNotFoundException;
import org.bank.exception.ClientNullException;
import org.bank.exception.InvalidBalanceException;

public class Main {
    public static void main(String[] args) {
        Client firstClient = new Client("Anton", "Zakhlebayeu", "Iharevich");

        Bank priorbank = new Bank("Priorbank");

        try {
            priorbank.addBankClient(firstClient);
        } catch (ClientNullException e) {
            System.out.println(e.getMessage());
        }

        try {
            priorbank.createCheckingAccount(firstClient.getClientId(), 200, 2);
        } catch (ClientNotFoundException | InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(priorbank.getBankClientBalance(firstClient.getClientId()));
        } catch (ClientNegativeIdException | ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
