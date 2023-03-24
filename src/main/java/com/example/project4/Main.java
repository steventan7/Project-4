package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("storeFrontView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 832, 600);
        primarystage.setTitle("Welcome to RUCafe!");
        primarystage.setScene(scene);
        primarystage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}