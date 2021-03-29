package edu.millersville.uml_editor.modelTest;

import edu.millersville.uml_editor.model.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.*;

public class FieldTest {

	@Test
	public void testField() {
		Field field = new Field("field", "type");
		assertEquals("Correct name of field", "field", field.getName());
		assertEquals("Correct type of field", "type", field.getType());
	}
	
	@Test
	public void testToString(){
	    Field field = new Field("field", "int");
	    assertEquals("Correct toString() output", "Name: field Type: int", field.toString());
	}
}
