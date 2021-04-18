package edu.millersville.uml_editor.cli_commandTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.millersville.uml_editor.cli_command.AddCommand;
import edu.millersville.uml_editor.cli_command.MiscCommand;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;
import edu.millersville.uml_editor.view.ViewTemplate;

public class MiscCommandTest {
	UMLModel model;
	CLIView view;
	ViewTemplate viewTemp;
	AddCommand command;
	boolean prompt;
	private Terminal terminal;
	private DefaultParser parser;
	private LineReader savePromptReader;
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

    	terminal = TerminalBuilder.builder().system(true).build();
    	StringsCompleter savePromptCompleter = new StringsCompleter("yes", "no");
    	parser = new DefaultParser();
    	parser.setEscapeChars(new char[] {});
    	savePromptReader = LineReaderBuilder.builder().terminal(terminal).completer(savePromptCompleter)
    			.variable(LineReader.MENU_COMPLETE, true).parser(parser).build();
    }

    @After
    public void cleanCLI() {
    	System.setOut(origOut);
    	System.setErr(origErr);
    	String[] commands = {"clear"};
    	command = new AddCommand(model, view, commands, prompt);
    }

    private void executeCommand(String[] commands) {
    	MiscCommand create = new MiscCommand(model, view, commands, prompt, savePromptReader);
    	prompt = create.execute();
    }

    private void executeCreateCommand(String[] commands) {
    	AddCommand create = new AddCommand(model, view, commands, prompt);
    	prompt = create.execute();
    }
    
    @Test
    public void helpTest() {
    	String[] help = {"help"};
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
    	ByteArrayOutputStream err = new ByteArrayOutputStream();

    	System.setOut(new PrintStream(out));
    	System.setErr(new PrintStream(err));

    	System.out.print("\nList of commands:");
    	System.out.println(
    			"\n  save <name>.json" + " - Save file to specific path" 
    		+ "\n  load <path>" + " - Loads a file at a specific path\n" 
    		+ "\n  add class <name>" + " - add a class with title <name>"
    		+ "\n  add field <class name> <field name> <field type>" + " - add a field in <class name>, titled <field name> with type <field type>"
    		+ "\n  add method <class name> <method name> <method type>" + " - add a method in <class name>, titled <method name> with type type <method type>"
    		+ "\n  add relationship <class name1> <class name2> <relationship ID> <relationship type>" + " - add relationship between <class name1> and <class name2> with type <type> (Aggregation, Realization, Composition, Inheritance)"
    		+ "\n  add parameter <class name> <method> <parameter name> <parameter type>" + " - add a parameter in <class name> for <method>  titled <parameter name> with type <parameter type>\n"
    		+ "\n  delete class <name>" + " - delete a class with title <name>" 
    		+ "\n  delete field <class name> <field name>" + " - delete field in class titled <class name> with name <field name>" 
    		+ "\n  delete method <class name> <method name>" + " - delete method in class titled <class name> with name <method name>" 
    		+ "\n  delete relationship <relationship ID>" + " - delete a relationship between <class name1> and <class name2> with type <type> (Aggregation, Realization, Composition, Inheritance)"
    		+ "\n  delete parameter <class name> <method name>, <parameter name>" + " - delete a parameter in <class name> for <method name> with <parameter name>\n"
    		+ "\n  rename class <name> <newname>" + " - rename class <name> to <new name>" 
    		+ "\n  rename field <class name> <field name> <newname>" + " - rename field in class titled <class name> with field name <field name> to <newname>" 
    		+ "\n  rename method <class name> <method name> <newname>" + " - rename method in class titled <class name> with method name <method name> to <newname>" 
    		+ "\n  rename parameter <class name> <method name> <parameter name> <parameter newname>" + " - rename parameter in <class name> for <method> titled <parameter name> to <parameter newname>\n"
    		+ "\n  list classes" +  " - List all existing classes" 
    		+ "\n  list relationships" + " - List all existing relationships" 
    		+ "\n  clear" + " - Clear all classes and relationships\n"
    		+ "  undo - Reverts the most recent change to the UML Editor\n"
    		+ "  redo - Restores the most recently undone action.\n" + "  quit - exits the program\n");
		String expected = out.toString();
		out.reset();
		err.reset();
		executeCommand(help);
		assertEquals("Initial print all does not equal printout", expected, out.toString());
    }
}
