package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class DonutController {
    private StoreFrontController mainController;
    private ObservableList<String> donutList;
    private ObservableList<String> donutFlavors;
    private ObservableList<String> donutOrderList;
    private ObservableList<String> amountList;

    @FXML
    private ListView<String> donutListView;

    @FXML
    private ListView<String> donutOrderListView;

    @FXML
    private ComboBox<String> donutBox;

    @FXML
    private ComboBox<String> amount;

    @FXML
    private TextArea itemPrice;

    @FXML
    private Button removeDonut, addDonut;

    private Donut yeastDonutOrder = new Donut();
    private Donut donutHoleOrder = new Donut();
    private Donut cakeDonutOrdedr = new Donut();

    public void setMainController (StoreFrontController controller){
        mainController = controller;
    }

    public void initialize() {
        amountList = FXCollections.observableArrayList("1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20");
        donutList = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Hole");
        donutFlavors = FXCollections.observableArrayList("Chocolate", "Vanilla", "Cinnamon", "Apple Cider",
                "Blueberry", "Pumpkin Spice");
        donutOrderList = FXCollections.observableArrayList();
        donutBox.setItems(donutList);
        donutListView.setItems(donutFlavors);
        donutOrderListView.setItems(donutOrderList);
        amount.setItems(amountList);
    }

    private ObservableList<String> yeastFlavors = FXCollections.observableArrayList("Chocolate", "Vanilla", "Cinnamon",
            "Apple Cider", "Blueberry", "Pumpkin Spice");

    @FXML
    public void addDonut() {
        String selectedDonutType = donutBox.getSelectionModel().getSelectedItem();
        String selectedFlavor= donutListView.getSelectionModel().getSelectedItem();
        if(selectedDonutType.equals("Yeast Donut")) {
            if(selectedFlavor != null) {
                donutOrderList.add(selectedFlavor + " " + amount.getSelectionModel().getSelectedItem() + ")");
                donutFlavors.remove(selectedFlavor);
            }
        } else if (selectedDonutType.equals("Cake Donut")) {
            if(selectedFlavor != null) {
                donutOrderList.add(selectedFlavor + " (" + amount.getSelectionModel().getSelectedItem() + ")");
                donutFlavors.remove(selectedFlavor);
            }
        } else {
            if(selectedFlavor != null) {
                donutOrderList.add(selectedFlavor + " (" + amount.getSelectionModel().getSelectedItem() + ")");
                donutFlavors.remove(selectedFlavor);
            }
        }
        itemPrice.setText(String.valueOf(yeastDonutOrder.itemPrice() + donutHoleOrder.itemPrice()
                + cakeDonutOrdedr.itemPrice()));
    }

    @FXML
    public void removeDonut() {
        String selectedDonutType= donutBox.getSelectionModel().getSelectedItem();
        String selectedFlavor= donutListView.getSelectionModel().getSelectedItem();
        if(selectedDonutType.equals("Yeast Donut")) {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor + " " + amount.getSelectionModel().getSelectedItem());
                donutFlavors.add(selectedFlavor);
            }
        } else if (selectedDonutType.equals("Cake Donut")) {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor + " " + amount.getSelectionModel().getSelectedItem());
                donutFlavors.add(selectedFlavor);
            }
        } else {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor + " " + amount.getSelectionModel().getSelectedItem());
                donutFlavors.add(selectedFlavor);
            }
        }
        itemPrice.setText(String.valueOf(yeastDonutOrder.itemPrice() + donutHoleOrder.itemPrice()
                + cakeDonutOrdedr.itemPrice()));
    }


}
