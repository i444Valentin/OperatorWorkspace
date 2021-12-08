module com.atc {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires org.hibernate.commons.annotations;
    requires com.opencsv;
    requires org.apache.commons.lang3;
    opens com.atc.tableviews to javafx.base;
    opens com.atc.entity to org.hibernate.orm.core;
    opens com.atc.dao to org.hibernate.commons.annotations, org.hibernate.orm.core;
    opens com.atc.сontrollers to javafx.fxml, javafx.controls, javafx.base, javafx.graphics, java.base, com.opencsv;
    opens com.atc.utils to javafx.base, javafx.controls, javafx.fxml, javafx.graphics, com.opencsv, java.base;
    opens com.atc to com.opencsv, java.base, javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    opens com.atc.csvbeans to com.opencsv, java.base, javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    opens com.atc.exporting to com.opencsv, java.base, javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    exports com.atc;
    exports com.atc.utils;
    exports com.atc.сontrollers;
    exports com.atc.csvbeans;
    exports com.atc.tableviews;
    exports com.atc.exporting;


}