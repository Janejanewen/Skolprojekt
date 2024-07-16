package com.example.marstravels;

import javaClass.PersonalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class SummaryReviewController {

    @FXML
    private Button btnsparabokning;

    @FXML
    private Button btntillbaka;

    @FXML
    private Label lblcabinfrom;

    @FXML
    private Label lblcabinto;

    @FXML
    private Label lbldateonmars;

    @FXML
    private Label lbleventfrom;

    @FXML
    private Label lbleventto;

    @FXML
    private Label lblfoodfrom;

    @FXML
    private Label lblfoodto;

    @FXML
    private Label lblfromdate;

    @FXML
    private Label lblhotel;

    @FXML
    private Label lblinsurance;

    @FXML
    private Label lblpaycard;

    @FXML
    private Label lblreturndate;

    @FXML
    private Label lbltotalsum;

    @FXML
    private Label lbltravelers;

    @FXML
    private Label lblError;

    private boolean saved = false;

    @FXML
    void initialize() {
        if (MarsTravelApplication.bookingFromMars._departureDate != null)
            lblreturndate.setText(MarsTravelApplication.bookingFromMars._departureDate.toString());
        if (MarsTravelApplication.bookingToMars._departureDate != null)
            lblfromdate.setText(MarsTravelApplication.bookingToMars._departureDate.toString());

        if (MarsTravelApplication.bookingToMars._cabin != null)
            lblcabinto.setText(MarsTravelApplication.bookingToMars._cabin.gettype());
        if (MarsTravelApplication.bookingFromMars._cabin != null)
            lblcabinfrom.setText(MarsTravelApplication.bookingFromMars._cabin.gettype());

        if (MarsTravelApplication.bookingToMars._foodPackage != null)
            lblfoodto.setText(MarsTravelApplication.bookingToMars._foodPackage.getName());
        if (MarsTravelApplication.bookingFromMars._foodPackage != null)
            lblfoodfrom.setText(MarsTravelApplication.bookingFromMars._foodPackage.getName());
        if (MarsTravelApplication.hotel != null)
            lblhotel.setText(MarsTravelApplication.hotel.gettype());

        lbleventto.setText
                (
                        "Film: " + MarsTravelApplication.bookingToMars._movieTickets + "\n" +
                        "Teater: " + MarsTravelApplication.bookingToMars._theatreTickets + "\n" +
                        "Konsert: " + MarsTravelApplication.bookingToMars._concertTickets
        );

        lbleventfrom.setText
                (
                        "Film: " + MarsTravelApplication.bookingFromMars._movieTickets + "\n" +
                                "Teater: " + MarsTravelApplication.bookingFromMars._theatreTickets + "\n" +
                                "Konsert: " + MarsTravelApplication.bookingFromMars._concertTickets
                );

        lbltravelers.setText(String.valueOf(MarsTravelApplication.personAmount));

        lblpaycard.setText(String.valueOf(MarsTravelApplication.payCard));

        calculatePrice();

        if (MarsTravelApplication.bookingFromMars._departureDate != null)
            lbldateonmars.setText(String.valueOf(MarsTravelApplication.bookingToMars._departureDate.plusMonths(6)));

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
        for (PersonalData p : MarsTravelApplication.persons) {
            if (p._healthInsurance) {
                amountOfHealthInsurances ++;
            }
        }

        lbltotalsum.setText(
                String.valueOf(totalPrice *
                        MarsTravelApplication.personAmount +
                        MarsTravelApplication.payCard +
                        amountOfHealthInsurances * 50000 + ":-")
        );
        lblinsurance.setText(amountOfHealthInsurances + " / " + MarsTravelApplication.personAmount + ".");
    }

    @FXML
    public void saveBooking() {
        if(!saved) {
            if(lblreturndate.getText() == "EJ VALD" || lblfromdate.getText() == "EJ VALD" || lblcabinto.getText() == "EJ VALD" || lblcabinfrom.getText() == "EJ VALD" || lblfoodfrom.getText() == "EJ VALD" || Objects.equals(lblfoodto.getText(), "EJ VALD") || MarsTravelApplication.hotel.gettype() == "EJ VALD") {
                lblError.setText("FEL! Alla alternativ måste väljas");
            }
            else {
                try {
                    saved = true;
                    Path path = Path.of("bookings.txt");
                    if (!Files.exists(path)) {
                        Files.createFile(path);
                    }
                    String movieString = lblreturndate.getText() + ";" + lblfromdate.getText() + ";" + lblcabinto.getText() + ";" + lblcabinfrom.getText() + ";" + lblfoodfrom.getText() + ";" + lblfoodto.getText() + ";" + MarsTravelApplication.bookingToMars._movieTickets + ";" + MarsTravelApplication.bookingToMars._theatreTickets + ";" + MarsTravelApplication.bookingToMars._concertTickets + ";" + MarsTravelApplication.bookingFromMars._movieTickets + ";" + MarsTravelApplication.bookingFromMars._theatreTickets + ";" + MarsTravelApplication.bookingFromMars._concertTickets + ";" + lblpaycard.getText() + ";" + lbltravelers.getText() + ";" + MarsTravelApplication.hotel.gettype();
                    Files.write(path, (movieString + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                } catch (Exception e) {
                    lblError.setText("FEL! Bokning gick fel");
                }
            }
        }
        else lblError.setText("FEL! Redan sparad");
    }

    @FXML
    public void openPrevious(ActionEvent event) throws IOException {
        MarsTravelApplication.logic.openScene(event, "CreditCard.fxml");
    }
}
