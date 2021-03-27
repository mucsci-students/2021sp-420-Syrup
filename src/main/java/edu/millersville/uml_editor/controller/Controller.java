package edu.millersville.uml_editor.controller;

import java.io.IOException;

import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.UMLGUI;
import edu.millersville.uml_editor.view.ViewTemplate;

public class Controller {

	private ControllerType control;
	private UMLGUI control2;

    public Controller(UMLModel model, ViewTemplate view) throws IOException {

    	
    		control = new CLIController(model, view);
    	
    }
    
    public Controller(UMLModel model)
    {
    	control2 = new UMLGUI(model);
    }
    
    public void init() throws IOException {
    	control.init();
    }
    
    public void initGUI() {
    	control2.drawGUI();
    }
}
