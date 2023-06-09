package com.easyline.classes;

import java.util.*;

public class AgenceVoyage {
    private long id;
    private String nom;
    private String adresse;
    private List<Voyageur> voyageurs;

    public AgenceVoyage(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId(long id) {
        this.id = id;
    }
}