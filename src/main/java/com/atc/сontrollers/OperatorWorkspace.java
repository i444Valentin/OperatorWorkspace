package com.atc.сontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class OperatorWorkspace {

    @FXML
    private TabPane operatorWorkspaceTabs;

    //Abonents Tab Section BEGIN
    @FXML
    private Tab AbonentsTab;

    @FXML
    private TableView<?> AbonentsTableView;

    @FXML
    private TableColumn<?, ?> abFiNameColumn;

    @FXML
    private TableColumn<?, ?> abLNameColumn;

    @FXML
    private TableColumn<?, ?> abPatronymicColumn;

    @FXML
    private TableColumn<?, ?> abBirthDateColumn;

    @FXML
    private TableColumn<?, ?> abGenderColumn;
    //Abonents Tab Section END

    //PhonesTab Section BEGIN
    @FXML
    private Tab PhonesTab;

    @FXML
    private TableView<?> PhonesTableView;

    @FXML
    private TableColumn<?, ?> phoneNumberColumn;

    @FXML
    private TableColumn<?, ?> phoneAbonentColumn;

    @FXML
    private TableColumn<?, ?> phoneTypeColumn;

    @FXML
    private TableColumn<?, ?> phoneTariffColumn;

    @FXML
    private TableColumn<?, ?> phoneDiscountColumn;

    @FXML
    private TableColumn<?, ?> idAbonentColumnH;

    @FXML
    private TableColumn<?, ?> phoneMountColumn;

    @FXML
    private TableColumn<?, ?> phoneMountTypeColumn;
    //PhonesTab Section END

    //TariffsTab Section BEGIN
    @FXML
    private Tab TariffsTab;

    @FXML
    private TableView<?> TariffsTableView;

    @FXML
    private TableColumn<?, ?> tariffNameColumn;

    @FXML
    private TableColumn<?, ?> tariffPriceColumn;

    @FXML
    private TableColumn<?, ?> tariffMinutesColumn;
    //Tariffs Tab Section END

    //RegPhonesTab Section BEGIN
    @FXML
    private Tab RegPhonesTab;

    @FXML
    private TableView<?> RegPhonesTableView;

    @FXML
    private TableColumn<?, ?> regOperatorColumn;

    @FXML
    private TableColumn<?, ?> regPhoneNumberColumn;

    @FXML
    private TableColumn<?, ?> regDateRegColumn;

    @FXML
    private TableColumn<?, ?> regOperatorIDColumnH;
    //RegPhonesTab Section END

    @FXML
    private TextField searchTextTxtFld;

    @FXML
    private ImageView searchBtn;

    @FXML
    private ImageView searchCloseBtn;

    @FXML
    private Label currentOperatorLabel;

    @FXML
    void buttonClickCancelSearch(MouseEvent event) {

    }

    @FXML
    void buttonClickDataExport(ActionEvent event) {

    }

    @FXML
    void buttonClickDataImport(ActionEvent event) {

    }

    @FXML
    void buttonClickDbSave(ActionEvent event) {

    }

    @FXML
    void buttonClickDbUpdate(ActionEvent event) {
        System.out.println(operatorWorkspaceTabs.getSelectionModel().getSelectedItem().getId());

    }

    @FXML
    void buttonClickGoSearch(MouseEvent event) {

    }

    @FXML
    void keyEnterPressedGoSearch(KeyEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

}

