
package calculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import calculator.BusinessLogic;

/**
 * <p> Title: UserInterface Class. </p>
 * 
 * <p> Description: The Java/FX-based user interface for the calculator. The class works with String
 * objects and passes work to other classes to deal with all other aspects of the computation.</p>
 * 
 * @author Lynn Robert Carter
 * @author Joel Vinay Kumar
 * 
 * @version 12 The mainline of a JavaFX-based GUI implementation of a UNumber calculator
 *  
 */

public class UserInterface {
	
	/**********************************************************************************************

	Attributes
	
	**********************************************************************************************/
	
	/* Constants used to parameterize the graphical user interface.  We do not use a layout manager for
	   this application. Rather we manually control the location of each graphical element for exact
	   control of the look and feel. */
	private final double BUTTON_WIDTH = 60;
	private final double BUTTON_OFFSET = BUTTON_WIDTH / 3;

	// These are the application values required by the user interface
	
	

	// list of units	
	String[] unitList = {"no-units",
			"meter", "kilometer", "feet",
			"seconds", "minutes", "hours", 
			"grams", "pounds", "kilograms",
			"mps", "kmph",
			"mps2", "kmph2",
			"Newton", "Dyne",
			"m3kg-1s-2",
			"m2","km2","feet2",
			"kg.m.s-1", "g.cm.s-1"
			};
		
	private Label label_UNumberCalculator = new Label("UNumber Calculator");
	
	// Attributes related to Operand 1
	
	private Label label_Operand1 = new Label("First operand");
	private TextField text_OperandMV1 = new TextField();
	
	private Label label_OperandET1 = new Label("First Error Term");
	private TextField text_OperandET1 = new TextField();
	
	Group rootPopUp1;
	Scene scenePopUp1;
	static Stage stagePopUp1;
	
	TitledPane td1, tt1, tm1, tv1, ta1, tf1, tgp1; //panes for accordion
	ObservableList<Button> arrayDistance1 = FXCollections.observableArrayList();
	ObservableList<Button> arrayTime1 = FXCollections.observableArrayList();
	ObservableList<Button> arrayMass1 = FXCollections.observableArrayList();
	ObservableList<Button> arrayVelocity1 = FXCollections.observableArrayList();
	ObservableList<Button> arrayAcceleration1 = FXCollections.observableArrayList();
	ObservableList<Button> arrayForce1 = FXCollections.observableArrayList();
	ObservableList<Button> arrayGravitationalParameter1 = FXCollections.observableArrayList();
	
	Label labelSelectAUnit1 = new Label("Select Unit 1");
	static Button btnSelectAUnit1 = new Button("Select a unit");

	Button btnUnit1000 = createButton1 ("no-unit-selected", "0");
	
	Button btnUnit1Meter = createButton1 ("meter", "1");
	Button btnUnit1KiloMeter = createButton1 ("kilometer", "2");
	Button btnUnit1Feet = createButton1 ("feet", "3");
	
	Button btnUnit1Seconds = createButton1 ("seconds", "4");
	Button btnUnit1Hours = createButton1 ("minutes", "5");
	Button btnUnit1Years = createButton1 ("hours", "6");
	
	Button btnUnit1Grams = createButton1 ("grams", "7");
	Button btnUnit1KiloGrams = createButton1 ("pounds", "8");
	Button btnUnit1Pounds = createButton1 ("kilograms", "9");
	
	Button btnUnit1mps = createButton1 ("mps", "10");
	Button btnUnit1kmph = createButton1 ("kmph", "11");
	
	Button btnUnit1mps2 = createButton1 ("mps2", "12");
	Button btnUnit1kmph2 = createButton1 ("kmph2", "13");
	
	Button btnUnit1N = createButton1 ("Newton", "14");
	Button btnUnit1d = createButton1 ("Dyne", "15");
	
	Button btnUnit1gp = createButton1 ("m3kg-1s-2", "16");
	
	Button button1Selected = btnUnit1000;
	
	String outputSelectedUnit1 = "";
	int outputSelectedUnit1Index = 0;
	
	String unit1Name = "no-unit-selected";
	int unit1Index = 0;
	Unit unit1 = new Unit(0);
	
	private Button createButton1 (String buttonText, String txtIndex) {
		Button button = new Button(buttonText);
		button.setOnAction(eve->{btnSelectAUnit1.setText(button.getText());
		outputSelectedUnit1 = button.getText(); 
		outputSelectedUnit1Index = Integer.parseInt(txtIndex);
		stagePopUp1.close();});
		unit1 = new Unit(outputSelectedUnit1Index);
		return button;
	}
	
	private Text errMVPart1Op1 = new Text();
    private Text errMVPart2Op1 = new Text();
    
    private Text errETPart1Op1 = new Text();
    private Text errETPart2Op1 = new Text();
	
    private TextFlow errMeasuredValueMV1;
    private TextFlow errMeasuredValueET1;
    private Label label_errOperandMV1 = new Label("");
    private Label label_errOperandET1 = new Label("");
    
	
	// Attributes related to Operand 2
	private Label label_Operand2 = new Label("Second operand");
	private TextField text_OperandMV2 = new TextField();
	
	private Label label_OperandET2 = new Label("Second Error Term");
	private TextField text_OperandET2 = new TextField();
	
	Group rootPopUp2;
	Scene scenePopUp2;
	static Stage stagePopUp2;
	
	TitledPane td2, tt2, tm2, tv2, ta2, tf2, tgp2; //panes for accordion
	ObservableList<Button> arrayDistance2 = FXCollections.observableArrayList();
	ObservableList<Button> arrayTime2 = FXCollections.observableArrayList();
	ObservableList<Button> arrayMass2 = FXCollections.observableArrayList();
	ObservableList<Button> arrayVelocity2 = FXCollections.observableArrayList();
	ObservableList<Button> arrayAcceleration2 = FXCollections.observableArrayList();
	ObservableList<Button> arrayForce2 = FXCollections.observableArrayList();
	ObservableList<Button> arrayGravitationalParameter2 = FXCollections.observableArrayList();
	
	Label labelSelectAUnit2 = new Label("Select Unit 2");
	static Button btnSelectAUnit2 = new Button("Select a unit");

	Button btnUnit2000 = createButton2 ("no-unit-selected", "0");

	Button btnUnit2Meter = createButton2 ("meter", "1"); 
	Button btnUnit2KiloMeter = createButton2 ("kilometer", "2");
	Button btnUnit2Feet = createButton2 ("feet", "3");
	
	Button btnUnit2Seconds = createButton2 ("seconds", "4");
	Button btnUnit2Hours = createButton2 ("minutes", "5");
	Button btnUnit2Years = createButton2 ("hours", "6");
	
	Button btnUnit2Grams = createButton2 ("grams", "7");
	Button btnUnit2KiloGrams = createButton2 ("pounds", "8");
	Button btnUnit2Pounds = createButton2 ("kilograms", "9");
	
	Button btnUnit2mps = createButton2 ("mps", "10");
	Button btnUnit2kmph = createButton2 ("kmph", "11");
	
	Button btnUnit2mps2 = createButton2 ("mps2", "12");
	Button btnUnit2kmph2 = createButton2 ("kmph2", "13");
	
	Button btnUnit2N = createButton2 ("Newton", "14");
	Button btnUnit2d = createButton2 ("Dyne", "15");
	
	Button btnUnit2gp = createButton2 ("m3kg-1s-2", "16");
	
	String outputSelectedUnit2 = "";
	int outputSelectedUnit2Index = 0;
	
	Button button2Selected = btnUnit2000;
	
	String unit2Name = "no-unit-selected";
	int unit2Index = 0;
	Unit unit2 = new Unit(0);
	
	private Button createButton2 (String buttonText, String txtIndex) {
		Button button = new Button(buttonText);
		button.setOnAction(eve->{btnSelectAUnit2.setText(button.getText());
		outputSelectedUnit2 = button.getText(); 
		outputSelectedUnit2Index = Integer.parseInt(txtIndex);
		stagePopUp2.close();});
		unit2 = new Unit(outputSelectedUnit2Index);
		return button;
	}
	
	private Text errMVPart1Op2 = new Text();
    private Text errMVPart2Op2 = new Text();
    
    private Text errETPart1Op2 = new Text();
    private Text errETPart2Op2 = new Text();
	
    private TextFlow errMeasuredValueMV2;
    private TextFlow errMeasuredValueET2;
	private Label label_errOperandMV2 = new Label("");
	private Label label_errOperandET2 = new Label("");
	
	// Attributes related to result
	
	private Label label_Result = new Label("Result");
	private TextField text_Result = new TextField();
	
	private Label label_ResultUnit= new Label("Result unit");
	private TextField text_ResultUnit = new TextField();
	
	private Label label_ResultET = new Label("Result Error Term");
	private TextField text_ResultET = new TextField();
	
	private Label label_errResult = new Label("");
	
	// Attributes related to various buttons
	
	private Button button_Add = new Button("+");
	private Button button_Sub = new Button("-");
	private Button button_Mpy = new Button("x");				// The multiply symbol: \u00D7
	private Button button_Div = new Button("/");				// The divide symbol: \u00F7
	private Button button_Sqrt = new Button("\u221A");			// The sqrt âˆš symbol: \u221A
	
	
    
	// If the multiplication and/or division symbols do not display properly, replace the 
	// quoted strings used in the new Button constructor call with the <backslash>u00xx values
	// shown on the same line. This is the Unicode representation of those characters and will
	// work regardless of the underlying hardware being used.
	
	private double buttonSpace;		// This is the white space between the operator buttons.
	
	/* This is the link to the business logic */
	public BusinessLogic perform = new BusinessLogic();

	
	/**********************************************************************************************

	Constructors
	
	**********************************************************************************************/

	/**********
	 * This method initializes all of the elements of the graphical user interface. These assignments
	 * determine the location, size, font, color, and change and event handlers for each GUI object.
	 */
	public UserInterface(Pane theRoot) {
				
		// There are five gaps. Compute the button space accordingly.
		buttonSpace = Calculator.WINDOW_WIDTH / 6;
		
		// Label theScene with the name of the calculator, centered at the top of the pane
		setupLabelUI(label_UNumberCalculator, "Arial", 24, Calculator.WINDOW_WIDTH, Pos.CENTER, 0, 10);
		
		/******************
		/* First operand
		*******************/
		//Label of Operand 1
		setupLabelUI(label_Operand1, "Arial", 18, 650, Pos.BASELINE_LEFT, 30, 60);
		
		//Label of ETOperand 1
		setupLabelUI(label_OperandET1, "Arial", 18, 990, Pos.BASELINE_LEFT, 450, 60);
		
		//Operand1 textfield
		setupTextUI(text_OperandMV1, "Arial", 18, Calculator.WINDOW_WIDTH -650, Pos.BASELINE_LEFT, 30, 90, true);
		text_OperandMV1.textProperty().addListener((observable, oldValue, newValue) -> {setOperand1(); });
		
		//OperandET1 textfield
		setupTextUI(text_OperandET1, "Arial", 18, Calculator.WINDOW_WIDTH -650, Pos.BASELINE_LEFT, 450, 90, true);
		text_OperandET1.textProperty().addListener((observable, oldValue, newValue) -> {setOperand1(); });
				
		//Error in operandMV1
		setupLabelUI(label_errOperandMV1, "Arial", 14, 990, Pos.BASELINE_LEFT, 30, 145);
		label_errOperandMV1.setTextFill(Color.RED);
				
		//Error in OperandET1
		setupLabelUI(label_errOperandET1, "Arial", 14, 650, Pos.BASELINE_LEFT, 480, 145);
		label_errOperandET1.setTextFill(Color.RED);
				
		errMVPart1Op1.setFill(Color.BLACK);
	    errMVPart1Op1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
	    errMVPart2Op1.setFill(Color.RED);
	    errMVPart2Op1.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
	    
	    errMeasuredValueMV1 = new TextFlow(errMVPart1Op1, errMVPart2Op1);
		errMeasuredValueMV1.setMinWidth(600); 
		errMeasuredValueMV1.setLayoutX(30);  
		errMeasuredValueMV1.setLayoutY(120);
		
		errETPart1Op1.setFill(Color.BLACK);
	    errETPart1Op1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
	    errETPart2Op1.setFill(Color.RED);
	    errETPart2Op1.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
	    
	    errMeasuredValueET1 = new TextFlow(errETPart1Op1, errETPart2Op1);
		errMeasuredValueET1.setMinWidth(600); 
		errMeasuredValueET1.setLayoutX(480);  
		errMeasuredValueET1.setLayoutY(120);
		
		text_OperandMV1.setOnAction((event) -> { text_OperandMV2.requestFocus(); });
		
		arrayDistance1 = FXCollections.observableArrayList(btnUnit1000, btnUnit1Meter, btnUnit1KiloMeter, btnUnit1Feet);
		arrayTime1 = FXCollections.observableArrayList(btnUnit1000, btnUnit1Seconds, btnUnit1Hours, btnUnit1Years);
		arrayMass1 = FXCollections.observableArrayList(btnUnit1000, btnUnit1Grams, btnUnit1KiloGrams, btnUnit1Pounds);
		arrayVelocity1 = FXCollections.observableArrayList(btnUnit1000, btnUnit1mps, btnUnit1kmph);
		arrayAcceleration1 = FXCollections.observableArrayList(btnUnit1000, btnUnit1mps2, btnUnit1kmph2);
		arrayForce1 = FXCollections.observableArrayList(btnUnit1000, btnUnit1N, btnUnit1d);
		arrayGravitationalParameter1 = FXCollections.observableArrayList(btnUnit1000, btnUnit1gp);
		
		td1 = new TitledPane("distance", new ListView<>(arrayDistance1));
		tt1 = new TitledPane("time", new ListView<>(arrayTime1));
		tm1 = new TitledPane("mass", new ListView<>(arrayMass1));
		tv1 = new TitledPane("velocity", new ListView<>(arrayVelocity1));
		ta1 = new TitledPane("acceleration", new ListView<>(arrayAcceleration1));
		tf1 = new TitledPane("force", new ListView<>(arrayForce1));
		tgp1 = new TitledPane("gravitational constant", new ListView<>(arrayGravitationalParameter1));
		
		Accordion accordion1 = new Accordion();
		accordion1.getPanes().addAll(td1, tt1, tm1, tv1, ta1, tf1, tgp1);
		accordion1.setMinWidth(300);
		accordion1.setMaxHeight(400);
		
		// Unit1
		setupLabelUI(labelSelectAUnit1, "Arial", 18, 200, Pos.BASELINE_LEFT, 850, 60);		
		setupButtonUI(btnSelectAUnit1, "Arial", 14, 35, Pos.BASELINE_LEFT, 850, 90);
		btnSelectAUnit1.setOnAction(e->{stagePopUp1.showAndWait();});
		btnSelectAUnit1.setMinWidth(35);		
		
		/******************
		/* Second operand
		*******************/
		//Label of OperandMV2
		setupLabelUI(label_Operand2, "Arial", 18, 650, Pos.BASELINE_LEFT, 30, 180);
		
		//Label of OperandET2
		setupLabelUI(label_OperandET2, "Arial", 18, 990, Pos.BASELINE_LEFT, 450, 180);
		
		//Operand2 textfield
		setupTextUI(text_OperandMV2, "Arial", 18, Calculator.WINDOW_WIDTH -650, Pos.BASELINE_LEFT, 30, 220, true);
		text_OperandMV2.textProperty().addListener((observable, oldValue, newValue) -> {setOperand2(); });
		
		//OperandET2 textfield
		setupTextUI(text_OperandET2, "Arial", 18, Calculator.WINDOW_WIDTH -650, Pos.BASELINE_LEFT, 450, 220, true);
		text_OperandET2.textProperty().addListener((observable, oldValue, newValue) -> {setOperand2(); });
				
		//Error in OperandMV2
		setupLabelUI(label_errOperandMV2, "Arial", 14, 990, Pos.BASELINE_LEFT, 30, 275);
		label_errOperandMV2.setTextFill(Color.RED);
				
		//Error in OperandET2
		setupLabelUI(label_errOperandET2, "Arial", 14, 650, Pos.BASELINE_LEFT, 480, 275);
		label_errOperandET2.setTextFill(Color.RED);
		
		errMVPart1Op2.setFill(Color.BLACK);
	    errMVPart1Op2.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
	    errMVPart2Op2.setFill(Color.RED);
	    errMVPart2Op2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
	    
	    errMeasuredValueMV2 = new TextFlow(errMVPart1Op2, errMVPart2Op2);
		errMeasuredValueMV2.setMinWidth(600); 
		errMeasuredValueMV2.setLayoutX(30);  
		errMeasuredValueMV2.setLayoutY(250);
	   
		errETPart1Op2.setFill(Color.BLACK);
	    errETPart1Op2.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
	    errETPart2Op2.setFill(Color.RED);
	    errETPart2Op2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
	    
	    errMeasuredValueET2 = new TextFlow(errETPart1Op2, errETPart2Op2);
		errMeasuredValueET2.setMinWidth(600); 
		errMeasuredValueET2.setLayoutX(480);  
		errMeasuredValueET2.setLayoutY(250);
	   
		text_OperandMV2.setOnAction((event) -> { text_Result.requestFocus(); });
		
		arrayDistance2 = FXCollections.observableArrayList(btnUnit2000, btnUnit2Meter, btnUnit2KiloMeter, btnUnit2Feet);;
		arrayTime2 = FXCollections.observableArrayList(btnUnit2000, btnUnit2Seconds, btnUnit2Hours, btnUnit2Years);
		arrayMass2 = FXCollections.observableArrayList(btnUnit2000, btnUnit2Grams, btnUnit2KiloGrams, btnUnit2Pounds);
		arrayVelocity2 = FXCollections.observableArrayList(btnUnit2000, btnUnit2mps, btnUnit2kmph);
		arrayAcceleration2 = FXCollections.observableArrayList(btnUnit2000, btnUnit2mps2, btnUnit2kmph2);
		arrayForce2 = FXCollections.observableArrayList(btnUnit2000, btnUnit2N, btnUnit2d);
		arrayGravitationalParameter2 = FXCollections.observableArrayList(btnUnit2000, btnUnit2gp);
		
		td2 = new TitledPane("distance", new ListView<>(arrayDistance2));
		tt2 = new TitledPane("time", new ListView<>(arrayTime2));
		tm2 = new TitledPane("mass", new ListView<>(arrayMass2));
		tv2 = new TitledPane("velocity", new ListView<>(arrayVelocity2));
		ta2 = new TitledPane("acceleration", new ListView<>(arrayAcceleration2));
		tf2 = new TitledPane("force", new ListView<>(arrayForce2));
		tgp2 = new TitledPane("gravitational constant", new ListView<>(arrayGravitationalParameter2));
		
		Accordion accordion2 = new Accordion();
		accordion2.getPanes().addAll(td2, tt2, tm2, tv2, ta2, tf2, tgp2);
		accordion2.setMinWidth(300);
		accordion2.setMaxHeight(400);
		
		//Unit2
		setupLabelUI(labelSelectAUnit2, "Arial", 18, 200, Pos.BASELINE_LEFT, 850, 180);		
		setupButtonUI(btnSelectAUnit2, "Arial", 14, 35, Pos.BASELINE_LEFT, 850, 220);
		btnSelectAUnit2.setOnAction(e->{stagePopUp2.showAndWait();});
		btnSelectAUnit2.setMinWidth(35);
		
		/******************
		/*  Result
		*******************/
		//Label of Result
		setupLabelUI(label_Result, "Arial", 18, 650, Pos.BASELINE_LEFT,30, 310);
		
		//Label of ResultET
		setupLabelUI(label_ResultET, "Arial", 18, 990, Pos.BASELINE_LEFT, 480, 310);
		
		setupLabelUI(label_ResultUnit, "Arial", 18, 200, Pos.BASELINE_LEFT, 850, 310);
		
		//Result textfield
		setupTextUI(text_Result, "Arial", 18, Calculator.WINDOW_WIDTH -650, Pos.BASELINE_LEFT, 30, 350, false);
		
		//ResultET textfield
		setupTextUI(text_ResultET, "Arial", 18, Calculator.WINDOW_WIDTH -650, Pos.BASELINE_LEFT, 450, 350, false);
		
		setupTextUI(text_ResultUnit, "Arial", 18, Calculator.WINDOW_WIDTH -900, Pos.BASELINE_LEFT, 850, 350, false);
		
		//Error in Result
		setupLabelUI(label_errResult, "Arial", 18, 990, Pos.BASELINE_LEFT, 350, 480);
		label_errResult.setTextFill(Color.RED);
		
		// Establish the ADD "+" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Add, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 1 * buttonSpace-BUTTON_OFFSET, 400);
		button_Add.setOnAction((event) -> { addOperands(); });
		
		// Establish the SUB "-" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Sub, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 2 * buttonSpace-BUTTON_OFFSET, 400);
		button_Sub.setOnAction((event) -> { subOperands(); });
		
		// Establish the MPY "x" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Mpy, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 3 * buttonSpace-BUTTON_OFFSET, 400);
		button_Mpy.setOnAction((event) -> { mpyOperands(); });
		
		// Establish the DIV "/" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Div, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 4 * buttonSpace-BUTTON_OFFSET, 400);
		button_Div.setOnAction((event) -> { divOperands(); });
		
		// Establish the SQRT button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Sqrt, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 5 * buttonSpace-BUTTON_OFFSET, 400);
		button_Sqrt.setOnAction((event) -> { sqrtOperands(); });
				
		// Place all of the just-initialized GUI elements into the pane
		theRoot.getChildren().addAll(label_UNumberCalculator, 
				label_Operand1, label_OperandET1, text_OperandMV1, text_OperandET1, label_errOperandMV1, label_errOperandET1,
				label_Operand2, label_OperandET2, text_OperandMV2, text_OperandET2, label_errOperandMV2, label_errOperandET2,
				label_Result, label_ResultET, text_Result, text_ResultET, label_ResultUnit, text_ResultUnit, label_errResult, 
				button_Add, button_Sub, button_Mpy, button_Div, button_Sqrt,
				errMeasuredValueMV1, errMeasuredValueMV2, errMeasuredValueET1, errMeasuredValueET2);

		rootPopUp1 = new Group();
		rootPopUp1.getChildren().addAll(accordion1);
		
		theRoot.getChildren().addAll(labelSelectAUnit1, btnSelectAUnit1);
		
		scenePopUp1 = new Scene(rootPopUp1, 200, 300);
		
		stagePopUp1 = new Stage();
		stagePopUp1.setScene(scenePopUp1);
		stagePopUp1.setTitle("Select a unit 1");

		btnUnit1000.setOnAction((event) -> { button1Selected = (btnUnit1000); setOperand1(); setOperand2(); });
		btnUnit1Meter.setOnAction((event) -> { button1Selected = (btnUnit1Meter); setOperand1(); setOperand2(); });
		btnUnit1KiloMeter.setOnAction((event) -> { button1Selected = (btnUnit1KiloMeter); setOperand1(); setOperand2(); });
		btnUnit1Feet.setOnAction((event) -> { button1Selected = (btnUnit1Feet); setOperand1(); setOperand2(); });
		
		btnUnit1Seconds.setOnAction((event) -> { button1Selected = (btnUnit1Seconds); setOperand1(); setOperand2(); });
		btnUnit1Hours.setOnAction((event) -> { button1Selected = (btnUnit1Hours); setOperand1(); setOperand2(); });
		btnUnit1Years.setOnAction((event) -> { button1Selected = (btnUnit1Years); setOperand1(); setOperand2(); });
		
		btnUnit1Grams.setOnAction((event) -> { button1Selected = (btnUnit1Grams); setOperand1(); setOperand2(); });
		btnUnit1KiloGrams.setOnAction((event) -> { button1Selected = (btnUnit1KiloGrams); setOperand1(); setOperand2(); });
		btnUnit1Pounds.setOnAction((event) -> { button1Selected = (btnUnit1Pounds); setOperand1(); setOperand2(); });
		
		btnUnit1mps.setOnAction((event) -> { button1Selected = (btnUnit1mps); setOperand1(); setOperand2(); });
		btnUnit1kmph.setOnAction((event) -> { button1Selected = (btnUnit1kmph); setOperand1(); setOperand2(); });
		
		btnUnit1mps2.setOnAction((event) -> { button1Selected = (btnUnit1mps2); setOperand1(); setOperand2(); });
		btnUnit1kmph2.setOnAction((event) -> { button1Selected = (btnUnit1kmph2); setOperand1(); setOperand2(); });
		
		btnUnit1N.setOnAction((event) -> { button1Selected = (btnUnit1N); setOperand1(); setOperand2(); });
		btnUnit1d.setOnAction((event) -> { button1Selected = (btnUnit1d); setOperand1(); setOperand2(); });
		
		btnUnit1gp.setOnAction((event) -> { button1Selected = (btnUnit1gp); setOperand1(); setOperand2(); });
		
		
		rootPopUp2 = new Group();
		rootPopUp2.getChildren().addAll(accordion2);
		
		theRoot.getChildren().addAll(labelSelectAUnit2, btnSelectAUnit2);
		
		scenePopUp2 = new Scene(rootPopUp2, 200, 300);
		
		stagePopUp2 = new Stage();
		stagePopUp2.setScene(scenePopUp2);
		stagePopUp2.setTitle("Select a unit 2");
		
		btnUnit2000.setOnAction((event) -> { button2Selected = (btnUnit2000); setOperand2(); setOperand1(); });
		btnUnit2Meter.setOnAction((event) -> { button2Selected = (btnUnit2Meter); setOperand2(); setOperand1(); });
		btnUnit2KiloMeter.setOnAction((event) -> { button2Selected = (btnUnit2KiloMeter); setOperand2(); setOperand1(); });
		btnUnit2Feet.setOnAction((event) -> { button2Selected = (btnUnit2Feet); setOperand2(); setOperand1(); });
		
		btnUnit2Seconds.setOnAction((event) -> { button2Selected = (btnUnit2Seconds); setOperand2(); setOperand1(); });
		btnUnit2Hours.setOnAction((event) -> { button2Selected = (btnUnit2Hours); setOperand2(); setOperand1(); });
		btnUnit2Years.setOnAction((event) -> { button2Selected = (btnUnit2Years); setOperand2(); setOperand1(); });
		
		btnUnit2Grams.setOnAction((event) -> { button2Selected = (btnUnit2Grams); setOperand2(); setOperand1(); });
		btnUnit2KiloGrams.setOnAction((event) -> { button2Selected = (btnUnit2KiloGrams); setOperand2(); setOperand1(); });
		btnUnit2Pounds.setOnAction((event) -> { button2Selected = (btnUnit2Pounds); setOperand2(); setOperand1(); });
		
		btnUnit2mps.setOnAction((event) -> { button2Selected = (btnUnit2mps); setOperand2(); setOperand1(); });
		btnUnit2kmph.setOnAction((event) -> { button2Selected = (btnUnit2kmph); setOperand2(); setOperand1(); });
		
		btnUnit2mps2.setOnAction((event) -> { button2Selected = (btnUnit2mps2); setOperand2(); setOperand1(); });
		btnUnit2kmph2.setOnAction((event) -> { button2Selected = (btnUnit2kmph2); setOperand2(); setOperand1(); });
		
		btnUnit2N.setOnAction((event) -> { button2Selected = (btnUnit2N); setOperand2(); setOperand1(); });
		btnUnit2d.setOnAction((event) -> { button2Selected = (btnUnit2d); setOperand2(); setOperand1(); });
		
		btnUnit2gp.setOnAction((event) -> { button2Selected = (btnUnit2gp); setOperand2(); setOperand1(); });
		
	}
	
	/**********
	 * Private local method to initialize the standard fields for a label
	 */
	private void setupLabelUI(Label l, String ff, double f, double w, Pos p, double x, double y){
		l.setFont(Font.font(ff, f));
		l.setMinWidth(w);
		l.setAlignment(p);
		l.setLayoutX(x);
		l.setLayoutY(y);		
	}
	
	/**********
	 * Private local method to initialize the standard fields for a text field
	 */
	private void setupTextUI(TextField t, String ff, double f, double w, Pos p, double x, double y, boolean e){
		t.setFont(Font.font(ff, f));
		t.setMinWidth(w);
		t.setMaxWidth(w);
		t.setAlignment(p);
		t.setLayoutX(x);
		t.setLayoutY(y);		
		t.setEditable(e);
	}
	
	/**********
	 * Private local method to initialize the standard fields for a button
	 */
	private void setupButtonUI(Button b, String ff, double f, double w, Pos p, double x, double y){
		b.setFont(Font.font(ff, f));
		b.setMinWidth(w);
		b.setAlignment(p);
		b.setLayoutX(x);
		b.setLayoutY(y);		
	}
	
	
	/**********************************************************************************************

	User Interface Actions
	
	**********************************************************************************************/

	/**********
	 * Private local method to set the value of the first operand given a text value. The method uses the
	 * business logic class to perform the work of checking the string to see it is a valid value and if 
	 * so, saving that value internally for future computations. If there is an error when trying to convert
	 * the string into a value, the called business logic method returns false and actions are taken to
	 * display the error message appropriately.
	 */
private void setOperand1() {
		
		text_Result.setText("");								// Any change of an operand probably invalidates
		text_ResultET.setText("");								// Any change of an operand probably invalidates
		label_Result.setText("Result");						// the result, so we clear the old result.
		errMVPart1Op1.setText("");
		errMVPart2Op1.setText("");
		errETPart1Op1.setText("");
		errETPart2Op1.setText("");

		if (perform.setOperand1(text_OperandMV1.getText(), text_OperandET1.getText())) {	// Set the operand and see if there was an error
			label_errOperandMV1.setText("");					// If no error, clear this operands error
			if (text_OperandMV2.getText().length() == 0)		// If the other operand is empty, clear its error
				label_errOperandMV2.setText("");				// as well.
		}
		
		label_errOperandMV1.setText(perform.getOperand1ErrorMessageMV());
		label_errOperandET1.setText(perform.getOperand1ErrorMessageET());
		
		btnSelectAUnit1.setText(button1Selected.getText());
		text_ResultUnit.setText("");
		text_Result.setText("");
		text_ResultET.setText("");
		label_errResult.setText("");									// Reset any result error messages from before
		unit1Name = button1Selected.getText();
		for(int i=0;i<unitList.length;i++) {
			if(unit1Name.equals(unitList[i])) {
				unit1Index = i;
				break;
			}
		}
		stagePopUp1.close();											// Once a unit is selected the pop up must be closed.
		unit1 = new Unit(unit1Index);
		
		performGoMV1();
		performGoET1();
	}
	
	private void setOperand2() {
		
		text_Result.setText("");								// Any change of an operand probably invalidates
		text_ResultET.setText("");								// Any change of an operand probably invalidates
		label_Result.setText("Result");						// the result, so we clear the old result.
		errMVPart1Op2.setText("");
		errMVPart2Op2.setText("");
		errETPart1Op2.setText("");
		errETPart2Op2.setText("");

		if (perform.setOperand2(text_OperandMV2.getText(), text_OperandET2.getText())) {	// Set the operand and see if there was an error
			label_errOperandMV2.setText("");					// If no error, clear this operands error
			if (text_OperandMV1.getText().length() == 0)		// If the other operand is empty, clear its error
				label_errOperandMV1.setText("");				// as well.
		}
		
		label_errOperandMV2.setText(perform.getOperand2ErrorMessageMV());
		label_errOperandET2.setText(perform.getOperand2ErrorMessageET());
		
		btnSelectAUnit2.setText(button2Selected.getText());
		text_ResultUnit.setText("");
		text_Result.setText("");
		text_ResultET.setText("");
		label_errResult.setText("");									// Reset any result error messages from before
		unit2Name = button2Selected.getText();
		for(int i=0;i<unitList.length;i++) {
			if(unit2Name.equals(unitList[i])) {
				unit2Index = i;
				break;
			}
		}
		stagePopUp2.close();											// Once a unit is selected the pop up must be closed.
		unit2 = new Unit(unit2Index);
	
		performGoMV2();
		performGoET2();
	}
	
	private void performGoMV1() {
		String errMessage = MeasuredValueRecognizer.checkMeasureValue(text_OperandMV1.getText());
		if (errMessage != "") {
			label_errOperandMV1.setText(MeasuredValueRecognizer.measuredValueErrorMessage);
			if (MeasuredValueRecognizer.measuredValueIndexofError <= -1) return;
			String input = MeasuredValueRecognizer.measuredValueInput;
			errMVPart1Op1.setText(input.substring(0, MeasuredValueRecognizer.measuredValueIndexofError));
			errMVPart2Op1.setText("\u21EB");
		}
	}
	
	private void performGoMV2() {
		String errMessage = MeasuredValueRecognizer.checkMeasureValue(text_OperandMV2.getText());
		if (errMessage != "") {
			label_errOperandMV2.setText(MeasuredValueRecognizer.measuredValueErrorMessage);
			if (MeasuredValueRecognizer.measuredValueIndexofError <= -1) return;
			String input = MeasuredValueRecognizer.measuredValueInput;
			errMVPart1Op2.setText(input.substring(0, MeasuredValueRecognizer.measuredValueIndexofError));
			errMVPart2Op2.setText("\u21EB");
		}
	}
	
	private void performGoET1() {
		String errMessage = ErrorTermRecognizer.checkErrorTerm(text_OperandET1.getText());
		if (errMessage != "") {
			label_errOperandET1.setText(ErrorTermRecognizer.errorTermErrorMessage);
			if (ErrorTermRecognizer.errorTermIndexofError <= -1) return;
			String input = ErrorTermRecognizer.errorTermInput;
			errETPart1Op1.setText(input.substring(0, ErrorTermRecognizer.errorTermIndexofError));
			errETPart2Op1.setText("\u21EB");
		}
	}
	
	private void performGoET2() {
		String errMessage = ErrorTermRecognizer.checkErrorTerm(text_OperandET2.getText());
		if (errMessage != "") {
			label_errOperandET2.setText(ErrorTermRecognizer.errorTermErrorMessage);
			if (ErrorTermRecognizer.errorTermIndexofError <= -1) return;
			String input = ErrorTermRecognizer.errorTermInput;
			errETPart1Op2.setText(input.substring(0, ErrorTermRecognizer.errorTermIndexofError));
			errETPart2Op2.setText("\u21EB");
		}
	}
	
	/**********
	 * Private local method to set the value of the second operand given a text value. The logic is exactly the
	 * same as used for the first operand, above.
	 */

	/**********
	 * This method is called when an binary operation button has been pressed. It assesses if there are issues 
	 * with either of the binary operands or they are not defined. If not return false (there are no issues)
	 * 
	 * @return	True if there are any issues that should keep the calculator from doing its work.
	 */
	private boolean binaryOperandIssues() {
		String errorMessageMV1 = perform.getOperand1ErrorMessageMV();	// Fetch the error messages, if there are any
		String errorMessageET1 = perform.getOperand1ErrorMessageET();
		String errorMessageMV2 = perform.getOperand2ErrorMessageMV();
		String errorMessageET2 = perform.getOperand2ErrorMessageET();
		
		if (errorMessageMV1.length() > 0 || errorMessageET1.length() > 0) {						// Check the first.  If the string is not empty
			label_errOperandMV1.setText(errorMessageMV1);			// there's an error message, so display it.
			label_errOperandET1.setText(errorMessageET1);
			if (errorMessageMV2.length() > 0 || errorMessageET2.length() > 0) {					// Check the second and display it if there is
				label_errOperandMV2.setText(errorMessageMV2);		// and error with the second as well.
				label_errOperandET2.setText(errorMessageET2);
				return true;										// Return true when both operands have errors
			}
			else {
				return true;										// Return true when only the first has an error
			}
		}
		else if (errorMessageMV2.length() > 0 || errorMessageET2.length() > 0) {					// No error with the first, so check the second
			label_errOperandMV2.setText(errorMessageMV2);			// operand. If non-empty string, display the error
			label_errOperandET2.setText(errorMessageET2);
			return true;											// message and return true... the second has an error
		}														// Signal there are issues
		
		// If the code reaches here, neither the first nor the second has an error condition. The following code
		// check to see if the operands are defined.
		if (!perform.getOperand1Defined()) {						// Check to see if the first operand is defined
			label_errOperandMV1.setText("no input found");			// If not, this is an issue for a binary operator
			if (!perform.getOperand2Defined()) {					// Now check the second operand. It is is also
				label_errOperandMV2.setText("no input found");		// not defined, then two messages should be displayed
				return true;										// Signal there are issues
			}
			return true;
		} else if (!perform.getOperand2Defined()) {				// If the first is defined, check the second. Both
			label_errOperandMV2.setText("invalid input");			// operands must be defined for a binary operator.
			return true;											// Signal there are issues
		}
		
		return false;											// Signal there are no issues with the operands
	}
	
	private boolean unaryOperandIssues() {
		String errorMessageMV1 = perform.getOperand1ErrorMessageMV();	// Fetch the error messages, if there are any
		String errorMessageET1 = perform.getOperand1ErrorMessageET();
		if (errorMessageMV1.length() > 0 || errorMessageET1.length() > 0) {						// Check the first.  If the string is not empty
			label_errOperandMV1.setText(errorMessageMV1);
			label_errOperandET1.setText(errorMessageET1);			// there's an error message, so display it.
				return true;										// Return true when only the first has an error
			}
		if (!perform.getOperand1Defined()) {						// Check to see if the first operand is defined
			label_errOperandMV1.setText("no input found");			// If not, this is an issue for a binary operator
			if (perform.getOperand2Defined())						// Check to see if the first operand is defined
				label_errOperandMV2.setText("Enter in the text box First Operand");			// If not, this is an issue for a binary operator
				label_errOperandET2.setText("");
			return true;
			}
		return false;
	}

	/*******************************************************************************************************
	 * This portion of the class defines the actions that take place when the various calculator
	 * buttons (add, subtract, multiply, and divide) are pressed.
	 */

	/**********
	 * This is the add routine
	 * 
	 */
	private void addOperands(){
		label_errOperandMV1.setText("");								// Reset any Operand1 error messages from before
		label_errOperandMV2.setText("");								// Reset any Operand2 error messages from before

		label_errOperandET1.setText("");								
		label_errOperandET2.setText("");	
		
		label_errResult.setText("");									// Reset any result error messages from before
		text_ResultUnit.setText("");
		// Check to see if both operands are defined and valid
		if (binaryOperandIssues()) 									// If there are issues with the operands, return
			return;													// without doing the computation
		
		if(!unit1.checkIfValidForAddition(unit2) && !(unit1Index==0) && !(unit2Index==0)) {
			text_Result.setText("");
			text_ResultET.setText("");
			label_errResult.setText("Units not compatable for addition");
			return;
		}
		
		perform.setOperand1WithConversion(unit1.getMetricMultiplier());
		perform.setOperand2WithConversion(unit2.getMetricMultiplier());
		
		/**** 
		* If the operands are defined and valid, request the business logic method to do the addition and return the
		* result as a String. If there is a problem with the actual computation, an empty string is returned
		*/
		String[] theAnswer = perform.addition().split(";");						// Call the business logic add method
//		String temp = Double.toString(Math.ceil(Double.parseDouble(theAnswer[1])));
		if ((theAnswer[0]).length() > 0 || (theAnswer[1]).length() > 0) {								// Check the returned String to see if it is okay
			text_Result.setText(theAnswer[0]);							// If okay, display it in the result field and
			text_ResultET.setText(theAnswer[1]);
			Unit result = unit1.getResultantUnitAfterAddition(unit2);
			this.text_ResultUnit.setText(result.toString());
			label_Result.setText("Sum");								// change the title of the field to "Sum"
		}
		else {														// Some error occurred while doing the addition.
			text_Result.setText("");									// Do not display a result if there is an error.				
			label_Result.setText("Result");							// Reset the result label if there is an error.
			label_ResultET.setText("");
			
		}
	}

	/**********
	 * This is the subtract routine
	 * 
	 */
	private void subOperands(){
		label_errOperandMV1.setText("");								// Reset any Operand1 error messages from before
		label_errOperandMV2.setText("");								// Reset any Operand2 error messages from before
		
		label_errOperandET1.setText("");
		label_errOperandET2.setText("");
		
		label_errResult.setText("");									// Reset any result error messages from before
		text_ResultUnit.setText("");
		
		// Check to see if both operands are defined and valid
		if (binaryOperandIssues()) 									// If there are issues with the operands, return
			return;													// without doing the computation
		
		if(!unit1.checkIfValidForSubtraction(unit2) && !(unit1Index==0) && !(unit2Index==0)) {
			text_Result.setText("");
			text_ResultET.setText("");
			label_errResult.setText("Units not compatable for subtraction");
			return;
		}
		
		perform.setOperand1WithConversion(unit1.getMetricMultiplier());
		perform.setOperand2WithConversion(unit2.getMetricMultiplier());
		
		// If the operands are defined and valid, request the business logic method to do the subtraction and return the
		// result as a String. If there is a problem with the actual computation, an empty string is returned
		String[] theAnswer = perform.subtraction().split(";");						// Call the business logic add method
		if ((theAnswer[0]).length() > 0 || (theAnswer[1]).length() > 0) {								// Check the returned String to see if it is okay
			text_Result.setText(theAnswer[0]);							// If okay, display it in the result field and
			text_ResultET.setText(theAnswer[1]);	
			Unit result = unit1.getResultantUnitAfterSubtraction(unit2);
			this.text_ResultUnit.setText(result.toString());
			label_Result.setText("Difference");								// change the title of the field to "Difference"
		}
		else {														// Some error occurred while doing the addition.
			text_Result.setText("");									// Do not display a result if there is an error.				
			label_Result.setText("Result");							// Reset the result label if there is an error.
			label_ResultET.setText("");
		}
	}

	/**********
	 * This is the multiply routine
	 * 
	 */
	private void mpyOperands(){
		label_errOperandMV1.setText("");								// Reset any Operand1 error messages from before
		label_errOperandMV2.setText("");								// Reset any Operand2 error messages from before
		
		label_errOperandET1.setText("");
		label_errOperandET2.setText("");
		
		label_errResult.setText("");									// Reset any result error messages from before
		text_ResultUnit.setText("");
		
		// Check to see if both operands are defined and valid
		if (binaryOperandIssues()) 									// If there are issues with the operands, return
			return;													// without doing the computation
		
		if(!unit1.checkIfValidForMultiplication(unit2) && !(unit1Index==0) && !(unit2Index==0)) {
			text_Result.setText("");
			text_ResultET.setText("");
			label_errResult.setText("Units not compatable for multiplication");
			return;
		}

		perform.setOperand1WithConversion(unit1.getMetricMultiplier());
		perform.setOperand2WithConversion(unit2.getMetricMultiplier());
		
		// If the operands are defined and valid, request the business logic method to do the multiplication and return the
		// result as a String. If there is a problem with the actual computation, an empty string is returned
		String[] theAnswer = perform.multiplication().split(";");						// Call the business logic add method
		System.out.println(theAnswer[0]+"\t"+theAnswer[1]);
		if ((theAnswer[0]).length() > 0 || (theAnswer[1]).length() > 0) {				// Check the returned String to see if it is okay
			text_Result.setText(theAnswer[0]);							// If okay, display it in the result field and
			text_ResultET.setText(theAnswer[1]);	
			Unit result = unit1.getResultantUnitAfterMultiplication(unit2);
			this.text_ResultUnit.setText(result.toString());
			label_Result.setText("Product");								// change the title of the field to "Product"
		}
		else {														// Some error occurred while doing the addition.
			text_Result.setText("");									// Do not display a result if there is an error.				
			label_Result.setText("Result");							// Reset the result label if there is an error.
			label_ResultET.setText("");
		}
	}

	/**********
	 * This is the divide routine.  If the divisor is zero, the divisor is declared to be invalid.
	 * 
	 */
	private void divOperands(){
		
		label_errOperandMV1.setText("");								// Reset any Operand1 error messages from before
		label_errOperandMV2.setText("");								// Reset any Operand2 error messages from before
		
		label_errOperandET1.setText("");
		label_errOperandET2.setText("");
		
		label_errResult.setText("");								// Reset any result error messages from before
		text_ResultUnit.setText("");
		
		// Check to see if both operands are defined and valid
		if (binaryOperandIssues()) 									// If there are issues with the operands, return
			return;													// without doing the computation
		
		String[] theAnswer = perform.division().split(";");						// Call the business logic add method
		
		if(!unit1.checkIfValidForDivision(unit2) && !(unit1Index==0) && !(unit2Index==0)) {
			text_Result.setText("");
			text_ResultET.setText("");
			label_errResult.setText("Units not compatable for division");
			return;
		}

		perform.setOperand1WithConversion(unit1.getMetricMultiplier());
		perform.setOperand2WithConversion(unit2.getMetricMultiplier());
		
		// If the operands are defined and valid, request the business logic method to do the Division and return the
		// result as a String. If there is a problem with the actual computation, an empty string is returned
		if(perform.getOperand2ErrorMessageMV().length()>0 || perform.getOperand2ErrorMessageET().length()>0)	{		// Check if any error message for Operand2
			text_Result.setText("");									// Do not display a result if there is an error.				
			label_Result.setText("Result");								// Reset the result label if there is an error.
			label_errOperandMV2.setText(perform.getOperand2ErrorMessageMV());
			label_errOperandET2.setText(perform.getOperand2ErrorMessageET());// Display the error message 
			perform.setOperand2ErrorMessageMV("");
			perform.setOperand2ErrorMessageET("");
		}
		theAnswer = perform.division().split(";");						// Call the business logic add method
		if (((theAnswer[0]).length() > 0 || (theAnswer[1]).length() > 0) && Double.parseDouble(theAnswer[0])!=0) {								// Check the returned String to see if it is okay
			text_Result.setText(theAnswer[0]);							// If okay, display it in the result field and
			text_ResultET.setText(theAnswer[1]);	
			Unit result = unit1.getResultantUnitAfterDivision(unit2);
			this.text_ResultUnit.setText(result.toString());
			label_Result.setText("Quotient");								// change the title of the field to "Quotient"
		}
		else {														// Some error occurred while doing the Division.
			text_Result.setText("");									// Do not display a result if there is an error.				
			label_Result.setText("Result");							// Reset the result label if there is an error.
		}
	}
	
	private void sqrtOperands() {
		label_errOperandMV1.setText("");								// Reset any Operand1 error messages from before
		label_errResult.setText("");								// Reset any result error messages from before
		label_errResult.setText("");								// Reset any result error messages from before
		text_ResultUnit.setText("");
		if (unaryOperandIssues())
			return;
		
		String[] theAnswer = perform.sqrt().split(";");						// Call the business logic add method
		if ((theAnswer[0]).length() > 0 || (theAnswer[1]).length() > 0) {								// Check the returned String to see if it is okay
			text_Result.setText(theAnswer[0]);							// If okay, display it in the result field and
			text_ResultET.setText(theAnswer[1]);	
			label_Result.setText("Square root");								// change the title of the field to "Sum"
		}
		else {														// Some error occurred while doing the division.
			text_Result.setText("");									// Do not display a result if there is an error.				
			label_Result.setText("Result");							// Reset the result label if there is an error.
		}
	}
	
}