package com.example.project4;

public class Donut extends MenuItem{
    static public final String [] donutTypes = {"Yeast Donut", "Cake Donut", "Donut Hole"};
    static private final double [] donutPrices = {1.59, 1.79, 0.39};
    static public final String [] yeastDonutFlavors = {"Jelly", "Vanilla", "Cinnamon", "Apple Cider", "Blueberry",
            "Pumpkin Spice"};
    static public final String [] cakeDonutFlavors = {"Chocolate", "Rainbow", "Sugar"};
    static public final String [] donutHoleFlavors = {"Red Velvet", "Apple Fritter", "Powdered"};
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
        if(this.donutType.equals(donutTypes[0])) {
            return donutPrices[0] * this.donutQuantity;
        } else if(this.donutType.equals(donutTypes[1])) {
            return donutPrices[1] * this.donutQuantity;
        } else if(this.donutType.equals(donutTypes[2])){
            return donutPrices[2] * this.donutQuantity;
        }
        return 0.00;
    }
    public String donutFlavor() {
        return this.donutFlavor;
    }
}
