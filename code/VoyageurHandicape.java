class VoyageurHandicape extends Voyageur {
    private String handicap; 

    public VoyageurHandicape(String nom, int age) {
        super(nom, age);
    }

    public String getHandicap() {
        return this.handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public String toString() {
        return "Voyageur : \n" + this.nom + "\n" + Integer.toString(this.age) 
        + "\n" + this.bagage.toString() + this.adressePostale.toString()
        + "\n Type d'handicap : " + this.handicap + "\n"; 
    }
}