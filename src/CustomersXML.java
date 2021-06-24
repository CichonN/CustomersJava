import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Abstract: write to XML
 * @author Neina
 * @since 4/27/2021
 * @version 1.0
 */
public class CustomersXML {
	/**
	 * main method - Create manually entered list of customers
	 * @param args - not used
	 */
    public static void main(String[] args) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
        	//create an instance of the DocumentBuilder
            dBuilder = dbFactory.newDocumentBuilder();
            //create new instance of a DOM Document object to build a DOM tree with
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                doc.createElementNS("https://www.w3.org/1999/xhtml", "Customers");
            //append root element to document
            doc.appendChild(rootElement);

            //append first child element to root element
            rootElement.appendChild(getCustomer(doc, "1", "ACME Hauling", "commercial", "123 Main Street", "Cincinnati,", "OH", "45211"));

            //append second child
            rootElement.appendChild(getCustomer(doc, "2", "AJ Newtown", "residential", "1 Sunny Way", "Cincinnati,", "OH", "45010"));

            //append third child
            rootElement.appendChild(getCustomer(doc, "3", "Foster Burgers", "commercial", "2000 Chester Road", "Cincinnati,", "OH", "45242"));
            

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for indenting and printing line by line
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("customers.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * Method Name: getCustomer()
	 * @param doc - The XML doc
	 * @param id - ID of Customer
	 * @param name - Name of Customer
	 * @param type - type of business
	 * @param address - Address of business
	 * * @param city - city of business
	 * * @param state - state of business
	 * * @param zipcode - zipcode of business
	 * @return customer - Node element
	 */
    private static Node getCustomer(Document doc, String id, String name, String type, String address, String city, String state, String zipcode) {
        Element customer = doc.createElement("Customer");

        //set id attribute
        customer.setAttribute("id", id);

        //create name element
        customer.appendChild(getCustomerElements(doc, customer, "name", name));

        //create type element
        customer.appendChild(getCustomerElements(doc, customer, "type", type));

        //create address element
        customer.appendChild(getCustomerElements(doc, customer, "address", address));

     	//create city element
        customer.appendChild(getCustomerElements(doc, customer, "city", city));

        //create state element
        customer.appendChild(getCustomerElements(doc, customer, "state", state));

        //create zipcode element
        customer.appendChild(getCustomerElements(doc, customer, "zipcode", zipcode));


        return customer;
    }


    
	/**
	 * Method Name: getCustomerElements()
	 * @param doc - The XML doc
	 * @param element - Customer Element
	 * @param name - Name of Element
	 * @param value - The specified element
	 * @return node - text node
	 * Abstract: utility method to create text node
	 */
    private static Node getCustomerElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
