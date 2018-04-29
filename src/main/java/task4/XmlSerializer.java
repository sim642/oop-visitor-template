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
            try {
                xml.writeEmptyElement("rectangle");
                xml.writeAttribute("x", Integer.toString(rectangle.getX()));
                xml.writeAttribute("y", Integer.toString(rectangle.getY()));
                xml.writeAttribute("width", Integer.toString(rectangle.getWidth()));
                xml.writeAttribute("height", Integer.toString(rectangle.getHeight()));
            }
            catch (XMLStreamException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void visit(CircleNode circle) {
            try {
                xml.writeEmptyElement("circle");
                xml.writeAttribute("x", Integer.toString(circle.getX()));
                xml.writeAttribute("y", Integer.toString(circle.getY()));
                xml.writeAttribute("radius", Integer.toString(circle.getRadius()));
            }
            catch (XMLStreamException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void visit(TextNode text) {
            try {
                xml.writeStartElement("text");
                xml.writeAttribute("x", Integer.toString(text.getX()));
                xml.writeAttribute("y", Integer.toString(text.getY()));
                xml.writeCharacters(text.getText());
                xml.writeEndElement();
            }
            catch (XMLStreamException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void visit(GroupNode group) {
            try {
                xml.writeStartElement("group");
                super.visit(group);
                xml.writeEndElement();
            }
            catch (XMLStreamException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void visit(ImageNode image) {
            try {
                xml.writeStartElement("image");
                super.visit(image);
                xml.writeEndElement();
            }
            catch (XMLStreamException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
