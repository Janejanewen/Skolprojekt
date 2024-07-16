package com.example.marstravels;

import javaClass.Cabin;
import javaClass.FoodInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class FoodPackagesinformationController {

    @FXML
    public void openPreviousScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FoodPackages.fxml"));
        Scene chosenScene = new Scene(loader.load(), 600, 400);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(chosenScene);
        window.show();
    }
    @FXML
    private TextArea txtBudget;

    @FXML
    private TextArea txtLyx;

    @FXML
    private TextArea txtMatinfo;

    @FXML
    private TextArea txtMellan;

    private final Repository repository = new Repository();
    private void display() {
        List<FoodInfo> infos = repository.getFoodinfos();
        for (FoodInfo finfo : infos) {
            if (finfo.getId() == 1) {
                txtMatinfo.setText
                        (finfo.getInfo());
            } else if (finfo.getId() == 2) {
                txtBudget.setText
                        (finfo.getInfo());
            } else if (finfo.getId() == 3) {
                txtMellan.setText
                        (finfo.getInfo());
            } else if (finfo.getId() == 4) {
                txtLyx.setText
                        (finfo.getInfo());
            }
        }
    }
    @FXML
    public void initialize()
    {
        display();
    }

}
