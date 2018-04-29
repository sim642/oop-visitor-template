package task3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nodes.DrawNode;
import sample.DemoImages;

public class JavaFxRenderer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(320, 240);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        render(gc, DemoImages.DEMO_IMAGE);

        BorderPane borderPane = new BorderPane(canvas);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void render(GraphicsContext gc, DrawNode node) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
