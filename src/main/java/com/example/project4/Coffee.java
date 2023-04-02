package com.example.project4;

import java.util.ArrayList;

public class Coffee extends MenuItem{

    public static final double NONE = 0.00;
    public static final double COSTOFSHORT = 1.89;
    public static final double COSTOFTALL = 2.29;
    public static final double COSTOFGRANDE = 2.69;
    public static final double COSTOFVENTI = 3.09;
    public static final double COSTOFADD_IN = 0.30;

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
            price = NONE;
        } else if(cupSize.equals("Short")) {
            price = COSTOFSHORT;
        } else if(cupSize.equals("Tall")) {
            price = COSTOFTALL;
        } else if(cupSize.equals("Grande")) {
            price = COSTOFGRANDE;
        } else if (cupSize.equals("Venti")){
            price = COSTOFVENTI;
        }
        return (price + this.addIns.size() * COSTOFADD_IN) * this.quantity;
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
        return cupSize + " Black Coffee (" + quantity + ")" + "[" + stringListOfAddIns() + "]";
    }

    private String stringListOfAddIns() {
        String list = "";
        for (String addIn: addIns) {
            list += addIn;
        }
        return list;
    }
}
