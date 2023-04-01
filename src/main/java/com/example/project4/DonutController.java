package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class DonutController {
    private StoreFrontController mainController;
    private ObservableList<String> donutList;
    private ObservableList<String> donutFlavors;
    private ObservableList<String> donutOrderList;
    private ObservableList<String> amountList;
    private ImageView yeastDonutImage;
    private ImageView donutHoleImage;
    private ImageView cakeDonutImage;

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

    private ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Jelly", "Vanilla",
            "Cinnamon", "Apple Cider", "Blueberry", "Pumpkin Spice");
    private ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Chocolate", "Vanilla",
            "Cinnamon", "Apple Cider", "Blueberry", "Pumpkin Spice");
    private ObservableList<String> donutHoleFlavors = FXCollections.observableArrayList("Chocolate", "Vanilla",
            "Cinnamon", "Apple Cider", "Blueberry", "Pumpkin Spice");
    protected void setMainController (StoreFrontController controller){
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
        donutBox.getSelectionModel().select("Yeast Donut");
        itemPrice.setText("0.00");
        amount.getSelectionModel().select("1");
    }

    @FXML
    protected void addDonut() {
        String selectedDonutType = donutBox.getSelectionModel().getSelectedItem();
        String selectedFlavor= donutListView.getSelectionModel().getSelectedItem();
        if(selectedFlavor != null) {
            if(selectedDonutType.equals("Yeast Donut")) {
                donutOrderList.add(selectedFlavor + "(" + amount.getSelectionModel().getSelectedItem() + ")");
                donutFlavors.remove(selectedFlavor);
            } else if (selectedDonutType.equals("Cake Donut")) {
                donutOrderList.add(selectedFlavor + "(" + amount.getSelectionModel().getSelectedItem() + ")");
                donutFlavors.remove(selectedFlavor);
            } else {
                donutOrderList.add(selectedFlavor + "(" + amount.getSelectionModel().getSelectedItem() + ")");
                donutFlavors.remove(selectedFlavor);
            }
        }
        itemPrice.setText(String.valueOf(yeastDonutOrder.itemPrice() + donutHoleOrder.itemPrice()
                + cakeDonutOrdedr.itemPrice()));
    }

    @FXML
    protected void removeDonut() {
        String selectedDonutType= donutBox.getSelectionModel().getSelectedItem();
        String selectedFlavor= donutOrderListView.getSelectionModel().getSelectedItem();
        if(selectedDonutType.equals("Yeast Donut")) {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor);
                donutFlavors.add(selectedFlavor.substring(0,selectedFlavor.indexOf('(')));
            }
        } else if (selectedDonutType.equals("Cake Donut")) {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor);
                donutFlavors.add(selectedFlavor.substring(0,selectedFlavor.indexOf('(')));
            }
        } else {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor);
                donutFlavors.add(selectedFlavor.substring(0,selectedFlavor.indexOf('(')));
            }
        }
        itemPrice.setText(String.valueOf(yeastDonutOrder.itemPrice() + donutHoleOrder.itemPrice()
                + cakeDonutOrdedr.itemPrice()));
    }

}
