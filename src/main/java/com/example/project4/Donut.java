package com.example.project4;

import java.util.ArrayList;

public class Donut extends MenuItem{

    private ArrayList<String> donutList;
    private String donutType;

    public Donut() {
        donutList = new ArrayList<>();
    }

    @Override
    public double itemPrice() {
        return 0.0;
    }

    public ArrayList<String> donutList() {
        return this.donutList;
    }
}
