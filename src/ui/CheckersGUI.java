package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CheckersGUI extends Application {

    private Label label;
    private EventHandler<MouseEvent> mouseHandler;

    @Override
    public void init() {
        label = new Label("Click Me");
        mouseHandler = evt -> handleMouseEvents(evt);
    }

    private void initOnFxApplicationThread(final Stage stage) {

        registerListeners();
    }

    private void registerListeners() {
        label.addEventHandler(MouseEvent.ANY, mouseHandler);
    }

    @Override
    public void start(final Stage stage) {
        initOnFxApplicationThread(stage);

        StackPane pane = new StackPane(label);
        pane.setPrefSize(400, 400);
        pane.setPadding(new Insets(10));

        Scene scene = new Scene(pane);

        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @Override
    public void stop() {
        // Remove event handlers
        label.removeEventHandler(MouseEvent.ANY, mouseHandler);

        // Shutdown
        Platform.exit();
        System.exit(0);
    }

    // ******************** Event Handling **************************
    private void handleMouseEvents(final MouseEvent evt) {
        final EventType<? extends Event> type = evt.getEventType();
        switch (type.getName()) {
            case "MOUSE_PRESSED" -> label.setTextFill(Color.RED);
            case "MOUSE_RELEASED" -> label.setTextFill(Color.BLACK);
        }
    }

    // ******************** Launching *******************************
    public static void main(final String[] args) {
        launch(args);
    }
}