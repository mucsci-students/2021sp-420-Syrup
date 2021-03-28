package edu.millersville.uml_editor.Commands;

import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;

public class RemoveCommand extends Command {
    
    public RemoveCommand(UMLModel m, CLIView v, String[] c) {
        this.model = m;
        this.view = v;
        this.commands = c;

        int desiredArgs;

        switch(commands[1]) {
            case "class":
                //TODO
                break;
            
            case "field":
                desiredArgs = 5;
                if(checkArgNum(commands.length, desiredArgs)) {
                    model.addField(commands[2], commands[3], commands[4]);
                }
                break;

            case "method":
                desiredArgs = 5;
                model.addMethod(commands[2], commands[3], commands[4]);
                break;

            case "parameter":
                desiredArgs = 4;
                model.deleteParameter(commands[2], commands[3], commands[4]);
                break;
        }
    }
}
