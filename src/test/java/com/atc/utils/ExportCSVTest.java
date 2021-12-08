package com.atc.utils;

import com.atc.exporting.ExportCSVAbonents;
import com.atc.tableviews.TableViewAbonent;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ExportCSVTest {
    @Test
    void testWrite() throws IOException, URISyntaxException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Path path = Paths.get("C:/Users/Walentin/Desktop/writtenBean.csv");
        List<TableViewAbonent> list = new ArrayList<>();
        list.add(new TableViewAbonent(1,"TestFirstName","TestSecondName","TestPatronymic","2000-01-01","male"));
        ExportCSVAbonents exportCSV = new ExportCSVAbonents(path,list);
        exportCSV.export();
    }
}