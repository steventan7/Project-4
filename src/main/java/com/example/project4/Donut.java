package com.example.project4;

import java.util.ArrayList;

public class Donut extends MenuItem{
    public static final double NONE = 0.00;
    static public final String [] DONUTTYPES = {"Yeast Donut", "Cake Donut", "Donut Hole"};
    public static final double COSTOFYEASTDONUT = 1.59;
    public static final double COSTOFCAKEDONUT = 1.79;
    public static final double COSTOFDONUTHOLE = 0.39;
    static public final String [] YEASTDONUTFLAVORS = {"Jelly", "Vanilla", "Cinnamon", "Apple Cider", "Blueberry",
            "Pumpkin Spice"};
    static public final String [] CAKEDONUTFLAVORS = {"Chocolate", "Rainbow", "Sugar"};
    static public final String [] DONUTHOLEFLAVORS = {"Red Velvet", "Apple Fritter", "Powdered"};
    private String donutType;
    private int donutQuantity;
    private String donutFlavor;

    public Donut(String donutType, String donutFlavor, int donutQuantity) {
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
        this.donutQuantity = donutQuantity;
    }

    @Override
    public double itemPrice() {
        if(this.donutType.equals(DONUTTYPES[0])) {
            return COSTOFYEASTDONUT * this.donutQuantity;
        } else if(this.donutType.equals(DONUTTYPES[1])) {
            return COSTOFCAKEDONUT * this.donutQuantity;
        } else if(this.donutType.equals(DONUTTYPES[2])){
            return COSTOFDONUTHOLE * this.donutQuantity;
        }
        return NONE;
    }

    public String donutFlavor() {
        return this.donutFlavor;
    }

    public String donutType() {
        return this.donutType;
    }
    public String toString() {
        return this.donutFlavor + "(" + this.donutQuantity +")";
    }
}
