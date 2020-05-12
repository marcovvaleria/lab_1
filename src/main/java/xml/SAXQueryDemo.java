package xml;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXQueryDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("music.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler2 userhandler = new UserHandler2();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class UserHandler2 extends DefaultHandler {

    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bNickName = false;
    boolean bMarks = false;
    String rollNo = null;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("jazz")) {
            rollNo = attributes.getValue("time");
        }
        if(("60's").equals(rollNo) && qName.equalsIgnoreCase("jazz")) {
            System.out.println("Start Element :" + qName);
        }
        if (qName.equalsIgnoreCase("name")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("author")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("album")) {
            bNickName = true;
        }
        else if (qName.equalsIgnoreCase("desc")) {
            bMarks = true;
        }
    }

    @Override
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("jazz")) {

            if(("60's").equals(rollNo)
                    && qName.equalsIgnoreCase("jazz"))
                System.out.println("End Element :" + qName);
        }
    }


    @Override
    public void characters(
            char ch[], int start, int length) throws SAXException {

        if (bFirstName && ("60's").equals(rollNo)) {
            //age element, set Employee age
            System.out.println("Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName && ("60's").equals(rollNo)) {
            System.out.println("Author: " + new String(ch, start, length));
            bLastName = false;
        } else if (bNickName && ("60's").equals(rollNo)) {
            System.out.println("Album: " + new String(ch, start, length));
            bNickName = false;
        } else if (bMarks && ("60's").equals(rollNo)) {
            System.out.println("Description: " + new String(ch, start, length));
            bMarks = false;
        }
    }
}