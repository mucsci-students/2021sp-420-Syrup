package edu.millersville.uml_editor.cli_command;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class ListCommand extends Command{

	 public ListCommand(UMLModel m, CLIView v, String[] com, boolean p) {
			super(m, v, com, p);
		    }

		    public boolean execute() {
			if (commands.length < 2) {
			    view.printError(errorMessage + commandUsage[16] + commandUsage[17] + "\n");
			    return prompt;
			}
			// get list of classes
			if (commands[1].equals("classes")) {
			    if (commands.length != 2) {
				view.printError(errorMessage + commandUsage[16] + "\n");
				return prompt;
			    } else {
				System.out.println();
				System.out.print(model.getClasses());
				System.out.println();
				return prompt;
			    }
			// get list of relationships
			} else if (commands[1].equals("relationships")) {
			    if (commands.length != 2) {
				view.printError(errorMessage + commandUsage[17] + "\n");
				return prompt;
			    } else {
				System.out.println();
				System.out.print(model.getRelationships());
				System.out.println();
				return prompt;
			    }
			
			} else {
			    view.printError(errorMessage + commandUsage[16] + commandUsage[17] + "\n");
			}
			return prompt;
	}
}
