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
    private ObservableList<String> donutOrderList;
    private ObservableList<String> amountList;

    @FXML
    private ImageView cakeDonutImage, yeastDonutImage, donutHoleImage;

    @FXML
    private ListView<String> donutFlavorsListView;

    @FXML
    private ListView<String> donutOrderListView;

    @FXML
    private ComboBox<String> donutOrderBox;

    @FXML
    private ComboBox<String> amount;

    @FXML
    private TextArea itemPrice;

    @FXML
    private Button removeDonut, addDonut;

    private Donut yeastDonutOrder = new Donut("Yeast Donut");
    private Donut donutHoleOrder = new Donut("Donut Hole");
    private Donut cakeDonutOrder = new Donut("Cake Donut");

    private ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Jelly", "Vanilla",
            "Cinnamon", "Apple Cider", "Blueberry", "Pumpkin Spice");
    private ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Chocolate", "Rainbow",
            "Sugar");
    private ObservableList<String> donutHoleFlavors = FXCollections.observableArrayList("Red Velvet", "Apple Fritter",
            "Powdered");

    protected void setMainController (StoreFrontController controller){
        mainController = controller;
    }

    public void initialize() {
        amountList = FXCollections.observableArrayList("1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20");
        donutList = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Hole");
        donutOrderList = FXCollections.observableArrayList();
        donutOrderBox.setItems(donutList);
        donutFlavorsListView.setItems(yeastDonutFlavors);
        donutOrderListView.setItems(donutOrderList);
        amount.setItems(amountList);
        donutOrderBox.getSelectionModel().select("Yeast Donut");
        itemPrice.setText("0.00");
        amount.getSelectionModel().select("1");
    }

    @FXML
    protected void changeDonutType() {
        String selectedDonutType = donutOrderBox.getSelectionModel().getSelectedItem();
        if(selectedDonutType.equals("Yeast Donut")) {
            donutFlavorsListView.setItems(yeastDonutFlavors);
            yeastDonutImage.setVisible(true);
            donutHoleImage.setVisible(false);
            cakeDonutImage.setVisible(false);
        } else if (selectedDonutType.equals("Cake Donut")) {
            donutFlavorsListView.setItems(cakeDonutFlavors);
            yeastDonutImage.setVisible(false);
            donutHoleImage.setVisible(false);
            cakeDonutImage.setVisible(true);
        } else {
            donutFlavorsListView.setItems(donutHoleFlavors);
            yeastDonutImage.setVisible(false);
            donutHoleImage.setVisible(true);
            cakeDonutImage.setVisible(false);
        }
    }

    @FXML
    protected void addDonut() {
        String selectedDonutType = donutOrderBox.getSelectionModel().getSelectedItem();
        String selectedFlavor= donutFlavorsListView.getSelectionModel().getSelectedItem();
        String order = selectedFlavor + "(" + amount.getSelectionModel().getSelectedItem() + ")";
        if(selectedFlavor != null) {
            if(selectedDonutType.equals("Yeast Donut")) {
                donutOrderList.add(order);
                yeastDonutOrder.donutList().add(order);
                yeastDonutFlavors.remove(selectedFlavor);
            } else if (selectedDonutType.equals("Cake Donut")) {
                donutOrderList.add(order);
                cakeDonutOrder.donutList().add(order);
                cakeDonutFlavors.remove(selectedFlavor);
            } else {
                donutOrderList.add(order);
                donutHoleOrder.donutList().add(order);
                donutHoleFlavors.remove(selectedFlavor);
            }
        }
        itemPrice.setText(String.valueOf(yeastDonutOrder.itemPrice() + donutHoleOrder.itemPrice()
                + cakeDonutOrder.itemPrice()));
    }

    @FXML
    protected void removeDonut() {
        String selectedDonutType= donutOrderBox.getSelectionModel().getSelectedItem();
        String selectedFlavor= donutOrderListView.getSelectionModel().getSelectedItem();
        String flavor = selectedFlavor.substring(0,selectedFlavor.indexOf('('));
        if(selectedDonutType.equals("Yeast Donut")) {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor);
                yeastDonutOrder.donutList().remove(selectedFlavor);
                yeastDonutFlavors.add(flavor);
            }
        } else if (selectedDonutType.equals("Cake Donut")) {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor);
                cakeDonutOrder.donutList().remove(selectedFlavor);
                cakeDonutFlavors.add(flavor);
            }
        } else {
            if(selectedFlavor != null) {
                donutOrderList.remove(selectedFlavor);
                donutHoleOrder.donutList().remove(selectedFlavor);
                donutHoleFlavors.add(flavor);
            }
        }
        itemPrice.setText(String.valueOf(yeastDonutOrder.itemPrice() + donutHoleOrder.itemPrice()
                + cakeDonutOrder.itemPrice()));
    }

}
