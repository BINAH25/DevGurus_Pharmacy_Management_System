package com.example.pharmacy_management_system;
import com.example.pharmacy_management_system.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HelloController {
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

    // ADMIN LOGIN METHOD
    public void Login(){
        String sql = "SELECT email,password FROM admin WHERE email = ? and password = ? ";

        try {
            if (
                    email.getText().isEmpty() || password.getText().isEmpty()

            ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                connect = Database.connect();
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,email.getText());
                prepare.setString(2,password.getText());
                result = prepare.executeQuery();
                if(result.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("success Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Successfully");
                    alert.showAndWait();
                    login_btn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setTitle("ADMIN LOGIN PAGE");
                    stage.setScene(scene);
                    stage.show();
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid Credential");
                    alert.showAndWait();
                }
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}
