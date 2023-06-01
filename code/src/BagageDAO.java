import java.sql.Connection;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Properties;

public class BagageDAO extends DAO<Bagage> {
    public Connection connection = new DBconn().getConnection();

    @Override
    public Bagage select(long id) {
        Bagage bagage = new Bagage();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bagage WHERE id = '?'");
            preparedStatement.setString(1, Long.toString(id));
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            double weight = result.getDouble("poids");

            preparedStatement.close();
            bagage = new Bagage(weight);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bagage;
    }

    @Override
    public Bagage insert(Bagage b) {
        Bagage bagage = b;

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "INSERT INTO bagage (poids) VALUES ( ?)");
            preparedStatement.setDouble(1, bagage.getWeight());
            preparedStatement.executeUpdate();
            // long bagageId = preparedStatement.getLong("id");
            // bagage.setId(bagageId);
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bagage;
    }

    @Override
    public boolean update(Bagage b) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE bagage SET poids = ? WHERE id = ? ");
            preparedStatement.setDouble(1, b.getWeight());
            preparedStatement.setLong(2, b.getId());
            preparedStatement.executeQuery();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM bagage WHERE id = " + id);
            preparedStatement.executeQuery();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
