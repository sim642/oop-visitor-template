package task4;

import nodes.DrawNode;
import sample.DemoImages;

import javax.xml.stream.XMLStreamException;

public class XmlSerializer {

    public static void main(String[] args) throws XMLStreamException {
        System.out.println(serializeToXml(DemoImages.DEMO_IMAGE));
    }

    public static String serializeToXml(DrawNode node) throws XMLStreamException {
        //XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        //StringWriter stringWriter = new StringWriter();
        //XMLStreamWriter xml = xmlOutputFactory.createXMLStreamWriter(stringWriter);
        //xml.writeStartDocument();

        throw new UnsupportedOperationException("Not implemented");

        //xml.writeEndDocument();
        //return stringWriter.toString();
    }
}
