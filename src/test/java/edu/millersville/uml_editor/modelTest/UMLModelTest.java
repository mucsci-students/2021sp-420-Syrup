package edu.millersville.uml_editor.modelTest;

import edu.millersville.uml_editor.model.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class UMLModelTest {

	/**
	 * Test all constructors
	 */
	@Test
	public void UMLModelConstructorsTest() {
		// first constructor
		UMLModel model1 = new UMLModel();
		assertTrue("Classes were initialized", model1.getClasses().isEmpty());
        assertTrue("Relationships were initialized", model1.getRelationships().isEmpty());
		
		// second constructor
		Map<String, ClassObject> classMap = new HashMap<String, ClassObject>();
		Map<String, Relationships> relMap = new HashMap<String, Relationships>();
		UMLModel model2 = new UMLModel(classMap, relMap);
        assertEquals("classMap was set properly", model2.getClasses(), classMap);
        assertEquals("relMap was set properly", model2.getRelationships(), relMap);
        		
		// third constructor
		UMLModel model3 = new UMLModel(model2);
        assertEquals("model3 classMap was set properly", model3.getClasses(), model2.getClasses());
        assertEquals("model3 relMap was set properly", model3.getRelationships(), model2.getRelationships());
     }
	
	/**
	 * Test to add a class
	 */
	@Test
	public void addClassTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		assertFalse("classMap is not empty", model.getClasses().isEmpty());
        assertEquals("class1 is in classMap", true, model.hasClass("class1"));
	}
	
	/**
	 * Test to rename a class
	 */
	@Test
	public void renameClassTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.renameClassGUI("class1", "newName1");
		assertFalse("classMap is not empty", model.getClasses().isEmpty());
        assertEquals("newName1 is in classMap", true, model.hasClass("newName1"));
        assertEquals("class1 is not in classMap", false, model.hasClass("class1"));
	}
	
	/**
	 * Test to delete a class
	 */
	@Test
	public void deleteClassTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.deleteClassGUI("class1");
		assertTrue("classMap is empty", model.getClasses().isEmpty());
        assertEquals("class1 is not in classMap", false, model.hasClass("class1"));
	}
	
	/**
	 * Test adding a relationship
	 */
	@Test
	public void addRelationshipsTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.createNewClassGUI("class2");
		model.createRelationshipGUI("class1", "class2", "ID1", "Aggregation");
		assertFalse("relMap is empty", model.getRelationships().isEmpty());
        assertEquals("relationship with ID: ID1 is in classMap", true, model.hasRelID("ID1"));
	}
	
	/**
	 * Test deleting a relationship
	 */
	@Test
	public void deleteRelationshipTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.createNewClassGUI("class2");
		model.createRelationshipGUI("class1", "class2", "ID1", "Aggregation");
		model.deleteRelationshipGUI("ID1");
		assertTrue("relMap is empty", model.getRelationships().isEmpty());
        assertEquals("relationship with ID: ID1 is not in classMap", false, model.hasRelID("ID1"));
	}
	
	/**
	 * Test changing relationship type 
	 */
	@Test
	public void changeRelationshipTypeTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.createNewClassGUI("class2");
		model.createRelationshipGUI("class1", "class2", "ID1", "Aggregation");
		model.changeRelationshipTypeGUI("ID1", "Composition");
		assertFalse("relMap is empty", model.getRelationships().isEmpty());
	}
	
	/**
	 * Test adding a method
	 */
	@Test
	public void addMethodTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		assertTrue("method1 exists in class1", model.hasMethod("class1", "method1"));
	}
	
	/**
	 * Test to rename a method
	 */
	@Test
	public void renameMethodTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.renameMethod("class1", "method1", "newMethod1");
		assertTrue("newMethod1 exists in class1", model.hasMethod("class1", "newMethod1"));
	}
	
	/**
	 * Test delete method
	 */
	@Test
	public void deleteMethodTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.deleteMethod("class1", "method1");
        assertEquals("method1 in class1 does not exists", false, model.hasMethod("class1", "method1"));
	}
	
	/**
	 * Test changing method type
	 */
	@Test
	public void changeMethodTypeTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.changeMethodType("class1", "method1", "String");
        assertEquals("method1's type changed to String", "String", model.getMethodType("class1", "method1"));
	}
	
	/**
	 * Test adding a field
	 */
	@Test
	public void addFieldTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addField("class1", "field1", "int");
		assertTrue("field1 exists in class1", model.hasField("class1", "field1"));
	}
	
	/**
	 * Test renaming a field
	 */
	@Test
	public void renameFieldTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addField("class1", "field1", "int");
		model.renameField("class1", "field1", "newField1");
		assertTrue("newField1 exists in class1", model.hasField("class1", "newField1"));
	}
	
	/**
	 * Test delete a field
	 */
	@Test
	public void deleteFieldTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addField("class1", "field1", "int");
		model.deleteField("class1", "field1");
		assertFalse("field1 does not exists in class1", model.hasField("class1", "field1"));
	}
	
	/**
	 * Test change field type
	 */
	@Test
	public void changeFieldTypeTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addField("class1", "field1", "int");
		model.changeFieldType("class1", "field1", "String");
        assertEquals("field1's type changed to String", "String", model.getFieldType("class1", "field1"));
	}
	
	/**
	 * Test add parameter
	 */
	@Test
	public void addParameterTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.addParameter("class1", "method1", "param1", "int");
		assertTrue("param1 exists in method1 in class1", model.hasParam("class1", "method1", "param1"));
	}
	
	/**
	 * Test delete a parameter
	 */
	@Test
	public void deleteParameterTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.addParameter("class1", "method1", "param1", "int");
		model.deleteParameter("class1", "method1", "param1");
		assertFalse("param1 does not exists in method1 in class1", model.hasParam("class1", "method1", "param1"));
	}
	
	/**
	 * Test renaming a parameter
	 */
	@Test
	public void renameParameterTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.addParameter("class1", "method1", "param1", "int");
		model.renameParameter("class1", "method1", "param1", "newParam1");
		assertTrue("newParam1 exists in method1 in class1", model.hasParam("class1", "method1", "newParam1"));
	}
	
	/**
	 * Test changing a parameter type
	 */
	@Test
	public void changeParameterTypeTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.addParameter("class1", "method1", "param1", "int");
		model.changeParameterType("class1", "method1", "param1", "String");
		assertTrue("param1's type is type String", model.hasParamType("class1", "method1", "param1", "String"));
	}
	
	/**
	 * Test change parameter list
	 */
	@Test
	public void changeParameterListTest() {
		UMLModel model = new UMLModel();
		ArrayList<Parameter> paramList = new ArrayList<Parameter>();
		paramList.add(new Parameter("param1", "int"));
		paramList.add(new Parameter("param2", "int"));
		paramList.add(new Parameter("param3", "int"));
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.addParameter("class1", "method1", "oldParam", "int");
		model.changeParameterList("class1", "method1", paramList);
		assertTrue("param1 exists in method1 in class1", model.hasParam("class1", "method1", "param1"));
		assertTrue("param1 exists in method1 in class1", model.hasParam("class1", "method1", "param2"));
		assertTrue("param1 exists in method1 in class1", model.hasParam("class1", "method1", "param3"));
	}
	
	/**
	 * Test delete parameter list
	 */
	@Test
	public void deleteParamListTest() {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.addMethod("class1", "method1", "int");
		model.addParameter("class1", "method1", "param1", "int");
		model.addParameter("class1", "method1", "param2", "int");
		model.addParameter("class1", "method1", "param3", "int");
		model.deleteAllParams("class1", "method1");
		assertFalse("param1 does not exists in method1 in class1", model.hasParam("class1", "method1", "param1"));
		assertFalse("param2 does not exists in method1 in class1", model.hasParam("class1", "method1", "param2"));
		assertFalse("param3 does not exists in method1 in class1", model.hasParam("class1", "method1", "param3"));
	}
	
	/**
	 * Test saving model to a json file.
	 * @throws IOException
	 */
	@Test
	public void saveJSONTest() throws IOException {
		UMLModel model = new UMLModel();
		model.saveJSON("umlexample");
		assertTrue("umlexample.json exists", model.fileCheck("umlexample.json"));
	}
	
	/**
	 * Test loading a json file
	 * @throws IOException
	 */
	@Test
	public void loadJSONTest() throws IOException {
		UMLModel model = new UMLModel();
		model.createNewClassGUI("class1");
		model.saveJSON("umlexample");
		
		model.createNewClassGUI("class2");
		model.loadJSON("umlexample");
		assertTrue("class1 exists from loaded json file", model.hasClass("class1"));
		assertFalse("class2 should not exist in the model", model.hasClass("class2"));
	}
}
