package task3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nodes.DrawNode;
import nodes.SimpleDrawVisitor;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;
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

    /**
     * Renders the image represented by the draw node tree onto the given {@link GraphicsContext}.
     */
    public static void render(GraphicsContext gc, DrawNode node) {
        RenderVisitor renderVisitor = new RenderVisitor(gc);
        node.accept(renderVisitor);
    }

    private static class RenderVisitor extends SimpleDrawVisitor {

        private final GraphicsContext gc;

        private RenderVisitor(GraphicsContext gc) {
            this.gc = gc;
        }

        @Override
        public void visit(RectangleNode rectangle) {
            gc.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        }

        @Override
        public void visit(CircleNode circle) {
            gc.fillOval(circle.getX(), circle.getY(), circle.getRadius(), circle.getRadius());
        }

        @Override
        public void visit(TextNode text) {
            gc.fillText(text.getText(), text.getX(), text.getY());
        }
    }
}
