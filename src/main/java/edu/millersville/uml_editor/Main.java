package edu.millersville.uml_editor;

import java.io.IOException;

import edu.millersville.uml_editor.controller.*;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
		UMLModel model = new UMLModel();
		ViewTemplate view;
		Controller control;
		
		if(args.length == 1 && args[0].equals("--cli")) {
			view = new ViewTemplate(ViewTemplate.InterfaceType.CLI);
    	    control = new Controller(model, view);
    	    control.init();
		}
		else if(args.length == 0) {
			GUI view2 = new GUI(model);
    	    view2.drawGUI();
		}
		else {
			System.out.println("*Invalid Argument*");
		}
    }
    		
}