package ui;

import core.CheckersLogic;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class CheckersGUI extends Application {

    CheckersLogic game = new CheckersLogic();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(showBoard());

        stage.setTitle("Checkers");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Show the current board
     * 
     * @param grid the grid pane that represents the current board
     */
    public GridPane showBoard() {
        // Create the grid pane
        GridPane grid = new GridPane();
        grid.setMinSize(800, 800);
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);

        // Create the board
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

                // Create the circle that represents the checker
                Circle circle = new Circle(37, color);
                // Handles mouse clicks on the checker piece
                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        circle.setStroke(Color.YELLOW);
                        circle.setStrokeWidth(5);
                        circle.setStrokeType(StrokeType.INSIDE);
                    }
                };
                circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
                grid.addRow(i, circle);
                GridPane.setMargin(circle, new Insets(5));
            }
        }
        return grid;
    }

    // ******************** Launching *******************************
    public static void main(final String[] args) {
        launch(args);
    }

}