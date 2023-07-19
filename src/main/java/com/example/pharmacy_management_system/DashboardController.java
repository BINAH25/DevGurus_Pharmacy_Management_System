package com.example.pharmacy_management_system;
import com.example.pharmacy_management_system.Data.Custermer;
import com.example.pharmacy_management_system.Data.Medicine;
import com.example.pharmacy_management_system.Data.Supplier;
import com.example.pharmacy_management_system.Database.Database;
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
import javafx.scene.control.Spinner;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


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
    private Button add_medicine_btn_4;


    @FXML
    private Button add_supplier_btn;

    @FXML
    private Button add_supplier_btn_1;

    @FXML
    private Button add_supplier_btn_2;

    @FXML
    private Button add_supplier_btn_3;
    @FXML
    private Button add_supplier_btn_4;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button dashboard_btn_1;

    @FXML
    private Button dashboard_btn_2;

    @FXML
    private Button dashboard_btn_3;
    @FXML
    private Button dashboard_btn_4;

    @FXML
    private AnchorPane dashboard_form;

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
    private Button sell_medicine_btn;

    @FXML
    private Button sell_medicine_btn_1;

    @FXML
    private Button sell_medicine_btn_2;

    @FXML
    private Button sell_medicine_btn_3;
    @FXML
    private Button sell_medicine_btn_4;

    @FXML
    private AnchorPane sell_medicine_form;

    @FXML
    private AnchorPane suplier_form;

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
    // ************************* PURCHASE MEDICINE START **********************
    @FXML
    private TextField amount;

    @FXML
    private Label balance;
    @FXML
    private Label total_income;
    @FXML
    private Label toatal_customer;
    @FXML
    private Label available_medicine;
    @FXML
    private Label total_suppliers;
    @FXML
    private Spinner<Integer> quantity;
    @FXML
    private Label total;
    @FXML
    private ComboBox<?> sell_category;
    @FXML
    private TableView<Custermer> sell_table_view;

    @FXML
    private TableColumn<Custermer, String> sell_col_1;

    @FXML
    private TableColumn<Custermer, String> sell_col_2;

    @FXML
    private TableColumn<Custermer, String> sell_col_3;

    @FXML
    private TableColumn<Custermer, String> sell_col_4;

    @FXML
    private TableColumn<Custermer, String> sell_col_5;

    @FXML
    private TableColumn<Custermer, String> sell_col_6;
    @FXML
    private ComboBox<?> sell_medicine_id;

    @FXML
    private ComboBox<?> sell_medicine_name;

    @FXML
    private ComboBox<?> sell_supplier;

    @FXML
    private TableView<Supplier> supplier_table_view;

    @FXML
    private Button bill_btn;
    @FXML
    private TableView<?> bill_able_view;
    @FXML
    private TableColumn<?, ?> bill_col_1;

    @FXML
    private TableColumn<?, ?> bill_col_2;

    @FXML
    private TableColumn<?, ?> bill_col_3;

    @FXML
    private TableColumn<?, ?> bill_col_4;

    @FXML
    private TableColumn<?, ?> bill_col_5;

    @FXML
    private AnchorPane bill_form;
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
            total_customers();
            total_income();
            total_available_medicine();
            total_suppliers();

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
            sell_category();
            get_sell_medicine_id();
            get_sell_supplier();
            get_sell_medicine_name();
            show_all_sell_medicine();
            getSpinner();
            displayTotalPrice();

            // SECOND OPTIONS
        } else if (event.getSource()==dashboard_btn_1) {
            dashboard_form.setVisible(true);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
            total_customers();
            total_income();
            total_available_medicine();
            total_suppliers();

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
            sell_category();
            get_sell_medicine_id();
            get_sell_supplier();
            get_sell_medicine_name();
            show_all_sell_medicine();
            getSpinner();
            displayTotalPrice();

            // THIRD OPTIONS
        } else if (event.getSource()==dashboard_btn_2) {
            dashboard_form.setVisible(true);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
            total_customers();
            total_income();
            total_available_medicine();
            total_suppliers();

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
            sell_category();
            get_sell_medicine_id();
            get_sell_supplier();
            get_sell_medicine_name();
            show_all_sell_medicine();
            getSpinner();
            displayTotalPrice();

            // LAST OPTIONS
        } else if (event.getSource()==dashboard_btn_3) {
            dashboard_form.setVisible(true);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
            total_customers();
            total_income();
            total_available_medicine();
            total_suppliers();

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
            bill_form.setVisible(false);
            sell_medicine_form.setVisible(true);
            sell_category();
            get_sell_medicine_id();
            get_sell_supplier();
            get_sell_medicine_name();
            show_all_sell_medicine();
            getSpinner();
            displayTotalPrice();

        } else if (event.getSource()==bill_btn) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
            bill_form.setVisible(true);
        }else if (event.getSource()==dashboard_btn_4) {
            dashboard_form.setVisible(true);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
            bill_form.setVisible(false);

            total_customers();
            total_income();
            total_available_medicine();
            total_suppliers();

        } else if (event.getSource()==add_medicine_btn_4) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(true);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(false);
            bill_form.setVisible(false);

            show_all_medicine();
        } else if (event.getSource()==add_supplier_btn_4) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(true);
            sell_medicine_form.setVisible(false);
            bill_form.setVisible(false);

            showAllSuppliers();

        } else if (event.getSource()==sell_medicine_btn_4) {
            dashboard_form.setVisible(false);
            medicine_form.setVisible(false);
            suplier_form.setVisible(false);
            sell_medicine_form.setVisible(true);
            bill_form.setVisible(false);

            sell_category();
            get_sell_medicine_id();
            get_sell_supplier();
            get_sell_medicine_name();
            show_all_sell_medicine();
            getSpinner();
            displayTotalPrice();

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
    // METHOD TO SELECT A MEDICINE
    public void select_medicine(){
        Medicine medicine = medicine_table_view.getSelectionModel().getSelectedItem();
        int num = medicine_table_view.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) return;
        medicine_id.setText(String.valueOf(medicine.getMedicine_id()));
        medicine_name.setText(String.valueOf(medicine.getMedicine_name()));
        medicine_price.setText(String.valueOf(medicine.getMedicine_price()));
    }
    // METHOD FOR DELETING A MEDICINE
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
    // METHOD TO UPDATE  MEDICINE
    public void update_medicine() {
        connect = Database.connect();
        try {
            if (medicine_id.getText().isEmpty()
                    || medicine_name.getText().isEmpty()
                    || medicine_price.getText().isEmpty()
                    || medicine_category.getSelectionModel().getSelectedItem() == null
                    || medicine_supplier.getSelectionModel().getSelectedItem() == null
                    || medicine_status.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blanks fields ");
                alert.showAndWait();
            } else {
                String updateData = "UPDATE medicine SET "
                        + "medicine_name = '" + medicine_name.getText()
                        + "',medicine_price = '" + medicine_price.getText()
                        + "',category = '" + medicine_category.getSelectionModel().getSelectedItem()
                        + "',supplier = '" + medicine_supplier.getSelectionModel().getSelectedItem()
                        + "',status = '" + medicine_status.getSelectionModel().getSelectedItem()
                        + "'WHERE medicine_id = " + medicine_id.getText();
                prepare = connect.prepareStatement(updateData);
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Medicine  Updated Successfully");
                alert.showAndWait();

                // TO UPDATE THE TABLE VIEW
                    show_all_medicine();
                // TO CLEAR THE MEDICINE FORM
                    clear_medicine_form();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // **************************** SELL MEDICINE CONTROLLER START *************************************
    // METHOD FOR GETTING CATEGORY
    public void sell_category(){
        String sql = "SELECT category FROM medicine WHERE status = 'Available'";
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList list_data = FXCollections.observableArrayList();
            while(result.next()){
                list_data.add(result.getString("category"));
            }
            sell_category.setItems(list_data);
            get_sell_medicine_id();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // METHOD FOR GETTING MEDICINE ID
    public void get_sell_medicine_id(){
        String sql = "SELECT * FROM medicine WHERE category = '"+ sell_category.getSelectionModel().getSelectedItem()+"'";
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList observableList = FXCollections.observableArrayList();
            while (result.next()){
                observableList.add(result.getString("medicine_id"));
                sell_medicine_id.setItems(observableList);
            }
            get_sell_supplier();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // METHOD FOR GETTING SUPPLIER NAME
    public void get_sell_supplier(){
        String sql = "SELECT * FROM medicine WHERE medicine_id = '"+ sell_medicine_id.getSelectionModel().getSelectedItem()+"'";
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList observableList = FXCollections.observableArrayList();
            while (result.next()){
                observableList.add(result.getString("supplier"));
                sell_supplier.setItems(observableList);
            }
            get_sell_medicine_name();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // METHOD FOR GETTING MEDICINE NAME
    public void get_sell_medicine_name(){
        String sql = "SELECT * FROM medicine WHERE supplier = '"+ sell_supplier.getSelectionModel().getSelectedItem()+"'";
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList observableList = FXCollections.observableArrayList();
            while (result.next()){
                observableList.add(result.getString("medicine_name"));
                sell_medicine_name.setItems(observableList);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // METHOD TO AUTOMATICALLY GENERATE CUSTOMER ID
    private  int customer_id;
    Statement statement;
    public void customerId(){
        String sql = "SELECT customer_id FROM customer";
        int checkId = 0;

        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                customer_id = result.getInt("customer_id");
            }
            String checkData = "SELECT * FROM customer_info";
            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            while (result.next()){
                checkId = result.getInt("customer_id");
            }

            if(customer_id == 0){
                customer_id += 1;
            } else if (checkId == customer_id) {
                customer_id += 1;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // METHOD TO GET ALL MEDICINES
    public ObservableList<Custermer> get_all_medicine_in_card (){
        customerId();
        ObservableList<Custermer> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer WHERE customer_id = '"+customer_id+"'";
        connect = Database.connect();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Custermer customers;

            while (result.next()){
                customers = new Custermer(
                        result.getInt("customer_id"),
                        result.getString("category"),
                        result.getString("medicine_id"),
                        result.getString("supplier"),
                        result.getString("medicine_name"),
                        result.getInt("quantity"),
                        result.getDouble("price"),
                        result.getDate("date")
                );
                listData.add(customers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    // THIS METHOD SHOW ALL THE MEDICINE IN CART OF A PARTICULAR CUSTOMER
    private ObservableList<Custermer> custermerObservableList;
    public void show_all_sell_medicine (){
        custermerObservableList = get_all_medicine_in_card();
        sell_col_1.setCellValueFactory(new PropertyValueFactory<>("category"));
        sell_col_2.setCellValueFactory(new PropertyValueFactory<>("medicine_id"));
        sell_col_3.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        sell_col_4.setCellValueFactory(new PropertyValueFactory<>("medicine_name"));
        sell_col_5.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        sell_col_6.setCellValueFactory(new PropertyValueFactory<>("price"));
        sell_table_view.setItems(custermerObservableList);
        //displayTotalPrice();
    }

    // THIS METHOD INITIALIZED NEW SPINNER
    private SpinnerValueFactory<Integer> spinner;
    public void getSpinner(){
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        quantity.setValueFactory(spinner);
    }
    // METHOD TO SET THE SPINNER VALUE

    int qty;
    public void sell_Spinner(){
        qty = quantity.getValue();
    }

    //METHOD TO ADD MEDICINE TO CART
    public void Add_to_cart(){
        customerId();
        String sql  = "INSERT INTO customer (customer_id,category,medicine_id,supplier,medicine_name,quantity,price,date) VALUES (?,?,?,?,?,?,?,?)";
        connect = Database.connect();
        try {
            String checkData = "SELECT medicine_price FROM medicine WHERE medicine_name = '"
                    +sell_medicine_name.getSelectionModel().getSelectedItem() +"'";

            double price = 0;

            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            if(result.next()){
                price = result.getDouble("medicine_price");

            }
            double total = (price * qty);
            if(
                    sell_category.getSelectionModel().getSelectedItem() == null
                    || sell_medicine_name.getSelectionModel().getSelectedItem() == null
                    || sell_supplier.getSelectionModel().getSelectedItem() == null
                    || sell_medicine_id.getSelectionModel().getSelectedItem() == null
                    || total == 0
            ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,String.valueOf(customer_id));
                prepare.setString(2,(String) sell_category.getSelectionModel().getSelectedItem());
                prepare.setString(3,(String) sell_medicine_id.getSelectionModel().getSelectedItem());
                prepare.setString(4,(String) sell_supplier.getSelectionModel().getSelectedItem());
                prepare.setString(5,(String) sell_medicine_name.getSelectionModel().getSelectedItem());
                prepare.setString(6,String.valueOf(qty));
                prepare.setString(7,String.valueOf(total));

                Date date = new Date();
                java.sql.Date  sqldate = new java.sql.Date(date.getTime());
                prepare.setString(8,String.valueOf(sqldate));
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Medicine Added to Cart Successfully");
                alert.showAndWait();
                displayTotalPrice();
                show_all_sell_medicine();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // METHOD TO DISPLAY TOTAL PRICE

    private double total_price;
    public void displayTotalPrice(){
        customerId();
        String sql  = "SELECT SUM(price) FROM customer WHERE customer_id = '" +customer_id+"'";
        connect = Database.connect();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                total_price = result.getDouble("SUM(price)");
            }
            total.setText("$"+String.valueOf(total_price));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
//
// THIS METHOD TAKE THE AMOUNT AND CALCULATE THE BALANCE FROM THE TOTAL
private double balance_price;
    private  double amount_price;
    public void orderAmount(){
        amount_price = Double.parseDouble(amount.getText());
        if(total_price > 0){
            if(amount_price >= total_price){
                balance_price = (amount_price - total_price);
                balance.setText("$"+ String.valueOf(balance_price));
            }else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Amount is less than total price");
                alert.showAndWait();
                amount.setText("");
            }
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Total price is less than zero");
            alert.showAndWait();
            amount.setText("");
        }

    }
    // THIS METHOD RECORD THE CUSTOMER ID AND TOTAL AND BALANCE
    public void pay_for_medicine(){
        customerId();
        String sql = "INSERT INTO customer_info (customer_id,total,amount,balance, date) VALUES (?,?,?,?,?)";
        try {
            connect = Database.connect();
            if(total_price > 0 && amount_price >= total_price){
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,String.valueOf(customer_id));
                prepare.setString(2,String.valueOf(total_price));
                prepare.setString(3,String.valueOf(amount_price));
                prepare.setString(4,String.valueOf(balance_price));
                Date date = new Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                prepare.setString(5,String.valueOf(sqldate));
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Medicine Payment made Successfully");
                alert.showAndWait();
                amount.setText("");
                balance.setText("");
                total.setText("$0.0");
                show_all_sell_medicine();

            }else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Amount or Total price");
                alert.showAndWait();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // THIS METHOD CLEAR THE ISSUED GOODS
    public void Reset(){
        String sql = "DELETE FROM customer WHERE customer_id = '"+ customer_id+"'";
        try {
            connect = Database.connect();
            if(sell_table_view.getItems().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No Medicine added");
                alert.showAndWait();

            }else{
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation  Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to reset the form");
                Optional<ButtonType> option = alert.showAndWait();

                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    show_all_sell_medicine();
                    amount_price = 0;
                    balance_price = 0;
                    total.setText("$0.0");
                    balance.setText("");
                    amount.setText("");

                }else{
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation  Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Action cancelled");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //
    public void total_available_medicine(){
        String sql = "SELECT COUNT(id) FROM medicine WHERE status = 'Available'";
        int count = 0;
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()){
                count = result.getInt("COUNT(id)");
            }
            available_medicine.setText(String.valueOf(count));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //
    public void total_income(){
        String sql = "SELECT SUM(total) FROM customer_info";
        double income = 0;
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()){
                income = result.getDouble("SUM(total)");
            }
            total_income.setText(String.valueOf(income));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//
    public void total_customers(){
        String sql = "SELECT COUNT(id) FROM customer_info";
        int count = 0;
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()){
                count = result.getInt("COUNT(id)");
            }
            toatal_customer.setText(String.valueOf(count));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //
    public void total_suppliers(){
        String sql = "SELECT COUNT(id) FROM supplier";
        int count = 0;
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()){
                count = result.getInt("COUNT(id)");
            }
            total_suppliers.setText(String.valueOf(count));

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
    sell_category();
    get_sell_medicine_id();
    get_sell_supplier();
    get_sell_medicine_name();
    show_all_sell_medicine();
    getSpinner();
    displayTotalPrice();
    // HOME
    total_customers();
    total_income();
    total_available_medicine();
    total_suppliers();

    }
}
