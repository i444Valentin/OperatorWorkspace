package com.atc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/scenes/start.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Автоматизированное рабочее место оператора АТС");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        System.out.println("Ready");
    }

    public static void main(String[] args) {
        launch(args);
    }
}