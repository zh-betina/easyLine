package com.easyline;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {


    @FXML
    private ImageView agencesIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private ImageView reservationsIcon;

    @FXML
    private ImageView voyageursIcon;

    public void logoutIconOnAction(MouseEvent event) {
        Stage stageToClose = (Stage) logoutIcon.getScene().getWindow();
        stageToClose.close();
    }



}