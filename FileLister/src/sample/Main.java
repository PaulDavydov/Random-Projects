package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        Label label1 = new Label("Enter Folder Path");
        TextField field = new TextField();
        Button button1 = new Button("Submit");
        pane.setTop(label1);
        pane.setCenter(field);
        pane.setBottom(button1);

        VBox box = new VBox();

        Scene one = new Scene(pane);
        Scene two = new Scene(box);

        button1.setOnAction(event ->{
            box.getChildren().add(buttonAction(field.getText()));
            stage.setScene(two);
        });

        stage.setScene(one);
        stage.show();
    }

    public ListView buttonAction(String file) {
        ListView list = new ListView<String>();
        String[] pathnames;
        File f = new File(file);
        pathnames = f.list();
        for(String i : pathnames) {
            list.getItems().add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
