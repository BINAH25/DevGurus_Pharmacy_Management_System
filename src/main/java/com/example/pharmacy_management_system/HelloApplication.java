package com.example.pharmacy_management_system;

/*

    NAME                    -   IDS
* Ernestine Akusika Dornyo  - 10923915

  Ofori Emmanuel            - 10923044

  Safura Aziz               - 10906101

  Ahlijah Bernard Delalorm  - 10891195

  Louis Binah               - 10899830
*
* */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("ADMIN LOGIN PAGE");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}