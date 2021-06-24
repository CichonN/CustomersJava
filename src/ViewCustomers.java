import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException; 
/**
 * Abstract: Create XML
 * @author Neina
 * @since 4/27/2021
 * @version 1.0
 */
public class ViewCustomers {
	/**
	 * main method
	 * @param args - not used
	 */
    public static void main(String[] args) {
        String filePath = "customers.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
        	//create an instance of the DocumentBuilder
            dBuilder = dbFactory.newDocumentBuilder();
            //Parse the content of the given InputStream as an XML document and return a new DOM Document object.
            Document doc = dBuilder.parse(xmlFile);
            //access to the child node that is the document element of the document
            //and "validate" parameter to verify if the value matches the validity constraint for standalone document declaration as defined in [XML 1.0]
            doc.getDocumentElement().normalize();
            //get the Root element node name
            System.out.println("Root element is : " + doc.getDocumentElement().getNodeName());
            //returns a collection of all elements in the document with the specified tag name, as a NodeList object
            NodeList nodeList = doc.getElementsByTagName("Customer");
            //now XML is loaded as Document in memory, convert it to Object List
            List<Customer> custList = new ArrayList<Customer>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	custList.add(getCustomer(nodeList.item(i)));
            }
            //print Employee list information
            for (Customer cust : custList) {
                System.out.println(cust.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

	/**
	 * Method Name: getCustomer()
	 * @param node - The Node
	 * @return cust - Customer node
	 * Abstract: Get Customer attribute values
	 */
    private static Customer getCustomer(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
    	Customer cust = new Customer();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            String id = element.getAttribute("id");
            cust.setID(id);
            cust.setName(getTagValue("name", element));
            cust.setType(getTagValue("type", element));
            cust.setAddress(getTagValue("address", element));
            cust.setCity(getTagValue("city", element));
            cust.setState(getTagValue("state", element));
            cust.setZipcode(getTagValue("zipcode", element));
        }

        return cust;
    }

	/**
	 * Method Name: getTagValue()
	 * @param tag - element name
	 * @param element - element node
	 * @return node - node value
	 * Abstract: Get Customer attribute values
	 */
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
       // Element element = (Element) node;
        //String id = element.getAttribute("id");
        return node.getNodeValue();
    }

}