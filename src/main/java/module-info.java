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
    opens com.atc.tableviews to javafx.base;
    opens com.atc to javafx.fxml, javafx.base;
    opens com.atc.entity to org.hibernate.orm.core;
    exports com.atc;
    opens com.atc.dao to org.hibernate.commons.annotations,org.hibernate.orm.core;
    opens com.atc.сontrollers to javafx.fxml, javafx.controls, javafx.base,javafx.graphics;
    opens com.atc.utils to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;


}