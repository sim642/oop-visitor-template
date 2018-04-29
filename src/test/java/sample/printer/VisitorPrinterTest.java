package sample.printer;

import nodes.DrawNode;

import java.io.PrintStream;

public class VisitorPrinterTest extends PrinterTest {

    @Override
    protected void printDrawNode(DrawNode node, PrintStream out) {
        VisitorPrinter.printDrawNode(node, out);
    }
}
