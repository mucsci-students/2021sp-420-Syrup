package edu.millersville.uml_editor.cli_command;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class RenameCommand extends Command{
	
	public RenameCommand(UMLModel m, CLIView v, String[] com, boolean p) {
		super(m, v, com, p);
	    }

	    public boolean execute() {
		if (commands.length < 4) {
		    view.printError(
			    errorMessage + commandUsage[12] + commandUsage[13] + commandUsage[14] + commandUsage[15] + "\n");
		    return prompt;
		}
		// renaming a class
		if (commands[1].equals("class")) {
		    if (commands.length != 4) {
				view.printError(errorMessage + commandUsage[12] + "\n");
				return prompt;
		    }
		    if (model.renameClassGUI(commands[2], commands[3])) {
		    	return true;
		    } else {
				view.printError(
					"Could not rename class. Make sure the original class name exists/is spelled correctly"
					+ " and the new class name doesn't exist.\n");
		    }
		// renaming a field
		} else if (commands[1].equals("field")) {
		    if (commands.length != 5) {
				view.printError(errorMessage + commandUsage[13] + "\n");
				return prompt;
		    }
		    if (model.renameField(commands[2], commands[3], commands[4])) {
		    	return true;
		    } else {
				view.printError(
					"Could not rename field. Make sure the class and field exist/are spelled correctly"
					+ " and the new field name doesn't exist.\n");
		    }
		// renaming a method    
		} else if (commands[1].equals("method")) {
		    if (commands.length != 5) {
				view.printError(errorMessage + commandUsage[14] + "\n");
				return prompt;
		    }
		    if (model.renameMethod(commands[2], commands[3], commands[4])) {
		    	return true;
		    } else {
				view.printError(
					"Could not rename method. Make sure the class and method exist/are spelled correctly"
					+ " and the new method name doesn't exist.\n");
		    }
		// renaming a parameter    
		} else if (commands[1].equals("parameter")) {
		    if (commands.length != 6) {
				view.printError(errorMessage + commandUsage[15] + "\n");
				return prompt;
		    }
		    if (model.renameParameter(commands[2], commands[3], commands[4], commands[5])) {
		    	return true;
		    } else {
				view.printError(
					"Could not rename parameter. Make sure the class, method, and parameter all exist/are spelled correctly"
					+ " and the new parameter name does not exist.");
		    }
		} else {
		    view.printError(
			    errorMessage + commandUsage[12] + commandUsage[13] + commandUsage[14] + commandUsage[15] + "\n");
		}
			return prompt;
	    }

}
