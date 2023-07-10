package com.example.pharmacy_management_system.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    @FXML
    private TextField email;

    @FXML
    private Button login_btn;

    @FXML
    private TextField password;
    Alert alert;
    Connection connect;
    PreparedStatement prepare;
    ResultSet result;

}
