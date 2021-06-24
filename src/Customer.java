/**
 * Abstract: Get/Set Attributes and Print List
 * @author Neina
 * @since 4/27/2021
 * @version 1.0
 */
public class Customer {
	private String id;
    private String name;
    private String type;
    private String address;
    private String city;
    private String state;
    private String zipcode;
	/**
	 * Method Name: setID()
	 * @param id - ID of company
	 * Abstract: Set ID of company
	 */
    public void setID(String id) {
        this.id = id;
    }
	/**
	 * Method Name: getID()
	 * @return id - id of company
	 * Abstract: Get id of company
	 */
    public String getID() {

        return id;
    }
//    
	/**
	 * Method Name: getName()
	 * @return name - name of company
	 * Abstract: Get name of company
	 */
    public String getName() {
        return name;
    }
	/**
	 * Method Name: setName()
	 * @param name - name of company
	 * Abstract: Set name of company
	 */
    public void setName(String name) {
        this.name = name;
    }
	/**
	 * Method Name: getType()
	 * @return name - name of type
	 * Abstract: Get name of type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Method Name: setType()
	 * @param type - name of type
	 * Abstract: Set name of type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Method Name: getAddress()
	 * @return address - name of address
	 * Abstract: Get name of address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Method Name: setAddress()
	 * @param address - name of address
	 * Abstract: Set name of address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Method Name: getCity()
	 * @return city - name of city
	 * Abstract: Get name of city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Method Name: setCity()
	 * @param city - name of city
	 * Abstract: Set name of city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Method Name: getState()
	 * @return state - name of state
	 * Abstract: Get name of state
	 */
	public String getState() {
		return state;
	}
	/**
	 * Method Name: setState()
	 * @param state - name of state
	 * Abstract: Set name of state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * Method Name: getZipcode()
	 * @return zipcode - name of zipcode
	 * Abstract: Get name of zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * Method Name: setZipcode()
	 * @param zipcode - name of zipcode
	 * Abstract: Set name of zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	/**
	 * Method Name: toString()
	 * @return string of company info
	 * Abstract: convert data to string
	 */
    @Override
    public String toString() {
        return "Customer ID: " + this.id + "\n\tName:\t\t" + this.name + "\n\tType:\t\t" + this.type + "\n\tAddress:\t" + this.address +
                "\n\tCity:\t\t" + this.city + "\n\tState:\t\t" + this.state + "\n\tZipcode:\t" + this.zipcode + "\n";
    }

    
}