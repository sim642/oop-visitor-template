package task1;

import nodes.DrawNode;
import nodes.SimpleDrawVisitor;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
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
        AreaVisitor areaVisitor = new AreaVisitor();
        node.accept(areaVisitor);
        return areaVisitor.area;
    }

    private static class AreaVisitor extends SimpleDrawVisitor {

        private double area = 0;

        @Override
        public void visit(RectangleNode rectangle) {
            area += rectangle.getWidth() * rectangle.getHeight();
        }

        @Override
        public void visit(CircleNode circle) {
            area += Math.PI * Math.pow(circle.getRadius(), 2);
        }
    }
}
