package com.example.project4;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.File;
import java.io.PrintWriter;
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
            alert.setTitle("NO STORE MORE ORDERS");
            alert.setHeaderText("Store order list now is empty!");
            alert.setContentText("Current store order list does not have any items. Please place orders first to " +
                    "utilize this tool.");
            alert.showAndWait();
        } else {
            this.orderNumberBox.getSelectionModel().select(0);
            this.selectedOrder = this.storeOrdersRef.get(0);
        }
        this.updateDisplayedItems();
        this.updatePrice();
    }
    @FXML
    protected void exportOrder() {
        String orderName = "Order-" + selectedOrder.orderNumber();
        String fullFileName = orderName + ".txt";
        File newFile = new File(fullFileName);
        int duplicates = 1;
        while(newFile.exists()) {
            fullFileName = orderName + "(" + duplicates + ")" + ".txt";
            newFile = new File(fullFileName);
            duplicates += 1;
        }
        String content = "Store Order # " + selectedOrder.orderNumber() + ":\n";
        for(String itemDesc : orderListView.getItems()) {
            content += itemDesc + "\n";
        }
        try {
            if(!newFile.createNewFile()) {
                throw new FileAlreadyExistsException(newFile.getAbsolutePath());
            }
            PrintWriter outputWriter = new PrintWriter(newFile);
            outputWriter.print(content);
            outputWriter.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("FILE CREATED");
            alert.setHeaderText("New File Was Created");
            alert.setContentText(newFile.getName() + " was created and is located: " + newFile.getAbsolutePath());
            alert.showAndWait();
            this.cancelOrder();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("FILE ERROR");
            alert.setHeaderText("Writing to File Error");
            alert.setContentText("New file could not be created to export store order.");
            alert.showAndWait();
        }
    }
    private void updateDisplayedItems() {
        ArrayList<String> itemList = new ArrayList<>();
        if(this.selectedOrder != null) {
            for(MenuItem item : this.selectedOrder.menuList()) {
                itemList.add(item.toString());
            }
        }
        this.orderedItemsArray = FXCollections.observableArrayList(itemList);
        this.orderListView.setItems(orderedItemsArray);
    }
    private void updatePrice() {
        if(this.selectedOrder != null) {
            this.orderTotal.setText(DecimalFormat.getCurrencyInstance().format(this.selectedOrder.subTotal() *
                    TOTALNJTAX));
        } else {
            this.orderTotal.setText("$0.00");
        }
    }
}
