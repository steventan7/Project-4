package com.example.project4;

import java.util.ArrayList;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private Button removeDonut, addDonut, exitButton;

    private ArrayList<MenuItem> selectedDonuts;
    private ObservableList<String> yeastDonutFlavors;
    private ObservableList<String> cakeDonutFlavors;
    private ObservableList<String> donutHoleFlavors;

    protected void setMainController (StoreFrontController controller){
        mainController = controller;
    }

    /**
     * Initializes the necessary components (Comboboxes, List views) by setting the observable arrays for each.
     * The yeast donut type is set as default in the selection.
     */
    public void initialize() {
        amountList = FXCollections.observableArrayList("1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20");
        yeastDonutFlavors = FXCollections.observableArrayList(Donut.yeastDonutFlavors);
        cakeDonutFlavors = FXCollections.observableArrayList(Donut.cakeDonutFlavors);
        donutHoleFlavors = FXCollections.observableArrayList(Donut.donutHoleFlavors);
        donutList = FXCollections.observableArrayList(Donut.donutTypes);
        donutOrderList = FXCollections.observableArrayList();

        donutOrderBox.setItems(donutList);
        donutFlavorsListView.setItems(yeastDonutFlavors);
        donutOrderListView.setItems(donutOrderList);
        amount.setItems(amountList);
        selectedDonuts = new ArrayList<>();

        donutOrderBox.getSelectionModel().select(Donut.donutTypes[0]);
        itemPrice.setText("$0.00");
        amount.getSelectionModel().select("1");
    }

    /**
     * Handles the Combobox that specifies the type of donut the user selected and updates the selection List view to
     * display the flavors specific to that type of donut.
     */
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

    /**
     * Adds the selected donut and flavor from the donut Combobox and List view to the order List view alongside with
     * the selected quantity from the amount Combobox. Removes that flavor from the selection List view then updates
     * the running subtotal and arraylist that keeps track of the currently selected items.
     */
    @FXML
    protected void addDonut() {
        String selectedDonutType = donutOrderBox.getSelectionModel().getSelectedItem();
        String selectedFlavor = donutFlavorsListView.getSelectionModel().getSelectedItem();
        String quantity = amount.getSelectionModel().getSelectedItem();
        if(selectedFlavor != null) {
            if(selectedDonutType.equals("Yeast Donut")) {
                donutOrderList.add(selectedFlavor + "(" + quantity + ")");
                selectedDonuts.add(new Donut(selectedDonutType, selectedFlavor, Integer.parseInt(quantity)));
                yeastDonutFlavors.remove(selectedFlavor);
            } else if (selectedDonutType.equals("Cake Donut")) {
                donutOrderList.add(selectedFlavor + "(" + quantity + ")");
                selectedDonuts.add(new Donut(selectedDonutType, selectedFlavor, Integer.parseInt(quantity)));
                cakeDonutFlavors.remove(selectedFlavor);
            } else {
                donutOrderList.add(selectedFlavor + "(" + quantity + ")");
                selectedDonuts.add(new Donut(selectedDonutType, selectedFlavor, Integer.parseInt(quantity)));
                donutHoleFlavors.remove(selectedFlavor);
            }
        }
        itemPrice.setText(DecimalFormat.getCurrencyInstance().format(calculateSubTotal()));
    }

    /**
     * Removes the selected donut flavor from the order List view alongside with quantity. The flavor is then added
     * back to the selection List view under the corresponding donut type. Updates the running subtotal and the
     * arraylist that keeps track of the currently selected items.
     */
    @FXML
    protected void removeDonut() {
        String selectedDonutType= donutOrderBox.getSelectionModel().getSelectedItem();
        String selectedFlavor= donutOrderListView.getSelectionModel().getSelectedItem();
        if(selectedFlavor != null) {
            String flavor = selectedFlavor.substring(0,selectedFlavor.indexOf('('));
            if(selectedDonutType.equals("Yeast Donut")) {
                donutOrderList.remove(selectedFlavor);
                removeDonut(flavor);
                yeastDonutFlavors.add(flavor);
            } else if (selectedDonutType.equals("Cake Donut")) {
                donutOrderList.remove(selectedFlavor);
                removeDonut(flavor);
                cakeDonutFlavors.add(flavor);
            } else {
                donutOrderList.remove(selectedFlavor);
                removeDonut(flavor);
                donutHoleFlavors.add(flavor);
            }
        }
        itemPrice.setText(DecimalFormat.getCurrencyInstance().format(calculateSubTotal()));
    }
    @FXML
    public void addToOrder() {
        mainController.updateOrder(selectedDonuts);
        ((Stage) exitButton.getScene().getWindow()).close();
    }

    /**
     * Calculates the running subtotal of the items currently selected by the user, which is tracked by an
     * arraylist.
     * @return double equal to the sum of all the selected donut prices.
     */
    private double calculateSubTotal() {
        double subTotal = 0.00;
        for(MenuItem itemChosen : selectedDonuts) {
            subTotal += itemChosen.itemPrice();
        }
        return subTotal;
    }
    /**
     * Searches through the arraylist that tracks the items currently selected by the user to remove the donut item
     * with the flavor that is equal to the one given as an argument String.
     * @param donutFlavor String equal to the donut flavor that should be removed.
     */
    private void removeDonut(String donutFlavor) {
        for(MenuItem itemChosen : selectedDonuts) {
            if(itemChosen instanceof Donut) {
                Donut donutChosen = (Donut) itemChosen;
                if (donutChosen.donutFlavor().equals(donutFlavor)){
                    selectedDonuts.remove(itemChosen);
                    return;
                }
            }
        }
    }
}
