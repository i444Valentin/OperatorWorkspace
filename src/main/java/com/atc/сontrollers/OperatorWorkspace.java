package com.atc.сontrollers;

import com.atc.entity.AbonentsEntity;
import com.atc.exchange.Exchanger;
import com.atc.mapping.AbonentsTable;
import com.atc.services.AbonentService;
import com.atc.tableviews.*;
import com.atc.exporting.ExportCSVAbonents;
import com.atc.utils.SceneLoader;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OperatorWorkspace extends Exchanger {

    protected static Scene authorizationScene;

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
    private TableColumn<TableViewAbonent, String> abBirthDateColumn;

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
    private TableColumn<TableViewPhone, Integer> phoneNumberColumn;

    @FXML
    private TableColumn<TableViewPhone, String> phoneAbonentColumn;

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
        setEditableAbonentsTableView();
        getAbonents();
        putInTableAbonents(AbonentsTableView,abonentsListTable);
    }

    private void putInTableAbonents(TableView<TableViewAbonent> tableView, ObservableList<TableViewAbonent> observableList) {
        tableView.setItems(observableList);
    }


    @FXML
    void buttonClickCancelSearch(MouseEvent event) {

    }

    @FXML
    void buttonClickDataExport(ActionEvent event) {
        Exchanger.data = abonentsListTable;
        SceneLoader.load("/scenes/export_data.fxml",true,false,"Экспорт данных");


    }

    @FXML
    void buttonClickDataImport(ActionEvent event) {
        Path path = Paths.get("C:/Users/Walentin/Desktop/writtenBean.csv");
        try {
            ExportCSVAbonents exportCSV = new ExportCSVAbonents(path,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void buttonClickDbSave(ActionEvent event) {
        AbonentsTableView.sort();
        String selectedTabName = operatorWorkspaceTabs.getSelectionModel().getSelectedItem().getId();
        switch(selectedTabName){
            case "AbonentsTab":
                System.out.println("Save table Abonents");
                break;
            case "PhonesTab":
                System.out.println("Save table Phones");
                break;
            case "TariffsTab":
                System.out.println("Save table Tariffs");
            case "RegPhonesTab":
                AlertMessage.showAlert(Alert.AlertType.WARNING,
                        "Таблица не редактируется",
                        "Ошибка сохранения",
                        "Вы не можете сохранить эту таблицу, так как она защищена от изменений.");
            default:
                System.out.println("Target tab not defied");
        }

    }

    @FXML
    void buttonClickDbUpdate(ActionEvent event) {
        AbonentsTableView.sort();
        System.out.println(abonentsListTable);
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
        searchTextTxtFld.getScene().getWindow().hide();
        SceneLoader.load("/scenes/start.fxml",false,false,"Авторизация оператора");

    }

    private void initializeAbonentsTableView() {
        abFNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        abLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        abPatronymicColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        abBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        abGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        AbonentsTableView.setRowFactory(param -> {
            TableRow<TableViewAbonent> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if ((event.getClickCount() == 1)) {
                    //create a new Item and initialize it ...
                    if (!abonentsListTable.get(abonentsListTable.size() - 1).isNullFields()) {
                        AbonentsTableView.getItems().add(new TableViewAbonent());
                    }
                }
            });
            abFNameColumn.setOnEditCommit(event -> {
            });

            return row;
        });
    }

    /**
     * Возвращает данные абонентов из базы данных
     */
    private void getAbonents() {
        AbonentService abonentService = new AbonentService();
        List<AbonentsEntity> abonentsList = abonentService.findAllAbonents();
        abonentsListTable = FXCollections.observableArrayList();
        AbonentsTable abonentsTable = new AbonentsTable(abonentsList,abonentsListTable);
        abonentsListTable = (ObservableList<TableViewAbonent>) abonentsTable.map();
    }

    private void setEditableAbonentsTableView() {
        abFNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        abFNameColumn.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setFirstName(e.getNewValue());
        });

        abLNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        abLNameColumn.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setLastName(e.getNewValue());
        });

        abPatronymicColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        abPatronymicColumn.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPatronymic(e.getNewValue());
        });

        abBirthDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        abBirthDateColumn.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setBirthDate(e.getNewValue());
        });

        abGenderColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        abGenderColumn.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setGender(e.getNewValue());
        });
    }
}

