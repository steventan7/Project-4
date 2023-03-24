package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreFrontController {
    @FXML
    protected void displayView1() {
        Stage view1 = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DonutView.fxml"));
            root = (BorderPane) loader.load();
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
}
