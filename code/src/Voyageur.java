import java.util.*;

public class Voyageur {
    protected long id;
    protected String nom;
    protected Date birthDate;
    protected Category category;
    protected AdressePostale adressePostale;
    protected Bagage bagage;

    public Voyageur() {

    }

    public Voyageur(String nom, Date birthDate) {
    //    this.setAge(age);
       this.setNom(nom);
       this.setBirthDate(birthDate);
       this.adressePostale = new AdressePostale();
       this.bagage = new Bagage();
    }

    // public void setAge(int age) {
    //     if (isAgeValid(age)) {
    //         this.age = age;
    //         this.category = this.determineCategory();
    //     }
    // }

    // public int getAge() {
    //     return this.age;
    // }

    public void setNom(String nom) {
        if (isNomValid(nom)) this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return this.category;
    }

    // Je sais, qu'on pourra faire autrement cette partie. Avec 
    // les if's embriques ou plain d'if independent. Lequel
    // serai le meuilleur du coup ?
    // private Category determineCategory() {
    //     if (this.age > 60) {
    //         return Category.SENIOR;
    //     } else if (this.age <= 60 && this.age >= 18) {
    //         return Category.ADULTE;
    //     } else if (this.age < 18 && this.age > 1) {
    //         return Category.ENFANT;
    //     } else {
    //         return Category.NOURISSON;
    //     }
    // }

    // private Boolean isAgeValid(int age) {
    //     if (age > 0) {
    //         return true;
    //     } else {
    //         System.out.println("L'age doit etre un valeur positif");
    //         return false;
    //     }
    // }

    private Boolean isNomValid(String nom) {
        if (nom.length() >= 2) {
            return true;
        } else {
            System.out.println("Le nom doit etre compose d'au moins deux caracteres");
            return false;
        }
    }

    public void displayInfoVoyageur() {
        System.out.println("Le nom du voyageur : " + this.nom);
        // System.out.println("L'age du voyageur : " + this.age);
        this.adressePostale.displayInfoAdresse();
        this.bagage.displayInfoBagage();
    }

    public String toString() {
        return "Voyageur : \n" + this.nom + "\n" + this.birthDate + "\n" + this.bagage.toString() + this.adressePostale.toString();
    }

    public void setStreet(String street) {
        this.adressePostale.setStreet(street);
    }

    public void setCity(String city) {
        this.adressePostale.setCity(city);
    }

    public void setPostalCode(String postalCode) {
        this.adressePostale.setPostalCode(postalCode);
    }

    public long getAdresse() {
        return this.adressePostale.getId();
    }

    public void addBagage(double weight) {
        this.bagage.setWeight(weight);
    }

    public long getBagage() {
        return this.bagage.getId();
    }

    public void removeBagage() {
        this.bagage = new Bagage();
    }

    public void setWeight(double weight) {
        this.bagage.setWeight(weight);
    }

    public void setBirthDate(Date date) {
        this.birthDate = date;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }
}