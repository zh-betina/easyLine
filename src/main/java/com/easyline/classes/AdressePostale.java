package com.easyline.classes;

public class AdressePostale {
    private String street;
    private String city;
    private String postalCode;
    private long id;

    public AdressePostale() {
        
    }

    public AdressePostale(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String toString() {
        return this.street + "\n" + this.city + "\n" + this.postalCode + "\n \n";
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    } 
}