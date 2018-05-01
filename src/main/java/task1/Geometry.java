package task1;

import nodes.DrawNode;
import sample.DemoImages;

public class Geometry {

    public static void main(String[] args) {
        System.out.println(calculateTotalArea(DemoImages.DEMO_IMAGE));
    }

    /**
     * Calculates the total area of shapes in the draw node tree.
     * Rectangles and Circles have area and should be counted, others don't.
     */
    public static double calculateTotalArea(DrawNode node) {
        // TODO: implement a visitor
        // HINT: it only needs to do something useful for rectangles and circles
        // TODO: create the visitor
        // TODO: make node accept the visitor
        throw new UnsupportedOperationException("Not implemented");
    }
}
