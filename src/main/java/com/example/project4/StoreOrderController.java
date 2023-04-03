package com.example.project4;

import java.util.ArrayList;
import java.text.DecimalFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

/**
 * This class contains methods that allows the user to view all the orders placed so far, make any final changes, and
 * export the order.
 * @author David Fabian, Steven Tan
 */
public class StoreOrderController {
    private StoreFrontController mainController;
    private ArrayList<Order> storeOrdersRef;
    private Order selectedOrder;
    private static final double TOTALNJTAX = 1.06625;
    @FXML
    private ListView<String> orderListView;
    @FXML
    private ComboBox<Integer> orderNumberBox;
    @FXML
    private TextField orderTotal;
    private ObservableList<Integer> orderNumberArray;
    private ObservableList<String> orderedItemsArray;
    public void setMainController (StoreFrontController controller){
        mainController = controller;
    }
    public void initialize() {}
    public void setOrder() {
        this.storeOrdersRef = null;
        if(mainController == null || mainController.storeOrders == null || mainController.storeOrders.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("NO STORE ORDERS");
            alert.setHeaderText("Store order list is empty!");
            alert.setContentText("Current store order list does not have any items. Please place orders first to " +
                    "utilize this tool.");
            alert.showAndWait();
            return;
        }
        this.storeOrdersRef = mainController.storeOrders;
        ArrayList<Integer> orderNumList = new ArrayList<>();
        for(Order item : this.storeOrdersRef) {
            orderNumList.add(item.orderNumber());
        }
        this.orderNumberArray = FXCollections.observableArrayList(orderNumList);
        this.orderNumberBox.setItems(orderNumberArray);
        this.orderNumberBox.getSelectionModel().select(0);
        this.selectedOrder = this.storeOrdersRef.get(0);
        this.updateDisplayedItems();
        this.updatePrice();
    }
    @FXML
    protected void changeOrder() {
        int orderNum = this.orderNumberBox.getSelectionModel().getSelectedItem();
        int findOrderIndex = 0;
        while(findOrderIndex < this.storeOrdersRef.size() &&
                this.storeOrdersRef.get(findOrderIndex).orderNumber() != orderNum) {
            findOrderIndex++;
        }
        if(findOrderIndex < this.storeOrdersRef.size()) {
            this.selectedOrder = this.storeOrdersRef.get(findOrderIndex);
            this.updateDisplayedItems();
            this.updatePrice();
        }
    }
    @FXML
    protected void cancelOrder() {
        this.orderNumberArray.remove((Integer) this.selectedOrder.orderNumber());
        this.storeOrdersRef.remove(this.selectedOrder);
        if(this.storeOrdersRef.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("NO STORE ORDERS");
            alert.setHeaderText("Store order list is empty!");
            alert.setContentText("Current store order list does not have any items. Please place orders first to " +
                    "utilize this tool.");
            alert.showAndWait();
            return;
        }
        this.orderNumberBox.getSelectionModel().select(0);
        this.selectedOrder = this.storeOrdersRef.get(0);
        this.updateDisplayedItems();
        this.updatePrice();
    }
    @FXML
    protected void exportOrder() {}
    private void updateDisplayedItems() {
        if(this.selectedOrder == null) {
            return;
        }
        ArrayList<String> itemList = new ArrayList<>();
        for(MenuItem item : this.selectedOrder.menuList()) {
            itemList.add(item.toString());
        }
        this.orderedItemsArray = FXCollections.observableArrayList(itemList);
        this.orderListView.setItems(orderedItemsArray);
    }
    private void updatePrice() {
        if(this.selectedOrder != null) {
            orderTotal.setText(DecimalFormat.getCurrencyInstance().format(this.selectedOrder.subTotal() *
                    TOTALNJTAX));
        }
    }
}
