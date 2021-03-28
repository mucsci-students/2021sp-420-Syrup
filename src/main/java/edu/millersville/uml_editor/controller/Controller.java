package edu.millersville.uml_editor.controller;

import java.io.IOException;

import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.GUI;
import edu.millersville.uml_editor.view.ViewTemplate;

public class Controller {

	private ControllerType control;
	private GUI control2;

    public Controller(UMLModel model, ViewTemplate view) throws IOException {

    	
    		control = new CLIController(model, view);
    	
    }
    
    public Controller(UMLModel model)
    {
    	control2 = new GUI(model);
    }
    
    public void init() throws IOException {
    	control.init();
    }
    
    public void initGUI() {
    	control2.drawGUI();
    }
}
