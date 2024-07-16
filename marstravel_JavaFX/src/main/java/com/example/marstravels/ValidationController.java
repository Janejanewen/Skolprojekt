package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ValidationController {

    @FXML
    private Label lblChFood;

    @FXML
    public void openPreviousScene(ActionEvent event) throws IOException {
        MarsTravelApplication.logic.openScene(event, MarsTravelApplication.previousScene);
        System.out.println(MarsTravelApplication.bookingToMars._foodPackage);
    }
}