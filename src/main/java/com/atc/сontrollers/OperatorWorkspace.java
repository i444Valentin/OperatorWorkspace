package com.atc.сontrollers;

import com.atc.entity.AbonentsEntity;
import com.atc.entity.PhonesEntity;
import com.atc.entity.RegistrationEntity;
import com.atc.entity.TariffsEntity;
import com.atc.exchange.Exchanger;
import com.atc.mapping.AbonentsMapper;
import com.atc.mapping.PhonesMapper;
import com.atc.mapping.RegistrationMapper;
import com.atc.mapping.TariffsMapper;
import com.atc.services.AbonentService;
import com.atc.services.PhoneService;
import com.atc.services.RegPhoneService;
import com.atc.services.TariffService;
import com.atc.tableviews.*;
import com.atc.utils.SceneLoader;
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

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private TableColumn<TableViewPhone, String> phoneTypeColumn;

    @FXML
    private TableColumn<TableViewPhone, String> phoneTariffColumn;

    @FXML
    private TableColumn<TableViewPhone, Integer> phoneDiscountColumn;

    @FXML
    private TableColumn<TableViewPhone, Long> idAbonentColumnH;

    @FXML
    private TableColumn<TableViewPhone, String> phoneMountColumn;

    @FXML
    private TableColumn<TableViewPhone, String> phoneMountTypeColumn;

    ObservableList<TableViewPhone> phonesListTable;
    //PhonesTab Section END

    //TariffsTab Section BEGIN
    @FXML
    private Tab TariffsTab;

    @FXML
    private TableView<TableViewTariff> TariffsTableView;

    @FXML
    private TableColumn<TableViewTariff, String> tariffNameColumn;

    @FXML
    private TableColumn<TableViewTariff, BigDecimal> tariffPriceColumn;

    @FXML
    private TableColumn<TableViewTariff, Integer> tariffMinutesColumn;

    ObservableList<TableViewTariff> tariffsListTable;
    //Tariffs Tab Section END

    //RegPhonesTab Section BEGIN
    @FXML
    private Tab RegPhonesTab;

    @FXML
    private TableView<TableViewRegistration> RegPhonesTableView;

    @FXML
    private TableColumn<TableViewRegistration, String> regOperatorColumn;

    @FXML
    private TableColumn<TableViewRegistration, Long> regPhoneNumberColumn;

    @FXML
    private TableColumn<TableViewRegistration, String> regDateRegColumn;

    @FXML
    private TableColumn<TableViewRegistration, Integer> regOperatorIDColumnH; // H is hidden column
    ObservableList<TableViewRegistration> registrationListTable;
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
    private Label notFoundSearch;

    @FXML
    void initialize() {
        initializeAbonentsTableView();
        setEditableAbonentsTableView();
        getAbonents();
        putInTableAbonents(AbonentsTableView, abonentsListTable);

        initializePhonesTableView();
        setEditablePhonesTableView();
        getPhones();
        putInTablePhones(PhonesTableView, phonesListTable);

        initializeTariffsTableView();
        setEditableTariffsTableView();
        getTariffs();
        putInTableTariffs();

        initializeRegistrationTableView();
        getRegistration();
        putInTableRegistration();
    }

    private void putInTableRegistration() {
        RegPhonesTableView.setItems(registrationListTable);

    }

    private void getRegistration() {
        RegPhoneService regPhoneService = new RegPhoneService();
        List<RegistrationEntity> registrationEntities = regPhoneService.findAllRegistrations();
        registrationListTable = FXCollections.observableArrayList();
        RegistrationMapper registrationMapper = new RegistrationMapper(registrationEntities,registrationListTable);
        registrationListTable = (ObservableList<TableViewRegistration>) registrationMapper.map();
    }

    private void initializeRegistrationTableView() {
        regPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        regOperatorColumn.setCellValueFactory(new PropertyValueFactory<>("operator"));
        regDateRegColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
    }

    private void putInTableTariffs() {
        TariffsTableView.setItems(tariffsListTable);
    }

    private void getTariffs() {
        TariffService tariffService = new TariffService();
        List<TariffsEntity> tariffsEntities = tariffService.findAllTariffs();
        tariffsListTable = FXCollections.observableArrayList();
        TariffsMapper mapper = new TariffsMapper(tariffsEntities, tariffsListTable);
        tariffsListTable = (ObservableList<TableViewTariff>) mapper.map();
    }

    private void setEditableTariffsTableView() {
    }

    private void initializeTariffsTableView() {
        tariffNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tariffPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tariffMinutesColumn.setCellValueFactory(new PropertyValueFactory<>("minutes"));

        TariffsTableView.setRowFactory(param -> {
            TableRow<TableViewTariff> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if ((event.getClickCount() == 1)) {
                    //create a new Item and initialize it ...
                    if (!tariffsListTable.get(tariffsListTable.size() - 1).isNullFields()) {
                        TariffsTableView.getItems().add(new TableViewTariff());
                    }
                }
            });
            return row;
        });
    }

    private void putInTablePhones(TableView<TableViewPhone> phonesTableView, ObservableList<TableViewPhone> phonesListTable) {
        phonesTableView.setItems(phonesListTable);
    }

    private void getPhones() {
        PhoneService phoneService = new PhoneService();
        List<PhonesEntity> phonesList = phoneService.findAllPhones();
        phonesListTable = FXCollections.observableArrayList();
        PhonesMapper phonesMapper = new PhonesMapper(phonesList, phonesListTable);
        phonesListTable = (ObservableList<TableViewPhone>) phonesMapper.map();
        System.out.println();
    }

    private void setEditablePhonesTableView() {
    }

    private void initializePhonesTableView() {
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        phoneAbonentColumn.setCellValueFactory(new PropertyValueFactory<>("abonent"));
        phoneTypeColumn.setCellValueFactory(new PropertyValueFactory<>("phoneType"));
        phoneTariffColumn.setCellValueFactory(new PropertyValueFactory<>("tariff"));
        phoneDiscountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        phoneMountColumn.setCellValueFactory(new PropertyValueFactory<>("mount"));
        phoneMountTypeColumn.setCellValueFactory(new PropertyValueFactory<>("mountType"));

        PhonesTableView.setRowFactory(param -> {
            TableRow<TableViewPhone> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if ((event.getClickCount() == 1)) {
                    //create a new Item and initialize it ...
                    if (!phonesListTable.get(phonesListTable.size() - 1).isNullFields()) {
                        PhonesTableView.getItems().add(new TableViewPhone());
                    }
                }
            });
            return row;
        });
    }

    private void putInTableAbonents(TableView<TableViewAbonent> tableView, ObservableList<TableViewAbonent> observableList) {
        tableView.setItems(observableList);
    }


    @FXML
    void buttonClickCancelSearch(MouseEvent event) {
        String textSelectedTab = operatorWorkspaceTabs.getSelectionModel().getSelectedItem().getText();
        searchCloseBtn.setVisible(false);
        searchBtn.setVisible(true);
        switch (textSelectedTab) {
            case "Абоненты":
                AbonentsTableView.setEditable(true);
                AbonentService abonentService = new AbonentService();

                List<AbonentsEntity> abonentsEntities = abonentService.findAllAbonents();
                AbonentsMapper abonentsMapper = new AbonentsMapper(abonentsEntities, abonentsListTable);

                abonentsListTable.clear();
                AbonentsTableView.refresh();
                abonentsListTable = (ObservableList<TableViewAbonent>) abonentsMapper.map();
                AbonentsTableView.setItems(abonentsListTable);
                notFoundSearch.setVisible(false);
        }

    }

    @FXML
    void buttonClickDataExport(ActionEvent event) {
        List<Object> listTables = new ArrayList();
        listTables.add(abonentsListTable);
        listTables.add(phonesListTable);
        listTables.add(tariffsListTable);
        listTables.add(registrationListTable);
        Exchanger.exportData = listTables;
        SceneLoader.load("/scenes/export_data.fxml", true, false, "Экспорт данных", true);


    }

    @FXML
    void buttonClickDataImport(ActionEvent event) {
        SceneLoader.load("/scenes/import_data.fxml", true, false, "Импорт данных", true);
        abonentsListTable = (ObservableList<TableViewAbonent>) Exchanger.importData.get(0);

        AbonentsTableView.refresh();
    }

    @FXML
    void buttonClickDbSave(ActionEvent event) {
        AbonentsTableView.sort();
        String selectedTabName = operatorWorkspaceTabs.getSelectionModel().getSelectedItem().getId();
        switch (selectedTabName) {
            case "AbonentsTab":
                AlertMessage.showAlert(Alert.AlertType.INFORMATION,
                        "Таблица " + operatorWorkspaceTabs.getSelectionModel().getSelectedItem().getText() +" была успешно сохранена.",
                        "Сохранение таблицы",
                        "");
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
        searchBtn.setVisible(false);
        searchCloseBtn.setVisible(true);
        String textSelectedTab = operatorWorkspaceTabs.getSelectionModel().getSelectedItem().getText();
        switch (textSelectedTab) {
            case "Абоненты":
                AbonentsTableView.setEditable(false);
                AbonentService abonentService = new AbonentService();
                String textInitials = searchTextTxtFld.getText();
                String[] arrayInitials = textInitials.split(" ");
                String textFirstName = arrayInitials[0];
                String textLastName = arrayInitials[1];
                String textPatronymic = arrayInitials[2];
                List<AbonentsEntity> abonentsEntities = abonentService.findByInitials(textFirstName, textLastName, textPatronymic);
                AbonentsMapper abonentsMapper = new AbonentsMapper(abonentsEntities, abonentsListTable);

                abonentsListTable.clear();
                AbonentsTableView.refresh();
                abonentsListTable = (ObservableList<TableViewAbonent>) abonentsMapper.map();
                AbonentsTableView.setItems(abonentsListTable);
                if (AbonentsTableView.getItems().isEmpty()) {
                    notFoundSearch.setVisible(true);
                }
        }
    }

    @FXML
    void keyEnterPressedGoSearch(KeyEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {
        searchTextTxtFld.getScene().getWindow().hide();
        SceneLoader.load("/scenes/start.fxml", false, false, "Авторизация оператора", false);

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
        AbonentsMapper abonentsTable = new AbonentsMapper(abonentsList, abonentsListTable);
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

