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

    /**
     * Constructs an Order instance with its own unique order number and arraylist representing the menu items for
     * the order.
     */
    public Order() {
        this.subTotal = 0;
        this.orderNumber = trackingNumber;
        trackingNumber++;
        this.listOfMenuItems = new ArrayList<>();
    }

    /**
     * Adds the items contained in the argument arraylist to the list of menu items in the order.
     * @param subOrderList arraylist containing new menu items to add to the order.
     */
    public void addItems(ArrayList<MenuItem> subOrderList) {
        int searcher = 0;
        for(MenuItem newItem : subOrderList) {
            searcher = this.listOfMenuItems.indexOf(newItem);
            if(searcher != -1) {
                if(newItem instanceof Donut) {
                    Donut newDonut = (Donut) newItem;
                    ((Donut) this.listOfMenuItems.get(searcher)).addQuantity(newDonut.donutQuantity());
                } else if(newItem instanceof Coffee) {
                    Coffee newCoffee = (Coffee) newItem;
                    ((Coffee) this.listOfMenuItems.get(searcher)).setQuantity(newCoffee.coffeeQuantity() +
                            ((Coffee) this.listOfMenuItems.get(searcher)).coffeeQuantity());
                }
            } else {
                this.listOfMenuItems.add(newItem);
            }
        }
    }

    /**
     * Removes an item in the order given the item description of the menu item as a String. Traverses through the
     * list of menu items and compares String values to perform this.
     * @param itemDesc
     */
    public void removeItem(String itemDesc) {
        for(MenuItem item : listOfMenuItems) {
            if(item.toString().equals(itemDesc)) {
                listOfMenuItems.remove(item);
                return;
            }
        }
    }

    /**
     * Retrieves the arraylist containing the list of menu items in this order.
     * @return arraylist with the items in this order.
     */
    public ArrayList<MenuItem> menuList(){
        return this.listOfMenuItems;
    }

    /**
     * Retrieves the order number of this order.
     * @return int representing the order number of this order.
     */
    public int orderNumber() {
        return this.orderNumber;
    }

    /**
     * Retrieves the subtotal, before tax, representing the sum of all prices of menu items in this order.
     * @return double representing the subtotal of this order.
     */
    public double subTotal() {
        double subtotalAmount = 0.0;
        for(MenuItem item : listOfMenuItems) {
            subtotalAmount += item.itemPrice();
        }
        return subtotalAmount;
    }
}
