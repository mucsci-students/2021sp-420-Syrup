package edu.millersville.uml_editor;

import java.util.HashMap;
import java.util.Map;
 

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
    public void createNewClass(String className) 
    {
        //Checks if the class already exists
    	if (hasClass(className))
    	{
    		System.out.println("There is already a class with that name.");
    		return;
    	}
    	getClasses().put(className, new ClassObject(className));
	    
	    System.out.println();
        System.out.print("The class has been added!");
        System.out.println();
    }
    
    ///////////////////////////////////////////////////////////
    //
    //	renameClass
    //
    ///////////////////////////////////////////////////////////
  
    public void renameClass(String name, String newName)
    {
        //Checks if class exists, doesn't exists or if the name is a duplicate
        if (hasClass(newName))
        {
            System.out.println("There is a class with the new name.");
            return;
        }
        if(!hasClass(name))
        {
        System.out.println("There is not an existing class with the name: " + name + ".");
            return; 
        }
        //Rename class but putting into map with new name and removing the old name
        getClasses().put(newName, getClassFor(name));
        getClasses().remove(name);
        
        System.out.println();
        System.out.print("The class has been renamed!");
        System.out.println();
    }

    ///////////////////////////////////////////////////////////
    //
    //	deleteClass
    //
    ///////////////////////////////////////////////////////////

    public void deleteClass(String name)
    {
        //Checks if class exists
        if (!hasClass(name))
        {
            System.out.println("There is not a class with that name.");
            return;
        }
        //Deletes attributes and the deletes the class
        getClassFor(name).deleteAttributes();
        getClasses().remove(name);
        
        System.out.println();
        System.out.print("The class has been deleted!");
        System.out.println();
    }
    
    //////////////////////////////////////////////////////////
    //
    //	createRelationship
    //
    ///////////////////////////////////////////////////////////

    public void createRelationship(String class1, String class2, String ID, String newType)
    {
        //Checks to make sure the relationship is not already created
        if(getRelationships().containsKey(ID))
        {
            System.out.println();
            System.out.println("This relationship already exists");
            return;
        }
        //Create temp classes to be able to create relationship
        ClassObject source = getClassFor(class1);
        ClassObject destination = getClassFor(class2);
        getRelationships().put(ID, new Relationships(source, destination, ID, newType)); 
        
        System.out.println();
        System.out.print("The relationship has been added!");
        System.out.println();
    }

    //////////////////////////////////////////////////////////
    //
    //	deleteRelationship
    //
    ///////////////////////////////////////////////////////////

    public void deleteRelationship(String ID)
    {
        //Checks to see if relationship exists
        if (!getRelationships().containsKey(ID))
        {
            System.out.println("There is not a relationship with that ID.");
            return;
        }
        getRelationships().remove(ID); 
        
        System.out.println();
        System.out.print("The relationship has been deleted!");
        System.out.println();
    }

    //////////////////////////////////////////////////////////
    //
    //	changeRelationshipType
    //
    ///////////////////////////////////////////////////////////

    public void changeRelationshipType(String ID, String newType)
    {
        if(newType.equals(getRelationships().get(ID).relType()))
        {
            System.out.println();
            System.out.println("There is already the type of the relationship.");
            return;
        }
        getRelationships().get(ID).changeType(newType);

        System.out.println();
        System.out.print("The relationship type has been changed!");
        System.out.println();
    }
    
    

}
