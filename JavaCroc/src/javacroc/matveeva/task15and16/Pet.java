package javacroc.matveeva.task15and16;

import java.util.List;

public class Pet {
    private int petId;
    private String petName;
    private int petAge;
    private List<Client> clients;

    public Pet(int petId, String petName, int petAge, List<Client> clients) {
        this.petId = petId;
        this.petName = petName;
        this.petAge = petAge;
        this.clients = clients;
    }

    // Геттеры и сеттеры для всех полей
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

