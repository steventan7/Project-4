package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainView.class.getResource("ru-cafe.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 832, 600);
        stage.setTitle("Welcome to RUCafe!");
        Button back = new Button("Back ..");
        Button forth = new Button(".. forth.");

        Scene first = new Scene(back);
        Scene second = new Scene(forth);

        back.setOnAction((event) -> {
            stage.setScene(second);
        });

        forth.setOnAction((event) -> {
            stage.setScene(first);
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}