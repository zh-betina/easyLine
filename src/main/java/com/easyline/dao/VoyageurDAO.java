package com.easyline.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import com.easyline.classes.*;

public class VoyageurDAO extends DAO<Voyageur> {
    public Connection connection = new DBconn().getConnection();

    @Override
    public Voyageur select(long id) {
        Voyageur voyageur = new Voyageur();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM voyageur WHERE id = '?'");
            preparedStatement.setString(1, Long.toString(id));
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            Date birthDate = result.getDate("date_naissance");
            System.out.println(birthDate);

            preparedStatement.close();
            voyageur = new Voyageur(result.getString("nom"), birthDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyageur;
    }

    @Override
    public Voyageur insert(Voyageur v) {
        System.out.println(this.connection.toString());
        Voyageur voyageur = new Voyageur(v.getNom(), v.getBirthDate());

        long categorieId = v.getCategory().ordinal();
        long adresseId = v.getAdresse();
        long bagageId = v.getBagage();

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String strDate = dateFormat.format(v.getBirthDate());

            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "INSERT INTO voyageur (categorie_id, adresse_id, bagage_id, nom, date_naissance) VALUES ( ? , ? , ? , ? , ?)");
            preparedStatement.setString(1, Long.toString(categorieId));
            preparedStatement.setString(2, Long.toString(adresseId));
            preparedStatement.setString(3, Long.toString(bagageId));
            preparedStatement.setString(4, v.getNom());
            preparedStatement.setString(5, strDate);
            ResultSet result = preparedStatement.executeQuery();
            long voyageurId = result.getLong("id");
            voyageur.setId(voyageurId);
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voyageur;
    }

    @Override
    public boolean update(Voyageur v) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(v.getBirthDate());

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE voyageur SET categorie_id = ?, adresse_id = ?, bagage_id = ?, nom = ?, date_naissance = ? WHERE id = ? ");
            preparedStatement.setLong(1, v.getCategory().ordinal());
            preparedStatement.setLong(2, v.getAdresse());
            preparedStatement.setLong(3, v.getBagage());
            preparedStatement.setString(4, v.getNom());
            preparedStatement.setString(5, strDate);
            preparedStatement.setLong(6, v.getId());
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
                    "DELETE FROM voyageur WHERE id = " + id);
            preparedStatement.executeQuery();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}