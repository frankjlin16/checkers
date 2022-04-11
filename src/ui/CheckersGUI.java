package ui;

import core.CheckersLogic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class CheckersGUI extends Application {
    CheckersLogic game = new CheckersLogic();

    @Override
    public void start(Stage stage) throws Exception {

        GridPane grid = new GridPane();
        grid.setMinSize(800, 800);
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid);

        showBoard(grid);

        stage.setTitle("Checkers");
        stage.setScene(scene);
        stage.show();
    }

    public void showBoard(GridPane grid) {
        String[][] currentBoard = game.getBoard();
        for (int i = 0; i < currentBoard.length; i++) {
            for (String item : currentBoard[i]) {
                Color color;
                if (item == "O") {
                    color = Color.BLACK;
                } else if (item == "X") {
                    color = Color.RED;
                } else {
                    color = Color.TRANSPARENT;
                }
                Circle circle = new Circle(37, color);
                grid.addRow(i, circle);
                GridPane.setMargin(circle, new Insets(5));
            }
        }
    }

    // ******************** Launching *******************************
    public static void main(final String[] args) {
        launch(args);
    }

}