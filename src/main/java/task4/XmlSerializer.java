package task4;

import nodes.DrawNode;
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

        // TODO: implement using visitor
        // HINT: xml.writeStartElement, xml.writeEmptyElement, xml.writeAttribute, xml.writeCharacters, xml.writeEndElement
        // HINT: look at XmlDemo class for an example

        // finish XML writing
        xml.writeEndDocument();
        return stringWriter.toString();
    }
}
