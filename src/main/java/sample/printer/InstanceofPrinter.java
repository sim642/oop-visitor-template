package sample.printer;

import nodes.DrawNode;
import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;
import sample.DemoImages;

import java.io.PrintStream;

public class InstanceofPrinter {

    public static void main(String[] args) {
        printDrawNode(DemoImages.DEMO_IMAGE, System.out);
    }

    public static void printDrawNode(DrawNode node, PrintStream out) {
        if (node instanceof RectangleNode) {
            out.print("Rectangle");
        }
        else if (node instanceof CircleNode) {
            out.print("Circle");
        }
        else if (node instanceof TextNode) {
            out.print("Text");
        }
        else if (node instanceof GroupNode) {
            GroupNode group = (GroupNode) node;
            out.print("Group(");
            for (int i = 0; i < group.getChildren().size(); i++) {
                if (i > 0)
                    out.print(",");
                printDrawNode(group.getChildren().get(i), out);
            }
            out.print(")");
        }
        else if (node instanceof ImageNode) {
            ImageNode image = (ImageNode) node;
            out.print("Image(");
            printDrawNode(image.getChild(), out);
            out.print(")");
        }
    }
}
