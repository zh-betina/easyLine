import java.sql.*;

public class DBconn {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.append("driver ok \n");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3308","admin","admin");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}