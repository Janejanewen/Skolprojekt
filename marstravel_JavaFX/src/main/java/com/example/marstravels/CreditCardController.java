package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreditCardController {

    @FXML
    private Button btninfo;

    @FXML
    private Button btnnext;

    @FXML
    private Button btnprevious;

    @FXML
    private Button btnvarukorg;

    @FXML
    private Label lblCreditCard;

    @FXML
    private Label lblErrorMessage;

    @FXML
    private Label lblKr;

    @FXML
    private Label lblhowmuch;

    @FXML
    private TextField txtAmount;

    private String sAmount = "0"; // txtAmount.getText().;

    private int money;

    private boolean correctInput = false;

    @FXML
    void openNextScene(ActionEvent event) throws IOException {
        save();
        if(correctInput) {
            MarsTravelApplication.previousScene = "CreditCard.fxml";
            MarsTravelApplication.logic.openScene(event, "SummaryReview.fxml");
        }
    }

    @FXML
    void openPreviousScene(ActionEvent event) throws IOException {
        MarsTravelApplication.logic.openScene(event, "PersonalData.fxml");
    }

    @FXML
    void openShoppingCart(ActionEvent event) throws IOException {
        save();
        if(correctInput) {
            MarsTravelApplication.previousScene = "CreditCard.fxml";
            MarsTravelApplication.logic.openScene(event, "ShoppingCart.fxml");
        }
    }

    private void save(){
        sAmount = txtAmount.getText();
        try {
            money = Integer.parseInt(sAmount);
            if (money >= 20000){
                MarsTravelApplication.payCard = money;
                correctInput = true;
            }
            else {
                lblErrorMessage.setText("För lite: måste vara minst 20 000Kr");
            }
        } catch (NumberFormatException e) {
            lblErrorMessage.setText("Felformaterad input");
        }
    }

    public void initialize() {
        txtAmount.setText(String.valueOf(MarsTravelApplication.payCard));
    }
}

