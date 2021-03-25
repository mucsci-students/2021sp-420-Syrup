package edu.millersville.uml_editor.controllerTest;

import org.junit.Test;
import org.mockito.Mock;

import edu.millersville.uml_editor.controller.*;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.UMLGUI;

public class UMLControllerTest {
		
	@Mock
    UMLGUI umlViewMock;
    @Mock
    UMLController control;
    
    private UMLController UMLControllerMock;
    private UMLModel model;
    
   
    @Test
    public void constructorTest() throws Exception {
    	UMLControllerMock = new UMLController(model,umlViewMock);
    }
    
    
}
