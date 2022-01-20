package com.atc.utils;

import com.atc.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SceneLoader {
    public static void load(String fxmlFile, boolean isModality,boolean isResizable,String title, boolean isUtility) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SceneLoader.class.getResource(fxmlFile));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.setResizable(isResizable);
        if(isUtility){
            stage.setIconified(false);
        }else{
            stage.getIcons().add(new Image(String.valueOf(Main.class.getResource("/scenes/pictures/icon.png"))));
        }
        if (isModality) {
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } else {
            stage.show();
        }
    }
}
