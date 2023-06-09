package com.easyline.dao;

import com.easyline.classes.*;
import java.sql.*;
import java.util.*;

public class AgenceVoyageDAO {
    public Connection connection = new DBconn().getConnection();

    public List<AgenceVoyage> selectAll() {
        List<AgenceVoyage> agences = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT agence.id, agence.nom, adresse.libelle, adresse.ville, adresse.code_postale FROM agence INNER JOIN adresse ON agence.id_adresse = adresse.id");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                long id = result.getLong("agence.id");
                String nom = result.getString("agence.nom");
                String libelle= result.getString("adresse.libelle");
                String ville= result.getString("adresse.ville");
                String codePostale= result.getString("adresse.code_postale");

                AdressePostale adresse = new AdressePostale(libelle, ville, codePostale);
                AgenceVoyage agence = new AgenceVoyage(nom, adresse.toString());
                agence.setId(id);
                agences.add(agence);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agences;
    }

    // public AgenceVoyage select(long id) {
    //     AgenceVoyage bagage = new Bagage();
    //     try {
    //         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bagage WHERE id = ?");
    //         preparedStatement.setLong(1, id);
    //         ResultSet result = preparedStatement.executeQuery();
    //         result.next();
    //         double weight = result.getDouble("poids");
    //         preparedStatement.close();
    //         bagage = new Bagage(weight);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return bagage;
    // }
}
