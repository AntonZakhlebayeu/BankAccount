package org.bank.client;

public class Client {
    private static int amountOfClients = 0;

    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final int clientId;

    public Client(String firstName, String lastName, String patronymic) {
        amountOfClients++;

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.clientId = amountOfClients - 1;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPatronymic() { return patronymic; }
    public int getClientId() { return clientId; }
}
