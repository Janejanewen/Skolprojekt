package com.example.marstravels;

import javaClass.PersonalData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class PersonalDataController {
    @FXML
    private TabPane tabPersonData;
    @FXML
    private Button btnNext;

    @FXML
    private CheckBox chexInsurance;

    @FXML
    private TextField labAdress;

    @FXML
    private TextField labEmail;

    @FXML
    private TextField labNamn;

    @FXML
    private TextField labOrt;

    @FXML
    private TextField labPersonNo;

    @FXML
    private TextField labPostNO;

    @FXML
    private TextField labTele;

    @FXML
    private TextArea txtHeathDetaljer;

    @FXML
    private void openPreviousScene(ActionEvent event) throws IOException {
        saveData();
        MarsTravelApplication.logic.openScene(event, "EventsOnBoard.fxml");
    }

    @FXML
    private void openNextScene(ActionEvent event) throws IOException
    {
        saveData();
        MarsTravelApplication.logic.openScene(event, "CreditCard.fxml");
    }

    //********
    public void copyCurrentTab(TabPane tabPane, int numCopies) {
        Tab currentTab = tabPane.getSelectionModel().getSelectedItem();

        for (int i = 1; i <= numCopies; i++) {
            Tab tab = new Tab(currentTab.getText() + " " + (i + 1));

            try {
                FXMLLoader clonedLoader = new FXMLLoader(getClass().getResource("PersonDataForm.fxml"));
                Parent clonedContent = clonedLoader.load();
                Node clonedNode = clonedLoader.getRoot();
                clonedNode.setId("New" + i);
                tab.setContent(clonedContent);

                tabPane.getTabs().add(tabPane.getSelectionModel().getSelectedIndex() + i, tab);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //*********

    @FXML
    private void handleCopyButton() {
        int numCopies = MarsTravelApplication.personAmount - 1;
        copyCurrentTab(tabPersonData, numCopies);
    }

    //******* Spara PersonalData ******
    public void saveData() {
        for (int i = 0; i < MarsTravelApplication.personAmount; i++)
        {
            Tab tab = tabPersonData.getTabs().get(i);
            AnchorPane anchorPane = (AnchorPane) tab.getContent();
            PersonalData person = new PersonalData(
                    ((TextField) anchorPane.lookup("#labNamn")).getText(),
                    ((TextField) anchorPane.lookup("#labAdress")).getText(),
                    ((TextField) anchorPane.lookup("#labOrt")).getText(),
                    ((TextField) anchorPane.lookup("#labPersonNo")).getText(),
                    ((TextField) anchorPane.lookup("#labEmail")).getText(),
                    ((TextArea) anchorPane.lookup("#txtHeathDetaljer")).getText(),
                    ((CheckBox) anchorPane.lookup("#chexInsurance")).isSelected(),
                    ((TextField) anchorPane.lookup("#labPostNO")).getText(),
                    ((TextField) anchorPane.lookup("#labTele")).getText()
            );
            MarsTravelApplication.persons.set(i, person);
        }
    }


    @FXML
    public void initialize() throws IOException {
        handleCopyButton();
        iniData();
        if(MarsTravelApplication.personAmount>1){
            tabIsSelect();
        }
    }

    public void iniData()
    {   labNamn.setText(MarsTravelApplication.persons.get(0)._Name);
        labAdress.setText(MarsTravelApplication.persons.get(0)._adress);
        labOrt.setText(MarsTravelApplication.persons.get(0)._cityName);
        labPersonNo.setText(MarsTravelApplication.persons.get(0)._personNumber);
        labEmail.setText(MarsTravelApplication.persons.get(0)._mailAdress);
        txtHeathDetaljer.setText(MarsTravelApplication.persons.get(0)._healthDetails);
        chexInsurance.setSelected(MarsTravelApplication.persons.get(0)._healthInsurance);
        labPostNO.setText(MarsTravelApplication.persons.get(0)._postNumber);
        labTele.setText(MarsTravelApplication.persons.get(0)._phoneNumber);
    }

    public void tabIsSelect() {
        Tab currentTab = tabPersonData.getSelectionModel().getSelectedItem();
        for (int i = 1; i < MarsTravelApplication.personAmount; i++) {
            Tab tab = tabPersonData.getTabs().get(i);
            if (tab == currentTab) {
                continue;
            }
            try {
                FXMLLoader clonedLoader = new FXMLLoader(getClass().getResource("PersonDataForm.fxml"));
                Parent clonedContent = clonedLoader.load();
                Node clonedNode = clonedLoader.getRoot();
                clonedNode.setId("New" + i);

                PersonalData person = MarsTravelApplication.persons.get(i);

                TextField labNamn = (TextField) clonedNode.lookup("#labNamn");
                labNamn.setText(person._Name);

                TextField labAdress = (TextField) clonedNode.lookup("#labAdress");
                labAdress.setText(person._adress);

                TextField labOrt = (TextField) clonedNode.lookup("#labOrt");
                labOrt.setText(person._cityName);

                TextField labPersonNo = (TextField) clonedNode.lookup("#labPersonNo");
                labPersonNo.setText(person._personNumber);

                TextField labEmail = (TextField) clonedNode.lookup("#labEmail");
                labEmail.setText(person._mailAdress);

                TextArea txtHeathDetaljer = (TextArea) clonedNode.lookup("#txtHeathDetaljer");
                txtHeathDetaljer.setText(person._healthDetails);

                CheckBox chexInsurance = (CheckBox) clonedNode.lookup("#chexInsurance");
                chexInsurance.setSelected(person._healthInsurance);

                TextField labPostNO = (TextField) clonedNode.lookup("#labPostNO");
                labPostNO.setText(person._postNumber);

                TextField labTele = (TextField) clonedNode.lookup("#labTele");
                labTele.setText(person._phoneNumber);

                tab.setContent(clonedContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

