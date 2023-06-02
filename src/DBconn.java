import java.sql.*;

public class DBconn {
    public Connection conn;

    public DBconn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.append("driver ok \n");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyline","admin","admin");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }
}
