package com.example.project4;

import java.util.ArrayList;

public class Order {
    static private int trackingNumber;
    private int orderNumber;
    private ArrayList<MenuItem> listOfMenuItems;
    private int subTotal;

    public Order() {
        this.subTotal = 0;
        this.orderNumber = trackingNumber;
        trackingNumber++;
        this.listOfMenuItems = new ArrayList<>();
    }
    public void addItems(ArrayList<MenuItem> subOrderList) {
        listOfMenuItems.addAll(subOrderList);
    }

    public ArrayList<MenuItem> menuList(){
        return this.listOfMenuItems;
    }

    public String orderNumber() {
        return String.valueOf(this.orderNumber);
    }
}
