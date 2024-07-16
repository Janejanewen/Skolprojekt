package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ToDoOnboardController {

    @FXML
    private Button btnTllbaka;

    @FXML
    private void openPreviousScene(ActionEvent event) throws IOException {
        MarsTravelApplication.logic.openScene(event, "EventsOnBoard.fxml");
    }

}
