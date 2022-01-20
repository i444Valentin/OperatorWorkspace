package com.atc.сontrollers;

import com.atc.exchange.Exchanger;
import com.atc.importing.ImportCSVAbonents;
import com.atc.tableviews.TableViewAbonent;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ControllerImportData extends Exchanger{

    @FXML
    private RadioButton abonentsTableRadioButton;

    @FXML
    private ToggleGroup tables;

    @FXML
    private RadioButton phonesTableRadioButton;

    @FXML
    private RadioButton tariffsTableRadioButton;

    @FXML
    private TextField pathTxtFld;

    @FXML
    private Button selectPathToOpenButton;

    @FXML
    private Button importButton;

    @FXML
    void buttonClickImport(ActionEvent event) {
        Path path = Paths.get(pathTxtFld.getText());
        RadioButton selected = (RadioButton) tables.getSelectedToggle();
        String value = selected.getText();


        ImportCSVAbonents importCSVAbonents = new ImportCSVAbonents();
        ObservableList<TableViewAbonent> tableViewAbonents = null;

        try {
            tableViewAbonents = importCSVAbonents.readAll(path);
        } catch (Exception e) {
            AlertMessage.showAlert(Alert.AlertType.ERROR,
                    "Не удалось завершить импорт. Убедитесь, что имя файла введено верно и к каталогу есть доступ.",
                    "Ошибка импорта",
                    "");
        }
        List<Object> listTables = new ArrayList();
        listTables.add(tableViewAbonents);
        Exchanger.importData = listTables;
        pathTxtFld.getScene().getWindow().hide();
    }

    @FXML
    void buttonClickOpenSaveFileDialog(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Выбрать местоположение сохраненного файла");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV File", "*.csv"),
                new FileChooser.ExtensionFilter("Text File", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File fileSelected = chooser.showOpenDialog(pathTxtFld.getScene().getWindow());
        if (fileSelected !=null){
            pathTxtFld.setText(fileSelected.getPath());
        }
    }
}

