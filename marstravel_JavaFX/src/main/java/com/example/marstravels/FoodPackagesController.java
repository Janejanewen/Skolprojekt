package com.example.marstravels;

import javaClass.Cabin;
import javaClass.FoodPackage;
import javaClass.PersonalData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;

public class FoodPackagesController {

    @FXML
    private Label lblFromOrTo;

    @FXML
    private ImageView LeftImageView;

    @FXML
    private ImageView RightImageView;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnInfo;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnShoppingcart;

    @FXML
    private ChoiceBox<String> cbFoods;

    private Repository repository = new Repository();
    private List<FoodPackage> foods = repository.getFoods();

    private ObservableList<String> foodChoice = FXCollections.observableArrayList();

    @FXML
    private Label lblCabinAlternatives;

    @FXML
    private void openNextScene(ActionEvent event) throws IOException {
        selectButton();
        MarsTravelApplication.logic.openScene(event, "EventsOnBoard.fxml");
    }

    @FXML
    private void openPreviousScene(ActionEvent event) throws IOException {
        selectButton();
        MarsTravelApplication.logic.openScene(event, "CabinAlternatives.fxml");
    }

    @FXML
    private void openInformationScene(ActionEvent event) throws IOException {
        selectButton();
        MarsTravelApplication.logic.openScene(event, "FoodPackagesInformation.fxml");
    }

    @FXML
    private void openShoppingCart(ActionEvent event) throws IOException {
        selectButton();
        MarsTravelApplication.previousScene = "FoodPackages.fxml";
        MarsTravelApplication.logic.openScene(event, "ShoppingCart.fxml");
    }

    private void selectButton() {
        for (FoodPackage f : foods) {
            if ((f.getName() + " - " + (int) f.getPrice() + " :-").equals(cbFoods.getValue())) {
                if (MarsTravelApplication.isBookingToMars)
                    MarsTravelApplication.bookingToMars._foodPackage = f;
                else
                    MarsTravelApplication.bookingFromMars._foodPackage = f;
            }
        }
    }

    @FXML
    public void initialize()
    {
        if (!MarsTravelApplication.isBookingToMars)
            lblFromOrTo.setText("Returresa");

        for (FoodPackage f : foods) {
            foodChoice.add(f.getName() + " - " + (int) f.getPrice() + " :-");
        }
        cbFoods.setItems(foodChoice);
        if (MarsTravelApplication.isBookingToMars && MarsTravelApplication.bookingToMars._foodPackage != null) {
            cbFoods.setValue(MarsTravelApplication.bookingToMars._foodPackage.getName() +
                    " - " +
                    (int) MarsTravelApplication.bookingToMars._foodPackage.getPrice() +
                    " :-");
        } else {
            if (MarsTravelApplication.bookingFromMars._foodPackage != null) {
                cbFoods.setValue(MarsTravelApplication.bookingFromMars._foodPackage.getName() +
                        " - " +
                        (int) MarsTravelApplication.bookingFromMars._foodPackage.getPrice() +
                        " :-");
            }
        }
    }
}
