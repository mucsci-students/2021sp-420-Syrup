package edu.millersville.uml_editor.cli_commandTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.millersville.uml_editor.cli_command.AddCommand;
import edu.millersville.uml_editor.cli_command.RenameCommand;
import edu.millersville.uml_editor.model.ClassObject;
import edu.millersville.uml_editor.model.Method;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;
import edu.millersville.uml_editor.view.ViewTemplate;

public class RenameCommandTest {
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
    
    private void resetStreams() {
        out.reset();
        err.reset();
    }
    
    private void executeCommand(String[] commands) {
    	RenameCommand create = new RenameCommand(model, view, commands, prompt);
    	prompt = create.execute();
    }
    
    private void executeCreateCommand(String[] commands) {
    	AddCommand create = new AddCommand(model, view, commands, prompt);
    	prompt = create.execute();
    }
    
    //Rename class
    @Test
    public void renameClassTest() {
    	// Setup
    	String[] commands = {"create", "class", "class1"};
        executeCreateCommand(commands);
        commands[2] = "class2";
        executeCreateCommand(commands);

        assertTrue("class1 should exist.", model.hasClass("class1"));
        assertTrue("class2 should exist.", model.hasClass("class2"));

        // Test rename a class
        String[] rename = {"rename", "class", "class1", "class3"};
        executeCommand(rename);

        assertTrue("class3 should exist.", model.hasClass("class3"));
        assertFalse("class1 does not exist anymore.", model.hasClass("class1"));
    }
    
    //Rename field
    @Test
    public void renameFieldTest() {
    	String[] classCommands = {"create", "class", "class1"};
    	executeCreateCommand(classCommands);
    	ClassObject class1 = model.getClasses().get("class1");
    	String[] createFieldCommands = {"create", "field", "class1", "field1", "int"};
    	executeCreateCommand(createFieldCommands);
	
		String[] renameFieldCommands = {"rename", "field", "class1", "field1", "newfield1"};
		executeCommand(renameFieldCommands);
		assertFalse("field1 should not exist.", class1.containsField("field1"));
		assertTrue("newfield1 should exist.", class1.containsField("newfield1"));
    }
    
    //Rename method
    @Test
    public void renameMethodTest() {
    	String[] classCommands = {"create", "class", "class1"};
    	executeCreateCommand(classCommands);
    	ClassObject class1 = model.getClasses().get("class1");
    	String[] createMethodCommands = {"create", "method", "class1", "method1", "int"};
    	executeCreateCommand(createMethodCommands);
    	
    	String[] renameMethodCommands = {"rename", "method", "class1", "method1", "newmethod1"};
    	executeCommand(renameMethodCommands);
    	assertFalse("method1 should not exist.", class1.containsMethod("method1"));
    	assertTrue("newmethod1 should exist.", class1.containsMethod("newmethod1"));
    }
    
    //Rename parameter
    @Test
    public void renameParameterTest() {
    	String[] classCommands = {"create", "class", "class1"};
    	executeCreateCommand(classCommands);
    	ClassObject class1 = model.getClasses().get("class1");
    	String[] methodCommands = {"create", "method", "class1", "method", "int"};
    	executeCreateCommand(methodCommands);
    	Method method1 = class1.getMethods().get(0);
    	String[] parameterCommands = {"create", "parameter", "class1", "method1", "int"};
    	executeCreateCommand(parameterCommands);
    	
    	String[] renameParameterCommands = {"rename", "parameter", "class1", "method1", "param1", "newparam1"};
    	executeCommand(renameParameterCommands);
    	assertFalse("param1 should not exist.", method1.containsParameter("param1"));
    }
}
