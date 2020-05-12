package xml;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {
    public static void main(String[] args) {

        try {
            File inputFile = new File("music.xml");    //Reads a file in "inputFile" object
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    //
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                  //
            Document doc = dBuilder.parse(inputFile);                                   //Creates the document file with all data
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("jazz");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Time : "
                            + eElement.getAttribute("time"));
                    System.out.println("Name : "
                            + eElement
                            .getElementsByTagName("name") //elementS - Takes a list of elements
                            .item(0)                     //element from the list of elements
                            .getTextContent());                //Text-type content
                    System.out.println("Author : "
                            + eElement
                            .getElementsByTagName("author")
                            .item(0)
                            .getTextContent());
                    System.out.println("Album : "
                            + eElement
                            .getElementsByTagName("album")
                            .item(0)
                            .getTextContent());
                    System.out.println("Description : "
                            + eElement
                            .getElementsByTagName("desc")
                            .item(0)
                            .getTextContent());
                    if(eElement.getElementsByTagName("status").getLength()>0){
                        System.out.println("Status : "
                                +eElement.getElementsByTagName("status")
                                .item(0)
                                .getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Something went wrong! Press %s",'F');
        }
    }
}
