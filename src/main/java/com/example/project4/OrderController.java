package com.example.project4;

import java.util.ArrayList;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrderController {
    private StoreFrontController mainController;
    private Order currOrderRef;
    private static final double NJSALESTAX = 0.06625;
    @FXML
    private ListView<String> orderListView;
    @FXML
    private TextField orderNumber, orderSubTotal, orderSalesTax, orderTotal;
    @FXML
    private Button exitButton;
    private ObservableList<String> orderedItems;
    public void setMainController (StoreFrontController controller){
        mainController = controller;
    }
    public void initialize() {}
    @FXML
    protected void removeItem() {
        String selectedItem = this.orderListView.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            this.currOrderRef.removeItem(selectedItem);
            this.orderedItems.remove(selectedItem);
        }
        this.updatePrices();
    }
    @FXML
    protected void addToStoreOrders() {
        this.mainController.addToStoreOrders(this.currOrderRef);
        ((Stage) exitButton.getScene().getWindow()).close();
    }
    public void setOrderedItems() {
        this.currOrderRef = null;
        if(mainController == null || mainController.currentOrder == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("NO ORDERED ITEMS");
            alert.setHeaderText("Order list is empty!");
            alert.setContentText("Current order list does not have any items. Please go to the Coffee or Donut Views" +
                    " to add menu items to your order.");
            alert.showAndWait();
            return;
        }
        this.currOrderRef = mainController.currentOrder;
        ArrayList<String> itemList = new ArrayList<>();
        for(MenuItem item : mainController.currentOrder.menuList()) {
            itemList.add(item.toString());
        }
        this.orderNumber.setText(String.valueOf(mainController.currentOrder.orderNumber()));
        this.orderedItems = FXCollections.observableArrayList(itemList);
        this.orderListView.setItems(this.orderedItems);
        this.updatePrices();
    }
    private void updatePrices() {
        if(this.currOrderRef != null) {
            double salesTax = NJSALESTAX * this.currOrderRef.subTotal();
            orderSubTotal.setText(DecimalFormat.getCurrencyInstance().format(this.currOrderRef.subTotal()));
            orderSalesTax.setText(DecimalFormat.getCurrencyInstance().format(salesTax));
            orderTotal.setText(DecimalFormat.getCurrencyInstance().format(this.currOrderRef.subTotal()
                    + salesTax));
        }
    }
}
