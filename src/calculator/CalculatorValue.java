package calculator;

import java.text.DecimalFormat;
//import java.util.Scanner;
//import java.util.Scanner;

//import java.util.Scanner;
import uNumberLibrary.UNumber;


/**
 * <p> Title: CalculatorValue Class. </p>
 * 
 * <p> Description: A component of a JavaFX demonstration application that performs computations </p>
 * 
 * @author Lynn Robert Carter
 * @author Joel Vinay Kumar
 * 
 * @version 12 The mainline of a JavaFX-based GUI implementation of a UNumber calculator
 * 
 */
public class CalculatorValue {
	
	/**********************************************************************************************

	Attributes
	
	**********************************************************************************************/
	
	// These are the major values that define a calculator value
	UNumber measuredValue = new UNumber();
	UNumber errorValue = new UNumber();
	String errorMessageMV = "";
	String errorMessageET = "";
	
	/**********************************************************************************************

	Constructors
	
	**********************************************************************************************/

	/*****
	 * This is the default constructor
	 */
	public CalculatorValue() {
	}

	/*****
	 * This constructor creates a calculator value based on a double floating point integer. For future calculators, it
	 * is best to avoid using this constructor.
	 * When an errorValue is not given it makes the errorValue 0 by default.
	 */
	public CalculatorValue(double v) {
		measuredValue = new UNumber(v);
		errorValue = new UNumber("0");
	}
	
	/*****
	 * This constructor creates a calculator value based on a double floating point integer. For future calculators, it
	 * is best to avoid using this constructor.
	 * When both measuredValue and errorValue are given
	 */
	public CalculatorValue(double v, double e) {
		measuredValue = new UNumber(v);
		errorValue = new UNumber(e);
	}

	/*****
	 * This copy constructor creates a duplicate of an already existing calculator value
	 */
	public CalculatorValue(CalculatorValue v) {
		measuredValue = v.measuredValue;
		errorValue = v.errorValue;
		errorMessageMV = v.errorMessageMV;
		errorMessageET = v.errorMessageET;
	}

	/*****
	 * This constructor creates a calculator value from a string... Due to the nature
	 * of the input, there is a high probability that the input has errors, so the 
	 * routine returns the value with the error message value set to empty or the string 
	 * of an error message.
	 * The following constructor is when no errorValue is given and the next one is when
	 * both measuredValue and errorValues are given
	 */
	
	public CalculatorValue(String s) {
		measuredValue = new UNumber();
		errorValue = new UNumber();
		if (s.length() == 0) {								// If there is nothing there,
			errorMessageMV = "***Error*** Input is empty";		// signal an error	
			return;												
		}
		errorMessageMV = MeasuredValueRecognizer.checkMeasureValue(s);
		if(errorMessageMV.length()>0) {
			return;
		}
		errorMessageET = "";
//		s = s.replace(".",",");
		System.out.println("****************");
		double decimals = Math.pow(10,-s.replace(".",",").split(",")[1].length()-1)*5;
		System.out.println(decimals);
		System.out.println("****************");
		measuredValue = new UNumber(s);
		errorValue = new UNumber(decimals);
		errorMessageMV = "";
		errorMessageET = "";
	}
	
	
	public CalculatorValue(String s, String e) {
		measuredValue = new UNumber();
		errorValue = new UNumber();
		if (s.length() == 0) {								// If there is nothing there,
			errorMessageMV = "***Error*** Input is empty";		// signal an error	
			return;												
		}
		
		if (e.length() == 0) {								// If there is nothing there,
			errorMessageET = "***Error*** Input is empty";	// signal an error
			return;												
		}
		
		
		errorMessageMV = MeasuredValueRecognizer.checkMeasureValue(s);
		errorMessageET = ErrorTermRecognizer.checkErrorTerm(e);
		
		if(errorMessageMV.length()>0) {
			return;
		}

		if(errorMessageET.length()>0) {
			return;
		}
		
		measuredValue = new UNumber(s);
		errorValue = new UNumber(e);
		errorMessageMV = "";
		errorMessageET = "";
	}
	
	/**********************************************************************************************

	Getters and Setters
	
	**********************************************************************************************/
	
	/*****
	 * This is the start of the getters and setters
	 * 
	 * Get the error message
	 */
	
	public String getMeasuredValue() {
		return measuredValue.toString(10);
	}
	
	public String getErrorValue() {
		return errorValue.toString(10);
	}
	
	public String getErrorMessageMV(){
		return errorMessageMV;
	}
	
	public String getErrorMessageET(){
		return errorMessageET;
	}
	
	/*****
	 * Set the current value of a calculator value to a specific double
	 */
	public void setValue(double v, double e){
		measuredValue = new UNumber(v);
		errorValue = new UNumber(e);
		errorMessageMV = "";
		errorMessageET = "";
	}
	
	public void setValue(UNumber v, UNumber e){
		measuredValue = v;
		errorValue = e;
		errorMessageMV = "";
		errorMessageET = "";
	}
	
	/*******
	 * When the units of he operand fields are different one of the operands must be converted to other operand's unit
	 * and for that the operand which is to be converted must be multiplied by some factor and that factor is 
	 * obtained from unit.java 
	 * */
	void convertMeasuredValue (String x) {
		measuredValue.mpy(new UNumber(x));
	}
	
	/*****
	 * Set the current value of a calculator error message to a specific string
	 */
	public void setErrorMessageMV(String m){
		errorMessageMV = m;
	}
	
	public void setErrorMessageET(String m){
		errorMessageET = m;
	}
	
	/*****
	 * Set the current value of a calculator value to the value of another (copy)
	 */
	public void setValue(CalculatorValue v){
		measuredValue = v.measuredValue;
		errorValue = v.errorValue;
		errorMessageMV = v.errorMessageMV;
		errorMessageET = v.errorMessageET;
	}
	
	/**********************************************************************************************

	The toString() Method
	
	**********************************************************************************************/
	
	/*****
	 * This is the default toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be updated
	 */
	public String toString() {
		return measuredValue+""+ "+/-" + errorValue; // + "+/-" + errorValue;
	}
	
	/*****
	 * This is the debug toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be updated
	 */
	public String debugToString() {
		return "measuredValue = " + measuredValue + "\nerrorMessage = " + errorMessageMV + "\nerrorValue = " + errorValue + "\nerrorMessageET = " + errorMessageET + "\n";
	}

	
	/**********************************************************************************************

	The computation methods
	
	**********************************************************************************************/
	

	/*******************************************************************************************************
	 * The following methods implement computation on the calculator values.  These routines assume that the
	 * caller has verified that things are okay for the operation to take place.  These methods understand
	 * the technical details of the values and their reputations, hiding those details from the business 
	 * logic and user interface modules.
	 * 
	 * The following methods are to perform addition, subtraction, multiplication, division and square root 
	 */
	public void add(CalculatorValue v) {
		
		UNumber a1 = new UNumber(measuredValue);
		UNumber b1 = new UNumber(v.measuredValue);
		
		UNumber a2 = new UNumber(errorValue);
		UNumber b2 = new UNumber(v.errorValue);
		UNumber resultMV = new UNumber(a1);
		resultMV.add(b1);
		
		UNumber resultET = new UNumber(a2);
		resultET.add(b2);
		
		measuredValue = resultMV;
		errorValue = resultET;
		
		errorMessageMV = "";
		errorMessageET = "";
		
	}

	public void sub(CalculatorValue v) {
		
		UNumber a1 = new UNumber(measuredValue);
		UNumber b1 = new UNumber(v.measuredValue);
		
		UNumber a2 = new UNumber(errorValue);
		UNumber b2 = new UNumber(v.errorValue);
		
		UNumber resultMV = new UNumber(a1);
		resultMV.sub(b1);
		
		UNumber resultET = new UNumber(a2);
		resultET.add(b2);
		
		measuredValue = resultMV;
		errorValue = resultET;
		
		errorMessageMV = "";
		errorMessageET = "";
		
	}

	public void mpy(CalculatorValue v) {		

		UNumber a1 = new UNumber(measuredValue);
		UNumber b1 = new UNumber(v.measuredValue);
		
		UNumber a2 = new UNumber(errorValue);
		UNumber b2 = new UNumber(v.errorValue);
		
		UNumber resultMV = new UNumber(a1);
		resultMV.mpy(b1);
		
		UNumber resultET1 = new UNumber(a2);
		resultET1.mpy(b1);
		UNumber resultET2 = new UNumber(a1);
		resultET2.mpy(b2);
		UNumber resultET = new UNumber(resultET1);
		resultET.add(resultET2);
		
		measuredValue = resultMV;
		errorValue = resultET;
		
		errorMessageMV = "";
		errorMessageET = "";
		
	}

	 public void div(CalculatorValue v) {
		
		if(v.measuredValue.getDouble()==0.0) {
			errorMessageMV = "***division by zero***";
			return;
		}
		
		UNumber a1 = new UNumber(measuredValue);
		UNumber b1 = new UNumber(v.measuredValue);
		
		UNumber a2 = new UNumber(errorValue);
		UNumber b2 = new UNumber(v.errorValue);
		
		UNumber resultMV = new UNumber(a1);
		resultMV.div(b1);
		
		UNumber resultET1 = new UNumber(a2);
		resultET1.mpy(b1);
		UNumber resultET2 = new UNumber(a1);
		resultET2.mpy(b2);
		UNumber resultET = new UNumber(resultET1);
		resultET.add(resultET2);
		resultET.div(b1);
		resultET.div(b1);
		
		measuredValue = resultMV;
		errorValue = resultET;
		
		errorMessageMV = "";
		errorMessageET = "";
		
		
	}
	 
	 public void sqrt() {
		UNumber ValueErrorFraction = new UNumber(new UNumber(errorValue.getDouble()));
		ValueErrorFraction.div(new UNumber(measuredValue.getDouble()+""));
		measuredValue.SquareRoot();
		ValueErrorFraction.mpy(new UNumber(measuredValue.getDouble()+""));
		ValueErrorFraction.mpy(new UNumber("0.5"));
		errorValue = ValueErrorFraction;
		
		errorMessageMV = "";
		errorMessageET = "";
	}
	 	 
	private double round(double d, int x) {
		String format = "#.";
		
		for (int i=0;i<x;i++)
		{
			format += "#";
		}
		DecimalFormat twoDForm = new DecimalFormat(format);
		return Double.valueOf(twoDForm.format(d));
	}
	
	/*****
	 * The enhancedToString() method converts the operand or any calculatorValue into an enhanced format as explained in the 
	 * comments at each step.
	 * */
	
	public String enhancedToString () {
		String mVo, eTo;
		
		/* *
		 * If 1e-5 < measuredValue < 1E+7, it should be expressed as basic decimal values, else it must 
		 * be expressed in scientific notation (i.e., UNumber)
		 * */
		boolean case1=false;
		if (measuredValue.greaterThan(new UNumber("1e-5")) && measuredValue.lessThan(new UNumber("1E+7"))) {
			mVo = Double.parseDouble(measuredValue.toString())+"";
			case1=true;
		} else {
			mVo = measuredValue.toString();
		}
		
		/* *
		 * If errorTerm has x number of decimals then the corresponding measuredValue must have no more than x decimals
		 * */
		int noOfDecimalsET = errorValue.toString().length()-errorValue.getCharacteristic();
		int noOfDecimalsMV = measuredValue.toString().length()-measuredValue.getCharacteristic();
		if (case1 && noOfDecimalsMV > noOfDecimalsET) {
			mVo = round(Double.parseDouble(mVo), noOfDecimalsET)+"";
		}
		
		/* *
		 * If 1e-3 < errorTerm < 9E+3, it must be represented as basic decimal values, else it must be expressed in 
		 * scientific notation (i.e., UNumber) where errorTerms when displayed for output, must only be displayed with 
		 * one significant digit.
		 * */
		boolean case2 = false;
		if (errorValue.lessThan(new UNumber("9E+3")) && errorValue.greaterThan(new UNumber("1e-3"))) {
			eTo = Double.parseDouble(errorValue.toString())+"";
			case2=true;
		} else {
			eTo = errorValue.toString();
		}
		
		/* *
		 * If the errorTerm > 10 then the measuredValue must be displayed by rounding it off to nearest 100.
		 * */
		if (case2 && errorValue.greaterThan(new UNumber("10"))) {
			eTo = (((Double.parseDouble(errorValue.toString()))/100))*100+"";
		}
		
		
		return mVo + ";" + eTo;		
	}
	
}