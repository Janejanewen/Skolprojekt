package com.example.marstravels;

import javaClass.Hotel;
import javaClass.PersonalData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarsTravelApplication extends Application {
    public static MarsTravelApplicationLogic logic;

    public static Booking bookingToMars;
    public static Booking bookingFromMars;

    public static int personAmount;
    public static List<PersonalData> persons;
    public static int payCard;
    public static Hotel hotel;

    public static boolean isBookingToMars;

    public static String previousScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MarsTravelApplication.class.getResource("Startsida.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Mars travels");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}