package task4;

import nodes.DrawNode;
import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;

import java.util.List;

import static org.junit.Assert.*;

public class XmlSerializerTest {

    @Test
    public void testRectangle() throws XMLStreamException, DocumentException {
        Element rectangle = getSerializedElement(new RectangleNode(1, 2, 3, 4));

        assertEquals("rectangle", rectangle.getName());
        assertEquals("1", rectangle.attributeValue("x"));
        assertEquals("2", rectangle.attributeValue("y"));
        assertEquals("3", rectangle.attributeValue("width"));
        assertEquals("4", rectangle.attributeValue("height"));
    }

    @Test
    public void testCircle() throws XMLStreamException, DocumentException {
        Element circle = getSerializedElement(new CircleNode(1, 2, 3));

        assertEquals("circle", circle.getName());
        assertEquals("1", circle.attributeValue("x"));
        assertEquals("2", circle.attributeValue("y"));
        assertEquals("3", circle.attributeValue("radius"));
    }

    @Test
    public void testText() throws XMLStreamException, DocumentException {
        Element text = getSerializedElement(new TextNode(1, 2, "foo"));

        assertEquals("text", text.getName());
        assertEquals("1", text.attributeValue("x"));
        assertEquals("2", text.attributeValue("y"));
        assertEquals("foo", text.getText());
    }

    @Test
    public void testGroup() throws XMLStreamException, DocumentException {
        Element group = getSerializedElement(new GroupNode(List.of(new RectangleNode(0, 0, 1, 1), new CircleNode(0, 0, 1))));

        assertEquals("group", group.getName());
        assertEquals(2, group.elements().size());
    }

    @Test
    public void testImage() throws XMLStreamException, DocumentException {
        Element image = getSerializedElement(new ImageNode(new RectangleNode(0, 0, 1, 1)));

        assertEquals("image", image.getName());
        assertEquals(1, image.elements().size());
    }

    private Element getSerializedElement(DrawNode node) throws XMLStreamException, DocumentException {
        String xmlString = XmlSerializer.serializeToXml(node);
        System.err.println(xmlString);
        Document xmlDocument = DocumentHelper.parseText(xmlString);
        return xmlDocument.getRootElement();
    }
}
