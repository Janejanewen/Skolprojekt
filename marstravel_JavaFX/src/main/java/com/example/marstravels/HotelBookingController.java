package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HotelBookingController {

    private Repository repository = new Repository();

    @FXML
    private ToggleGroup HotelButtons;

    @FXML
    private ImageView LeftImageView;

    @FXML
    private ImageView RightImageView;

    @FXML
    private RadioButton btnAtman;

    @FXML
    private Button btnBack;

    @FXML
    private RadioButton btnFour;

    @FXML
    private RadioButton btnHilton;

    @FXML
    private Button btnInformation;

    @FXML
    private RadioButton btnJin;

    @FXML
    private RadioButton btnMarriot;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnShop;


    @FXML
    void openPreviousScene(ActionEvent event) throws IOException {
        saveChoice();
        MarsTravelApplication.logic.openScene(event, "EventsOnBoard.fxml");
    }

    @FXML
    void openShoppingCart(ActionEvent event) throws IOException {
        saveChoice();
        MarsTravelApplication.previousScene = "HotelBooking.fxml";
        MarsTravelApplication.logic.openScene(event, "ShoppingCart.fxml");
    }


    public void changeHotelImage(ActionEvent event) throws IOException {

        if (btnHilton.isSelected()) {
            Image myImage1 = new Image(getClass().getResourceAsStream("/assets/HotelBooking/ImageRightHilton.jpg"));
            RightImageView.setImage(myImage1);
        } else if (btnAtman.isSelected()) {
            Image myImage2 = new Image(getClass().getResourceAsStream("/assets/HotelBooking/ImageRight6.png"));
            RightImageView.setImage(myImage2);
        } else if (btnFour.isSelected()) {
            Image myImage3 = new Image(getClass().getResourceAsStream("/assets/HotelBooking/ImageRight7.png"));
            RightImageView.setImage(myImage3);
        } else if (btnJin.isSelected()) {
            Image myImage4 = new Image(getClass().getResourceAsStream("/assets/HotelBooking/ImageRight9.png"));
            RightImageView.setImage(myImage4);
        } else if (btnMarriot.isSelected()) {
            Image myImage5 = new Image(getClass().getResourceAsStream("/assets/HotelBooking/ImageRight8.png"));
            RightImageView.setImage(myImage5);
        }
    }


    @FXML
    public void hotelInformationView(ActionEvent event) throws IOException {
        saveChoice();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HotelBookingInformation.fxml"));
        Scene bookingScene = new Scene(loader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(bookingScene);
        window.show();

    }

    @FXML
    void initialize() {
        if (MarsTravelApplication.hotel != null) {
            switch (MarsTravelApplication.hotel.gettype()) {
                case "Hilton" -> btnHilton.setSelected(true);
                case "Atman Resorts" -> btnAtman.setSelected(true);
                case "Four Seasons" -> btnFour.setSelected(true);
                case "Jin Jiang" -> btnJin.setSelected(true);
                case "Marriot" -> btnMarriot.setSelected(true);
            }
        }
        MarsTravelApplication.isBookingToMars = true;
    }

    @FXML
    private void openNextScene(ActionEvent event) throws IOException {
        saveChoice();
        MarsTravelApplication.isBookingToMars = false;
        MarsTravelApplication.logic.openScene(event, "CabinAlternatives.fxml");
    }

    private void saveChoice() {
        RadioButton selectedRadioButton = (RadioButton) HotelButtons.getSelectedToggle();
        if (selectedRadioButton != null) {
            Scanner scanner = new Scanner(selectedRadioButton.getId());

            String id = scanner.next();
            switch(id) {
                case "btnAtman" -> MarsTravelApplication.hotel = repository.hotel2;
                case "btnJin" -> MarsTravelApplication.hotel = repository.hotel4;
                case "btnFour" -> MarsTravelApplication.hotel = repository.hotel3;
                case "btnHilton" -> MarsTravelApplication.hotel = repository.hotel1;
                case "btnMarriot" -> MarsTravelApplication.hotel = repository.hotel5;
            }
        }
    }
}
