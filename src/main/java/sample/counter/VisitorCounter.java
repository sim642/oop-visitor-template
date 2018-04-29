package sample.counter;

import nodes.DrawNode;
import nodes.SimpleDrawVisitor;
import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;
import sample.DemoImages;

public class VisitorCounter {

    public static void main(String[] args) {
        System.out.println(countNodes(DemoImages.DEMO_IMAGE));
    }

    /**
     * Counts all nodes in the draw node tree.
     */
    public static int countNodes(DrawNode node) {
        CountVisitor countVisitor = new CountVisitor();
        node.accept(countVisitor);
        return countVisitor.count;
    }

    private static class CountVisitor extends SimpleDrawVisitor {

        private int count = 0;

        @Override
        public void visit(RectangleNode rectangle) {
            count++;
        }

        @Override
        public void visit(CircleNode circle) {
            count++;
        }

        @Override
        public void visit(TextNode text) {
            count++;
        }

        @Override
        public void visit(GroupNode group) {
            count++;
            super.visit(group);
        }

        @Override
        public void visit(ImageNode image) {
            count++;
            super.visit(image);
        }
    }
}
