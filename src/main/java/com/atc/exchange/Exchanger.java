package com.atc.exchange;

import java.util.List;

public class Exchanger {
    protected static List<Object> exportData;
    protected static List<Object> importData;

    public Exchanger() {
    }

    protected static Object getExportData() {
        return exportData;
    }

    protected static void setExportData(List<Object> exportData) {
        Exchanger.exportData = exportData;
    }

    protected static List<Object> getImportData() {
        return importData;
    }

    protected static void setImportData(List<Object> importData) {
        Exchanger.importData = importData;
    }
}
