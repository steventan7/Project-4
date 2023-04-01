package com.example.project4;

import java.util.ArrayList;

public class Donut extends MenuItem{

    public static final double NONE = 0.00;
    public static final double COSTOFYEASTDONUT = 1.59;
    public static final double COSTOFCAKEDONUT = 1.79;
    public static final double COSTOFDONUTHOLE = 0.39;

    private ArrayList<String> donutList;
    private String donutType;

    public Donut(String donutType) {
        this.donutType = donutType;
        this.donutList = new ArrayList<>();
    }

    @Override
    public double itemPrice() {
        if(this.donutType.equals("Yeast Donut")) {
            return COSTOFYEASTDONUT * donutList.size();
        } else if(this.donutType.equals("Cake Donut")) {
            return COSTOFCAKEDONUT * donutList.size();
        } else if(this.donutType.equals("Donut Hole")){
            return COSTOFDONUTHOLE * donutList.size();
        }
        return NONE;
    }

    public ArrayList<String> donutList() {
        return this.donutList;
    }
}
