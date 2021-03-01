package edu.millersville.uml_editor.model;

import java.util.ArrayList;
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
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    // Method Functions
    /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A function that adds a method to a specific class.
     * @param className
     * 		The name of the class where the method will be added to.
     * @param methodName
     * 		The name of the method.
     * @param methodType
     * 		The type of the method.
     * @return
     * 		Returns true when the method is added to the correct class.
     */
    public boolean addMethod(String className, String methodName, String methodType) {
    	// search classes to see if className exists
    	if(!classMap.containsKey(className)) {
    		return false;
    	}
    	return classMap.get(className).addMethod(methodName, methodType);
    }

    /**
     * A function that removes a method from a class.
     * @param className
     * 		The name of the class the method is in.
     * @param methodName
     * 		The name of the method.
     * @return
     * 		Returns true when the method has been removed.
     */
    public boolean deleteMethod(String className, String methodName) {
    	if(!classMap.containsKey(className)) {
    		return false;
    	}
    	return classMap.get(className).deleteMethod(methodName);
    }

    /**
     * A function that renames a specific method in a specific class.
     * @param className
     * 		The name of the class the method is in.
     * @param originalName
     * 		The name of the method.
     * @param newName
     * 		The new name of the method.
     * @return
     * 		Returns true when the method has been renamed.
     */
    public boolean renameMethod(String className, String originalName, String newName) {
    	if(!classMap.containsKey(className)) {
    		return false;
    	}
    	return classMap.get(className).renameMethod(originalName, newName);
    }

    /**
     * A function that changes the method's type.
     * @param className
     * 		The name of the class the method is in.
     * @param methodName
     * 		The name of the method.
     * @param newType
     * 		The new type the method is.
     * @return
     * 		Returns true when the method's type has been changed.
     */
    public boolean changeMethodType(String className, String methodName, String newType) {
    	if(!classMap.containsKey(className)) {
    		return false;
    	}
    	return classMap.get(className).changeMethodType(methodName, newType);
    }
    
    
	////////////////////////////////////////////////////////////////////////////////////////////
	// Field Functions
	////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A function that adds a field to a class.
	 * @param className
	 * 		The name of the class.
	 * @param fieldName
	 * 		The name of the field.
	 * @param fieldType
	 * 		The type of the field.
	 * @return
	 * 		Returns true when the field has been added.
	 */
	public boolean addField(String className, String fieldName, String fieldType) {
		if(!classMap.containsKey(className)) {
			return false;
		}
		return classMap.get(className).addField(fieldName, fieldType);
	}
	
	/**
	 * A function that removes a field.
	 * @param className
	 * 		The name of the class the field is in.
	 * @param fieldName
	 * 		The name of the field to remove.
	 * @return
	 * 		Returns true when the field has been removed.
	 */
	public boolean deleteField(String className, String fieldName) {
		if(!classMap.containsKey(className)) {
			return false;
		}
		return classMap.get(className).deleteField(fieldName);
	}
	
	/**
	 * A function that gives a field a new name.
	 * @param classname
	 * 		The name of the class.
	 * @param fieldName
	 * 		The old name of the field.
	 * @param newName
	 * 		The new name of the field.
	 * @return
	 * 		Returns true when the field has been renamed.
	 */
	public boolean renameField(String classname, String fieldName, String newName) {
		if(!classMap.containsKey(classname)) {
			return false;
		}
		return classMap.get(classname).renameField(fieldName, newName);
	}
	
	/**
	 * A function that changes the type of a field.
	 * @param className
	 * 		The name of the class.
	 * @param fieldName
	 * 		The name of the field.
	 * @param newType
	 * 		The new type of the field.
	 * @return
	 * 		Returns true when the field's type has been changed.
	 */
	public boolean changeFieldType(String className, String fieldName, String newType) {
		if(!classMap.containsKey(className)) {
			return false;
		}
		return classMap.get(className).changeFieldType(fieldName, newType);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	// Parameter Functions
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A function that adds a parameter to a method in a class.
	 * @param className
	 * 		The name of the class the method is in.
	 * @param methodName
	 * 		The method to add the parameter to.
	 * @param paramName
	 * 		The name of the parameter.
	 * @param paramType
	 * 		The type of the parameter.
	 * @return
	 * 		Returns true when the parameter has been added.
	 */
	public boolean addParameter(String className, String methodName, String paramName, String paramType) {
		if(!classMap.containsKey(className)) {
			return false;
		}
		return classMap.get(className).addParameter(methodName, paramName, paramType);
	}
	
	/**
	 * A function that removes the parameter.
	 * @param className
	 * 		The class the method is in.
	 * @param methodName
	 * 		The method that the parameter is in.
	 * @param paramName
	 * 		The parameter to delete.
	 * @return
	 * 		Returns true when the parameter is deleted.
	 */
	public boolean deleteParameter(String className, String methodName, String paramName) {
		if(!classMap.containsKey(className)) {
			return false;
		}
		return classMap.get(className).deleteParameter(methodName, paramName);
	}
	
	/**
	 * A function that renames a parameter.
	 * @param className
	 * 		The name of the class that stores the method.
	 * @param methodName
	 * 		The name of the method that holds the parameter.
	 * @param originalParam
	 * 		The old name of the parameter.
	 * @param newParam
	 * 		The new name of the parameter.
	 * @return
	 * 		Returns true when the parameter's name has changed.
	 */
	public boolean renameParameter(String className, String methodName, String originalParam, String newParam) {
		if(!classMap.containsKey(className)) {
			return false;
		}
		return classMap.get(className).renameParameter(methodName, originalParam, newParam);
	}
	
	/**
	 * A function that changes the parameter type.
	 * @param className
	 * 		The name of the class that the method is in.
	 * @param methodName
	 * 		The name of the method that holds the parameter.
	 * @param param
	 * 		The name of the parameter whose type to change.
	 * @param newtype
	 * 		The new type of the parameter.
	 * @return
	 * 		Returns true when the parameter's type has been changed.
	 */
	public boolean changeParameterType(String className, String methodName, String param, String newtype) {
		if(!classMap.containsKey(className)) {
			return false;
		}
		return classMap.get(className).changeParameterType(methodName, param, newtype);
	}
	
	/**
	 * A function that changes the parameter list of a method.
	 * @param className
	 * 		The name of the class that holds the method.
	 * @param methodName
	 * 		The name of the method that holds the parameter list.
	 * @param newParamList
	 * 		The new parameter list.
	 * @return
	 * 		Returns true when the parameter's list has been changed.
	 */
	public boolean changeParameterList(String className, String methodName, ArrayList<Parameter> newParamList) {
		if(!classMap.containsKey(className)) {
			return false;
		}
		return classMap.get(className).replaceParameterList(methodName, newParamList);
	}
}
