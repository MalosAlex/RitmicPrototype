package com.example.ritmic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 480);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/logo.png")));
        stage.setTitle("Day Viewer");
        stage.setScene(scene);
        stage.setResizable(false); // Prevents resizing
        //stage.setWidth(800); // Set fixed width
        //stage.setHeight(700); // Set fixed height
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}