package com.example.pharmacy_management_system;
import com.example.pharmacy_management_system.Data.Medicine;
import com.example.pharmacy_management_system.Data.Supplier;
import com.example.pharmacy_management_system.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


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
    private TableColumn<Medicine, String> medicine_col_1;

    @FXML
    private TableColumn<Medicine, String> medicine_col_2;

    @FXML
    private TableColumn<Medicine, String> medicine_col_3;

    @FXML
    private TableColumn<Medicine, String> medicine_col_4;

    @FXML
    private TableColumn<Medicine, String> medicine_col_5;

    @FXML
    private TableColumn<Medicine, String> medicine_col_6;

    @FXML
    private TableColumn<Medicine, String> medicine_col_7;

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
    private TableView<Medicine> medicine_table_view;

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
    @FXML
    private TableColumn<Supplier, String> supplier_col_1;

    @FXML
    private TableColumn<Supplier, String> supplier_col_2;

    @FXML
    private TableColumn<Supplier, String> supplier_col_3;


    @FXML
    private TableView<Supplier> supplier_table_view;
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
            show_all_medicine();
        } else if (event.getSource()==add_supplier_btn) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
            showAllSuppliers();

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
            show_all_medicine();
        } else if (event.getSource()==add_supplier_btn_1) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
            showAllSuppliers();

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
            show_all_medicine();
        } else if (event.getSource()==add_supplier_btn_2) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
            showAllSuppliers();

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
            show_all_medicine();
        } else if (event.getSource()==add_supplier_btn_3) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
            showAllSuppliers();

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
// ******************************* SUPPLIER CONTROLLER START *****************************************//
    // METHOD TO ADD SUPPLIER
    public void addSupplier(){
        String sql = "INSERT INTO supplier (suppler_id,supplier_name,date) VALUES (?,?,?)";
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
                showAllSuppliers();
            // SET THE SUPPLIER FORM EMPTY
                clearSupplierForm();

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    // METHOD TO CLEAR THE SUPPLIER FORM
    public void clearSupplierForm (){
        supplier_name.setText("");
        suppler_id.setText("");
    }
    // METHOD TO GET ALL SUPPLIERS
    public ObservableList<Supplier> getAllSupplier(){
        ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
        String getSuppliers = "SELECT * FROM supplier";
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(getSuppliers);
            result = prepare.executeQuery();
            Supplier supplier ;
            while (result.next()){
                supplier = new Supplier(
                        result.getString("suppler_id"),
                        result.getString("supplier_name"),
                        result.getDate("date")
                );
                suppliers.add(supplier);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  suppliers;
    }
// METHOD FOR DISPLAYING SUPPLIERS ON THE ON THE SUPPLIER TABLEVIEW
    ObservableList<Supplier> supplierObservableList;
    public void showAllSuppliers(){
        supplierObservableList = getAllSupplier();
        supplier_col_1.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));
        supplier_col_2.setCellValueFactory(new PropertyValueFactory<>("supplier_name"));
        supplier_col_3.setCellValueFactory(new PropertyValueFactory<>("date"));
        supplier_table_view.setItems(supplierObservableList);
    }
    // METHOD FOR SELECTING A SUPPLIER
    public void selectSupplier(){
        Supplier supplier = supplier_table_view.getSelectionModel().getSelectedItem();
        int num = supplier_table_view.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) return;
        suppler_id.setText(String.valueOf(supplier.getSupplier_id()));
        supplier_name.setText(String.valueOf(supplier.getSupplier_name()));
    }
// METHOD FOR DELETING A SUPPLIER
    public void deleteSupplier(){
        connect = Database.connect();
        try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation  Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete Student with ID:" + suppler_id.getText()+ "?");
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){
                String deleteData = "DELETE FROM supplier WHERE suppler_id = "+ suppler_id.getText();
                prepare = connect.prepareStatement(deleteData);
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Supplier  Deleted Successfully");
                alert.showAndWait();

                // TO UPDATE THE TABLE VIEW
                showAllSuppliers();
                // TO CLEAR THE STUDENT FORM
                clearSupplierForm();
            }else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Action Cancelled..");
                alert.showAndWait();
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //THIS METHOD UPDATE THE SUPPLIER
    public void updateSupplier() {
        connect = Database.connect();
        try {
            if (suppler_id.getText().isEmpty() || supplier_name.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blanks fields ");
                alert.showAndWait();
            } else {
                String updateData = "UPDATE supplier SET "
                        + "supplier_name = '" + supplier_name.getText()
                        + "'WHERE suppler_id = " + suppler_id.getText();
                prepare = connect.prepareStatement(updateData);
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Supplier Name Updated Successfully");
                alert.showAndWait();

                // TO UPDATE THE TABLE VIEW
                showAllSuppliers();
                // TO CLEAR THE STUDENT FORM
                clearSupplierForm();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //
    public void medecineCategoryList(){
        String sql = "SELECT * FROM supplier";
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ObservableList lissData = FXCollections.observableArrayList();
            while (result.next()){
                lissData.add(result.getString("supplier_name"));
            }
            medicine_supplier.setItems(lissData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // ******************** MEDICINE CONTROLLER START *********************************
    // ADD MEDICINE METHOD
    public void addMedicine(){
        String sql = "INSERT INTO medicine (medicine_id,medicine_name,medicine_price,category,supplier,status,date)" +
                "VALUES(?,?,?,?,?,?,?)";
        try {
            if(
                    medicine_id.getText().isEmpty()
                    || medicine_name.getText().isEmpty()
                    || medicine_price.getText().isEmpty()
                    || medicine_category.getSelectionModel().getSelectedItem()==null
                    || medicine_supplier.getSelectionModel().getSelectedItem()==null
                    || medicine_status.getSelectionModel().getSelectedItem()==null
            ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                connect = Database.connect();
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,medicine_id.getText());
                prepare.setString(2,medicine_name.getText());
                prepare.setString(3,medicine_price.getText());
                prepare.setString(4, (String) medicine_category.getSelectionModel().getSelectedItem());
                prepare.setString(5,(String) medicine_supplier.getSelectionModel().getSelectedItem());
                prepare.setString(6,(String)medicine_status.getSelectionModel().getSelectedItem());
                // GETTING THE DATE
                Date date = new Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                prepare.setString(7,String.valueOf(sqldate));
                // EXECUTING THE COMMAND
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Medicine Added  Successfully");
                alert.showAndWait();
                clear_medicine_form();
                show_all_medicine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    // METHOD TO CLEAR THE MEDICINE FORM AFTER ADDING A MEDICINE
    public void clear_medicine_form(){
        medicine_id.setText("");
        medicine_name.setText("");
        medicine_price.setText("");
        medicine_category.getSelectionModel().clearSelection();
        medicine_supplier.getSelectionModel().clearSelection();
        medicine_status.getSelectionModel().clearSelection();
    }

    //METHOD TO GET ALL MEDICINE
    ObservableList<Medicine> getAllMedicine(){
        ObservableList<Medicine> medicines = FXCollections.observableArrayList();
        String sql = "SELECT * FROM medicine";
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Medicine medicine;
            while (result.next()){
                medicine = new Medicine(
                        result.getString("medicine_id"),
                        result.getString("medicine_name"),
                        result.getDouble("medicine_price"),
                        result.getString("category"),
                        result.getString("supplier"),
                        result.getString("status"),
                        result.getDate("date")
                );
                medicines.add(medicine);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return medicines;
    }
    // METHOD TO DISPLAY ALL MEDICINES
    ObservableList<Medicine> medicineObservableList;
    public void show_all_medicine(){
        medicineObservableList = getAllMedicine();
        medicine_col_1.setCellValueFactory(new PropertyValueFactory<>("medicine_id"));
        medicine_col_2.setCellValueFactory(new PropertyValueFactory<>("medicine_name"));
        medicine_col_3.setCellValueFactory(new PropertyValueFactory<>("medicine_price"));
        medicine_col_4.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        medicine_col_5.setCellValueFactory(new PropertyValueFactory<>("category"));
        medicine_col_6.setCellValueFactory(new PropertyValueFactory<>("status"));
        medicine_col_7.setCellValueFactory(new PropertyValueFactory<>("date"));
        medicine_table_view.setItems(medicineObservableList);
    }
    public void select_medicine(){
        Medicine medicine = medicine_table_view.getSelectionModel().getSelectedItem();
        int num = medicine_table_view.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) return;
        medicine_id.setText(String.valueOf(medicine.getMedicine_id()));
        medicine_name.setText(String.valueOf(medicine.getMedicine_name()));
        medicine_price.setText(String.valueOf(medicine.getMedicine_price()));
    }
    // METHOD FOR DELETING A SUPPLIER
    public void delete_medicine(){
        connect = Database.connect();
        try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation  Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete Student with ID:" + medicine_id.getText()+ "?");
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){
                String deleteData = "DELETE FROM medicine WHERE medicine_id = "+ medicine_id.getText();
                prepare = connect.prepareStatement(deleteData);
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Medicine  Deleted Successfully");
                alert.showAndWait();

                // TO UPDATE THE TABLE VIEW
                show_all_medicine();
                // TO CLEAR THE STUDENT FORM
                clear_medicine_form();
            }else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Action Cancelled..");
                alert.showAndWait();
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    medicineStatusList();
    medicineCategory();
    showAllSuppliers();
    medecineCategoryList();
    show_all_medicine();
    }

}
