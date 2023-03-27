package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class CoffeeController {
    private StoreFrontController mainController;
    private ObservableList<String> cupSizeList;
    private ObservableList<String> quantityList;

    @FXML
    private CheckBox sweetCream, caramel, vanilla, irishCream, frenchVanilla;

    @FXML
    private ComboBox cupSize;

    @FXML
    private ComboBox chosenQuantity;

    private Coffee coffeeOrder = new Coffee();

    public void initialize() {
        quantityList = FXCollections.observableArrayList("1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        cupSizeList = FXCollections.observableArrayList("Small", "Medium", "Large");
        cupSize.setItems(cupSizeList);
        chosenQuantity.setItems(quantityList);
    }

    @FXML
    protected void addCaramel() {
        if (caramel.isSelected() && !coffeeOrder.listOfAddIns().contains("Caramel")) {
            coffeeOrder.listOfAddIns().add("Caramel");
        } else {
            if(coffeeOrder.listOfAddIns().contains("Caramel")) {
                coffeeOrder.listOfAddIns().remove("Caramel");
            }
        }
    }

    @FXML
    protected void addIrishCream() {
        if (caramel.isSelected() && !coffeeOrder.listOfAddIns().contains("Irish Cream")) {
            coffeeOrder.listOfAddIns().add("Irish Cream");
        } else {
            if(coffeeOrder.listOfAddIns().contains("Irish Cream")) {
                coffeeOrder.listOfAddIns().remove("Irish Cream");
            }
        }
    }

    @FXML
    protected void addVanilla() {
        if (caramel.isSelected() && !coffeeOrder.listOfAddIns().contains("Vanilla")) {
            coffeeOrder.listOfAddIns().add("Vanilla");
        } else {
            if(coffeeOrder.listOfAddIns().contains("Vanilla")) {
                coffeeOrder.listOfAddIns().remove("Vanilla");
            }
        }
    }

    @FXML
    protected void addFrenchVanilla() {
        if (caramel.isSelected() && !coffeeOrder.listOfAddIns().contains("French Vanilla")) {
            coffeeOrder.listOfAddIns().add("French Vanilla");
        } else {
            if(coffeeOrder.listOfAddIns().contains("French Vanilla")) {
                coffeeOrder.listOfAddIns().remove("French Vanilla");
            }
        }
    }

    @FXML
    protected void addSweetCream() {
        if (caramel.isSelected() && !coffeeOrder.listOfAddIns().contains("Sweet Cream")) {
            coffeeOrder.listOfAddIns().add("Sweet Cream");
        } else {
            if(coffeeOrder.listOfAddIns().contains("Sweet Cream")) {
                coffeeOrder.listOfAddIns().remove("Sweet Cream");
            }
        }
    }

    @FXML
    protected void setQuantity() {

    }
    public void setMainController (StoreFrontController controller){
        mainController = controller;
    }
}
