package com.easyline;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    private App myApp;

    @FXML
    private ImageView agencesIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private ImageView reservationsIcon;

    @FXML
    private ImageView voyageursIcon;

    public MenuController() {
        myApp = new App();
    }

    public void logoutIconOnAction(MouseEvent event) {
        Stage stageToClose = (Stage) logoutIcon.getScene().getWindow();
        stageToClose.close();
    }

    public void agencesIconOnAction(MouseEvent event) {
        try {
            myApp.setRoot("AgencesPage");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void reservationsIconOnAction(MouseEvent event) {
        try {
            myApp.setRoot("VoyagesPage");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void voyageursIconIconOnAction(MouseEvent event) {
        try {
            myApp.setRoot("VoyageursPage");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}