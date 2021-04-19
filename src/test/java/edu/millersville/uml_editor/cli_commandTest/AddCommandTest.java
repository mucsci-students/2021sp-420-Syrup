package edu.millersville.uml_editor.cli_commandTest;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.cli_command.*;
import edu.millersville.uml_editor.view.*;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddCommandTest {
	UMLModel model;
    CLIView view;
    ViewTemplate viewTemp;
    AddCommand command;
    boolean prompt;
    
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();

    private final PrintStream origOut = System.out;
    private final PrintStream origErr = System.err;
    
    @Before
    public void createCLI() throws IOException {
    	System.setOut(new PrintStream(out));
    	System.setErr(new PrintStream(err));
    	model = new UMLModel();
    	viewTemp = new ViewTemplate(ViewTemplate.InterfaceType.CLI);
    	view = (CLIView) viewTemp.getViewinterface();
    	prompt = false;
    }
    
    @After
    public void cleanCLI() {
    	System.setOut(origOut);
    	System.setErr(origErr);
    	String[] commands = {"sudo", "clear"};
    	command = new AddCommand(model, view, commands, prompt);
    }
     
    /**
     * Used to execute the AddCommand
     * @param commands the commands to input
     */
    private void executeCommand(String[] commands) {
    	AddCommand create = new AddCommand(model, view, commands, prompt);
    	prompt = create.execute();
    }
    
    /**
     * Test to add a class
     */
    @Test
    public void addClassTest() {
    	String[] commands = {"add", "class", "class1"};
    	executeCommand(commands);
    	assertTrue("Should be one class called class1.", model.hasClass("class1"));
	    commands[2] = "class2";
    	executeCommand(commands);
    	commands[2] = "class3";
    	executeCommand(commands);
    	
	  	assertTrue("Should be class called class2.", model.hasClass("class2"));
    	assertTrue("Should be class called class3.", model.hasClass("class3"));
    }
    
    /**
     * Test to add a field
     */
    @Test
    public void addFieldTest() {
    	String[] classCommands = {"add", "class", "class1"};
    	executeCommand(classCommands);
    	ClassObject class1 = model.getClasses().get("class1");
	
    	String[] fieldCommands = {"add", "field", "class1", "field1", "int"};
    	executeCommand(fieldCommands);
    	assertTrue("Should be one field called field1.", class1.containsField("field1"));
	}
      
    /**
     * Test adding a method
     */
    @Test
    public void addMethodTest() {
    	String[] classCommands = {"add", "class", "class1"};
		executeCommand(classCommands);
		ClassObject class1 = model.getClasses().get("class1");
	
		String[] methodCommands = {"add", "method", "class1", "method1", "int"};
		executeCommand(methodCommands);
		assertTrue("Should be one method called method1.", class1.containsMethod("method1"));
	}
    
    /**
     * Test to add a parameter
     */
    @Test
    public void addParameterTest() {
    	String[] classCommands = {"add", "class", "class1"};
    	executeCommand(classCommands);
    	ClassObject class1 = model.getClasses().get("class1");
    	String[] methodCommands = {"add", "method", "class1","method1", "int"};
    	executeCommand(methodCommands);
    	Method method1 = class1.getMethod("method1");
	
    	String[] parameterCommands = {"add", "parameter", "class1", "method1", "param1", "String"};
    	executeCommand(parameterCommands);
    	assertTrue("Should be one parameter called p1.", method1.containsParameter("param1"));	
    }
    
    /**
     * Test to add a relationship
     */
    @Test
    public void addRelationshipTest() {
        String[] classes = {"add", "class", "class1"};
        executeCommand(classes);
        classes[2] = "class2";
        executeCommand(classes);
        
        String[] rels = {"add", "relationship", "class1", "class2", "ID1", "Aggregation"};
        executeCommand(rels);
        assertFalse("Relationship was created", model.getRelationships().isEmpty());
    }
    
}
