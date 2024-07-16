package com.example.marstravels;

import javaClass.Cabin;
import javaClass.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HotelBookingInformationController {

    @FXML
    private TextArea AtmanTxt;

    @FXML
    private TextArea FourTxt;

    @FXML
    private TextArea HiltonTxt;

    @FXML
    private TextArea JinTxt;

    @FXML
    private TextArea MarriotTxt;

    @FXML
    private ImageView RightImageView;

    @FXML
    private ImageView RightImageView1;

    @FXML
    private ImageView RightImageView11;

    @FXML
    private ImageView RightImageView12;

    @FXML
    private ImageView RightImageView13;

    @FXML
    private Button btnTllbaka;


    @FXML
    public void hotelView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HotelBooking.fxml"));
        Scene bookingScene = new Scene(loader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(bookingScene);
        window.show();

    }

    private final Repository repository = new Repository();
    private void display() {
        List<Hotel> hotels = repository.gethotels();
        for (Hotel hotel : hotels)
            if (hotel.getId() == 1) {
                HiltonTxt.setText
                        (hotel.getInformation());
            } else if (hotel.getId() == 2) {
                AtmanTxt.setText
                        (hotel.getInformation());
            } else if (hotel.getId() == 3) {
                FourTxt.setText
                        (hotel.getInformation());
            } else if (hotel.getId() == 4) {
                JinTxt.setText
                        (hotel.getInformation());
            } else if (hotel.getId() == 5) {
                MarriotTxt.setText
                        (hotel.getInformation());
            }
    }
    @FXML
    public void initialize ()
    {
        display();
    }

}
