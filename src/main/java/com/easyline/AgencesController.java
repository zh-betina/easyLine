package com.easyline;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import java.net.URL;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn.CellEditEvent;

import com.easyline.classes.AgenceVoyage;
import com.easyline.dao.AdressePostaleDAO;
import com.easyline.dao.AgenceVoyageDAO;

public class AgencesController implements Initializable {

    @FXML
    private App myApp;

    @FXML
    private TableView<AgenceVoyage> agencesTable;

    @FXML
    private TableColumn<AgenceVoyage, String> libelleCol;

    @FXML
    private TableColumn<AgenceVoyage, String> cityCol;

    @FXML
    private TableColumn<AgenceVoyage, String> streetCol;

    @FXML
    private TableColumn<AgenceVoyage, String> postalCodeCol;

    @FXML
    private TableColumn<AgenceVoyage, Number> idCol;

    @FXML
    private TableColumn<AgenceVoyage, Number> idAddrCol;

    @FXML
    private ImageView goBackIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private ImageView nextIcon;

    @FXML
    private ImageView previousIcon;

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
            idCol = new TableColumn<AgenceVoyage, Number>("Id");
            idAddrCol = new TableColumn<AgenceVoyage, Number>("Id addr");
            libelleCol = new TableColumn<AgenceVoyage, String>("Nom");
            streetCol = new TableColumn<AgenceVoyage, String>("Libellé");
            cityCol = new TableColumn<AgenceVoyage, String>("Ville");
            postalCodeCol = new TableColumn<AgenceVoyage, String>("Code postal");

            idCol.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getId()));
            idAddrCol.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getAdresse().getId()));
            libelleCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
            streetCol.setCellValueFactory(
                    cellData -> new SimpleStringProperty(cellData.getValue().getAdresse().getStreet()));
            cityCol.setCellValueFactory(
                    cellData -> new SimpleStringProperty(cellData.getValue().getAdresse().getCity()));
            postalCodeCol.setCellValueFactory(
                    cellData -> new SimpleStringProperty(cellData.getValue().getAdresse().getPostalCode()));

            libelleCol.setCellFactory(TextFieldTableCell.forTableColumn());
            streetCol.setCellFactory(TextFieldTableCell.forTableColumn());
            cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
            postalCodeCol.setCellFactory(TextFieldTableCell.forTableColumn());

            idCol.setVisible(false);
            idAddrCol.setVisible(false);

            agencesTable.setEditable(true);
            agencesTable.setItems(observableAgences);
            agencesTable.getColumns().addAll(idCol, idAddrCol, libelleCol, streetCol, cityCol, postalCodeCol);

            setEditEvents();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void setEditEvents() {
        libelleCol.setOnEditCommit(
                (CellEditEvent<AgenceVoyage, String> t) -> {
                    ((AgenceVoyage) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setNom(t.getNewValue());
                    AgenceVoyageDAO agenceDao = new AgenceVoyageDAO();
                    if (agenceDao.update(t.getRowValue())) {
                        agencesTable.refresh();
                    } else {
                        System.err.println("Une erreur est survenue");
                    }
                });
        streetCol.setOnEditCommit(
                (CellEditEvent<AgenceVoyage, String> t) -> {
                    ((AgenceVoyage) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).getAdresse().setStreet(t.getNewValue());
                    AdressePostaleDAO adressePostaleDAO = new AdressePostaleDAO();
                    if (adressePostaleDAO.update(t.getRowValue().getAdresse())) {
                        agencesTable.refresh();
                    } else {
                        System.err.println("Une erreur est survenue");
                    }
                });
        cityCol.setOnEditCommit(
                (CellEditEvent<AgenceVoyage, String> t) -> {
                    ((AgenceVoyage) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).getAdresse().setCity(t.getNewValue());
                    AdressePostaleDAO adressePostaleDAO = new AdressePostaleDAO();
                    if (adressePostaleDAO.update(t.getRowValue().getAdresse())) {
                        agencesTable.refresh();
                    } else {
                        System.err.println("Une erreur est survenue");
                    }
                });
        postalCodeCol.setOnEditCommit(
                (CellEditEvent<AgenceVoyage, String> t) -> {
                    ((AgenceVoyage) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).getAdresse().setPostalCode(t.getNewValue());
                    AdressePostaleDAO adressePostaleDAO = new AdressePostaleDAO();
                    if (adressePostaleDAO.update(t.getRowValue().getAdresse())) {
                        agencesTable.refresh();
                    } else {
                        System.err.println("Une erreur est survenue");
                    }
                });
    }

    public void goBackIconOnAction(MouseEvent event) {
        try {
            myApp.setRoot("MenuPage");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}