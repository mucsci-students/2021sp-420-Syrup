package edu.millersville.uml_editor.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.*;


public class UMLModel implements Model{
    private Map<String, ClassObject> classMap;
    private Map<String, Relationships> relMap;
    
    ///////////////////////////////////////////////////////////
    //
    //	Constructors
    //
    ///////////////////////////////////////////////////////////
    public UMLModel() {
		classMap = new HashMap<String, ClassObject>();
		relMap = new HashMap<String, Relationships>();
    }
    
    public UMLModel(UMLModel newModel) {
    	classMap = new HashMap<String, ClassObject>();
		relMap = new HashMap<String, Relationships>();
		
		for(String key : newModel.getClasses().keySet()) {
			classMap.put(key, newModel.getClassFor(key));
		}
		for(String key : newModel.getRelationships().keySet()) {
			relMap.put(key, newModel.getRelFor(key));
		}
    }
    
    public UMLModel(Map<String, ClassObject> newClassMap, Map<String, Relationships> newRelMap) {
    	classMap = newClassMap;
    	relMap = newRelMap;
    }
    
    ///////////////////////////////////////////////////////////
    //
    //	Copy/clear
    //
    ///////////////////////////////////////////////////////////
    
    public void clear() {
    	classMap.clear();
    	relMap.clear();
    }
    
    public UMLModel copy() {
    	return new UMLModel(classMap, relMap);
    }
    
    ///////////////////////////////////////////////////////////
    //
    //	Bool checks
    //
    ///////////////////////////////////////////////////////////

    public boolean hasClass(String className) {
        return classMap.containsKey(className);
    }
    
    public boolean hasMethod(String className, String methodName) {
    	Method methodObject = classMap.get(className).getMethod(methodName);
    	if (methodObject == null)
    		return false;
    	return true;
    }
    
    public boolean hasField(String className, String fieldName) {
    	Field FieldObject = classMap.get(className).getField(fieldName);
    	if (FieldObject == null)
    		return false;
    	return true;
    }
    
    public boolean hasRelID(String ID) {
    	return relMap.containsKey(ID);
    }
    
    /**
     * A method that checks to see if the parameter exists
     * @param className name of class the method is in
     * @param methodName name of method the parameter is in
     * @param paramName name of parameter
     * @return returns true if the parameter exists
     */
    public boolean hasParam(String className, String methodName, String paramName) {
    	if(classMap.containsKey(className) && this.hasMethod(className, methodName)) {
        	Method methodObject = classMap.get(className).getMethod(methodName);
        	return methodObject.containsParameter(paramName);
    	}
    	return false;
    }
    
    /**
     * A method that checks to see if the parameter's type is correct.
     * @param className the name of the class the method is in.
     * @param methodName the name of the method the parameter is in.
     * @param paramName the name of the parameter associated with the type to check.
     * @param paramType the type of the parameter.
     * @return returns a boolean value that returns true when the parameter's type matches.
     */
    public boolean hasParamType(String className, String methodName, String paramName, String paramType) {
    	if(classMap.containsKey(className) && this.hasMethod(className, methodName)) {
        	Method methodObject = classMap.get(className).getMethod(methodName);
        	return methodObject.checkParameterType(paramName, paramType);
    	}
    	return false;
    }
    
    public boolean isEmpty() {
    	return classMap.isEmpty();
    }

    ///////////////////////////////////////////////////////////
    //
    //	Getters
    //
    ///////////////////////////////////////////////////////////
    /**
     * A method that gets the class object specified by the class name.
     * @param className the name of the class
     * @return the value where className is mapped to.
     */
    public ClassObject getClassFor(String className) {
        return classMap.get(className);
    }
    
    public Relationships getRelFor(String relName) {
    	return relMap.get(relName);
    }
    
    public  Map<String, ClassObject> getClasses() {
        return classMap;
    }

    public Map<String, Relationships> getRelationships() {
        return relMap;
    }
    
    public String getMethodType(String className, String methodName) {
    	return classMap.get(className).getMethod(methodName).getType();
    }
    
    public String getFieldType(String className, String fieldName) {
    	return classMap.get(className).getField(fieldName).getType();
    }

    ///////////////////////////////////////////////////////////
    //
    //	createNewClass
    //
    ///////////////////////////////////////////////////////////
    public boolean createNewClassGUI(String className) 
    {
    	if(!classMap.containsKey(className)) {
    		classMap.put(className, new ClassObject(className));
    		return true;
    	}
    	return false;
    }
    
    ///////////////////////////////////////////////////////////
    //
    //	renameClass
    //
    ///////////////////////////////////////////////////////////
  
    public boolean renameClassGUI(String name, String newName)
    {
        //Rename class but putting into map with new name and removing the old name
    	if(!classMap.containsKey(newName)) {
    		getClasses().put(newName, getClassFor(name));
    		getClasses().remove(name);
    		return true;
    	}
    	return false;
    }

    ///////////////////////////////////////////////////////////
    //
    //	deleteClass
    //
    ///////////////////////////////////////////////////////////

    public boolean deleteClassGUI(String name)
    {
        //Deletes attributes and the deletes the class
        if(!classMap.containsKey(name)) {
        	return false;
        }
        getClasses().remove(name);
        return true;   
    }
    
    //////////////////////////////////////////////////////////
    //
    //	createRelationship
    //
    ///////////////////////////////////////////////////////////

    public boolean createRelationshipGUI(String class1, String class2, String ID, String newType)
    {
        //Create temp classes to be able to create relationship
    	if(!classMap.containsKey(class1) || !classMap.containsKey(class2) || hasRelID(ID)) {
    		return false;
    	}
        ClassObject source = getClassFor(class1);
        ClassObject destination = getClassFor(class2);
        getRelationships().put(ID, new Relationships(source, destination, ID, newType)); 
        return true;
    }

    //////////////////////////////////////////////////////////
    //
    //	deleteRelationship
    //
    ///////////////////////////////////////////////////////////

    public boolean deleteRelationshipGUI(String ID)
    {
    	if(!relMap.containsKey(ID)) {
    		return false;
    	}
        getRelationships().remove(ID); 
        return true;
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
	
	/**
     * A function that removes the parameter.
     * @param className
     *         The class the method is in.
     * @param methodName
     *         The method that the parameter is in.
     * @param paramName
     *         The parameter to delete.
     * @return
     *         Returns true when the parameter is deleted.
     */
    public void deleteAllParams(String className, String methodName) {
        classMap.get(className).deleteAllParams(methodName);
    }
    
	/**
	 * A method that saves this model into a JSON file.
	 * @param name the name of the file.
	 * @throws IOException
	 */
	
    ///////////////////////////////////////////////////////////
    //
    //	Save/Load
    //
    ///////////////////////////////////////////////////////////
	public void saveJSON(String name) throws IOException {
		UMLModel model = new UMLModel();
		model.classMap = classMap;
		model.relMap = relMap;
		ObjectMapper mapper = new ObjectMapper();
	  	
		ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
    	String fileText = writer.writeValueAsString(model);
    	String finalText = fileText.replace("\"empty\"", "");
    	String finalText2 = finalText.replace(": true,", "");
    	String finalText3 = finalText2.replace(": false,", "");
    	FileWriter file = new FileWriter(name);
    	file.write(finalText3);
		file.close();
	}
	
	/**
	 * A method that loads a JSON file into this object.
	 * @param filepath the name of the file
	 * @throws IOException
	 */
	
	public UMLModel loadJSON(String filepath) throws IOException{
		File jsonFile = new File(filepath);
		ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    	try {
    		classMap.clear();
    		String classFile = FileUtils.readFileToString(jsonFile, StandardCharsets.UTF_8);
    		UMLModel uml = objectMapper.readValue(classFile, UMLModel.class);
    		classMap = uml.getClasses();
    		relMap = uml.getRelationships();
    		return null;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    	
	}
	
		
	/**
	 * A method to check if a file has been created.
	 * @param file the name of the file to check.
	 * @return A boolean value true when the file exists.
	 */
	public boolean fileCheck(String file) {
		return new File(file).exists();
	}
}
