package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class DonutController {

    private StoreFrontController mainController;
    private ObservableList<String> donutComboBoxList;
    private ObservableList<String> donutOrderList;
    private ObservableList<String> amountList;

    @FXML
    private ImageView cakeDonutImage, yeastDonutImage, donutHoleImage;

    @FXML
    private ListView<String> donutFlavorsListView;

    @FXML
    private ListView<String> donutOrderListView;

    @FXML
    private ComboBox<String> donutOrderComboBox;

    @FXML
    private ComboBox<String> amount;

    @FXML
    private TextArea itemPrice;

    @FXML
    private Button removeDonut, addDonut;

    private ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("Jelly", "Vanilla",
            "Cinnamon", "Apple Cider", "Blueberry", "Pumpkin Spice");
    private ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("Chocolate", "Rainbow",
            "Sugar");
    private ObservableList<String> donutHoleFlavors = FXCollections.observableArrayList("Red Velvet", "Apple Fritter",
            "Powdered");

    private ArrayList<Donut> listOfDonutsOrdered = new ArrayList<>();

    private double totalCost = 0;

    protected void setMainController(StoreFrontController controller) {
        mainController = controller;
    }

    public void initialize() {
        amountList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20");
        donutComboBoxList = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Hole");
        donutOrderList = FXCollections.observableArrayList();
        donutOrderComboBox.setItems(donutComboBoxList);
        donutFlavorsListView.setItems(yeastDonutFlavors);
        donutOrderListView.setItems(donutOrderList);
        amount.setItems(amountList);
        donutOrderComboBox.getSelectionModel().select("Yeast Donut");
        itemPrice.setText("0.00");
        amount.getSelectionModel().select("1");
    }

    @FXML
    protected void changeDonutType() {
        String selectedDonutType = donutOrderComboBox.getSelectionModel().getSelectedItem();
        if (selectedDonutType.equals("Yeast Donut")) {
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
        String selectedDonutType = donutOrderComboBox.getSelectionModel().getSelectedItem();
        String selectedFlavor = donutFlavorsListView.getSelectionModel().getSelectedItem();
        String order = selectedFlavor + "(" + amount.getSelectionModel().getSelectedItem() + ")";
        int quantity = Integer.parseInt(amount.getSelectionModel().getSelectedItem());

        if (selectedFlavor != null) {
            Donut donut;
            if (selectedDonutType.equals("Yeast Donut")) {
                donut = new Donut("Yeast Donut", selectedFlavor, quantity);
                donutOrderList.add(order);
                yeastDonutFlavors.remove(selectedFlavor);
            } else if (selectedDonutType.equals("Cake Donut")) {
                donut = new Donut("Cake Donut", selectedFlavor, quantity);
                donutOrderList.add(order);
                cakeDonutFlavors.remove(selectedFlavor);
            } else {
                donut = new Donut("Donut Hole", selectedFlavor, quantity);
                donutOrderList.add(order);
                donutHoleFlavors.remove(selectedFlavor);
            }
            listOfDonutsOrdered.add(donut);
            totalCost += donut.itemPrice();
            itemPrice.setText(String.valueOf(totalCost));
        }
    }

    @FXML
    protected void removeDonut() {
        try {
            String selectedFlavor = donutOrderListView.getSelectionModel().getSelectedItem();
            String flavor = selectedFlavor.substring(0, selectedFlavor.indexOf('('));
            Donut donutToBeRemoved = listOfDonutsOrdered.get(findDonut(flavor));

            if (donutToBeRemoved.donutType().equals("Yeast Donut")) {
                if (selectedFlavor != null) {
                    donutOrderList.remove(selectedFlavor);
                    yeastDonutFlavors.add(flavor);
                }
            } else if (donutToBeRemoved.donutType().equals("Cake Donut")) {
                if (selectedFlavor != null) {
                    donutOrderList.remove(selectedFlavor);
                    cakeDonutFlavors.add(flavor);
                }
            } else {
                if (selectedFlavor != null) {
                    donutOrderList.remove(selectedFlavor);
                    donutHoleFlavors.add(flavor);
                }
            }
            listOfDonutsOrdered.remove(donutToBeRemoved);
            totalCost -= donutToBeRemoved.itemPrice();
            itemPrice.setText(String.valueOf(totalCost));
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Order cannot be removed");
            alert.setHeaderText("Please click an order to be removed");
            alert.showAndWait();
        }
    }

    private int findDonut(String flavor) {
        for (int i = 0; i < listOfDonutsOrdered.size(); i++) {
            if (listOfDonutsOrdered.get(i).donutFlavor().equals(flavor)) {
                return i;
            }
        }
        return -1;
    }
}
