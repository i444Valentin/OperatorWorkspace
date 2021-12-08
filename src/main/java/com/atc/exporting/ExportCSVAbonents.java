package com.atc.exporting;

import com.atc.csvbeans.AbonentCsvBean;
import com.atc.exporting.mapping_strategies.CustomMappingStrategy;
import com.atc.tableviews.TableViewAbonent;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExportCSVAbonents {

    private StatefulBeanToCsv sbc;
    private Writer writer;
    private List<AbonentCsvBean> list;
    public ExportCSVAbonents(Path path, List<TableViewAbonent> exportList) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CustomMappingStrategy<AbonentCsvBean> mappingStrategy = new CustomMappingStrategy<AbonentCsvBean>();
        mappingStrategy.setType(AbonentCsvBean.class);
        writer  = new FileWriter(path.toString());

        sbc = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR).withMappingStrategy(mappingStrategy)
                .build();
        list = new ArrayList<>();
        for (TableViewAbonent abonent: exportList){
            list.add(new AbonentCsvBean(abonent.getId(),abonent.getFirstName(),abonent.getLastName(),abonent.getPatronymic(),abonent.getBirthDate(),abonent.getGender()));
        }
    }

    public void export() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        sbc.write(list);
        writer.close();
    }
}
