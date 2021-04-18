package edu.millersville.uml_editor.modelTest;

import edu.millersville.uml_editor.model.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParameterTest {

	@Test
	public void testCreateClass() {
		Parameter param = new Parameter("param", "type");
		assertEquals("Correct name of method", "param", param.getName());
		assertEquals("Correct type of method", "type", param.getType());
	}
	
	@Test
	public void testToString(){
	    Parameter param = new Parameter("param", "int");
	    assertEquals("Correct toString() output", "Name: param Type: int", param.toString());
	}
}
