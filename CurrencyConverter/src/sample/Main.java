package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("converter.fxml"));
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(new Scene(root, 650, 305));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
