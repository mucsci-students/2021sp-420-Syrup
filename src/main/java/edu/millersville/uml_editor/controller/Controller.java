package edu.millersville.uml_editor.controller;

import java.io.IOException;



import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.ViewTemplate;

public class Controller {

	private ControllerType control;

    public Controller(UMLModel model, ViewTemplate view) throws IOException {
    		control = new CLIController(model, view);
    }
    
    
    public void init() throws IOException {
    	control.init();
    }
    
   
}
