package edu.millersville.uml_editor.modelTest;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import edu.millersville.uml_editor.model.Memento;

public class MementoTest {

	 @Test
	 public void mementoConstructorTest() {
		Memento meme = new Memento();
		assertFalse("Memento is somehow null.", meme.equals(null));
	 }
}
