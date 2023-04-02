package com.example.project4;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreFrontController {
    public Order currentOrder;
    @FXML
    protected void donutView() {
        Stage view1 = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("donutView.fxml"));
            root = loader.load();
            Scene scene = new Scene(root, 832, 600);
            view1.setScene(scene);
            view1.show();
            DonutController view1controller = loader.getController();
            view1controller.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void orderView() {
        Stage view1 = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderView.fxml"));
            root = loader.load();
            Scene scene = new Scene(root, 832, 600);
            view1.setScene(scene);
            view1.show();
            OrderController view1controller = loader.getController();
            view1controller.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void storeOrderView() {
        Stage view1 = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("storeOrderView.fxml"));
            root = loader.load();
            Scene scene = new Scene(root, 832, 600);
            view1.setScene(scene);
            view1.show();
            StoreOrderController view1controller = loader.getController();
            view1controller.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }
    @FXML
    protected void coffeeView() {
        Stage view1 = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("coffeeView.fxml"));
            root = loader.load();
            Scene scene = new Scene(root, 832, 600);
            view1.setScene(scene);
            view1.show();
            CoffeeController view1controller = loader.getController();
            view1controller.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }
    public void updateOrder(ArrayList<MenuItem> newItems) {
        if(currentOrder == null) {
            currentOrder = new Order();
        }
        currentOrder.addItems(newItems);
    }

}
