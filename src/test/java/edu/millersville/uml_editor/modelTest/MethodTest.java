package edu.millersville.uml_editor.modelTest;

import edu.millersville.uml_editor.model.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.*;

public class MethodTest {
	/**
	 * Test the method constructor
	 */
	@Test
	public void Method() {
		Method method = new Method("method", "int");
		assertEquals("Correct name of method", "method", method.getName());
		assertEquals("Returns type of method", "int", method.getType());
		assertTrue("Parameter list is empty", method.getParameters().isEmpty());
	}
	
	@Test
	public void testAddParameter() {
		Method method = new Method("method", "int");
		method.addParameter("param", "int");
		
		assertEquals("Parameters list size is 1", 1, method.getParameters().size());
		assertTrue("Parameters list has param", method.containsParameter("param"));
		assertFalse("Creating parameter with duplicate name", method.addParameter("param", "String"));
	}
	
	@Test
	public void testRenameParameter() {
		Method method = new Method("method", "int");
		method.addParameter("param1", "param1type");
		method.addParameter("param2", "param2type");
		assertFalse("Flase when renaming a parameter that doesn't exist", method.renameParameter("MIA", "newName"));
		assertFalse("False when new name already exists", method.renameParameter("param1", "param2"));
		assertTrue("param1 renamed to newparam1", method.renameParameter("param1", "newparam1"));
	    assertTrue("Parameters list contains newparam1", method.containsParameter("newparam1"));
	    assertFalse("Parameters list no longer contains param1", method.containsParameter("param1"));
	}
	
    /* test deleteParameter */
    @Test
    public void testDeleteParameter()
    {
        Method method = new Method("method", "int");
        method.addParameter("param", "int");
        assertFalse("False when deleting non-existent parameter", method.deleteParameter("fake"));
        assertTrue("param deleted", method.deleteParameter("param"));
        assertFalse("parameters list no longer contains param", method.containsParameter("param"));
        assertEquals("Parameters list size is 0", 0, method.getParameters().size());
    }
    
    /* test containsParameter */
    @Test
    public void testContainsParameter()
    {
        Method method = new Method("method", "int");
        method.addParameter("param", "int");
        assertTrue("param found", method.containsParameter("param"));
        assertFalse("non-existing parameter not found", method.containsParameter("fake"));
    }
    
    /**
     * Test changing a Method Parameter type
     */
    @Test
    public void testChangeParameterType()
    {
        Method m = new Method("m", "number");
        m.addParameter("param", "type");
        m.changeParameterType("param", "newtype");
        assertTrue("param type changed", m.getParameters().get(0).getType().equals("newtype"));
    }
    
    @Test
    public void testGetParameterNames()
    {
        Method method = new Method("method", "type");
        method.addParameter("param1", "Set");
        method.addParameter("param2", "Map");
        method.addParameter("param3", "Deque");

        List<String> paramNames = method.getParameterNames();
        assertEquals("Correct param 1 name", "param1", paramNames.get(0));
        assertEquals("Correct param 2 name", "param2", paramNames.get(1));
        assertEquals("Correct param 3 name", "param3", paramNames.get(2));
    }
    
    @Test
    public void testReplaceParameterList() {
    	Method method = new Method("method", "type");
    	method.addParameter("param1", "type");
    	method.addParameter("param2", "type");
    	
    	Method newMethod = new Method("method1", "type");
    	newMethod.addParameter("newparam1", "type");
    	newMethod.addParameter("newparam2", "type");
    	ArrayList<Parameter> newList = newMethod.getParameters();
    	
    	assertTrue("param list replaced with new list", method.replaceParameterList(newList));
    }

    @Test
    public void testDeleteAllParameters() {
    	Method method = new Method("method", "type");
    	method.addParameter("param", "type");
    	method.addParameter("param2", "type");
    	method.addParameter("param3", "type");
    	assertTrue("all params deleted", method.deleteAllParameters());
    }
    
}
