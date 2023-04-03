package com.example.project4;

/**
 * Donut class used to create objects representing different types and flavors of donuts
 * @author Steven Tan, David Fabian
 */
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

    /**
     * Constructs a Donut instance for a donut order.
     * Holds the donut type, flavor of donut, and number of donuts ordered
     * @param  donutType  type of donut
     * @param  donutFlavor  flavor of donut
     * @param  donutQuantity  number of donut type and flavor ordered
     */
    public Donut(String donutType, String donutFlavor, int donutQuantity) {
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
        this.donutQuantity = donutQuantity;
    }

    /**
     * Calculates the itemPrice based upon the cost of type of donut and the donut quantity.
     * @return the new itemPrice for the most recent coffee order.
     */
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

    /**
     * Gets the most recently selected donut flavor
     * @return a string representation of the donut flavor
     */
    public String donutFlavor() {
        return this.donutFlavor;
    }

    /**
     * Gets the most recently selected donut type
     * @return a string representation of the donut type
     */
    public String donutType() {
        return this.donutType;
    }

    /**
     * Forms a formatted string [donut flavor (quantity)]
     * @return a string formatted as above representing a donut order.
     */
    public String toString() {
        return this.donutFlavor + "(" + this.donutQuantity +")";
    }
}
