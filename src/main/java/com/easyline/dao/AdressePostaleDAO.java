package com.easyline.dao;

import java.sql.*;
import com.easyline.classes.*;

public class AdressePostaleDAO extends DAO<AdressePostale> {
    public Connection connection = new DBconn().getConnection();

    @Override
    public AdressePostale select(long id) {
        AdressePostale adresse = new AdressePostale();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM adresse WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            String street = result.getString("libelle");
            String city = result.getString("ville");
            String postalCode = result.getString("code_postale");
            long adresseId = result.getLong(1);

            preparedStatement.close();
            adresse = new AdressePostale(street, city, postalCode);
            adresse.setId(adresseId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adresse;
    }

    @Override
    public AdressePostale insert(AdressePostale ad) {
        AdressePostale adresse = ad;

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "INSERT INTO adresse (libelle, ville, code_postale) VALUES ( ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, adresse.getStreet());
            preparedStatement.setString(2, adresse.getCity());
            preparedStatement.setString(3, adresse.getPostalCode());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            long adresseId = resultSet.getLong(1);
            adresse.setId(adresseId);
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adresse;
    }

    @Override
    public boolean update(AdressePostale adresse) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE adresse SET libelle = ?, ville = ?, code_postale = ? WHERE id = ? ");
            preparedStatement.setString(1, adresse.getStreet());
            preparedStatement.setString(2, adresse.getCity());
            preparedStatement.setString(3, adresse.getPostalCode());
            preparedStatement.setDouble(4, adresse.getId());
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
                    "DELETE FROM adresse WHERE id = " + id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
