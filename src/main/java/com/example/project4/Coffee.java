package com.example.project4;

import java.util.ArrayList;

/**
 * Donut class used to create objects representing different orders for cups of coffee
 * @author Steven Tan, David Fabian
 */
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

    /**
     * Constructs a Coffee instance for a coffee order.
     * Holds an empty list of addIns and has a default quantity of 1.
     */
    public Coffee() {
        this.addIns = new ArrayList<>();
        this.quantity = 1;
    }

    /**
     * Calculates the itemPrice based upon cupSize, the number of add-ins, and the number of cups ordered.
     * @return the new itemPrice for the most recent coffee order.
     */
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

    /**
     * Gets the list of add-ins in the current coffee order.
     * @return an ArrayList<String> of the list of add-ins.
     */
    public ArrayList<String> listOfAddIns() {
        return this.addIns;
    }

    /**
     * Sets the current cupSize to the newCupSize.
     * @oaram newCupSize String representation of the cupSize the order is changed to
     */
    public void setCupSize(String newCupSize) {
        this.cupSize = newCupSize;
    }

    /**
     * Sets the current quantity to the newQuantity.
     * @oaram newQuantity the newQuantity value the quantity value is changed to
     */
    public void setQuantity (int newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * Forms a formatted string [cupSize Black Coffee (quantity) [listOfAddIns]] of this Date instance.
     * @return a string formatted as above representing a coffee order.
     */
    public String toString() {
        return cupSize + " Black Coffee (" + quantity + ")" + "[" + stringListOfAddIns() + "]";
    }

    /**
     * Creates a String of the list of add-ins.
     * @return a string representation of the list of add-ins
     */
    private String stringListOfAddIns() {
        String list = "";
        for (String addIn: addIns) {
            list += addIn;
        }
        return list;
    }
}
