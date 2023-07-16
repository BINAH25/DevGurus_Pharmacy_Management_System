package com.example.pharmacy_management_system.Data;
import java.util.Date;

public class Custermer {
    private Integer customer_id;
    private String category;
    private String medicine_id;

    private String supplier;
    private String medicine_name;
    private Integer quantity;
    private Double price;
    private  Date date;

    public Custermer(Integer customer_id,String category,String medicine_id,String supplier,String medicine_name,Integer quantity,Double price,Date date){
        this.customer_id = customer_id;
        this.category = category;
        this.medicine_id = medicine_id;
        this.supplier = supplier;
        this.medicine_name = medicine_name;
        this.quantity = quantity;
        this.price =price;
        this.date = date;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public String getCategory() {
        return category;
    }

    public String getMedicine_id() {
        return medicine_id;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

}
