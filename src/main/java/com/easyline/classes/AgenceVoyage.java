package com.easyline.classes;

import java.util.*;

public class AgenceVoyage {
    private long id;
    private String nom;
    private AdressePostale adresse;
    private List<Voyageur> voyageurs;

    public AgenceVoyage(String nom, AdressePostale adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public AdressePostale getAdresse() {
        return this.adresse;
    }

    public void setAdresse(AdressePostale adresse) {
        this.adresse = adresse;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}