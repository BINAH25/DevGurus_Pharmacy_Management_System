package com.example.pharmacy_management_system;
import com.example.pharmacy_management_system.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {
    @FXML
    private Button add_medicine;

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
    private Button clear_medicine_form;

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
    private ComboBox<?> medicine_category;

    @FXML
    private TableColumn<?, ?> medicine_col_1;

    @FXML
    private TableColumn<?, ?> medicine_col_2;

    @FXML
    private TableColumn<?, ?> medicine_col_3;

    @FXML
    private TableColumn<?, ?> medicine_col_4;

    @FXML
    private TableColumn<?, ?> medicine_col_5;

    @FXML
    private TableColumn<?, ?> medicine_col_6;

    @FXML
    private TableColumn<?, ?> medicine_col_7;

    @FXML
    private AnchorPane medicine_form;

    @FXML
    private TextField medicine_id;

    @FXML
    private TextField medicine_name;

    @FXML
    private TextField medicine_price;

    @FXML
    private ComboBox<?> medicine_status;

    @FXML
    private ComboBox<?> medicine_supplier;

    @FXML
    private TableView<?> medicine_table_view;

    @FXML
    private Button remove_medicine;

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

    @FXML
    private Button update_medicine;
    @FXML
    private TextField suppler_id;
    @FXML
    private TextField supplier_name;
    // Sql import
    Connection connect;
    PreparedStatement prepare;
    ResultSet result;
    Alert alert;

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
// METHOD TO HIDE THE CURRENT ACTIVE WINDOW
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

    // METHOD FOR SWITCHING THE FORMS


    public void switchForm(javafx.event.ActionEvent event) {
        // FIRST OPTIONS
        if(event.getSource()==dashboard_btn){
            dashboard_form.setVisible(true);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==add_medicine_btn) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(true);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==add_supplier_btn) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==sell_medicine_btn) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(true);
            // SECOND OPTIONS
        } else if (event.getSource()==dashboard_btn_1) {
            dashboard_form.setVisible(true);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==add_medicine_btn_1) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(true);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==add_supplier_btn_1) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==sell_medicine_btn_1) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(true);
            // THIRD OPTIONS
        } else if (event.getSource()==dashboard_btn_2) {
            dashboard_form.setVisible(true);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==add_medicine_btn_2) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(true);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==add_supplier_btn_2) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==sell_medicine_btn_2) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(true);
            // LAST OPTIONS
        } else if (event.getSource()==dashboard_btn_3) {
            dashboard_form.setVisible(true);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==add_medicine_btn_3) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(true);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==add_supplier_btn_3) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
        } else if (event.getSource()==sell_medicine_btn_3) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(true);
        }
    }
// METHOD TO FILL THE STATUS COMBO
    String[]StatusList = {"Available","Unavailable"};
    public void medicineStatusList(){
        List<String> listStatus = new ArrayList<>();
        for(String data: StatusList){
            listStatus.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listStatus);
        medicine_status.setItems(listData);

    }
    // CREATING A LIST OF CATEGORY
    String[] Category = {
            "Analgesics and Pain Relief",
            "Cold and Flu",
            "Allergy and Asthma",
            "Vitamins and Supplements",
            "Antibiotics",
            "Antipyretics",
            "Antiemetics"
    };
    // METHOD TO FILL THE MEDICINE CATEGORY COMBO

    public void medicineCategory(){
        List<String> categoryList = new ArrayList<>();
        for(String data:Category){
            categoryList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(categoryList);
        medicine_category.setItems(listData);
    }

    //
    public void addSupplier(){
        String sql = "INSERT INTO supplier (suppler_id,supplier_name) VALUES (?,?)";
        try {
            if(suppler_id.getText().isEmpty()|| supplier_name.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                connect = Database.connect();
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,suppler_id.getText());
                prepare.setString(2,supplier_name.getText());
                // GETTING THE DATE
                Date date = new Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                prepare.setString(3, String.valueOf(sqldate));

                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("success Message");
                alert.setHeaderText(null);
                alert.setContentText("Supplier Added successfully");
                alert.showAndWait();
                supplier_name.setText("");
                suppler_id.setText("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        medicineStatusList();
        medicineCategory();

    }

}
