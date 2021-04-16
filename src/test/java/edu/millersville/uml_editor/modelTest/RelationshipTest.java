package edu.millersville.uml_editor.modelTest;

import edu.millersville.uml_editor.model.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class RelationshipTest {

	@Test
	public void testConstructorandGetters() {
		ClassObject class1 = new ClassObject("class1");
		ClassObject class2 = new ClassObject("class2");
		Relationships r = new Relationships(class1, class2, "ID1", "A");

		assertEquals("Relationship name should be set properly.", "A", r.relType());
		assertEquals("First class name should be set properly.", class1.getName(), r.sourceName());
		assertEquals("Second class name should be set properly.", class2.getName(), r.destinationName());
		assertEquals("Relationship ID name should be set properly.", "ID1", r.getID());
	}
}
