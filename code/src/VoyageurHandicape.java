import java.util.*;

class VoyageurHandicap extends Voyageur {
    private long idHandicap;

    public VoyageurHandicap(String nom, Date birthDate) {
        super(nom, birthDate);
    }

    public long getHandicap() {
        return this.idHandicap;
    }

    public void setHandicap(long idHandicap) {
        this.idHandicap = idHandicap;
    }
}