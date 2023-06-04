package com.easyline.dao;

import java.sql.*;
import com.easyline.classes.*;
import java.security.*;
import java.nio.charset.*;

public class LoginDAO {
    public Connection connection = new DBconn().getConnection();
    
    public boolean select(String username, String password) {
        Boolean response = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(1) FROM users WHERE username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            if (result.getInt(1) == 1) {
                response = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response = false;
        }
        return response;
    }

}
