import java.sql.Connection;
import java.sql.*;

public class BagageDAO extends DAO<Bagage> {
    public Connection connection = new DBconn().getConnection();

    @Override
    public Bagage select(long id) {
        Bagage bagage = new Bagage();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bagage WHERE id = ?");
            preparedStatement.setLong(1, id);
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
                            "INSERT INTO bagage (poids) VALUES ( ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, bagage.getWeight());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            long bagageId = resultSet.getLong(1);
            bagage.setId(bagageId);
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
            preparedStatement.executeUpdate();
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
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
