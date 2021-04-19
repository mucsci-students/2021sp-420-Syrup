package edu.millersville.uml_editor.controllerTest;

import org.junit.Test;
import org.mockito.Mock;

import edu.millersville.uml_editor.controller.*;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.GUI;

public class UMLControllerTest {
		
	@Mock
    GUI umlViewMock;
    @Mock
    UMLController control;
    
    private UMLModel model;
    
   
    @Test
    public void constructorTest() throws Exception {
    	new UMLController(model,umlViewMock);
    }  
}
