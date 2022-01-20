package com.atc.importing;

import com.atc.csvbeans.AbonentCsvBean;
import com.atc.tableviews.TableViewAbonent;
import com.opencsv.CSVReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImportCSVAbonents {
    private Reader reader;
    private List<AbonentCsvBean> list;
    public ObservableList<TableViewAbonent> readAll(Path path) throws Exception {
        reader = Files.newBufferedReader(path);
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list;
        list = csvReader.readAll();

        reader.close();
        csvReader.close();
        list.remove(0);
        ObservableList<TableViewAbonent> abonentsList= FXCollections.observableArrayList();
        for (String[] strings : list) {
            abonentsList.add(new TableViewAbonent(Integer.valueOf(strings[0]), strings[1], strings[2], strings[3], strings[4], strings[5]));
        }

        return abonentsList;
    }
}
