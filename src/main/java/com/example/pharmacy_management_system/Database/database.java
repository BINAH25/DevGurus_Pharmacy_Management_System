package com.example.pharmacy_management_system.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy", "root", "");
            return connect;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
