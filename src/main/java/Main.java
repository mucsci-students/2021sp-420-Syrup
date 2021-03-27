import java.io.IOException;
import java.util.Scanner;

import edu.millersville.uml_editor.controller.*;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;
import org.json.simple.parser.*;

public class Main 
{


///////////////////////////////////////////////////////////
//
//	Main Method
//
///////////////////////////////////////////////////////////
	
    public static void main(String[] args) throws IOException, ParseException
    {
    	System.out.println("Enter mode: ");
    	Scanner console = new Scanner(System.in);
    	String line = console.next();
    	UMLModel model = new UMLModel();
    	ViewTemplate view;
    	Controller control;

    	if (line.equals("cli")) {
    	    view = new ViewTemplate(ViewTemplate.InterfaceType.CLI);
    	    control = new Controller(model, view);
    	    control.init();
    	} else if(line.equals("gui")){
    	    view = new ViewTemplate(ViewTemplate.InterfaceType.GUI);
    	    control = new Controller(model);
    	    control.initGUI();
    	} else {
    	    System.out.println(
    		    "You did not enter the correct mode. Please enter a mode.");
    	}
    }
    		
}