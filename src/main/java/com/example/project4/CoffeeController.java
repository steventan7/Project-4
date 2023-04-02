package com.example.project4;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class CoffeeController {
    private StoreFrontController mainController;
    private ObservableList<String> cupSizeList;
    private ObservableList<String> quantityList;

    @FXML
    private CheckBox sweetCream, caramel, vanilla, irishCream, frenchVanilla;

    @FXML
    private ComboBox<String> cupSize;

    @FXML
    private ComboBox<String> chosenQuantity;

    @FXML
    private TextArea itemPrice;

    private Coffee coffeeOrder = new Coffee();

    public void initialize() {
        quantityList = FXCollections.observableArrayList("1","2","3", "4", "5");
        cupSizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        cupSize.setItems(cupSizeList);
        chosenQuantity.setItems(quantityList);
        itemPrice.setText("$0.00");
        chosenQuantity.getSelectionModel().select("1");
        cupSize.getSelectionModel().select("Short");
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
        itemPrice.setText(String.valueOf(coffeeOrder.itemPrice()));
    }

    @FXML
    protected void addIrishCream() {
        if (irishCream.isSelected() && !coffeeOrder.listOfAddIns().contains("Irish Cream")) {
            coffeeOrder.listOfAddIns().add("Irish Cream");
        } else {
            if(coffeeOrder.listOfAddIns().contains("Irish Cream")) {
                coffeeOrder.listOfAddIns().remove("Irish Cream");
            }
        }
        itemPrice.setText("$" + coffeeOrder.itemPrice());
    }

    @FXML
    protected void addVanilla() {
        if (vanilla.isSelected() && !coffeeOrder.listOfAddIns().contains("Vanilla")) {
            coffeeOrder.listOfAddIns().add("Vanilla");
        } else {
            if(coffeeOrder.listOfAddIns().contains("Vanilla")) {
                coffeeOrder.listOfAddIns().remove("Vanilla");
            }
        }
        itemPrice.setText("$" + coffeeOrder.itemPrice());
    }

    @FXML
    protected void addFrenchVanilla() {
        if (frenchVanilla.isSelected() && !coffeeOrder.listOfAddIns().contains("French Vanilla")) {
            coffeeOrder.listOfAddIns().add("French Vanilla");
        } else {
            if(coffeeOrder.listOfAddIns().contains("French Vanilla")) {
                coffeeOrder.listOfAddIns().remove("French Vanilla");
            }
        }
        itemPrice.setText("$" + coffeeOrder.itemPrice());
    }

    @FXML
    protected void addSweetCream() {
        if (sweetCream.isSelected() && !coffeeOrder.listOfAddIns().contains("Sweet Cream")) {
            coffeeOrder.listOfAddIns().add("Sweet Cream");
        } else {
            if(coffeeOrder.listOfAddIns().contains("Sweet Cream")) {
                coffeeOrder.listOfAddIns().remove("Sweet Cream");
            }
        }
        itemPrice.setText("$" + coffeeOrder.itemPrice());
    }

    @FXML
    protected void setCupSize() {
        String cup = this.cupSize.getSelectionModel().getSelectedItem();
        if(cup != null) {
            coffeeOrder.setCupSize(this.cupSize.getSelectionModel().getSelectedItem());
        }
        itemPrice.setText("$" + coffeeOrder.itemPrice());
    }

    @FXML
    protected void setQuantity() {
        String value = this.chosenQuantity.getSelectionModel().getSelectedItem();
        coffeeOrder.setQuantity(Integer.parseInt(value));
        itemPrice.setText("$" + coffeeOrder.itemPrice());
    }

    public void setMainController (StoreFrontController controller){
        mainController = controller;
    }
}
