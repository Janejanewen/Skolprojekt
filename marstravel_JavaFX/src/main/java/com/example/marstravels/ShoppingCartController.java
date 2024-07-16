package com.example.marstravels;

import javaClass.PersonalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class ShoppingCartController {
    @FXML
    private Label lblCabinChoice;
    @FXML
    private Label lblInsuranceChoice;

    @FXML
    private Label lblMealChoice;

    @FXML
    private Label lblMoney;

    @FXML
    private Label lblTicket1;

    @FXML
    private Label lblTicket2;

    @FXML
    private Label lblTicket3;

    @FXML
    private Label lblSumNmbr;

    @FXML
    private Label lblCabinChoiceR;

    @FXML
    private Label lblMealChoiceR;

    @FXML
    private Label lblTicket1R;

    @FXML
    private Label lblTicket2R;

    @FXML
    private Label lblTicket3R;


    public void initialize() {
        if(MarsTravelApplication.bookingToMars._cabin != null) {
            lblCabinChoice.setText(MarsTravelApplication.bookingToMars._cabin.gettype());
        } else {
            lblCabinChoice.setText("empty");
        }
        if(MarsTravelApplication.bookingToMars._foodPackage != null) {
            lblMealChoice.setText(MarsTravelApplication.bookingToMars._foodPackage.getName());
        } else {
            lblMealChoice.setText("empty");
        }
        if(MarsTravelApplication.payCard != 0) {
            lblMoney.setText(String.valueOf(MarsTravelApplication.payCard));
        } else {
            lblMoney.setText("empty");
        }
        lblInsuranceChoice.setText("insurance");
        lblTicket1.setText("Bio:        " + String.valueOf(MarsTravelApplication.bookingToMars._movieTickets));
        lblTicket2.setText("Konsert: " + String.valueOf(MarsTravelApplication.bookingToMars._concertTickets));
        lblTicket3.setText("Theater: " + String.valueOf(MarsTravelApplication.bookingToMars._theatreTickets));

        if(MarsTravelApplication.bookingFromMars._cabin != null) {
            lblCabinChoiceR.setText(MarsTravelApplication.bookingFromMars._cabin.gettype());
        } else {
            lblCabinChoiceR.setText("Empty");
        }
        if(MarsTravelApplication.bookingFromMars._foodPackage != null) {
            lblMealChoiceR.setText(MarsTravelApplication.bookingFromMars._foodPackage.getName());
        } else {
            lblMealChoiceR.setText("Empty");
        }
        lblTicket1R.setText("Bio:        " + String.valueOf(MarsTravelApplication.bookingFromMars._movieTickets));
        lblTicket2R.setText("Konsert: " + String.valueOf(MarsTravelApplication.bookingFromMars._concertTickets));
        lblTicket3R.setText("Theater: " + String.valueOf(MarsTravelApplication.bookingFromMars._theatreTickets));

        calculatePrice();
    }

    private void calculatePrice() {


        int totalPrice = 0;
        if(MarsTravelApplication.bookingToMars._cabin != null)
            totalPrice += MarsTravelApplication.bookingToMars._cabin.getPrice();
        if(MarsTravelApplication.bookingToMars._foodPackage != null)
            totalPrice += MarsTravelApplication.bookingToMars._foodPackage.getPrice();

        if(MarsTravelApplication.bookingFromMars._cabin != null)
            totalPrice += MarsTravelApplication.bookingFromMars._cabin.getPrice();
        if(MarsTravelApplication.bookingFromMars._foodPackage != null)
            totalPrice += MarsTravelApplication.bookingFromMars._foodPackage.getPrice();

        int amountOfHealthInsurances = 0;
        for (PersonalData p : MarsTravelApplication.persons)
        {
            if (p._healthInsurance)
            {
                amountOfHealthInsurances ++;
            }
        }

        lblSumNmbr.setText(
                String.valueOf(totalPrice *
                MarsTravelApplication.personAmount +
                MarsTravelApplication.payCard +
                50000 * amountOfHealthInsurances + " :-")
        );
        lblInsuranceChoice.setText(amountOfHealthInsurances + "/" + MarsTravelApplication.personAmount);
    }
    public void openPreviousScene(ActionEvent event) throws IOException {
        MarsTravelApplication.logic.openScene(event, MarsTravelApplication.previousScene);
    }
}
