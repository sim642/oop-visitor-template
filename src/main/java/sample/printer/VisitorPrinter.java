package sample.printer;

import nodes.DrawNode;
import nodes.DrawVisitor;
import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;
import sample.DemoImages;

import java.io.PrintStream;

public class VisitorPrinter {

    public static void main(String[] args) {
        printDrawNode(DemoImages.DEMO_IMAGE, System.out);
        //printDrawNode(DemoImages.DEMO_GROUP, System.out);
    }

    /**
     * Prints the draw node tree.
     */
    public static void printDrawNode(DrawNode node, PrintStream out) {
        PrintVisitor printVisitor = new PrintVisitor(out);
        node.accept(printVisitor);
    }

    private static class PrintVisitor implements DrawVisitor {

        private final PrintStream out;
        private int indent = 0;

        public PrintVisitor(PrintStream out) {
            this.out = out;
        }

        @Override
        public void visit(RectangleNode rectangle) {
            printWithIndent("Rectangle");
        }

        @Override
        public void visit(CircleNode circle) {
            printWithIndent("Circle");
        }

        @Override
        public void visit(TextNode text) {
            printWithIndent("Text");
        }

        @Override
        public void preVisit(GroupNode group) {
            printWithIndent("Group");
            indent++;
        }

        @Override
        public void postVisit(GroupNode group) {
            indent--;
        }

        @Override
        public void preVisit(ImageNode image) {
            printWithIndent("Image");
            indent++;
        }

        @Override
        public void postVisit(ImageNode image) {
            indent--;
        }

        private void printWithIndent(String str) {
            out.println(StringUtils.repeat("  ", indent) + str);
        }
    }
}
