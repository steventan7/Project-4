package com.example.project4;

import java.util.ArrayList;

public class Order {
    private String orderNumber;
    private ArrayList<MenuItem> listOfMenuItems;
    private int subTotal;

    public Order(String orderNumber) {
        this.subTotal = 0;
        this.orderNumber = orderNumber;
        this.listOfMenuItems = new ArrayList<>();
    }

    public ArrayList<MenuItem> menuList(){
        return this.listOfMenuItems;
    }

    public String orderNumber() {
        return this.orderNumber;
    }
}
