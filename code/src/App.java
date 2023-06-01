import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = "1994-09-04";
        try {
            // Date date = formatter.parse(strDate);
            // Voyageur v = new Voyageur("Zhou", date);
            // System.out.println(v.toString());
            // VoyageurDAO vd = new VoyageurDAO();
            // vd.insert(v);
            double weight = 2.05;
            Bagage b = new Bagage(weight);
            BagageDAO bDao = new BagageDAO();
            bDao.insert(b);
        } catch (Exception e) {
            System.out.println(e);
            e.getStackTrace();
        }
    }
}
