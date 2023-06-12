package com.easyline;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VoyagesController implements Initializable {


    @FXML
    private App myApp;

    @FXML
    private ImageView goBackIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private TableView<?> voyagesTable;

       @Override
    public void initialize(URL location, ResourceBundle resources) {
        // AgenceVoyageDAO agenceDAO = new AgenceVoyageDAO();
        // List<AgenceVoyage> agences = agenceDAO.selectAll();
        // ObservableList<AgenceVoyage> observableAgences = FXCollections.observableArrayList(agences);
        try {

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    @FXML
    void goBackIconOnAction(MouseEvent event) {
        try {
            myApp.setRoot("MenuPage");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void logoutIconOnAction(MouseEvent event) {
        Stage stageToClose = (Stage) logoutIcon.getScene().getWindow();
        stageToClose.close();
    }

}
