package edu.millersville.uml_editor.cli_command;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

/**
 * A function that handles the add commands. We store commands into a list of strings.
 * 
 * @author TeamSyrup
 *
 */
public class AddCommand extends Command {

	/**
	 * Initializes a command to add a class, field, method, parameter, or a relationship.
	 * 
	 * @param m the model for the uml
	 * @param v the view
	 * @param com the list of strings to store the commands
	 * @param p true or false
	 */
	 public AddCommand(UMLModel m, CLIView v, String[] com, boolean p) {
		 super();
	 }

	public boolean execute() {
		if (commands.length < 3) {
		    view.printError(errorMessage + commandUsage[2] + commandUsage[3] + commandUsage[4] + commandUsage[5]
			    + commandUsage[6] + "\n");
		    return prompt;
		}
		// adding a class
		if (commands[1].equals("class")) {
		    if (commands.length != 3) {
			view.printError(errorMessage + commandUsage[2] + "\n");
			return prompt;
		    }
		    if (model.createNewClassGUI(commands[2])) {
			return true;
		    } else {
			view.printError("Create class failed. Make sure the class name doesn't already exist.\n");
		    }
		// adding a field
		} else if (commands[1].equals("field")) {
		    if (commands.length != 6) {
			view.printError(errorMessage + commandUsage[3] + "\n");
			return prompt;
		    }
		    if (model.addField(commands[2], commands[3], commands[4])) {
			return true;
		    } else {
			view.printError(
				"Create field failed. Make sure the field doesn't already exist and the class name does exist.\n");
		    }
		// adding a method
		} else if (commands[1].equals("method")) {
		    if (commands.length != 6) {
			view.printError(errorMessage + commandUsage[4] + "\n");
			return prompt;
		    }
		    if (model.addMethod(commands[2], commands[3], commands[4])) {
			return true;
		    } else {
			view.printError(
				"Create method failed. Make sure the method doesn't already exist and the class name does exist.\n");
		    }
		// adding a relationship
		} else if (commands[1].equals("relationship")) {
		    if (commands.length != 5) {
			view.printError(errorMessage + commandUsage[5] + "\n");
			return prompt;
		    }
		    if (model.createRelationshipGUI(commands[2], commands[3], commands[4], commands[5]))  {
			return true;
		    } else {
			view.printError(
				"Create relationship failed. Make sure the classes exist, the relationship type is valid, and that it is not a duplicate.\n");
		    }
		// adding a parameter
		} else if (commands[1].equals("parameter")) {
		    if (commands.length != 6) {
			view.printError(errorMessage + commandUsage[6] + "\n");
			return prompt;
		    }
		    if (model.addParameter(commands[2], commands[3], commands[4], commands[5])) {
			return true;
		    } else {
			view.printError(
				"Create parameter failed. Make sure the class exists, method exists, and the parameter does NOT exist.\n");
		    }
		} else {
		    view.printError(errorMessage + commandUsage[2] + commandUsage[3] + commandUsage[4] + commandUsage[5]
			    + commandUsage[6] + "\n");
		}
		return prompt;
	}
}
