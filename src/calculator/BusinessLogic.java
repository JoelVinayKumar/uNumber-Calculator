
package calculator;

/**
 * <p> Title: BusinessLogic Class. </p>
 * 
 * <p> Description: The code responsible for performing the calculator business logic functions. 
 * This method deals with CalculatorValues and performs actions on them.  The class expects data
 * from the User Interface to arrive as Strings and returns Strings to it.  This class calls the
 * CalculatorValue class to do computations and this class knows nothing about the actual 
 * representation of CalculatorValues, that is the responsibility of the CalculatorValue class and
 * the classes it calls.</p>
 * 
 * @author Lynn Robert Carter
 * @author Joel Vinay Kumar
 * 
 * @version 12 The mainline of a JavaFX-based GUI implementation of a UNumber calculator
 * 
 */

public class BusinessLogic {
	
	/**********************************************************************************************

	Attributes
	
	**********************************************************************************************/
	
	// These are the major calculator values 
	private CalculatorValue operand1 = new CalculatorValue();
	private CalculatorValue operand2 = new CalculatorValue();
	
	private CalculatorValue result = new CalculatorValue();
	
	private String operand1ErrorMessageMV = "";
	private String operand1ErrorMessageET = "";
	private boolean operand1Defined = false;
	
	private String operand2ErrorMessageMV = "";
	private String operand2ErrorMessageET = "";
	private boolean operand2Defined = false;
	
	private String resultErrorMessageMV = "";
	private String resultErrorMessageET = "";
	

	/**********************************************************************************************

	Constructors
	
	**********************************************************************************************/
	
	/**********
	 * This method initializes all of the elements of the business logic aspect of the calculator.
	 * There is no special computational initialization required, so the initialization of the
	 * attributes above are all that are needed.
	 */
	public BusinessLogic() {
	}

	/**********************************************************************************************

	Getters and Setters
	
	**********************************************************************************************/
	
	/**********
	 * This public method takes an input String, checks to see if there is a non-empty input string.
	 * If so, it places the converted CalculatorValue into operand1, any associated error message
	 * into operand1ErrorMessage, and sets flags accordingly.
	 * 
	 * @param value
	 * @return	True if the set did not generate an error; False if there was invalid input
	 */
	
	public boolean setOperand1(String value) {
		operand1Defined = false;							// Assume the operand will not be defined
		if (value.length() <= 0) {						// See if the input is empty. If so no error
			operand1ErrorMessageMV = "";
			operand1ErrorMessageET = "";					// message, but the operand is not defined.
			return true;									// Return saying there was no error.
		}
		
		operand1 = new CalculatorValue(value);
		operand1ErrorMessageMV = operand1.getErrorMessageMV()	;// into a CalculatorValue and see if it
		operand1ErrorMessageET = operand1.getErrorMessageET();
		if (operand1ErrorMessageMV.length() > 0 || operand1ErrorMessageET.length() > 0) 			// worked. If there is a non-empty error 
			return false;								// message, signal there was a problem.
		operand1Defined = true;							// Otherwise, set the defined flag and
		return true;										// signal that the set worked
	}
	
	public boolean setOperand1(String value, String error) {
		operand1Defined = false;							// Assume the operand will not be defined
		if (value.length() <= 0) {						// See if the input is empty. If so no error
			operand1ErrorMessageMV = "";
			operand1ErrorMessageET = "";					// message, but the operand is not defined.
			return true;									// Return saying there was no error.
		}
		if(error.equals("")) {
			System.out.println("**************Debug Here 1**************");
			operand1 = new CalculatorValue(value);
		}
		else {
			operand1 = new CalculatorValue(value,error);			// If there was input text, try to convert it
		}
		operand1ErrorMessageMV = operand1.getErrorMessageMV()	;// into a CalculatorValue and see if it
		operand1ErrorMessageET = operand1.getErrorMessageET();
		if (operand1ErrorMessageMV.length() > 0 || operand1ErrorMessageET.length() > 0) 			// worked. If there is a non-empty error 
			return false;								// message, signal there was a problem.
		operand1Defined = true;							// Otherwise, set the defined flag and
		return true;										// signal that the set worked
	}
	
	/**********
	 * This public method takes an input String, checks to see if there is a non-empty input string.
	 * If so, it places the converted CalculatorValue into operand2, any associated error message
	 * into operand1ErrorMessage, and sets flags accordingly.
	 * 
	 * The logic of this method is the same as that for operand1 above.
	 * 
	 * @param value
	 * @return	True if the set did not generate an error; False if there was invalid input
	 */
	public boolean setOperand2(String value) {			// The logic of this method is exactly the
		operand2Defined = false;							// same as that for operand1, above.
		if (value.length() <= 0) {
			operand2ErrorMessageMV = "";
			operand2ErrorMessageET = "";
			return true;
		}
		operand2 = new CalculatorValue(value);
		operand2ErrorMessageMV = operand2.getErrorMessageMV();
		operand2ErrorMessageET = operand2.getErrorMessageET();
		if (operand2ErrorMessageMV.length() > 0 || operand2ErrorMessageET.length() > 0)
			return false;
		operand2Defined = true;
		return true;
	}
	
	void setOperand1WithConversion(String metricMultiplier) {
		operand1.convertMeasuredValue(metricMultiplier);
	}
	
	public boolean setOperand2(String value, String error) {			// The logic of this method is exactly the
		operand2Defined = false;										// same as that for operand1, above.
		if (value.length() <= 0) {
			operand2ErrorMessageMV = "";
			operand2ErrorMessageET = "";
			return true;
		}
		if(error.equals("")) {
			operand2 = new CalculatorValue(value);
		}
		else {
			operand2 = new CalculatorValue(value,error);			// If there was input text, try to convert it
		}
		operand2ErrorMessageMV = operand2.getErrorMessageMV();
		operand2ErrorMessageET = operand2.getErrorMessageET();
		if (operand2ErrorMessageMV.length() > 0 || operand2ErrorMessageET.length() > 0)
			return false;
		operand2Defined = true;
		return true;
	}
	
	void setOperand2WithConversion(String metricMultiplier) {
		operand1.convertMeasuredValue(metricMultiplier);
	}
	
	/**********
	 * This public method takes an input String, checks to see if there is a non-empty input string.
	 * If so, it places the converted CalculatorValue into result, any associated error message
	 * into resuyltErrorMessage, and sets flags accordingly.
	 * 
	 * The logic of this method is similar to that for operand1 above. (There is no defined flag.)
	 * 
	 * @param value
	 * @return	True if the set did not generate an error; False if there was invalid input
	 */
	
	public boolean setResult(String value) {				// The logic of this method is similar to
		if (value.length() <= 0) {						// that for operand1, above.
			operand2ErrorMessageMV = "";
			operand2ErrorMessageET = "";
			return true;
		}
		result = new CalculatorValue(value);
		resultErrorMessageMV = operand2.getErrorMessageMV();
		resultErrorMessageET = operand2.getErrorMessageET();
		if (operand2ErrorMessageMV.length() > 0 || operand2ErrorMessageET.length() > 0)
			return false;
		return true;
	}
	
	public boolean setResult(String value, String error) {				// The logic of this method is similar to
		if (value.length() <= 0) {						// that for operand1, above.
			operand2ErrorMessageMV = "";
			operand2ErrorMessageET = "";
			return true;
		}
		result = new CalculatorValue(value,error);
		resultErrorMessageMV = operand2.getErrorMessageMV();
		resultErrorMessageET = operand2.getErrorMessageET();
		if (operand2ErrorMessageMV.length() > 0 || operand2ErrorMessageET.length() > 0)
			return false;
		return true;
	}
	
	/**********
	 * This public setter sets the String explaining the current error in operand1.
	 * 
	 * @return
	 */
	public void setOperand1ErrorMessageMV(String m) {
		operand1ErrorMessageMV = m;
		return;
	}
	
	public void setOperand1ErrorMessageET(String m) {
		operand1ErrorMessageET = m;
		return;
	}
	
	/**********
	 * This public getter fetches the String explaining the current error in operand1, it there is one,
	 * otherwise, the method returns an empty String.
	 * 
	 * @return and error message or an empty String
	 */
	public String getOperand1ErrorMessageMV() {
		return operand1ErrorMessageMV;
	}
	
	public String getOperand1ErrorMessageET() {
		return operand1ErrorMessageET;
	}
	
	/**********
	 * This public setter sets the String explaining the current error into operand1.
	 * 
	 * @return
	 */
	public void setOperand2ErrorMessageMV(String m) {
		operand2ErrorMessageMV = m;
		return;
	}
	
	public void setOperand2ErrorMessageET(String m) {
		operand2ErrorMessageET = m;
		return;
	}
	
	/**********
	 * This public getter fetches the String explaining the current error in operand2, it there is one,
	 * otherwise, the method returns an empty String.
	 * 
	 * @return and error message or an empty String
	 */
	public String getOperand2ErrorMessageMV() {
		return operand2ErrorMessageMV;
	}
	
	public String getOperand2ErrorMessageET() {
		return operand2ErrorMessageET;
	}
	
	/**********
	 * This public setter sets the String explaining the current error in the result.
	 * 
	 * @return
	 */
	public void setResultErrorMessageMV(String m) {
		resultErrorMessageMV = m;
		return;
	}
	
	public void setResultErrorMessageET(String m) {
		resultErrorMessageET = m;
		return;
	}
	
	/**********
	 * This public getter fetches the String explaining the current error in the result, it there is one,
	 * otherwise, the method returns an empty String.
	 * 
	 * @return and error message or an empty String
	 */
	public String getResultErrorMessageMV() {
		return resultErrorMessageMV;
	}
	
	public String getResultErrorMessageET() {
		return resultErrorMessageET;
	}
	
	/**********
	 * This public getter fetches the defined attribute for operand1. You can't use the lack of an error 
	 * message to know that the operand is ready to be used. An empty operand has no error associated with 
	 * it, so the class checks to see if it is defined and has no error before setting this flag true.
	 * 
	 * @return true if the operand is defined and has no error, else false
	 */
	public boolean getOperand1Defined() {
		return operand1Defined;
	}
	
	/**********
	 * This public getter fetches the defined attribute for operand2. You can't use the lack of an error 
	 * message to know that the operand is ready to be used. An empty operand has no error associated with 
	 * it, so the class checks to see if it is defined and has no error before setting this flag true.
	 * 
	 * @return true if the operand is defined and has no error, else false
	 */
	public boolean getOperand2Defined() {
		return operand2Defined;
	}

	/**********************************************************************************************

	The toString() Method
	
	**********************************************************************************************/
	
	/**********
	 * This toString method invokes the toString method of the result type (CalculatorValue is this 
	 * case) to convert the value from its hidden internal representation into a String, which can be
	 * manipulated directly by the BusinessLogic and the UserInterface classes.
	 */
	public String toString() {
		return result.toString();
	}
	
	/**********
	 * This public toString method is used to display all the values of the BusinessLogic class in a
	 * textual representation for debugging purposes.
	 * 
	 * @return a String representation of the class
	 */
	public String debugToString() {
		String r = "\n******************\n*\n* Business Logic\n*\n******************\n";
		r += "operand1 = " + operand1.toString() + "\n";
		r += "     operand1ErrorMessageMV = " + operand1ErrorMessageMV+ "\n";
		r += "     operand1ErrorMessageET = " + operand1ErrorMessageET+ "\n";
		r += "     operand1Defined = " + operand1Defined+ "\n";
		r += "operand2 = " + operand2.toString() + "\n";
		r += "     operand2ErrorMessageMV = " + operand2ErrorMessageMV+ "\n";
		r += "     operand2ErrorMessageET = " + operand2ErrorMessageET+ "\n";
		r += "     operand2Defined = " + operand2Defined+ "\n";
		r += "result = " + result.toString() + "\n";
		r += "     resultErrorMessageMV = " + resultErrorMessageMV+ "\n";
		r += "     resultErrorMessageET = " + resultErrorMessageET+ "\n";
		r += "*******************\n\n";
		return r;
	}

	/**********************************************************************************************

	Business Logic Operations (e.g. addition)
	
	**********************************************************************************************/
	
	/**********
	 * This public method computes the sum of the two operands using the CalculatorValue class method 
	 * for addition. The goal of this class is to support a wide array of different data representations 
	 * without requiring a change to this class, user interface class, or the Calculator class.
	 * 
	 * This method assumes the operands are defined and valid. It replaces the left operand with the 
	 * result of the computation and it leaves an error message, if there is one, in a String variable
	 * set aside for that purpose.
	 * 
	 * This method does not take advantage or know any detail of the representation!  All of that is
	 * hidden from this class by the ClaculatorValue class and any other classes that it may use.
	 * 
	 * @return a String representation of the result
	 */
	public String addition() {
		result = new CalculatorValue(operand1);
		result.add(operand2);
		resultErrorMessageMV = result.getErrorMessageMV();
		resultErrorMessageET = result.getErrorMessageET();
		return result.enhancedToString();
	}
	
	/**********
	 * The following methods are method stubs that need to be implemented.
	 * 
	 * @return
	 */
	public String subtraction() {
		result = new CalculatorValue(operand1);
		
		result.sub(operand2);
		resultErrorMessageMV = result.getErrorMessageMV();
		resultErrorMessageET = result.getErrorMessageET();
		return result.enhancedToString();
	}
	
	public String multiplication() {
		result = new CalculatorValue(operand1);
		
		result.mpy(operand2);
		resultErrorMessageMV = result.getErrorMessageMV();
		resultErrorMessageET = result.getErrorMessageET();
		return result.enhancedToString();
	}
	
	 public String division() {
		operand2ErrorMessageMV="";
		operand2ErrorMessageET="";
		result = new CalculatorValue(operand1);
		result.div(operand2);
		resultErrorMessageMV = result.getErrorMessageMV();
		resultErrorMessageET = result.getErrorMessageET();
		if(resultErrorMessageMV.length()>0 || resultErrorMessageET.length()>0) {						// Check if any Error messages Found
			operand2ErrorMessageMV = resultErrorMessageMV;
			operand2ErrorMessageET = resultErrorMessageET;		// Setting Operand2ErrorMessage to resultErrorMessage 
			return new CalculatorValue("0").enhancedToString();											// return empty String when Error found
			
		}
		return result.enhancedToString();
	}
	 
	 public String sqrt() {
		operand2ErrorMessageMV="";
		operand2ErrorMessageET="";
		result = new CalculatorValue(operand1);
		result.sqrt();
		return result.enhancedToString();
	}
}
