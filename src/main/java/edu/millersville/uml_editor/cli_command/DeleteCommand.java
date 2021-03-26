package edu.millersville.uml_editor.cli_command;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class DeleteCommand extends Command {

	
	public DeleteCommand(Model m, CLIView v, String[] com, boolean p) {
		super();
	}
	
	public boolean execute() {
		if (commands.length < 3) {
		    view.printError(errorMessage + commandUsage[7] + commandUsage[8] + commandUsage[9] + commandUsage[10]
			    + commandUsage[11] + "\n");
		    return prompt;
		}
		// delete a class
		if (commands[1].equals("class")) {
		    if (commands.length != 3) {
			view.printError(errorMessage + commandUsage[7] + "\n");
			return prompt;
		    }
		    if (model.deleteClassGUI(commands[2])) {
			return true;
		    } else {
			view.printError("Could not delete class. Make sure the class name exists or is spelled correctly.\n");
		    }
		// delete a field
		} else if (commands[1].equals("field")) {
		    if (commands.length != 4) {
			view.printError(errorMessage + commandUsage[8] + "\n");
			return prompt;
		    }
		    if (model.deleteField(commands[2], commands[3])) {
			return true;
		    } else {
			view.printError("Delete field failed. Make sure the field and class name exist.\n");
		    }
		// delete a method
		} else if (commands[1].equals("method")) {
		    if (commands.length != 4) {
			view.printError(errorMessage + commandUsage[9] + "\n");
			return prompt;
		    }
		    if (model.deleteMethod(commands[2], commands[3])) {
			return true;
		    } else {
			view.printError("Could not delete method. Make sure the method and class name exist or are spelled correctly.\n");
		    }
		// delete a relationship
		} else if (commands[1].equals("relationship")) {
		    if (commands.length != 5) {
			view.printError(errorMessage + commandUsage[10] + "\n");
			return prompt;
		    }
		    if (model.deleteRelationshipGUI(commands[2])) {
			return true;
		    } else {
			view.printError("Could not delete relationship. Make sure the relationship exists.\n");
		    }
		// delete a parameter
		} else if (commands[1].equals("parameter")) {
		    if (commands.length != 5) {
			view.printError(errorMessage + commandUsage[11] + "\n");
			return prompt;
		    }
		    if (model.deleteParameter(commands[2], commands[3], commands[4])) {
			return true;
		    } else {
			view.printError("Could not delete parameter. Make sure the class, method, and parameter all exist or are spelled correctly.\n");
		    }
		} else {
		    view.printError(errorMessage + commandUsage[7] + commandUsage[8] + commandUsage[9] + commandUsage[10]
			    + commandUsage[11] + "\n");
		}
		return prompt;
	    }
}
