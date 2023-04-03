package com.example.project4;

import java.util.ArrayList;

public class Coffee extends MenuItem{

    private String cupSize;
    private ArrayList<String> addIns;
    private int quantity;

    public Coffee() {
        this.addIns = new ArrayList<>();
        this.quantity = 1;
    }

    @Override
    public double itemPrice() {
        double price = 0;
        if (cupSize == null) {
            price = 0.00;
        } else if(cupSize.equals("Short")) {
            price = 1.89;
        } else if(cupSize.equals("Tall")) {
            price = 2.29;
        } else if(cupSize.equals("Grande")) {
            price = 2.69;
        } else if (cupSize.equals("Venti")){
            price = 3.09;
        }
        return (price + this.addIns.size() * 0.30) * this.quantity;
    }

    public ArrayList<String> listOfAddIns() {
        return this.addIns;
    }

    public void setCupSize(String newCupSize) {
        this.cupSize = newCupSize;
    }

    public void setQuantity (int newQuantity) {
        this.quantity = newQuantity;
    }

    public String toString() {
        String coffeeDesc = "";
        for(String addIn : addIns) {
            coffeeDesc += addIn + " ";
        }
        return coffeeDesc + "(" + quantity + ")";
    }
}
