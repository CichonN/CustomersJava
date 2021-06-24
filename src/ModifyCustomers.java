import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * Abstract: Create new modified XML with new attributes
 * @author Neina
 * @since 4/27/2021
 * @version 1.0
 */
public class ModifyCustomers {
	/**
	 * @param args - not used
	 */
    public static void main(String[] args) {
        String filePath = "customers.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            //add attribute
            addElement(doc);
            
            //write the updated document to file or console
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("customers_updated.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML file updated successfully");
            
        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
    }
	/**
	 * Method Name: addElement()
	 * @param doc - The XML doc
	 * Abstract: Adding Element - Adding new elements for all customers
	 */
    private static void addElement(Document doc) {
        NodeList customers = doc.getElementsByTagName("Customer");
        Element cust = null;
        
        //loop for each Customer
        for(int i=0; i<customers.getLength();i++){
        	cust = (Element) customers.item(i);
            Element statusElement = doc.createElement("phone");
            statusElement.appendChild(doc.createTextNode("555-555-5555"));
            cust.appendChild(statusElement);
        }
        //loop for each Customer
        for(int i=0; i<customers.getLength();i++){
        	cust = (Element) customers.item(i);
            Element statusElement = doc.createElement("contactName");
            statusElement.appendChild(doc.createTextNode("John Doe"));
            cust.appendChild(statusElement);
        }
        //loop for each Customer
        for(int i=0; i<customers.getLength();i++){
        	cust = (Element) customers.item(i);
            Element statusElement = doc.createElement("emailAddress");
            statusElement.appendChild(doc.createTextNode("test@test.com"));
            cust.appendChild(statusElement);
        }
    }
}
