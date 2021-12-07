package com.atc.сontrollers;

import com.atc.dao.OperatorAccountDao;
import com.atc.entity.OperatorAccountsEntity;
import com.atc.utils.SceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Authorization {

    @FXML
    private Label welcomeText;

    @FXML
    private TextField loginTxtFld;

    @FXML
    private TextField passTxtFld;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        String login = loginTxtFld.getText();
        String pass = passTxtFld.getText();
        OperatorAccountDao operatorAccountDao = new OperatorAccountDao();
        OperatorAccountsEntity operator = operatorAccountDao.findByLogin(login);
        String dbLogin = operator.getLogin();
        String dbPass = operator.getPassword();
        if (dbLogin.equals(login) || dbPass.equals(pass)){
            System.out.println("Authorization success on user " + dbLogin);
            SceneLoader.load("/scenes/operator_workspace.fxml",false,true);
            loginTxtFld.getScene().getWindow().hide();
        }else System.out.println("Authorization failed on user " + dbLogin);

    }

}
