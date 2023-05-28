import java.util.*;

public class Main {
    public static void main(String args[]) {
        ArrayList<Voyageur> voyageurs = new ArrayList<Voyageur>();

        Voyageur v1 = new Voyageur("Foncin", 39);
        Voyageur v2 = new Voyageur("Arafa", 30);

        voyageurs.add(v1);
        voyageurs.add(v2);

        VoyageurPrivilege vP = new VoyageurPrivilege("Dupont", 35);
        System.out.println(vP.toString());

        vP.addBagage(1, "black", 0.23);
        vP.setCodePrivilege("24FSDFA235");

        System.out.println(vP.toString());

        voyageurs.add(vP);

        VoyageurHandicape vH = new VoyageurHandicape("Martin", 57);
        System.out.println(vH.toString());

        vH.setStreet("4 rue de Ouf");
        vH.setCity("Cergy");
        vH.setPostalCode("750494");
        vH.setHandicap("physique");

        voyageurs.add(vH);
        System.out.println(vH.toString());
    }
}
