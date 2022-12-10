package org.bank.client;

public class Client {
    private final String firstName;
    private final String lastName;
    private final String patronymic;

    public Client(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPatronymic() { return patronymic; }
}
