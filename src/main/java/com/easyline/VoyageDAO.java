package com.easyline;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.easyline.classes.DBconn;
import com.easyline.classes.Voyage;

public class VoyageDAO {
    public Connection connection = new DBconn().getConnection();

    public List<Voyage> selectAll() {
        List<Voyage> voyages = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT voyage.id, agence.nom, voyage.date_debut, voyage.date_fin, voyage.destination, voyage.prix FROM agence INNER JOIN voyage ON agence.id = voyage.agence_id");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                long id = result.getLong("voyage.id");
                String nomAgence = result.getString("agence.nom");
                Date dateDebut = result.getDate("voyage.date_debut");
                Date dateFin = result.getDate("voyage.date_fin");
                String destination = result.getString("voyage.destination");
                Double prix = result.getDouble("voyage.prix");

                Map<String, Date> dates = new HashMap<>() {{
                    put("debut", dateDebut);
                    put("fin", dateFin);
                }};

                Voyage voyage = new Voyage(id, dates, prix, destination);
                voyage.setAgenceNom(nomAgence);

                voyages.add(voyage);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyages;
    }

}

// SELECT t2.nom
// FROM table1 t1
// INNER JOIN table2 t2 ON t1.agence_id = t2.id_adresse;