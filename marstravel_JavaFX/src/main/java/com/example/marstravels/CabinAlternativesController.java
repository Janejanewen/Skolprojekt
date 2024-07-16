package com.example.marstravels;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javaClass.Cabin;


import java.io.IOException;
import java.util.List;

public class CabinAlternativesController {

    private final Repository repository = new Repository();

    @FXML
    private ToggleGroup CabinButtons;

    @FXML
    private Button btnInformation1;

    @FXML
    private Button btnBack;

    @FXML
    private RadioButton btnEconomy;

    @FXML
    private Button btnInformation;

    @FXML
    private Label lblToAndFrom;

    @FXML
    private RadioButton btnInside;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnShop;

    @FXML
    private RadioButton btnSomnkapsel;

    @FXML
    private RadioButton btnSpaceside;

    @FXML
    private RadioButton btnSvit;

    @FXML
    private ImageView myImageView;

    @FXML
    private Label lblCabinAlternatives;


    public void changeImage(ActionEvent event) throws IOException{

        if(btnSvit.isSelected()) {
            Image myImage1 = new Image(getClass().getResourceAsStream("/assets/CabinAlternatives/Svitbild1.png"));
            myImageView.setImage(myImage1);
        }

        else if(btnInside.isSelected()){
            Image myImage2 = new Image(getClass().getResourceAsStream("/assets/CabinAlternatives/Insidebild2.png"));
            myImageView.setImage(myImage2);
        }

        else if(btnEconomy.isSelected()){
            Image myImage3 = new Image(getClass().getResourceAsStream("/assets/CabinAlternatives/Economybild1.png"));
            myImageView.setImage(myImage3);
        }

        else if(btnSpaceside.isSelected()){
            Image myImage4 = new Image(getClass().getResourceAsStream("/assets/CabinAlternatives/Spacesidebild1.png"));
            myImageView.setImage(myImage4);
        }

        else if(btnSomnkapsel.isSelected()){
            Image myImage5 = new Image(getClass().getResourceAsStream("/assets/CabinAlternatives/kapselbild.png"));
            myImageView.setImage(myImage5);
        }
    }


    @FXML
    public void openNextScene(ActionEvent event) throws IOException {
        selectButton();
        MarsTravelApplication.logic.openScene(event, "FoodPackages.fxml");

    }


    private void display()
    { List<Cabin> cabins = repository.getcabins();
        for (Cabin cabin : cabins)
        {
            if(cabin.getId()==1)
            {
                btnSvit.setText
                        (cabin.gettype()+
                                " - "+cabin.getCapacity()+
                                "st - "+(int)cabin.getPrice()+" :-");
            } else if(cabin.getId()==2)
            {
                btnSpaceside.setText
                        (cabin.gettype()+
                                " - "+cabin.getCapacity()+
                                "st - "+(int)cabin.getPrice()+" :-");
            } else if(cabin.getId()==3)
            {
                btnInside.setText
                        (cabin.gettype()+
                                " - "+cabin.getCapacity()+
                                "st - "+(int)cabin.getPrice()+" :-");
            } else if(cabin.getId()==4)
            {
                btnEconomy.setText
                        (cabin.gettype()+
                                " - "+cabin.getCapacity()+
                                "st - "+(int)cabin.getPrice()+" :-");
            } else if(cabin.getId()==5)
            {
                btnSomnkapsel.setText
                        (cabin.gettype()+
                                " - "+cabin.getCapacity()+
                                "st - "+(int)cabin.getPrice()+" :-");
            }
        }
    }
    @FXML
    public void initialize()
    {
        display();

        if (!MarsTravelApplication.isBookingToMars)
            lblToAndFrom.setText("Returresa");

        String setCabin = null;
        if (MarsTravelApplication.isBookingToMars) {
            if (MarsTravelApplication.bookingToMars._cabin != null)
                setCabin = MarsTravelApplication.bookingToMars._cabin.gettype();
        } else {
            if (MarsTravelApplication.bookingFromMars._cabin != null)
                setCabin = MarsTravelApplication.bookingFromMars._cabin.gettype();
        }

        if (setCabin != null)
            switch (setCabin) {
                case "Svit" -> btnSvit.setSelected(true);
                case "Inside" -> btnInside.setSelected(true);
                case "Spaceside" -> btnSpaceside.setSelected(true);
                case "Economy" -> btnEconomy.setSelected(true);
                case "Sömnkapsel" -> btnSomnkapsel.setSelected(true);
            }
    }

    @FXML
    public void openPreviousScene(ActionEvent event) throws IOException {
        selectButton();
        String nextScene = "StartBooking.fxml";
        if(!MarsTravelApplication.isBookingToMars)
            nextScene = "HotelBooking.fxml";
        MarsTravelApplication.logic.openScene(event, nextScene);

    }

    @FXML
    public void openInformationScene(ActionEvent event) throws IOException {
        selectButton();
        MarsTravelApplication.logic.openScene(event, "CabinAlternativesInformation.fxml");
    }

    @FXML
    public void openShoppingCart(ActionEvent event) throws IOException {
        selectButton();
        MarsTravelApplication.previousScene = "CabinAlternatives.fxml";
        MarsTravelApplication.logic.openScene(event, "ShoppingCart.fxml");

    }

    private void selectButton() {
        MarsTravelApplication.logic.selectButton("Cabin", CabinButtons);
    }
}
