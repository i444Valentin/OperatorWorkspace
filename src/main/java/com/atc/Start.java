package com.atc;

import com.atc.dao.AbonentDao;
import com.atc.entity.AbonentsEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("/scenes/start.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Автоматизированное рабочее место оператора АТС");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
//        Main.startHBT(new String[]{"1", "2"});
//        AbonentDao abonentDao = new AbonentDao();
//        List<AbonentsEntity> abonents = abonentDao.findAll();
//        System.out.println(abonents);
        System.out.println("Ready");
    }

    public static void main(String[] args) {
        launch(args);
    }
}