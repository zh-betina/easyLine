class Avion {

    private int code;
    private int nbPlaces;
    private Compagnie compagnie;

    public Avion(int code, int nbPlaces, String compagnieNom) {
        this.code = code;
        this.nbPlaces = nbPlaces;
        this.compagnie = new Compagnie(compagnieNom);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Compagnie getCompagnie() {
        return this.compagnie;
    }

    public int getCode() {
        return this.code;
    }

    public int getNbPlaces() {
        return this.nbPlaces;
    }

    public void displayAvion() {
        System.out.println("Compagnie : " + this.compagnie.getNom() + 
        ", Code avion : " + this.getCode() + ", Nombre de places : " + this.getNbPlaces() + ", Longeur avion : " + this.getLongeur() + "\n");
    }
}