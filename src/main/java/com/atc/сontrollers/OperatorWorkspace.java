package com.atc.сontrollers;

import com.atc.entity.AbonentsEntity;
import com.atc.services.AbonentService;
import com.atc.tableviews.TableViewAbonent;
import com.atc.tableviews.TableViewPhone;
import com.atc.tableviews.TableViewRegistration;
import com.atc.tableviews.TableViewTariff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.Date;
import java.util.List;

public class OperatorWorkspace {

    @FXML
    private TabPane operatorWorkspaceTabs;

    //Abonents Tab Section BEGIN
    @FXML
    private Tab AbonentsTab;

    @FXML
    private TableView<TableViewAbonent> AbonentsTableView;

    @FXML
    private TableColumn<TableViewAbonent, String> abFNameColumn;

    @FXML
    private TableColumn<TableViewAbonent, String> abLNameColumn;

    @FXML
    private TableColumn<TableViewAbonent, String> abPatronymicColumn;

    @FXML
    private TableColumn<TableViewAbonent, Date> abBirthDateColumn;

    @FXML
    private TableColumn<TableViewAbonent, String> abGenderColumn;

    ObservableList<TableViewAbonent> abonentsListTable;
    //Abonents Tab Section END

    //PhonesTab Section BEGIN
    @FXML
    private Tab PhonesTab;

    @FXML
    private TableView<TableViewPhone> PhonesTableView;

    @FXML
    private TableColumn<TableViewPhone, ?> phoneNumberColumn;

    @FXML
    private TableColumn<TableViewPhone, ?> phoneAbonentColumn;

    @FXML
    private TableColumn<TableViewPhone, ?> phoneTypeColumn;

    @FXML
    private TableColumn<TableViewPhone, ?> phoneTariffColumn;

    @FXML
    private TableColumn<TableViewPhone, ?> phoneDiscountColumn;

    @FXML
    private TableColumn<TableViewPhone, ?> idAbonentColumnH;

    @FXML
    private TableColumn<TableViewPhone, ?> phoneMountColumn;

    @FXML
    private TableColumn<TableViewPhone, ?> phoneMountTypeColumn;
    //PhonesTab Section END

    //TariffsTab Section BEGIN
    @FXML
    private Tab TariffsTab;

    @FXML
    private TableView<TableViewTariff> TariffsTableView;

    @FXML
    private TableColumn<TableViewTariff, ?> tariffNameColumn;

    @FXML
    private TableColumn<TableViewTariff, ?> tariffPriceColumn;

    @FXML
    private TableColumn<TableViewTariff, ?> tariffMinutesColumn;
    //Tariffs Tab Section END

    //RegPhonesTab Section BEGIN
    @FXML
    private Tab RegPhonesTab;

    @FXML
    private TableView<TableViewRegistration> RegPhonesTableView;

    @FXML
    private TableColumn<TableViewRegistration, ?> regOperatorColumn;

    @FXML
    private TableColumn<TableViewRegistration, ?> regPhoneNumberColumn;

    @FXML
    private TableColumn<TableViewRegistration, ?> regDateRegColumn;

    @FXML
    private TableColumn<TableViewRegistration, ?> regOperatorIDColumnH; // H is hidden column
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
    void initialize(){
        initializeAbonentsTableView();
        getAbonents();
    }




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

    private void initializeAbonentsTableView() {
        abFNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        abLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        abPatronymicColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        abBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        abGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    private void getAbonents() {
        AbonentService abonentService = new AbonentService();
        List<AbonentsEntity> abonentsList = abonentService.findAllAbonents();
        abonentsListTable = FXCollections.observableArrayList();
        for (AbonentsEntity abonentsEntity : abonentsList){

            String gender;
            if (abonentsEntity.isПол()){
                gender="мужской";
            }else{
                gender = "женский";
            }

            String date;
            date = abonentsEntity.getДатарождения().toString();
            TableViewAbonent tableViewAbonent = new TableViewAbonent(
                    abonentsEntity.getИмя(),
                    abonentsEntity.getФамилия(),
                    abonentsEntity.getОтчество(),
                    date,
                    gender);
            abonentsListTable.add(tableViewAbonent);
        }
        AbonentsTableView.setItems(abonentsListTable);

    }
}

