class Bagage {
    private double weight;
    private long id;

    public Bagage() {
        
    }

    public Bagage(double weight) {
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void displayInfoBagage() {
        System.out.println(this.weight + " kg.");
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public String toString() {
        return Double.toString(this.weight) + " kg \n \n";
    }
}