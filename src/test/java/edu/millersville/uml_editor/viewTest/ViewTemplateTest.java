package edu.millersville.uml_editor.viewTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.millersville.uml_editor.view.ViewTemplate;
import edu.millersville.uml_editor.view.ViewTemplate.InterfaceType;

public class ViewTemplateTest {
	
    /* test default constructor */
    @Test
    public void DefaultConstructorTest() {
    	ViewTemplate vt = new ViewTemplate();
    	assertTrue("View template is null.", vt != null);
    }
    
    /* test gui constructor */
    @Test
    public void GUIConstructorTest() {
    	ViewTemplate guiVT = new ViewTemplate(InterfaceType.GUI);
	   	assertTrue("GUIViewTemplate is null.", guiVT != null);
    }
    
    /* test gui template */
    @Test
    public void IsGUITest() {
    	new ViewTemplate(InterfaceType.GUI);
		assertTrue("GUIViewTemplate not reported as GUIViewTemplate.", ViewTemplate.isGUI());
    }
    
    /* test cli constructor */
    @Test
    public void CLIConstructorTest() {
    	ViewTemplate cliVT = new ViewTemplate(InterfaceType.CLI);
	   	assertTrue("CLIViewTemplate is null.", cliVT != null);
    }
}
