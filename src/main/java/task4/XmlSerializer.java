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
        /* Should output something like:
        <image><group><rectangle x="10" y="10" width="100" height="50"/><group><circle x="150" y="30" radius="20"/><text x="200" y="50">Some text</text></group><text x="30" y="100">My cool image</text></group></image>
         */
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
        // HINT: take inspiration from VisitorPrinter
        // HINT: pass XMLStreamWriter to the visitor via constructor argument (like out in VisitorPrinter)
        // HINT: xml.writeStartElement, xml.writeEmptyElement, xml.writeAttribute, xml.writeCharacters, xml.writeEndElement
        // HINT: look at XmlDemo class for an example
        // HINT: elements and attributes to write can be seen in the main method's example comment or tests

        // finish XML writing
        xml.writeEndDocument();
        return stringWriter.toString();
    }
}
