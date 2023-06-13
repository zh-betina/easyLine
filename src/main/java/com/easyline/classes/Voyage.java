package com.easyline.classes;

// import java.util.Date;
import java.util.*;
import java.sql.Date;

public class Voyage {
    private long id;
    private long agenceId;
    private Date dateDebut;
    private Date dateFin;
    private String destination;
    private double prix;
    private String agenceNom;

    public Voyage() {

    }

    public Voyage(long id,  Map<String, Date> dates, double prix, String destination) {
        this.id = id;
        this.dateDebut = dates.get("debut");
        this.dateFin = dates.get("fin");
        this.prix = prix;
        this.destination = destination;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setAgenceId(long id) {
        this.agenceId = id;
    }

    public long getAgenceId() {
        return this.agenceId;
    }

    public void setDateDebut(Date date) {
        this.dateDebut = date;
    }

    public Date getDateDebut() {
        return this.dateDebut;
    }

    public void setDateFin(Date date) {
        this.dateFin = date;
    }

    public Date getDateFin() {
        return this.dateFin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return this.prix;
    }

    public String getAgenceNom() {
        return this.agenceNom;
    }

    public void setAgenceNom(String nom) {
        this.agenceNom = nom;
    }
}
