package sample;

import nodes.DrawNode;
import nodes.DrawVisitor;
import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;

import java.io.PrintStream;

public class VisitorPrintDemo {

    public static void main(String[] args) {
        printDrawNode(DemoImages.DEMO_IMAGE, System.out);
    }

    public static void printDrawNode(DrawNode node, PrintStream out) {
        PrintVisitor printVisitor = new PrintVisitor(out);
        node.accept(printVisitor);
    }

    private static class PrintVisitor implements DrawVisitor {

        private final PrintStream out;

        public PrintVisitor(PrintStream out) {
            this.out = out;
        }

        @Override
        public void visit(RectangleNode rectangle) {
            out.print("Rectangle");
        }

        @Override
        public void visit(CircleNode circle) {
            out.print("Circle");
        }

        @Override
        public void visit(TextNode text) {
            out.print("Text");
        }

        @Override
        public void visit(GroupNode group) {
            out.print("Group(");
            for (int i = 0; i < group.getChildren().size(); i++) {
                if (i > 0)
                    out.print(",");
                group.getChildren().get(i).accept(this);
            }
            out.print(")");
        }

        @Override
        public void visit(ImageNode image) {
            out.print("Image(");
            image.getChild().accept(this);
            out.print(")");
        }
    }
}
