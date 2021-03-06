package edu.millersville.uml_editor.cli_command;

import java.io.IOException;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class SaveCommand extends Command{
	
	private String file;

    public SaveCommand(UMLModel m, CLIView v, String[] com, boolean p, String file) {
        super(m, v, com, p);
        this.file = file;
    }

    //function that saves the program
    public boolean execute() {
        if (commands.length == 2) {
            try {
                file = commands[1];
                model.saveJSON(file);
                System.out.println("File saved at: " + file);
            } catch (IOException e) {
                view.printError("Failed save file. Exiting.");
                return prompt;
            }
        } else if(commands.length == 1) {
        	if(file == null) {
        		System.out.println("\nRe-enter name of file: " + commandUsage[0] + "\n");
        		return prompt;
			}
			try {
				model.saveJSON(file);
				System.out.println("File saved at: " + file);
			} catch (IOException e) {
				view.printError("Failed to save file. Exiting.");
				return prompt;
			}
		} else {
            view.printError(errorMessage + commandUsage[0] + "\n");
            return prompt;
        }
        return false;
    }

    public String getFile() {
        return file;
    }
}
