package ui;

import core.CheckersLogic;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckersGUI extends Application {

    /** The game logic */
    CheckersLogic game = new CheckersLogic();
    /** Holds the previous circle */
    Circle prevCircle;
    /** The message to display */
    Text message = new Text("Red's Turn");

    /** 
     * Start the GUI for checker
     * 
     * @param stage the stage to start the GUI
    */
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane bPane = new BorderPane();
        message.setFont(new Font(36));
        bPane.setTop(message);
        bPane.setCenter(showBoard());
        BorderPane.setAlignment(message, Pos.CENTER);
        Scene scene = new Scene(bPane);

        stage.setTitle("Checkers");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Show the current board
     *
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
                        if (prevCircle != null) {
                            if (circle.getFill() == prevCircle.getFill()) {
                                prevCircle.setStroke(Color.TRANSPARENT);
                                circle.setStroke(Color.YELLOW);
                                circle.setStrokeWidth(5);
                                circle.setStrokeType(StrokeType.INSIDE);
                                prevCircle = circle;
                            } else if (circle.getFill() != prevCircle.getFill()) {
                                int prevRow = GridPane.getRowIndex(prevCircle);
                                int prevCol = GridPane.getColumnIndex(prevCircle);
                                int currRow = GridPane.getRowIndex(circle);
                                int currCol = GridPane.getColumnIndex(circle);

                                // Check and make move
                                if (game.isValid(prevRow, prevCol, currRow, currCol)) {
                                    game.updateBoard(prevRow, prevCol, currRow, currCol);
                                    circle.setFill(prevCircle.getFill());
                                    prevCircle.setFill(Color.TRANSPARENT);
                                }
                                if (!game.isActive) {
                                    if (game.getActivePlayer() == "X") message.setText("Red has won!");
                                    else if (game.getActivePlayer() =="O") message.setText("Black has won!");
                                } else {
                                    if (game.getActivePlayer() == "O") message.setText("Black's Turn");
                                    else if (game.getActivePlayer() =="X") message.setText("Red's Turn");
                                }
                                // Clean up
                                prevCircle.setStroke(Color.TRANSPARENT);
                                prevCircle = null;
                            }
                        } else if (circle.getFill() != Color.TRANSPARENT) {
                            circle.setStroke(Color.YELLOW);
                            circle.setStrokeWidth(5);
                            circle.setStrokeType(StrokeType.INSIDE);
                            prevCircle = circle;
                        }
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