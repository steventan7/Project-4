package com.example.project4;

import java.util.ArrayList;

/**
 * Order class used to create objects representing an order for donuts or coffee.
 * @author Steven Tan, David Fabian
 */
public class Order {
    static private int trackingNumber = 1;
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
    public void removeItem(String itemDesc) {
        for(MenuItem item : listOfMenuItems) {
            if(item.toString().equals(itemDesc)) {
                listOfMenuItems.remove(item);
                return;
            }
        }
    }

    public ArrayList<MenuItem> menuList(){
        return this.listOfMenuItems;
    }

    public int orderNumber() {
        return this.orderNumber;
    }
    public double subTotal() {
        double subtotalAmount = 0.0;
        for(MenuItem item : listOfMenuItems) {
            subtotalAmount += item.itemPrice();
        }
        return subtotalAmount;
    }
}
