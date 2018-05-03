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

    /**
     * Prints the draw node tree.
     */
    public static void printDrawNode(DrawNode node, PrintStream out) {
        printDrawNode(node, out, 0);
    }

    private static void printDrawNode(DrawNode node, PrintStream out, int indent) {
        if (node instanceof RectangleNode) {
            printWithIndent(out, indent, "Rectangle");
        }
        else if (node instanceof CircleNode) {
            printWithIndent(out, indent, "Circle");
        }
        else if (node instanceof TextNode) {
            printWithIndent(out, indent, "Text");
        }
        else if (node instanceof GroupNode) {
            GroupNode group = (GroupNode) node;
            printWithIndent(out, indent, "Group");
            for (DrawNode child : group.getChildren())
                printDrawNode(child, out, indent + 1);
        }
        else if (node instanceof ImageNode) {
            ImageNode image = (ImageNode) node;
            printWithIndent(out, indent, "Image");
            printDrawNode(image.getChild(), out, indent + 1);
        }
    }

    private static void printWithIndent(PrintStream out, int indent, String str) {
        out.println(StringUtils.repeat("  ", indent) + str);
    }
}
