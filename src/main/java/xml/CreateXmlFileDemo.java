package xml;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class CreateXmlFileDemo {
    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
//            Element rootElement = doc.createElement("cars");
//            doc.appendChild(rootElement);
// supercars element
//            Element supercar = doc.createElement("supercars");
//            rootElement.appendChild(supercar);

            Element rootElement = doc.createElement("music");
            doc.appendChild(rootElement);

            Element genre = doc.createElement("genre");
            rootElement.appendChild(genre);

            Element jazz = doc.createElement("jazz");
            genre.appendChild(jazz);

            Attr attr = doc.createAttribute("time");
            attr.setValue("40's");
            jazz.setAttributeNode(attr);

            Element name = doc.createElement("name");
//            Attr attrType = doc.createAttribute("type");
//            attrType.setValue("");
//            name.setAttributeNode(attrType);
            name.appendChild(doc.createTextNode("So What"));
            jazz.appendChild(name);

            Element author = doc.createElement("author");
//            Attr attrType1 = doc.createAttribute("type");
//            attrType1.setValue("Miles Davis");
//            author.setAttributeNode(attrType1);
            author.appendChild(doc.createTextNode("Miles Davis"));
            jazz.appendChild(author);

            Element album = doc.createElement("album");
//            Attr attrType2 = doc.createAttribute("type");
//            attrType2.setValue("Kind Of Blue");
//            album.setAttributeNode(attrType2);
            album.appendChild(doc.createTextNode("Kind of Blue"));
            jazz.appendChild(album);

            Element desc = doc.createElement("desc");
            desc.appendChild(doc.createTextNode("The opening track on legendary trumpeter Miles’ landmark album Kind Of Blue is one of the best-known examples of modal jazz."));
            jazz.appendChild(desc);





            Element jazz1 = doc.createElement("jazz");
            genre.appendChild(jazz1);

            Attr attr1 = doc.createAttribute("time");
            attr1.setValue("60's");
            jazz1.setAttributeNode(attr1);

            Element name1 = doc.createElement("name");
//            Attr attrType3 = doc.createAttribute("type");
//            attrType3.setValue("Fly Me To The Moon");
//            name1.setAttributeNode(attrType3);
            name1.appendChild(doc.createTextNode("Fly Me To The Moon"));
            jazz1.appendChild(name1);

            Element author1 = doc.createElement("author");
//            Attr attrType4 = doc.createAttribute("type");
//            attrType4.setValue("Frank Sinatra");
//            author1.setAttributeNode(attrType4);
            author1.appendChild(doc.createTextNode("Frank Sinatra"));
            jazz1.appendChild(author1);

            Element album1 = doc.createElement("album");
//            Attr attrType5 = doc.createAttribute("type");
//            attrType5.setValue("Remember");
//            album1.setAttributeNode(attrType5);
            album1.appendChild(doc.createTextNode("Remember"));
            jazz1.appendChild(album1);

            Element desc1 = doc.createElement("desc");
            desc1.appendChild(doc.createTextNode("Originally penned by Bart Howard in 1954 and also recorded by Nat ‘King’ Cole, Peggy Lee and more. The definitive version, though, is surely Frank’s 1964 recording."));
            jazz1.appendChild(desc1);





            Element genre1 = doc.createElement("genre");
            rootElement.appendChild(genre1);

            Element jazz2 = doc.createElement("rock");
            genre1.appendChild(jazz2);

            Attr attr3 = doc.createAttribute("time");
            attr3.setValue("80's");
            jazz2.setAttributeNode(attr3);

            Element name3 = doc.createElement("name");
//            Attr attrType6 = doc.createAttribute("type");
//            attrType6.setValue("Purple Haze");
//            name3.setAttributeNode(attrType6);
            name3.appendChild(doc.createTextNode("Purple Haze"));
            jazz2.appendChild(name3);

            Element author3 = doc.createElement("author");
//            Attr attrType7 = doc.createAttribute("type");
//            attrType7.setValue("Jimi Hendrix");
//            author3.setAttributeNode(attrType7);
            author3.appendChild(doc.createTextNode("Jimi Hendrix"));
            jazz2.appendChild(author3);

            Element album3 = doc.createElement("album");
//            Attr attrType8 = doc.createAttribute("type");
//            attrType8.setValue("De Lane Lea");
//            album3.setAttributeNode(attrType8);
            album3.appendChild(doc.createTextNode("De Lane Lea"));
            jazz2.appendChild(album3);

            Element desc3 = doc.createElement("desc");
            desc3.appendChild(doc.createTextNode("There are famous riffs, and then there's Purple Haze."));
            jazz2.appendChild(desc3);






            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("music.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
