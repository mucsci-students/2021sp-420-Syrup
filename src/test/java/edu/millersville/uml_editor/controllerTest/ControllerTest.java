package edu.millersville.uml_editor.controllerTest;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import edu.millersville.uml_editor.controller.Controller;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.ViewTemplate;
import edu.millersville.uml_editor.view.ViewTemplate.InterfaceType;

public class ControllerTest {

	  @Test
	  public void CLIControllerCreationTest() throws IOException {
		UMLModel m = new UMLModel();
		ViewTemplate v = new ViewTemplate(InterfaceType.CLI);
		Controller c = new Controller(m, v);
		
		assertTrue("Controller equals null.", c != null);
	    }
}
