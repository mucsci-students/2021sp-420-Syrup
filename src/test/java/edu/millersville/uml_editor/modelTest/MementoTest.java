package edu.millersville.uml_editor.modelTest;

import edu.millersville.uml_editor.model.*;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class MementoTest {
	/**
	 * A test for the memento model
	 */
	@Test
	public void mementoConstructorTest() {
		Memento meme = new Memento();
		assertFalse("Memento is somehow null.", meme.equals(null));
	}
	
}
