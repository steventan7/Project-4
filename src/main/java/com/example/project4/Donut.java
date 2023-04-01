package com.example.project4;

import java.util.ArrayList;

public class Donut extends MenuItem{

    private ArrayList<String> donutList;
    private String donutType;

    public Donut(String donutType) {
        this.donutType = donutType;
        this.donutList = new ArrayList<>();
    }

    @Override
    public double itemPrice() {
        if(this.donutType.equals("Yeast Donut")) {
            return 1.59 * donutList.size();
        } else if(this.donutType.equals("Cake Donut")) {
            return 1.79 * donutList.size();
        } else if(this.donutType.equals("Donut Hole")){
            return 0.39 * donutList.size();
        }
        return 0.00;
    }

    public ArrayList<String> donutList() {
        return this.donutList;
    }
}
