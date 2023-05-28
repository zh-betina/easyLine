class AdressePostale {
    private String street;
    private String city;
    private String postalCode;

    public AdressePostale() {
        
    }

    public AdressePostale(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public void displayInfoAdresse() {
        System.out.println("L'adresse :");
        System.out.println(street);
        System.out.println(postalCode + " " + city);
    }

    public String toString() {
        return "Addresse : \n" + this.street + "\n" + this.city + "\n" + this.postalCode + "\n \n";
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
}