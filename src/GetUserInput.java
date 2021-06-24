import java.io.BufferedReader;
import java.io.InputStreamReader;
	/**
	* Class: GetUserInput
	* Abstract: Final - Company Customers Program
	* @author NC
	* @since  4/24/2021
	* @version 1.0
	*/
public class GetUserInput {
	/**
	 * main method: Company Customers
	 * @param args main args
	 * Abstract - get user input and direct to their selection
	 */
	public static void main(String[] args) 
	{
     // Declare variables
		int intResponse = 0;
		
		do
		{
			do {
			System.out.println( "-----------------------------------------------" );
			System.out.print( "Please select one of the options: \n" );
			System.out.print( "1-View Customers | 2-Create Modified Customers File | 0-Exit \n" );
			intResponse = ReadIntegerFromUser();
			
			}while( intResponse != 1 && intResponse != 2 && intResponse != 0);
	
			//Display results depending on user data
			if(intResponse == 1) 
			{
				//The View Customers will create a reporting listing of customers you will create in step 3
				viewCustomers();
				
			}
			else
			{
				//The Create Modified Customers File will generate an updated xml you will create in step 4. 
				modifyCustomers();
			}
				
		}while( intResponse != 0);
		
		
		
		//End Program
		ProgramEnded();
		
	}
	
	/**
	 * Method Name: viewCustomers()
	 * @return cust - List of customers
	 * Abstract: Get List of customers
	 */
    private static ViewCustomers viewCustomers() {
    	ViewCustomers cust = new ViewCustomers();
    	cust.main(null);
    	return cust;
    }
	
	/**
	 * Method Name: modifyCustomers()
	 * @return mod - Modified List of customers to XML file
	 * Abstract: Modify List of customers
	 */
    private static ModifyCustomers modifyCustomers() {
    	ModifyCustomers mod = new ModifyCustomers();
    	mod.main(null);
    	return mod;
    }
    
	/**
	 * Method ReadIntegerFromUser - Get user input
	 * @return intValue
	 */
	public static int ReadIntegerFromUser( )
	{

		int intValue = 0;

		try
		{
			String strBuffer = "";	

			// Input stream
			BufferedReader burInput = new BufferedReader( new InputStreamReader( System.in ) ) ;

			// Read a line from the user
			strBuffer = burInput.readLine( );
			
			// Convert from string to integer
			intValue = Integer.parseInt( strBuffer );
		}
		//Extra Credit- preventing code break from users entering a non-numeric value
		catch(NumberFormatException e){
			intValue = -1;
			System.out.println("Number format exception occurred. Please enter numbers only.");
		}	
		catch( Exception excError )
		{
			System.out.println( excError.toString( ) );
		}
		

		// Return integer value
		return intValue;
	}
	
	
	
	/**
	 * Method: ProgramEnded - When user enters "QUIT"
	 */
	private static void ProgramEnded() {
		System.out.println( "-----------------------------------------------" );
		System.out.println( "Program ended." );
		System.out.println( "Thank you for being a great teacher!" );
		System.out.println( "Have a great summer!" );
		System.out.println( "");
		System.out.println( "	     |\"\"-..._____");
		System.out.println( "	     '-.____    _````\"\"\"\"\"'`|");
		System.out.println( "	         \\  ``` ``\"---... _ |");
		System.out.println( "	         |              /  /#\\");
		System.out.println( "	         }--..______..-{   ###");
		System.out.println( "	        }}}}} _   _ {{{{{");
		System.out.println( "	        }}}}  6   6  {{{{");
		System.out.println( "	       {{{{{    ^    }}}}}");
		System.out.println( "	      {{{{{{\\  -=-  /}}}}}}");
		System.out.println( "	      {{{{{{{;.___.;}}}}}}}");
		System.out.println( "	       {{{{{{{)   (}}}}}}}'");
		System.out.println( "	        `\"\"'\"':   :'\"'\"'`");
		System.out.println( "	               `N`");
		

	}
}
