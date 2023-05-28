class Bagage {
    private String color;
    private double weight;

    public Bagage() {
        
    }

    public Bagage(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void displayInfoBagage() {
        System.out.println("Le bagage de couleur " + this.color + " pese " + this.weight + " kg.");
    }

    public String toString() {
        return "Bagage : \n Couleur : " + this.color + "\n Poids : " +  Double.toString(this.weight) + " kg \n \n";
    }
}