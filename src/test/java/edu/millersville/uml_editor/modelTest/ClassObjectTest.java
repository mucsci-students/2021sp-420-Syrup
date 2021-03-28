package edu.millersville.uml_editor.modelTest;

import edu.millersville.uml_editor.model.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class ClassObjectTest {

	/* test constructor */
    @Test
    public void testClassObject() {
        ClassObject e = new ClassObject("e");
        assertEquals("Name was set properly", "e", e.getName());
        assertTrue("Fields list was initialized", e.getFields().isEmpty());
        assertTrue("Methods list was initialized", e.getMethods().isEmpty());
    }
    
    /* test addField */
    @Test
    public void testAddField() {
        ClassObject e = new ClassObject("e");
        e.addField("a1", "int");
        assertTrue("Field a1 was created", e.containsField("a1"));
        assertEquals("List size is 1", 1, e.getFields().size());
        assertFalse("False when duplicating field", e.addField("a1", "int"));
    }

    /* test renameField */
    @Test
    public void testRenameField() {
        ClassObject e = new ClassObject("e");
        e.addField("a1", "int");
        e.addField("a2", "boolean");

        assertFalse("False when renaming non-existent field", e.renameField("fake", "a3"));

        assertTrue("Renamed a1 to a3", e.renameField("a1", "a3"));
        assertTrue("a3 field exists", e.containsField("a3"));

        assertFalse("a1 field no longer exists", e.containsField("a1"));
        assertEquals("List size still 2", 2, e.getFields().size());
        
        assertFalse("Renamed a1 to a a 1", e.renameField("a1", "a 1"));
    }
    
       /* test deleteField */
    @Test
    public void testDeleteField() {
        ClassObject e = new ClassObject("e");
        e.addField("a1", "int");
        e.addField("a2", "double");

        assertFalse("False when deleting non-existent field", e.deleteField("fake"));

        e.deleteField("a1");
        assertFalse("a1 field was deleted", e.containsField("a1"));
        assertEquals("List size is 1", 1, e.getFields().size());
        assertTrue("a2 field still exists", e.containsField("a2"));
    }

    /* test addMethod */
    @Test
    public void testaddMethod() {
        ClassObject e = new ClassObject("e");

        e.addMethod("a1", "int");
        assertTrue("Method a1 was created", e.containsMethod("a1"));
        assertEquals("List size is 1", 1, e.getMethods().size());
        assertFalse("False when duplicating method", e.addMethod("a1", "int"));
    }

    /* test renameMethod */
    @Test
    public void testRenameMethod() {
        ClassObject e = new ClassObject("e");
        e.addMethod("a1", "int");
        e.addMethod("a2", "String");
        assertFalse("False when renaming non-existent method", e.renameMethod("fake", "a3"));
        assertTrue("Renamed a1 to a3", e.renameMethod("a1", "a3"));
        assertTrue("a3 method exists", e.containsMethod("a3"));
        assertFalse("a1 method no longer exists", e.containsMethod("a1"));
        assertEquals("List size still 2", 2, e.getMethods().size());
        assertFalse("Renamed a1 to a a 1", e.renameMethod("a1", "a 1"));
    }
  
    /* test deleteMethod */
    @Test
    public void testDeleteMethod() {
        ClassObject e = new ClassObject("e");
        e.addMethod("a1", "int");
        e.addMethod("a2", "String");
        assertFalse("False when deleting non-existent method", e.deleteMethod("fake"));
        e.deleteMethod("a1");
        assertFalse("a1 method was deleted", e.containsMethod("a1"));
        assertEquals("List size is 1", 1, e.getMethods().size());
        assertTrue("a2 method still exists", e.containsMethod("a2"));
    }
    
    /* containsField */
    @Test
    public void testContainsField()
    {
        ClassObject e = new ClassObject("e");
        e.addField("a1", "int");
        assertFalse("False when searching non-existent field", e.containsField("fake"));
        assertTrue("a1 field found", e.containsField("a1"));
    }

    /* containsMethod */
    @Test
    public void testContainsMethod()
    {
        ClassObject e = new ClassObject("e");
        e.addMethod("a1", "int");
        assertFalse("False when searching non-existent method", e.containsMethod("fake"));
        assertTrue("a1 method found", e.containsMethod("a1"));
    }
}
