package com.example.marstravels;

import javaClass.PersonalData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;

public class StartBookingController {

    @FXML
    private Button btnLoggaUt;

    @FXML
    private Button btnNext;

    private ObservableList<Integer> persons =
            FXCollections.observableArrayList(
                    1, 2, 3, 4, 5
            );

    @FXML
    private ChoiceBox<Integer> cbChoice;

    @FXML
    private DatePicker dateReturn = new DatePicker();

    @FXML
    private DatePicker dateStart = new DatePicker();


    @FXML
    void initialize()
    {
        if (MarsTravelApplication.personAmount == 0)
            cbChoice.setValue(1);
        else
            cbChoice.setValue(MarsTravelApplication.personAmount);
        cbChoice.setItems(persons);
        if (MarsTravelApplication.bookingToMars._departureDate != null)
            dateStart.setValue(MarsTravelApplication.bookingToMars._departureDate);
        if (MarsTravelApplication.bookingFromMars._departureDate != null)
            dateReturn.setValue(MarsTravelApplication.bookingFromMars._departureDate);

    }

    private void saveChoices() {
        MarsTravelApplication.personAmount = cbChoice.getValue();
        for (int i = 0; i < MarsTravelApplication.personAmount; i ++)
        {
            MarsTravelApplication.persons.add(new PersonalData("Namn", "Adress",
                    "Ort",
                    "Personnummer", "Mail",
                    "Vilken/vilka sjukdom/sjukdomar har kunden?\nÄr kunden allergiskt mot någonting? ",
                    false, "Postnummer", "Mobilnummer"));
        }


        MarsTravelApplication.bookingToMars._departureDate = dateStart.getValue();
        MarsTravelApplication.bookingFromMars._departureDate = dateReturn.getValue();
    }

    @FXML
    private void openNextScene(ActionEvent event) throws IOException {
        saveChoices();
        MarsTravelApplication.logic.openScene(event, "CabinAlternatives.fxml");
    }

    @FXML
    public void openPreviousScene(ActionEvent event) throws IOException {
        MarsTravelApplication.logic.openScene(event, "Startsida.fxml");

    }
}
