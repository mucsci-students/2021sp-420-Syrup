package edu.millersville.uml_editor.cli_commandTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.millersville.uml_editor.cli_command.ListCommand;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;

public class ListCommandTest {
	Path path;
    UMLModel model;
    CLIView view;
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
    	view = new CLIView();
    }
    
    @After
    public void cleanCLI() {
    	System.setOut(origOut);
    	System.setErr(origErr);
    	String[] commands = {"clear"};
    	executeCommand(commands);
    }
    
    private void resetStreams() {
        out.reset();
        err.reset();
    }
    
    private void executeCommand(String[] commands) {
    	ListCommand create = new ListCommand(model, view, commands, prompt);
    	prompt = create.execute();
    }
    
    @Test
    public void listClassesTest() {
    	System.out.println();
    	System.out.println("{}");
    	String expected = out.toString();
        resetStreams();
        String[] commands = {"list", "classes"};
        executeCommand(commands);
        String actual = out.toString();
        assertEquals("Initial print all does not equal printout", expected, actual);
    }
    
    @Test
    public void listRelationshipTest() {
    	System.out.println();
    	System.out.println("{}");
        String expected = out.toString();
        resetStreams();
        String[] commands = {"list", "relationships"};
        executeCommand(commands);
        String actual = out.toString();
        assertEquals("Initial print all does not equal printout", expected, actual);
    }
}
