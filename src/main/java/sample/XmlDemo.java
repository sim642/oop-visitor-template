package sample;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;

public class XmlDemo {

    public static void main(String[] args) throws XMLStreamException {
        System.out.println(getRandomXml());
    }

    private static String getRandomXml() throws XMLStreamException {
        // set up StAX as streaming XML writer
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        StringWriter stringWriter = new StringWriter();
        XMLStreamWriter xml = xmlOutputFactory.createXMLStreamWriter(stringWriter);
        xml.writeStartDocument();

        // write something into the document
        writeRandomXmlData(xml);

        // finish XML writing
        xml.writeEndDocument();
        return stringWriter.toString();
    }

    private static void writeRandomXmlData(XMLStreamWriter xml) throws XMLStreamException {
        xml.writeStartElement("root");

        xml.writeStartElement("child"); // inside root
        xml.writeAttribute("name", "foo"); // adds to child

        xml.writeEmptyElement("subchild"); // inside child
        // empty element isn't ended

        xml.writeEndElement(); // ends child

        xml.writeStartElement("child"); // inside root again
        xml.writeAttribute("name", "bar"); // adds to child
        xml.writeCharacters("Just some text"); // adds text
        xml.writeEndElement(); // ends child

        xml.writeEndElement(); // ends root
    }
}
