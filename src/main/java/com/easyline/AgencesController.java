package com.easyline;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import java.net.URL;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import com.easyline.classes.AgenceVoyage;
import com.easyline.dao.AgenceVoyageDAO;
import java.io.IOException;

public class AgencesController implements Initializable {

    @FXML
    private App myApp;

    @FXML
    private TableView<AgenceVoyage> agencesTable;

    @FXML
    private TableColumn<AgenceVoyage, String> libelleCol;

    @FXML
    private TableColumn<AgenceVoyage, String> adresseCol;

    @FXML
    private ImageView goBackIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private ImageView nextIcon;

    @FXML
    private ImageView previousIcon;

    // public AgencesController() {
    // }

    @FXML
    void logoutIconOnAction(MouseEvent event) {
        Stage stageToClose = (Stage) logoutIcon.getScene().getWindow();
        stageToClose.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AgenceVoyageDAO agenceDAO = new AgenceVoyageDAO();
        List<AgenceVoyage> agences = agenceDAO.selectAll();
        ObservableList<AgenceVoyage> observableAgences = FXCollections.observableArrayList(agences);
        try {
            libelleCol = new TableColumn<AgenceVoyage, String>("Libelle");
            adresseCol = new TableColumn<AgenceVoyage, String>("Adresse");
            libelleCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
            adresseCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdresse()));
            agencesTable.setItems(observableAgences);
            agencesTable.getColumns().addAll(libelleCol, adresseCol);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void goBackIconOnAction(MouseEvent event) {
        try {
            myApp.setRoot("MenuPage");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setApp(App app) {
        this.myApp = app;
    }

}