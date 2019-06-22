package calculator;

/**
 * <p> Title: TestCalculatorValue </p>
 * 
 * <p> Description: A component of the Calculator application </p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2017 </p>
 * 
 * @author Lynn Robert Carter
 * @author Joel Vinay Kumar
 * 
 * @version 12 The mainline of a JavaFX-based GUI implementation of a UNumber calculator 
 * 
 */

public class TestCalculatorValue {

	/**********
	 * This class roots the execution of the test of the CalculatorValue class.  The application 
	 * tests the class by invoking the class methods and checking the result to see if the results 
	 * are proper.
	 * 
	 */
	
	/*********************************************************************************************/
	
	/**********
	 * The check method compares an Expected String to an Actual String and returns true if the 
	 * Strings match and false otherwise.  In addition, the Strings are displayed to the console
	 * and a message is display stating whether or not there is a difference.  If there is a
	 * difference, the character at the point of the difference in the actual String is replaced
	 * with a "?" and both are displayed making it clear what character is the start of the
	 * difference
	 * 
	 * @param Expected	The String object of the expected value
	 * @param Actual		The String object of the actual value
	 */
	private static boolean check(String expected, String actual) {
		// Display the input parameters
		System.out.println("***Expected String");
		System.out.println(expected);
		System.out.println("***Actual String");
		System.out.println(actual);
		
		// Check to see if there is a difference
		int lesserLength = expected.length();
		if (lesserLength > actual.length()) lesserLength = actual.length();
		int ndx = 0;
		while (ndx < lesserLength && expected.charAt(ndx) == actual.charAt(ndx))
			ndx++;
		
		// Explain why the loop terminated and if there is a difference make it clear to the user
		if (ndx < lesserLength || lesserLength < expected.length() || lesserLength < actual.length()) {
			System.out.println("*** There is a difference!\n" + expected.substring(0, ndx) + "? <-----");
			return false;
		}
		System.out.println("*** There is no difference!\n");
		return true;
	}
	
	/*********************************************************************************************/
	
	/**********
	 * This main method roots the execution of this test.  The method ignores the program
	 * parameters.  After initializing several local variables, it performs a sequence of
	 * tests, displaying information accordingly and tallying the number of successes and
	 * failures.
	 * 
	 * @param args	Ignored by this application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// Display the header message to the console and initialize local variables
		System.out.println("Test CalculatorValue Class\n");
		int numPassed = 0;
		int numFailed = 0;
		
		// 1. Perform a default constructor test
		CalculatorValue test = new CalculatorValue();						// Perform the test
		
		System.out.println("1. No input given");								// No input that was given

		// Check the actual output against the expected.  If they match, the test has been passed and display the proper
		// message and tally the result
		if (check("measuredValue = +0.00000000000000000000E+0\nerrorMessage = \nerrorValue = +0.00000000000000000000E+0\nerrorMessageET = \n", test.debugToString())) {
			numPassed++;
			System.out.println("\tPass");
		}
		// If they do not match, display that there was a failure and tally that result
		else {
			numFailed++;
			System.out.println("\tFail");
		}
		System.out.println();

		
		// 2. Perform a constructor test with a long
		test = new CalculatorValue(12345);						// Perform the test
		
		System.out.println("2. Input: 12345");	

		// Check the actual output against the expected.  If they match, the test has been passed and display the proper
		// message and tally the result
		if (check("measuredValue = +0.1234500000000000152766688188421539962291717529296875000000000000000000000000000000000000000000000000E+5\nerrorMessage = \nerrorValue = +0.00000000000000000000E+0\nerrorMessageET = \n", test.debugToString())) {
			numPassed++;
			System.out.println("\tPass");
		}
		// If they do not match, display that there was a failure and tally that result
		else {
			numFailed++;
			System.out.println("\tFail");
		}
		System.out.println();

		
		// 3. Perform a copy constructor test
		CalculatorValue t = new CalculatorValue(12345);			// Set up the test
		t.setErrorMessageMV("The error message string");
		
		test = new CalculatorValue(t);										// Perform the test
		
		System.out.println("3. Input:\n12345\nThe error message string\n");	

		// Check the actual output against the expected.  If they match, the test has been passed and display the proper
		// message and tally the result
		if (check("measuredValue = +0.1234500000000000152766688188421539962291717529296875000000000000000000000000000000000000000000000000E+5\nerrorMessage = The error message string\nerrorValue = +0.00000000000000000000E+0\nerrorMessageET = \n", test.debugToString())) {
			numPassed++;
			System.out.println("\tPass");
		}
		// If they do not match, display that there was a failure and tally that result
		else {
			numFailed++;
			System.out.println("\tFail");
		}
		System.out.println();

		
		// 4. Perform a constructor test with a string
		test = new CalculatorValue("12345");						// Perform the test
		
		System.out.println("4. Input: \"12345\"");	

		// Check the actual output against the expected.  If they match, the test has been passed and display the proper
		// message and tally the result
		if (check("measuredValue = +0.123450E+5\nerrorMessage = \nerrorValue = +0.00000000000000000000E+0\nerrorMessageET = \n", test.debugToString())) {
			numPassed++;
			System.out.println("\tPass");
		}
		// If they do not match, display that there was a failure and tally that result
		else {
			numFailed++;
			System.out.println("\tFail");
		}
		System.out.println();

		
		// 5. Perform addition
		CalculatorValue left = new CalculatorValue("1");						// Set up the test
		CalculatorValue right = new CalculatorValue("2");
		
		left.add(right);														// Perform the test
		
		System.out.println("5. Addition Input: \n1\n2");	

		// Check the actual output against the expected.  If they match, the test has been passed and display the proper
		// message and tally the result
		if (check("measuredValue = +0.30E+1\nerrorMessage = \nerrorValue = +0.00000000000000000000E+0\nerrorMessageET = \n", left.debugToString())) {
			numPassed++;
			System.out.println("\tPass");
		}
		// If they do not match, display that there was a failure and tally that result
		else {
			numFailed++;
			System.out.println("\tFail");
		}
		System.out.println();

		
		// 6. Perform subtraction
		left = new CalculatorValue("1");										// Set up the test
		right = new CalculatorValue("2");
		
		left.sub(right);														// Perform the test
		
		System.out.println("6. Subtraction Input: \n1\n2");	

		// Check the actual output against the expected.  If they match, the test has been passed and display the proper
		// message and tally the result
		if (check("measuredValue = -0.10E+1\nerrorMessage = \nerrorValue = +0.00000000000000000000E+0\nerrorMessageET = \n", left.debugToString())) {
			numPassed++;
			System.out.println("\tPass");
		}
		// If they do not match, display that there was a failure and tally that result
		else {
			numFailed++;
			System.out.println("\tFail");
		}
		System.out.println();

		
		// 7. Perform multiplication
		left = new CalculatorValue("6","0.1");										// Set up the test
		right = new CalculatorValue("7","0.1");
		
		left.mpy(right);														// Perform the test
		
		System.out.println("7. Multiplication Input: \n6\n7");	

		// Check the actual output against the expected.  If they match, the test has been passed and display the proper
		// message and tally the result
		if (check("measuredValue = +0.42E+2\nerrorMessage = \nerrorValue = +0.130E+1\nerrorMessageET = \n", left.debugToString())) {
			numPassed++;
			System.out.println("\tPass");
		}
		// If they do not match, display that there was a failure and tally that result
		else {
			numFailed++;
			System.out.println("\tFail");
		}
		System.out.println();

		
		// 8. Perform division
		left = new CalculatorValue("17","0.1");										// Set up the test
		right = new CalculatorValue("3","0.5");
		
		left.div(right);														// Perform the test
		
		System.out.println("8. Division Input: \n6\n7");	

		// Check the actual output against the expected.  If they match, the test has been passed and display the proper
		// message and tally the result
		if (check("measuredValue = +0.567E+1\nerrorMessage = \nerrorValue = +0.977E+0\nerrorMessageET = \n", left.debugToString())) {
			numPassed++;
			System.out.println("\tPass");
		}
		// If they do not match, display that there was a failure and tally that result
		else {
			numFailed++;
			System.out.println("\tFail");
		}
		System.out.println();

		
		System.out.println("Number of tests passed: " + numPassed);
		System.out.println("Number of tests failed: " + numFailed);

	}
}
