package sample;

import nodes.DrawNode;

import java.io.PrintStream;

public class InstanceofPrintDemoTest extends PrintDemoTest {

    @Override
    protected void printDrawNode(DrawNode node, PrintStream out) {
        InstanceofPrintDemo.printDrawNode(node, out);
    }
}
