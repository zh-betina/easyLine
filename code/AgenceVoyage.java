import java.util.*;

class AgenceVoyage {
    private String nom;
    private String adresse;
    private ArrayList<Voyageur> voyageurs;

    public AgenceVoyage(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.voyageurs = new ArrayList<Voyageur>(5);
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    } 

    public ArrayList<Voyageur> getVoyageurs() {
        return this.voyageurs;
    }

    public void addVoyageur() {
        int nbDeVoyageurs = 0;

        System.out.println("Combien de voyageurs aimerez-vous saisir : ");
        Scanner scanner = new Scanner(System.in);
        nbDeVoyageurs = scanner.nextInt();
        int counter = 1;

        while (nbDeVoyageurs > 0) {
                System.out.printf("%d \n", nbDeVoyageurs);
                System.out.printf("Saisissez le nom du voyageur numero %d \n", counter);

                String nom = scanner.nextLine();
                nom = scanner.nextLine();

                System.out.printf("Saisissez l'age du voyageur numero %d \n", counter);
                int age = scanner.nextInt();
                Voyageur newVoyageur = new Voyageur(nom, age);
                counter++;
                nbDeVoyageurs--;
                
                this.voyageurs.add(newVoyageur);
            }
    }

    public Voyageur getVoyageurByNom() {
        System.out.println("Saisissez le nom du voyageur à trouver : \n");
        Scanner scanner = new Scanner(System.in);
        String nom = scanner.nextLine();
        Voyageur foundVoyageur = null;
        Boolean isFound = false;

        for (Voyageur v : this.voyageurs) {
            if(v.getNom().equals(nom)) {
                v.displayInfoVoyageur();
                foundVoyageur = v;
                isFound = true;
                break;
            } else {
                //TODO : ameliorer ca
                if (!isFound) System.out.println("Voyageur avec ce nom n'existe pas. \n \n");
                isFound = true;
            }
        }

        return foundVoyageur;
    }

    public void removeVoyageurByNom() {
        System.out.println("Saisissez le nom du voyageur à supprimer : \n");
        Scanner scanner = new Scanner(System.in);
        String nom = scanner.nextLine();
        int isConfirmed = 0;
        Boolean isFound = false;

        System.out.println("Voulez-vous vraiment supprimer voyageur suivant : \n");
        
        for (Voyageur v : this.voyageurs) {
            if(v.getNom().equals(nom)) {
                v.displayInfoVoyageur();
                isFound = true;

                System.out.println("1 ------------ Oui \n");
                System.out.println("0 ------------ Non \n");
                isConfirmed = scanner.nextInt();
                scanner.nextLine();

                if (isConfirmed == 1) {
                    this.voyageurs.remove(v);
                }
                break;
            } else {
                if (!isFound) System.out.println("Voyageur avec ce nom n'existe pas. \n \n");
                isFound = true;
            }
        }
    }

    public void displayInfo() {
        String generalInfo = "Nom : " + this.nom + "\n" + "Adresse : " + this.adresse + "\n";
        System.out.println(generalInfo);
        System.out.println("Liste des voyageurs : \n");

        this.voyageurs.forEach((v)-> {
            v.displayInfoVoyageur();
            System.out.println("\n");
        });
    }
}