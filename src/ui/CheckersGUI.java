package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckersGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CheckerBoard.fxml"));

        Scene scene = new Scene(root, 700, 700);

        stage.setTitle("Checkers");
        stage.setScene(scene);
        stage.show();
    }

    // ******************** Launching *******************************
    public static void main(final String[] args) {
        launch(args);
    }
}