package sample;

import nodes.DrawNode;
import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.Assert.*;

public abstract class PrintDemoTest {

    protected abstract void printDrawNode(DrawNode node, PrintStream out);

    private void assertPrint(String expected, DrawNode node) throws UnsupportedEncodingException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        printDrawNode(node, out);

        String actual = baos.toString("UTF-8");
        assertEquals(expected, actual);
    }

    @Test
    public void testRectangle() throws Exception {
        assertPrint("Rectangle", new RectangleNode(0, 0, 1, 1));
    }

    @Test
    public void testCircle() throws Exception {
        assertPrint("Circle", new CircleNode(0, 0, 1));
    }

    @Test
    public void testText() throws Exception {
        assertPrint("Text", new TextNode(0, 0, "a"));
    }

    @Test
    public void testGroup() throws Exception {
        assertPrint("Group(Rectangle,Circle)", new GroupNode(List.of(new RectangleNode(0, 0, 1, 1), new CircleNode(0, 0, 1))));
    }

    @Test
    public void testImage() throws Exception {
        assertPrint("Image(Rectangle)", new ImageNode(new RectangleNode(0, 0, 1, 1)));
    }

    @Test
    public void testDemoImage() throws Exception {
        assertPrint("Image(Group(Rectangle,Group(Circle,Text),Text))", TestImages.DEMO_IMAGE);
    }
}
