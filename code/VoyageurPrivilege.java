class VoyageurPrivilege extends Voyageur {
    private String codePrivilege;

    public VoyageurPrivilege(String nom, int age) {
        super(nom, age);
    }

    public String getCodePrivilege() {
        return this.codePrivilege;
    }

    public void setCodePrivilege(String codePrivilege) {
        this.codePrivilege = codePrivilege;
    }

    public String toString() {
        return "Voyageur : \n" + this.nom + "\n" + Integer.toString(this.age) 
        + "\n" + this.bagage.toString() + this.adressePostale.toString()
        + "\n Code privilege : " + this.codePrivilege + "\n"; 
    }
}