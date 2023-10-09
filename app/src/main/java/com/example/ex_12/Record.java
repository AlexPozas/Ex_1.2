package com.example.ex_12;

public class Record {

    String nom;
    int intents;

    public Record(String nom, int intents) {
        this.nom = nom;
        this.intents = intents;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIntents() {
        return intents;
    }

    public void setIntents(int intents) {
        this.intents = intents;
    }
}
