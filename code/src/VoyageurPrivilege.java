import java.util.*;

class VoyageurPrivilege extends Voyageur {
    private long idCodePrivilege;

    public VoyageurPrivilege(String nom, Date birthDate) {
        super(nom, birthDate);
    }

    public long getCodePrivilege() {
        return this.idCodePrivilege;
    }

    public void setCodePrivilege(long idCodePrivilege) {
        this.idCodePrivilege = idCodePrivilege;
    }
}