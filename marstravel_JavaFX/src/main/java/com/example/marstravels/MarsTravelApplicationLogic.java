package com.example.marstravels;

import javaClass.Cabin;
import javaClass.FoodPackage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class MarsTravelApplicationLogic {
    private Repository repository = new Repository();
    @FXML
    public void openScene(ActionEvent event, String scene) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        Scene chosenScene = new Scene(loader.load(), 600, 400);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(chosenScene);
        window.show();
    }

    public void selectButton(String choice, ToggleGroup toggleGroup) {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            Scanner scanner = new Scanner(selectedRadioButton.getId());

            String id = scanner.next();
            switch(choice) {
                case "Food" -> {
                    if(MarsTravelApplication.isBookingToMars) {
                        FoodPackage placeHolder = MarsTravelApplication.bookingToMars._foodPackage;

                        MarsTravelApplication.bookingToMars._foodPackage = setFoodPackage(id);

                        if (MarsTravelApplication.bookingToMars._foodPackage == null)
                            MarsTravelApplication.bookingToMars._foodPackage = placeHolder;
                    } else {
                        FoodPackage placeHolder = MarsTravelApplication.bookingFromMars._foodPackage;

                        MarsTravelApplication.bookingFromMars._foodPackage = setFoodPackage(id);

                        if (MarsTravelApplication.bookingFromMars._foodPackage == null)
                            MarsTravelApplication.bookingFromMars._foodPackage = placeHolder;
                    }
                }
                case "Cabin" -> {
                    if(MarsTravelApplication.isBookingToMars) {
                        Cabin placeHolder = MarsTravelApplication.bookingToMars._cabin;

                        MarsTravelApplication.bookingToMars._cabin = setCabin(id);

                        if (MarsTravelApplication.bookingToMars._cabin == null)
                            MarsTravelApplication.bookingToMars._cabin = placeHolder;
                    } else {
                        Cabin placeHolder = MarsTravelApplication.bookingFromMars._cabin;

                        MarsTravelApplication.bookingFromMars._cabin = setCabin(id);

                        if(MarsTravelApplication.bookingFromMars._cabin == null)
                            MarsTravelApplication.bookingFromMars._cabin = placeHolder;
                    }
                }
            }
        }
    }
    public FoodPackage setFoodPackage(String id) {
        switch(id) {
            case "rbBudget1" -> {
                return repository.budget1;
            }
            case "rbBudget2" -> {
                return repository.budget2;
            }
            case "rbBudget3" -> {
                return repository.budget3;
            }
            case "rbMellan1" -> {
                return repository.mellan1;
            }
            case "rbMellan2" -> {
                return repository.mellan2;
            }
            case "rbMellan3" -> {
                return repository.mellan3;
            }
            case "rbLyx1" -> {
                return repository.lyx1;
            }
            case "rbLyx2" -> {
                return repository.lyx2;
            }
            case "rbLyx3" -> {
                return repository.lyx3;
            }
        }
        return null;
    }

    public Cabin setCabin(String id) {
        switch(id) {
            case "btnSvit" -> {
                return repository.cabin1;
            }
            case "btnSpaceside" -> {
                return repository.cabin2;
            }
            case "btnInside" -> {
                return repository.cabin3;
            }
            case "btnEconomy" -> {
                return repository.cabin4;
            }
            case "btnSomnkapsel" -> {
                return repository.cabin5;
            }
        }
        return null;
    }
}
