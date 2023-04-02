package com.example.project4;

public class Donut extends MenuItem{

    public static final double NONE = 0.00;
    public static final double COSTOFYEASTDONUT = 1.59;
    public static final double COSTOFCAKEDONUT = 1.79;
    public static final double COSTOFDONUTHOLE = 0.39;

    private String donutType;
    private String donutFlavor;
    private int quantity;

    public Donut(String donutType, String donutFlavor, int quantity) {
        this.donutType = donutType;
        this.quantity = quantity;
        this.donutFlavor = donutFlavor;
    }

    @Override
    public double itemPrice() {
        if(this.donutType.equals("Yeast Donut")) {
            return COSTOFYEASTDONUT * this.quantity;
        } else if(this.donutType.equals("Cake Donut")) {
            return COSTOFCAKEDONUT * this.quantity;
        } else if(this.donutType.equals("Donut Hole")){
            return COSTOFDONUTHOLE * this.quantity;
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
        return this.donutFlavor + "(" + this.quantity +")";
    }
}
