package sample;

import nodes.DrawNode;

import java.io.PrintStream;

public class VisitorPrintDemoTest extends PrintDemoTest {

    @Override
    protected void printDrawNode(DrawNode node, PrintStream out) {
        VisitorPrintDemo.printDrawNode(node, out);
    }
}
