package com.example.marstravels;

import javaClass.Cabin;
import javaClass.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class EventsOnBoardINFOController {

    @FXML
    private TextArea txtFilm;

    @FXML
    private TextArea txtKonsert;

    @FXML
    private TextArea txtTeat;

    @FXML
    public void openPreviousScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EventsOnBoard.fxml"));
        Scene chosenScene = new Scene(loader.load(), 600, 400);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(chosenScene);
        window.show();
    }
    private final Repository repository = new Repository();
    private void display()
    { List<Event> events = repository.getEvents();
        for (Event event : events)
        {
            if(event.getId()==1)
            {
                txtFilm.setText
                        (event.getInfo());
            } else if(event.getId()==2)
            {
                txtKonsert.setText
                        (event.getInfo());
            } else if(event.getId()==3)
            {
                txtTeat.setText
                        (event.getInfo());
            }
        }
    }
    @FXML
    public void initialize()
    {
        display();
    }



}