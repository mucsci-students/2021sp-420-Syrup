package edu.millersville.uml_editor.modelTest;

import edu.millersville.uml_editor.model.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FormalTest {

	 /* Test constructor */
    @Test
    public void testFormal()
    {
        Formal f = new Formal("f", "int");
        assertEquals("Name set correctly", "f", f.getName());
        assertEquals("Type set correctly", "int", f.getType());
    }
    
    /* Test getters and setters */
    @Test
    public void testGettersAndSetters()
    {
		Formal f = new Formal("f", "int");
		
		f.setName("g");
		f.setType("char");
		
		assertEquals("Name changed correctly", "g", f.getName());
		assertEquals("Type changed correctly", "char", f.getType());
    }
}
