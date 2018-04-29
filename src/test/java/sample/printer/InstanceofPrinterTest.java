package sample.printer;

import nodes.DrawNode;

import java.io.PrintStream;

public class InstanceofPrinterTest extends PrinterTest {

    @Override
    protected void printDrawNode(DrawNode node, PrintStream out) {
        InstanceofPrinter.printDrawNode(node, out);
    }
}
