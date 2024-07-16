package com.example.marstravels;
import javaClass.Cabin;
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

public class CabinAlternativesInformationController {

    @FXML
    private TextArea SvitTxt;

    @FXML
    private TextArea SpacesideTxt;

    @FXML
    private TextArea InsideTxt;

    @FXML
    private TextArea EconomyTxt;

    @FXML
    private TextArea SomnkapselTxt;


    private final Repository repository = new Repository();

    @FXML
    public void cabinView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CabinAlternatives.fxml"));
        Scene bookingScene = new Scene(loader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(bookingScene);
        window.show();

    }

    private void display() {
        List<Cabin> cabins = repository.getcabins();
        for (Cabin cabin : cabins)
            if (cabin.getId() == 1) {
                SvitTxt.setText
                        (cabin.getInformation());
            }
            else if (cabin.getId() == 2) {
                SpacesideTxt.setText
                        (cabin.getInformation());
            }
            else if (cabin.getId() == 3) {
                InsideTxt.setText
                        (cabin.getInformation());
            }
            else if (cabin.getId() == 4) {
                EconomyTxt.setText
                        (cabin.getInformation());
            }
            else if (cabin.getId() == 5) {
                SomnkapselTxt.setText
                        (cabin.getInformation());
            }
    }

        @FXML
        public void initialize ()
        {
            display();
        }

}
