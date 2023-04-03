package com.example.project4;

public class Donut extends MenuItem{
    static public final String [] DONUTTYPES = {"Yeast Donut", "Cake Donut", "Donut Hole"};
    static private final double [] DONUTPRICES = {1.59, 1.79, 0.39};
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
            return DONUTPRICES[0] * this.donutQuantity;
        } else if(this.donutType.equals(DONUTTYPES[1])) {
            return DONUTPRICES[1] * this.donutQuantity;
        } else if(this.donutType.equals(DONUTTYPES[2])){
            return DONUTPRICES[2] * this.donutQuantity;
        }
        return 0.00;
    }
    public String donutFlavor() {
        return this.donutFlavor;
    }
    @Override
    public String toString() {
        return this.donutFlavor + "(" + this.donutQuantity + ")";
    }
}
