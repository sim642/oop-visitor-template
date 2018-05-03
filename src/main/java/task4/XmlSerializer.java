package task4;

import nodes.DrawNode;
import nodes.SimpleDrawVisitor;
import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;
import sample.DemoImages;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;

import static task4.RunnableThrows.wrapThrows;

public class XmlSerializer {

    public static void main(String[] args) throws XMLStreamException {
        System.out.println(serializeToXml(DemoImages.DEMO_IMAGE));
    }

    /**
     * Serializes the draw node tree to corresponding XML structure.
     */
    public static String serializeToXml(DrawNode node) throws XMLStreamException {
        // set up StAX as streaming XML writer
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        StringWriter stringWriter = new StringWriter();
        XMLStreamWriter xml = xmlOutputFactory.createXMLStreamWriter(stringWriter);
        xml.writeStartDocument();

        XmlVisitor xmlVisitor = new XmlVisitor(xml);
        node.accept(xmlVisitor);

        // finish XML writing
        xml.writeEndDocument();
        return stringWriter.toString();
    }

    private static class XmlVisitor extends SimpleDrawVisitor {

        private final XMLStreamWriter xml;

        private XmlVisitor(XMLStreamWriter xml) {
            this.xml = xml;
        }

        @Override
        public void visit(RectangleNode rectangle) {
            wrapThrows(() -> {
                xml.writeEmptyElement("rectangle");
                xml.writeAttribute("x", Integer.toString(rectangle.getX()));
                xml.writeAttribute("y", Integer.toString(rectangle.getY()));
                xml.writeAttribute("width", Integer.toString(rectangle.getWidth()));
                xml.writeAttribute("height", Integer.toString(rectangle.getHeight()));
            });
        }

        @Override
        public void visit(CircleNode circle) {
            wrapThrows(() -> {
                xml.writeEmptyElement("circle");
                xml.writeAttribute("x", Integer.toString(circle.getX()));
                xml.writeAttribute("y", Integer.toString(circle.getY()));
                xml.writeAttribute("radius", Integer.toString(circle.getRadius()));
            });
        }

        @Override
        public void visit(TextNode text) {
            wrapThrows(() -> {
                xml.writeStartElement("text");
                xml.writeAttribute("x", Integer.toString(text.getX()));
                xml.writeAttribute("y", Integer.toString(text.getY()));
                xml.writeCharacters(text.getText());
                xml.writeEndElement();
            });
        }

        @Override
        public void visit(GroupNode group) {
            wrapThrows(() -> {
                xml.writeStartElement("group");
                super.visit(group);
                xml.writeEndElement();
            });
        }

        @Override
        public void visit(ImageNode image) {
            wrapThrows(() -> {
                xml.writeStartElement("image");
                super.visit(image);
                xml.writeEndElement();
            });
        }
    }
}
