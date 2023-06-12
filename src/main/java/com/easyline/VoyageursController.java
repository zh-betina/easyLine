package com.easyline;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.easyline.classes.AgenceVoyage;
import com.easyline.classes.Voyageur;
import com.easyline.dao.AgenceVoyageDAO;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VoyageursController implements Initializable {

    @FXML
    private App myApp;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView goBackIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private TableView<Voyageur> voyageursTable;

    @FXML
    private TableColumn<Voyageur, String> libelleCol;


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



}