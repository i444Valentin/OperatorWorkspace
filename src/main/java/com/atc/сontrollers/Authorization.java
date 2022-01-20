package com.atc.сontrollers;

import com.atc.dao.OperatorAccountDao;
import com.atc.entity.OperatorAccountsEntity;
import com.atc.utils.SceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Authorization extends OperatorWorkspace {

    @FXML
    private Label welcomeText;

    @FXML
    private TextField loginTxtFld;

    @FXML
    private TextField passTxtFld;

    @FXML
    void initialize(){
        boolean authNoPass = false;
        if (authNoPass){
            SceneLoader.load("/scenes/operator_workspace.fxml",false,true,"База данных АТС",false);
            OperatorWorkspace.authorizationScene=this.loginTxtFld.getScene();
        }
    }
    @FXML
    void onHelloButtonClick(ActionEvent event) {
        String login = loginTxtFld.getText();
        String pass = passTxtFld.getText();
        if (login.equals("")){
            AlertMessage.showAlert(Alert.AlertType.WARNING,
                    "Логин не введен",
                    "Ошибка входа",
                    "");
            return;
        }
        OperatorAccountDao operatorAccountDao = new OperatorAccountDao();
        try{
            OperatorAccountsEntity operator = operatorAccountDao.findByLogin(login);
            String dbLogin = operator.getLogin();
            String dbPass = operator.getPassword();
            if (dbLogin.equals(login) && dbPass.equals(pass)){
                System.out.println("Authorization success on user " + dbLogin);
                SceneLoader.load("/scenes/operator_workspace.fxml",false,true,"База данных АТС",false);
                loginTxtFld.getScene().getWindow().hide();
            }else {
                System.out.println("Authorization failed on user " + dbLogin);
                AlertMessage.showAlert(Alert.AlertType.WARNING,
                        "Неверный пароль. Убедитесь, что ввели его верно или обратитесь к системному администратору.",
                        "Ошибка входа",
                        "");
            }
        }catch (Exception e ){
            AlertMessage.showAlert(Alert.AlertType.WARNING,"Неверный логин.","Ошибка входа","");
        }
    }

}
