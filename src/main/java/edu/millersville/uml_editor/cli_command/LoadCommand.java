package edu.millersville.uml_editor.cli_command;

import org.jline.reader.LineReader;
import org.jline.reader.MaskingCallback;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class LoadCommand extends Command {
	private static LineReader savePromptReader;
    private String file;

    public LoadCommand(UMLModel m, CLIView v, String[] com, boolean p, LineReader reader, String file) {
        super(m, v, com, p);
        savePromptReader = reader;
        this.file = file;
    }

    public boolean execute() {
        if (commands.length == 2) {
            try {
                if (prompt) {
                    System.out.println("All previous work will be erased. Type 'yes' to continue loading, or 'no' to go back.");
                    prompt = savePrompt();
                }
                if (!prompt) {
                    file = commands[1];
                    model.loadJSON(file);
                    return false;
                }
            } catch (Exception e) {
                view.printError("Failed to load file. Exiting.\n");
                return prompt;
            }
        } else {
            view.printError(errorMessage + commandUsage[1] + "\n");
            return prompt;
        }
        return prompt;
    }

    private static boolean savePrompt() {
        while (prompt) {

            String line = savePromptReader.readLine("", "", (MaskingCallback) null, null);
            line = line.trim();

            if (line.equals("yes")) {
                System.out.println("Saving.\n");
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

    public String getFile() {
    	return file;
	}
    
    public UMLModel getModel() {
    	return this.model;
    }
}
