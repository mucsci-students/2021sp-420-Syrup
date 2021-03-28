package edu.millersville.uml_editor.viewTest;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import edu.millersville.uml_editor.controller.UMLController;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.GUI;

public class UMLGUITest {

	@Spy
	private UMLController controller;
	@Spy
    private UMLModel model;
	
	
	 @Mock
	 GUI guiViewMock;
	 
	 @Mock
	 UMLController guiControllerMock;
	
	@Test
	public void testUMLGUIConstructor() {
		guiViewMock = new GUI(model);
	}
}
