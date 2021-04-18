package edu.millersville.uml_editor.cli_command;

import org.jline.reader.LineReader;
import org.jline.reader.MaskingCallback;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class MiscCommand extends Command {

    private static LineReader savePromptReader;

    public MiscCommand(UMLModel m, CLIView v, String[] com, boolean p, LineReader reader) {
		super(m, v, com, p);
		prompt = p;
		savePromptReader = reader;
    }

    public boolean execute() {
	switch (commands[0]) {
	case "quit":
	    if (commands.length != 1) {
	    	view.printError(errorMessage + commandUsage[21] + "\n");
	    	return prompt;
	    } else if (prompt) {
	    	System.out.println("Type 'yes' to quit, or 'no' to go back.");
	    	prompt = savePrompt(prompt);
	    }
	    if (!prompt) {
	    	System.exit(0);
	    }
	    return true;

	case "help":
	    help(commandUsage);
	    return prompt;
	case "clear":
	    if (commands.length != 1) {
	    	view.printError(errorMessage + commandUsage[18] + "\n");
	    	return prompt;
	    } else if (!model.isEmpty()) {
	    	System.out.println("\nAre you sure you want to delete everything?");
	    	System.out.println("Type 'yes' to delete, or 'no' to go back.");
		boolean answer = savePrompt(true);

		if (!answer) {
		    model.clear();
		    prompt = true;
		}
	    }
	    return prompt;
	case "sudo":
	    if (commands[1].equals("quit") && commands.length == 2) {
	    	System.exit(0);
	    } else if (commands[1].equals("load") && commands.length == 3) {
		try {
		    String file = commands[2];
		    model.loadJSON(file);
		    prompt = false;
		} catch (Exception e) {
		    System.out.println("Failed to parse directory. Exiting.");
		}
	    } else if (commands[1].equals("clear") && commands.length == 2) {
	    	model.clear();
	    	prompt = true;
	    } else {
		System.out.println("\nInvalid command.\nType help to see a list of commands.\n");
	    }
	    return prompt;
	}
	return prompt;
    }

    
    private static boolean savePrompt(boolean prompt) {
	while (prompt) {

	    String line = savePromptReader.readLine("", "", (MaskingCallback) null, null);
	    line = line.trim();

	    if (line.equals("yes")) {
	    	System.out.println("Proceeding.\n");
	    	prompt = false;
	    	break;
	    } else if (line.equals("no")) {
	    	System.out.println("Stopping.\n");
	    	prompt = true;
	    	break;
	    }
	    System.out.println("Invalid command. Type 'yes' to proceed, or 'no' to go back.");
	}
	return prompt;
    }

    
    private static void help(String[] commandUsage) {
	System.out.print("\nList of commands:");
	System.out.println(
		commandUsage[0] + " - Save file to specific path" 
		+ commandUsage[1] + " - Loads a file at a specific path\n" 
		+ commandUsage[2] + " - add a class with title <name>"
		+ commandUsage[3] + " - add a field in <class name>, titled <field name> with type <field type>"
		+ commandUsage[4] + " - add a method in <class name>, titled <method name> with type type <method type>"
		+ commandUsage[5] + " - add relationship between <class name1> and <class name2> with type <type> (Aggregation, Realization, Composition, Inheritance)"
		+ commandUsage[6] + " - add a parameter in <class name> for <method>  titled <parameter name> with type <parameter type>\n"
		+ commandUsage[7] + " - delete a class with title <name>" 
		+ commandUsage[8] + " - delete field in class titled <class name> with name <field name>" 
		+ commandUsage[9] + " - delete method in class titled <class name> with name <method name>" 
		+ commandUsage[10] + " - delete a relationship between <class name1> and <class name2> with type <type> (Aggregation, Realization, Composition, Inheritance)"
		+ commandUsage[11] + " - delete a parameter in <class name> for <method name> with <parameter name>\n"
		+ commandUsage[12] + " - rename class <name> to <new name>" 
		+ commandUsage[13] + " - rename field in class titled <class name> with field name <field name> to <newname>" 
		+ commandUsage[14] + " - rename method in class titled <class name> with method name <method name> to <newname>" 
		+ commandUsage[15] + " - rename parameter in <class name> for <method> titled <parameter name> to <parameter newname>\n"
		+ commandUsage[16] +  " - List all existing classes" 
		+ commandUsage[17] + " - List all existing relationships" 
		+ commandUsage[18] + " - Clear all classes and relationships\n"
		+ "  undo - Reverts the most recent change to the UML Editor\n"
		+ "  redo - Restores the most recently undone action.\n" + "  quit - exits the program\n");
    }

}

