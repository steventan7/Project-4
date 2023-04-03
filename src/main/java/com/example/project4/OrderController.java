package com.example.project4;

import java.util.ArrayList;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderController {
    private StoreFrontController mainController;
    private Order editableOrder;
    private static final double newJerseySalesTax = 0.06625;
    @FXML
    private ListView<String> orderListView;
    @FXML
    private TextField orderNumber, orderSubTotal, orderSalesTax, orderTotal;
    private ObservableList<String> orderedItems;
    public void setMainController (StoreFrontController controller){
        mainController = controller;
    }
    public void initialize() {}
    @FXML
    protected void removeItem() {
        String selectedItem = this.orderListView.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            this.editableOrder.removeItem(selectedItem);
            this.orderedItems.remove(selectedItem);
        }
        this.updatePrices();
    }
    @FXML
    protected void addToStoreOrders() {
        this.orderListView.setItems(null);
    }
    public void setOrderedItems(Order currOrder) {
        this.editableOrder = null;
        if(currOrder == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("NO ORDERED ITEMS");
            alert.setHeaderText("Order list is empty!");
            alert.setContentText("Current order list does not have any items. Please go to the Coffee or Donut Views" +
                    " to add menu items to your order.");
            alert.showAndWait();
            return;
        }
        this.editableOrder = currOrder;
        ArrayList<String> itemList = new ArrayList<>();
        for(MenuItem item : currOrder.menuList()) {
            itemList.add(item.toString());
        }
        this.orderNumber.setText(String.valueOf(currOrder.orderNumber()));
        this.orderedItems = FXCollections.observableArrayList(itemList);
        this.orderListView.setItems(this.orderedItems);
        this.updatePrices();
    }
    private void updatePrices() {
        if(this.editableOrder != null) {
            double salesTax = newJerseySalesTax * this.editableOrder.subTotal();
            orderSubTotal.setText(DecimalFormat.getCurrencyInstance().format(this.editableOrder.subTotal()));
            orderSalesTax.setText(DecimalFormat.getCurrencyInstance().format(salesTax));
            orderTotal.setText(DecimalFormat.getCurrencyInstance().format(this.editableOrder.subTotal()
                    + salesTax));
        }
    }
}
