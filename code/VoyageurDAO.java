import java.sql.Connection;
import java.sql.*;
import java.util.Calendar;

public class VoyageurDAO extends DAO<Voyageur> {
    public Connection connection = null;

    public Voyageur select(long id) {
            try {
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM voyageur WHERE ID = '?'");
                preparedStatement.setString(1, ((new Long(id)).toString()));
                ResultSet result = preparedStatement.executeQuery();
                Date birthDate = result.getDate("date_naissance");
                String birthDateStr = birthDate.toString();
                
                Voyageur voyageur = new Voyageur(result.getString("nom"), birthDate);
                preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
}
}