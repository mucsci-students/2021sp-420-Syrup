package edu.millersville.uml_editor.Commands;

import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;

public abstract class Command {
    protected UMLModel model;
    protected CLIView view;
    protected String[] commands;

    protected boolean checkArgNum(int actual, int desired) {
        boolean result = false;

        if(actual == desired) {
            result = true;
        }
        else if(actual < desired) {
            view.printError("Missing arguments.\n");
        }
        else {
            view.printError("Too many arguments.\n");
        }
        return result;
    }
}
