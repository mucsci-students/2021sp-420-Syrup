package edu.millersville.uml_editor.cli_commandTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.millersville.uml_editor.cli_command.AddCommand;
import edu.millersville.uml_editor.cli_command.DeleteCommand;
import edu.millersville.uml_editor.model.ClassObject;
import edu.millersville.uml_editor.model.Method;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;
import edu.millersville.uml_editor.view.ViewTemplate;

public class DeleteCommandTest {

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
		String[] commands = { "sudo", "clear" };
		command = new AddCommand(model, view, commands, prompt);
    }
    
    private void resetStreams() {
        out.reset();
        err.reset();
    }
    
    private void executeCreate(String[] commands) {
    	AddCommand create = new AddCommand(model, view, commands, prompt);
    	prompt = create.execute();
    }

    private void executeDelete(String[] commands) {
    	DeleteCommand delete = new DeleteCommand(model, view, commands, prompt);
    	prompt = delete.execute();
    }
    
    @Test
    public void deleteClassTest() {
    	// Set up
    	String[] createClass = { "add", "class", "class1" };
    	executeCreate(createClass);
    	createClass[2] = "class2";
    	executeCreate(createClass);

    	// Test deleting a class
    	String[] delete = { "delete", "class", "class1" };
    	executeDelete(delete);
    	assertFalse("class1 should not exist.", model.hasClass("class1"));
    	assertTrue("class2 should still exist.", model.hasClass("class2"));


    	// Test deleting classes that have fields
    	createClass[2] = "c1";
    	executeCreate(createClass);
    	String[] createField = { "create", "field", "class1", "field", "int"};
    	executeCreate(createField);
    	executeDelete(delete);
    	assertFalse("class1 should not exist.", model.hasClass("class1"));

    	// Test deleting classes that have methods
    	executeCreate(createClass);
    	String[] createMethod = { "create", "method", "class1", "method1", "int"};
    	executeCreate(createMethod);
    	executeDelete(delete);

    	assertFalse("class1 should not exist.", model.hasClass("class1"));

    	// Test deleting classes with methods and parameters
    	executeCreate(createClass);
    	executeCreate(createMethod);
    	String[] createParameter = { "create", "parameter", "class1", "method1", "param1", "int"};
    	executeCreate(createParameter);
    	executeDelete(delete);
    	assertFalse("class1 should not exist.", model.hasClass("class1"));

	}

    //Deleting fields
    @Test
    public void deleteFieldTest() {
    	String[] classCommands = { "create", "class", "class1" };
    	executeCreate(classCommands);
    	ClassObject class1 = model.getClasses().get("class1");
    	String[] createFieldCommands = { "create", "field", "class1", "field", "int"};
    	executeCreate(createFieldCommands);

    	String[] deleteFieldCommands = { "delete", "field", "class1", "field1" };
    	executeDelete(deleteFieldCommands);
    	assertFalse("Should not have any fields.", class1.containsField("field1"));
    }

    //Deleting methods
    @Test
    public void deleteMethodTest() {
    	String[] classCommands = { "create", "class", "class1" };
    	executeCreate(classCommands);
    	ClassObject class1 = model.getClasses().get("class1");
    	String[] createMethodCommands = { "create", "method", "class1", "method1", "int"};
    	executeCreate(createMethodCommands);

		String[] deleteMethodCommands = { "delete", "method", "class1", "method1" };
		executeDelete(deleteMethodCommands);
		assertFalse("Method1 should not exist.", class1.containsMethod("method1"));
    }

    //Deleting parameters
    @Test
    public void deleteParameterTest() {
    	String[] classCommands = { "create", "class", "class1" };
    	executeCreate(classCommands);
    	ClassObject class1 = model.getClasses().get("class1");
    	String[] methodCommands = { "create", "method", "class1", "method1", "int"};
    	executeCreate(methodCommands);
    	Method method1 = class1.getMethods().get(0);
    	String[] parameterCommands = { "create", "parameter", "class1", "method1", "param1", "int"};
    	executeCreate(parameterCommands);

    	String[] deleteParameterCommands = { "delete", "parameter", "class1", "method1", "param1" };
    	executeDelete(deleteParameterCommands);
    	assertFalse("CLI did not get rid of p1.", method1.containsParameter("param1"));
    }
}
