package com.example.marstravels;

import javaClass.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class EventsOnBoardController {
    @FXML
    private ImageView LeftImageView;

    @FXML
    private ImageView RightImageView;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnShoppingcart;

    @FXML
    private Button btninfo3;

    @FXML
    private Button btntodoonboard;

    @FXML
    private Label lblCabinAlternatives;

    @FXML
    private Label lblFromOrTo;

    @FXML
    private Button btninfo1;

    @FXML
    private Button btninfo2;

    @FXML
    private Button btnnext;

    @FXML
    private Button btnprevious;

    @FXML
    private Button btnvarukorg;

    @FXML
    private Label lblToAndFrom;

    private ObservableList<Integer> ticketChoicesLong =
            FXCollections.observableArrayList(
                    0, 1, 2, 3, 4, 5, 6
            );
    private ObservableList<Integer> ticketChoicesShort =
            FXCollections.observableArrayList(
                    0, 1, 2, 3
            );

    @FXML
    void initialize() {
        filmchoice.setItems(ticketChoicesLong);
        filmchoice1.setItems(ticketChoicesShort);
        filmchoice2.setItems(ticketChoicesShort);

        if (MarsTravelApplication.isBookingToMars) {
            if (MarsTravelApplication.bookingToMars._movieTickets != 0)
                filmchoice.setValue(MarsTravelApplication.bookingToMars._movieTickets);
            else
                filmchoice.setValue(0);
            if (MarsTravelApplication.bookingToMars._concertTickets != 0)
                filmchoice1.setValue(MarsTravelApplication.bookingToMars._concertTickets);
            else
                filmchoice1.setValue(0);
            if (MarsTravelApplication.bookingToMars._theatreTickets != 0)
                filmchoice2.setValue(MarsTravelApplication.bookingToMars._theatreTickets);
            else
                filmchoice2.setValue(0);
        } else {
            lblFromOrTo.setText("Returresa");
            if (MarsTravelApplication.bookingFromMars._movieTickets != 0)
                filmchoice.setValue(MarsTravelApplication.bookingFromMars._movieTickets);
            else
                filmchoice.setValue(0);
            if (MarsTravelApplication.bookingFromMars._concertTickets != 0)
                filmchoice1.setValue(MarsTravelApplication.bookingFromMars._concertTickets);
            else
                filmchoice1.setValue(0);
            if (MarsTravelApplication.bookingFromMars._theatreTickets != 0)
                filmchoice2.setValue(MarsTravelApplication.bookingFromMars._theatreTickets);
            else
                filmchoice2.setValue(0);
        }
    }

    @FXML
    private ChoiceBox<Integer> filmchoice;

    @FXML
    private ChoiceBox<Integer> filmchoice1;

    @FXML
    private ChoiceBox<Integer> filmchoice2;

    @FXML
    private Label lblEvents;

    private void saveChoice() {
        if(MarsTravelApplication.isBookingToMars) {
            MarsTravelApplication.bookingToMars._movieTickets = filmchoice.getValue();
            MarsTravelApplication.bookingToMars._concertTickets = filmchoice1.getValue();
            MarsTravelApplication.bookingToMars._theatreTickets = filmchoice2.getValue();
        } else {
            MarsTravelApplication.bookingFromMars._movieTickets = filmchoice.getValue();
            MarsTravelApplication.bookingFromMars._concertTickets = filmchoice1.getValue();
            MarsTravelApplication.bookingFromMars._theatreTickets = filmchoice2.getValue();
        }
    }
    @FXML
    private void informationView(ActionEvent event) throws IOException {
        saveChoice();
        MarsTravelApplication.logic.openScene(event, "EventsOnBoardINFO.fxml");
    }

    @FXML
    private void openNextScene(ActionEvent event) throws IOException {
        saveChoice();
        String nextScene = "HotelBooking.fxml";
        if (!MarsTravelApplication.isBookingToMars)
            nextScene = "PersonalData.fxml";
        MarsTravelApplication.logic.openScene(event, nextScene);
    }

    @FXML
    private void openPreviousScene(ActionEvent event) throws IOException {
        saveChoice();
        MarsTravelApplication.logic.openScene(event, "FoodPackages.fxml");
    }

    @FXML
    private void openShoppingCart(ActionEvent event) throws IOException {
        saveChoice();
        MarsTravelApplication.previousScene = "EventsOnBoard.fxml";
        MarsTravelApplication.logic.openScene(event, "ShoppingCart.fxml");
    }

    @FXML
    private void openToDoOnBoard(ActionEvent event) throws IOException{
        saveChoice();
        MarsTravelApplication.logic.openScene(event, "ToDoOnBoard.fxml");
    }
}
