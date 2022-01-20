package com.atc.сontrollers;

import com.atc.exchange.Exchanger;
import com.atc.exporting.ExportCSVAbonents;
import com.atc.tableviews.TableViewAbonent;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ControllerExportData extends Exchanger{


    @FXML
    private ToggleGroup tables;

    @FXML
    private TextField pathTxtFld;

    @FXML
    private Button selectPathToSaveButton;

    @FXML
    private Button exportButton;



    @FXML
    void buttonClickExport(ActionEvent event) {
        Path path = Paths.get(pathTxtFld.getText());
        Object o = Exchanger.exportData.get(0);
        ObservableList<TableViewAbonent> tableViewAbonents = (ObservableList<TableViewAbonent>) o;
        RadioButton selected = (RadioButton) tables.getSelectedToggle();
        String value = selected.getText();

        try{
            ExportCSVAbonents exportCSV = new ExportCSVAbonents(path,tableViewAbonents);
            exportCSV.export();
            AlertMessage.showAlert(Alert.AlertType.INFORMATION,
                    "Экспорт завершен.",
                    "Экспорт",
                    "");


        } catch (CsvRequiredFieldEmptyException e) {
            AlertMessage.showAlert(Alert.AlertType.ERROR,"Не удалось сохранить csv-файл","Ошибка сохранения","");
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            AlertMessage.showAlert(Alert.AlertType.ERROR,"Не удалось сохранить csv-файл","Ошибка сохранения","");
            e.printStackTrace();
        } catch (IOException e) {
            AlertMessage.showAlert(Alert.AlertType.ERROR,
                    "Не удалось сохранить csv-файл. Убедитесь, что имя файла введено верно и к каталогу есть доступ.",
                    "Ошибка сохранения",
                    "");
            e.printStackTrace();
        }
    }

    @FXML
    void buttonClickOpenSaveFileDialog(ActionEvent event) {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Выбрать местоположение экспорта");
            chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV File", "*.csv"),
                new FileChooser.ExtensionFilter("Text File", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
            File fileSelected = chooser.showSaveDialog(pathTxtFld.getScene().getWindow());
            if (fileSelected !=null){
                pathTxtFld.setText(fileSelected.getPath());
            }
    }

}