package com.example.pharmacy_management_system.Data;

import java.util.Date;

public class Supplier {
    private String supplier_id;
    private String supplier_name;
    private Date date;

    public  Supplier(String supplier_id,String supplier_name,Date date){
        this.supplier_id =supplier_id;
        this.supplier_name = supplier_name;
        this.date = date;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public Date getDate() {
        return date;
    }
}
