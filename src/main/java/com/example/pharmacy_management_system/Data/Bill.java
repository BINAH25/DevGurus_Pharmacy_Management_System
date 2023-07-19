package com.example.pharmacy_management_system.Data;

import java.sql.Date;

public class Bill {
    private Integer customer_id;
    private double total;
    private Integer amount;
    private  double balance;
    private Date date;

    public Bill(Integer customer_id,double total,Integer amount,double balance,Date date){
        this.customer_id = customer_id;
        this.total = total;
        this.amount = amount;
        this.balance =balance;
        this.date =date;

    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public double getTotal() {
        return total;
    }

    public Integer getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDate() {
        return date;
    }
}
