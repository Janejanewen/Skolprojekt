package com.example.marstravels;

import javaClass.PersonalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StartsidaController {



    @FXML
    private Button btnloggain;

    @FXML
    private void openNextScene(ActionEvent event) throws IOException {
        MarsTravelApplication.logic.openScene(event, "StartBooking.fxml");
    }

    private Repository repository = new Repository();

    @FXML
    void initialize() {
        //RESETTAR HELA
        MarsTravelApplication.logic = new MarsTravelApplicationLogic();

        MarsTravelApplication.bookingToMars = new Booking();
        MarsTravelApplication.bookingFromMars = new Booking();

        MarsTravelApplication.personAmount = 0;
        MarsTravelApplication.persons = new ArrayList<>();
        MarsTravelApplication.payCard = 20000;

        MarsTravelApplication.isBookingToMars = true;

        MarsTravelApplication.previousScene = null;

        //förhandsval
        MarsTravelApplication.hotel = repository.hotel1;
        MarsTravelApplication.bookingToMars._cabin = repository.cabin1;
        MarsTravelApplication.bookingFromMars._cabin = repository.cabin1;
        MarsTravelApplication.bookingToMars._foodPackage = repository.budget1;
        MarsTravelApplication.bookingFromMars._foodPackage = repository.budget1;
        MarsTravelApplication.bookingToMars._departureDate = LocalDate.now().withDayOfMonth(1).plusMonths(1);
        MarsTravelApplication.bookingFromMars._departureDate = LocalDate.now().withDayOfMonth(1).plusMonths(7);



    }
}

