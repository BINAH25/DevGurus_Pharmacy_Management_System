package com.example.pharmacy_management_system;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {
    @FXML
    private Button add_medicine_btn;

    @FXML
    private Button add_medicine_btn_1;

    @FXML
    private Button add_medicine_btn_2;

    @FXML
    private Button add_medicine_btn_3;

    @FXML
    private Button add_supplier_btn;

    @FXML
    private Button add_supplier_btn_1;

    @FXML
    private Button add_supplier_btn_2;

    @FXML
    private Button add_supplier_btn_3;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button dashboard_btn_1;

    @FXML
    private Button dashboard_btn_2;

    @FXML
    private Button dashboard_btn_3;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Button logout_btn;

    @FXML
    private Button logout_btn_1;

    @FXML
    private Button logout_btn_2;

    @FXML
    private Button logout_btn_3;

    @FXML
    private AnchorPane medicine_form;

    @FXML
    private Button sell_medicine_btn;

    @FXML
    private Button sell_medicine_btn_1;

    @FXML
    private Button sell_medicine_btn_2;

    @FXML
    private Button sell_medicine_btn_3;

    @FXML
    private AnchorPane sell_medicine_form;

    @FXML
    private AnchorPane suplier_form;


    // LOGOUT METHOD
    public  void logout() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("ADMIN LOGIN PAGE");
        stage.setScene(scene);
        stage.show();
        hideCurrentWindow();


    }

    public void hideCurrentWindow(){
        dashboard_btn.getScene().getWindow().hide();
        add_medicine_btn.getScene().getWindow().hide();
        add_supplier_btn.getScene().getWindow().hide();
        sell_medicine_btn.getScene().getWindow().hide();

        dashboard_btn_1.getScene().getWindow().hide();
        add_medicine_btn_1.getScene().getWindow().hide();
        add_supplier_btn_1.getScene().getWindow().hide();
        sell_medicine_btn_1.getScene().getWindow().hide();

        dashboard_btn_2.getScene().getWindow().hide();
        add_medicine_btn_2.getScene().getWindow().hide();
        add_supplier_btn_2.getScene().getWindow().hide();
        sell_medicine_btn_2.getScene().getWindow().hide();

        dashboard_btn_3.getScene().getWindow().hide();
        add_medicine_btn_3.getScene().getWindow().hide();
        add_supplier_btn_3.getScene().getWindow().hide();
        sell_medicine_btn_3.getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
