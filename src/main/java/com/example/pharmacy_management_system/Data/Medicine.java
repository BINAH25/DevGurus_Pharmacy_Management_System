package com.example.pharmacy_management_system.Data;

import java.util.Date;

public class Medicine {
    private String medicine_id;
    private String medicine_name;
    private double medicine_price;
    private String category;
    private String supplier;
    private String status;
    private Date date;

    public Medicine(String medicine_id,String medicine_name,double medicine_price,String category,String supplier,String status, Date date){
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
        this.medicine_price = medicine_price;
        this.category = category;
        this.supplier = supplier;
        this.status = status;
        this.date = date;
    }

    public String getMedicine_id() {
        return medicine_id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public double getMedicine_price() {
        return medicine_price;
    }

    public String getCategory() {
        return category;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }
}
