package com.example.project4;

import java.util.ArrayList;

public class Coffee extends MenuItem{

    private String cupSize;
    private ArrayList<String> addIns;

    public Coffee() {
        this.addIns = new ArrayList<>();
    }

    @Override
    public double itemPrice() {
        return 0;
    }

    public ArrayList<String> listOfAddIns() {
        return this.addIns;
    }

    public void setCupSize(String newCupSize) {
        this.cupSize = newCupSize;
    }

    public String toString() {
        return "";
    }
}
