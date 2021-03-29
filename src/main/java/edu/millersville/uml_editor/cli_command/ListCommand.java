package edu.millersville.uml_editor.cli_command;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class ListCommand extends Command{

	 public ListCommand(UMLModel m, CLIView v, String[] com, boolean p) {
			super(m, v, com, p);
		    }

		    public boolean execute() {
			if (commands.length < 2) {
			    view.printError(errorMessage + commandUsage[21] + commandUsage[22] + commandUsage[23] + "\n");
			    return prompt;
			}
			// get list of classes
			if (commands[1].equals("classes")) {
			    if (commands.length != 2) {
				view.printError(errorMessage + commandUsage[21] + "\n");
				return prompt;
			    } else {
				System.out.println();
				System.out.print(model.getClasses());
				System.out.println();
				return prompt;
			    }
			} else if (commands[1].equals("relationships")) {
			    if (commands.length != 2) {
				view.printError(errorMessage + commandUsage[22] + "\n");
				return prompt;
			    } else {
				System.out.println();
				System.out.print(model.getRelationships());
				System.out.println();
				return prompt;
			    }
			} else if (commands[1].equals("all")) {
			    if (commands.length != 2) {
				view.printError(errorMessage + commandUsage[23] + "\n");
				return prompt;
			    } else {
				System.out.println();
				model.getClasses();
				System.out.println();
				model.getRelationships();
				System.out.println();
				return prompt;
			    }
			} else {
			    view.printError(errorMessage + commandUsage[21] + commandUsage[22] + commandUsage[23] + "\n");
			}
			return prompt;
	}
}
