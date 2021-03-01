package edu.millersville.uml_editor.model;

import java.util.HashMap;
import java.util.Map;

import edu.millersville.uml_editor.model.*;
 

public class UMLModel {
    private Map<String, ClassObject> classMap;
    private Map<String, Relationships> relMap;
    
    public UMLModel() {
		classMap = new HashMap<String, ClassObject>();
		relMap = new HashMap<String, Relationships>();
    }

    public  Map<String, ClassObject> getClasses() {
        return classMap;
    }

    public Map<String, Relationships> getRelationships() {
        return relMap;
    }

    public boolean hasClass(String className) {
        return classMap.containsKey(className);
    }

    public ClassObject getClassFor(String className) {
        return classMap.get(className);
    }
    
    public boolean hasRelID(String ID) {
    	return relMap.containsKey(ID);
    }

    ///////////////////////////////////////////////////////////
    //
    //	createNewClass
    //
    ///////////////////////////////////////////////////////////
    public void createNewClassGUI(String className) 
    {
        
    	getClasses().put(className, new ClassObject(className));
	    
    }
    
    ///////////////////////////////////////////////////////////
    //
    //	renameClass
    //
    ///////////////////////////////////////////////////////////
  
    public void renameClassGUI(String name, String newName)
    {
        //Rename class but putting into map with new name and removing the old name
        getClasses().put(newName, getClassFor(name));
        getClasses().remove(name);
    }

    ///////////////////////////////////////////////////////////
    //
    //	deleteClass
    //
    ///////////////////////////////////////////////////////////

    public void deleteClassGUI(String name)
    {
        //Deletes attributes and the deletes the class
        //getClassFor(name).deleteAttributes();
        getClasses().remove(name);
        
    }
    
    //////////////////////////////////////////////////////////
    //
    //	createRelationship
    //
    ///////////////////////////////////////////////////////////

    public void createRelationshipGUI(String class1, String class2, String ID, String newType)
    {
        //Create temp classes to be able to create relationship
        ClassObject source = getClassFor(class1);
        ClassObject destination = getClassFor(class2);
        getRelationships().put(ID, new Relationships(source, destination, ID, newType)); 
    }

    //////////////////////////////////////////////////////////
    //
    //	deleteRelationship
    //
    ///////////////////////////////////////////////////////////

    public void deleteRelationshipGUI(String ID)
    {
        getRelationships().remove(ID); 
    }

    //////////////////////////////////////////////////////////
    //
    //	changeRelationshipType
    //
    ///////////////////////////////////////////////////////////

    public void changeRelationshipTypeGUI(String ID, String newType)
    {
        getRelationships().get(ID).changeType(newType);
    }
}
