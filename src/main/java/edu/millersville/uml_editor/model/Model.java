package edu.millersville.uml_editor.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface Model {

    
    void clear();
    

    Map<String, ClassObject> getClasses();

    Map<String, Relationships> getRelationships();

    boolean hasClass(String className);
    
    boolean hasMethod(String className, String methodName);
    
    boolean hasField(String className, String fieldName);

    ClassObject getClassFor(String className);
    
    boolean hasRelID(String ID);

    ///////////////////////////////////////////////////////////
    //
    //	createNewClass
    //
    ///////////////////////////////////////////////////////////
    boolean createNewClassGUI(String className);
    
    ///////////////////////////////////////////////////////////
    //
    //	renameClass
    //
    ///////////////////////////////////////////////////////////
  
    boolean renameClassGUI(String name, String newName);

    ///////////////////////////////////////////////////////////
    //
    //	deleteClass
    //
    ///////////////////////////////////////////////////////////

    boolean deleteClassGUI(String name);
    
    //////////////////////////////////////////////////////////
    //
    //	createRelationship
    //
    ///////////////////////////////////////////////////////////

    boolean createRelationshipGUI(String class1, String class2, String ID, String newType);

    //////////////////////////////////////////////////////////
    //
    //	deleteRelationship
    //
    ///////////////////////////////////////////////////////////

    boolean deleteRelationshipGUI(String ID);

    //////////////////////////////////////////////////////////
    //
    //	changeRelationshipType
    //
    ///////////////////////////////////////////////////////////

   void changeRelationshipTypeGUI(String ID, String newType);
    
    
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
    boolean addMethod(String className, String methodName, String methodType);

    /**
     * A function that removes a method from a class.
     * @param className
     * 		The name of the class the method is in.
     * @param methodName
     * 		The name of the method.
     * @return
     * 		Returns true when the method has been removed.
     */
    boolean deleteMethod(String className, String methodName);

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
    boolean renameMethod(String className, String originalName, String newName);

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
    boolean changeMethodType(String className, String methodName, String newType);
    
    
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
	boolean addField(String className, String fieldName, String fieldType);
	
	/**
	 * A function that removes a field.
	 * @param className
	 * 		The name of the class the field is in.
	 * @param fieldName
	 * 		The name of the field to remove.
	 * @return
	 * 		Returns true when the field has been removed.
	 */
	boolean deleteField(String className, String fieldName);
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
	boolean renameField(String classname, String fieldName, String newName);
	
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
	boolean changeFieldType(String className, String fieldName, String newType);
	
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
	boolean addParameter(String className, String methodName, String paramName, String paramType);
	
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
	boolean deleteParameter(String className, String methodName, String paramName);
	
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
	boolean renameParameter(String className, String methodName, String originalParam, String newParam);
	
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
	boolean changeParameterType(String className, String methodName, String param, String newtype);
	
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
	boolean changeParameterList(String className, String methodName, ArrayList<Parameter> newParamList);
	
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
    void deleteAllParams(String className, String methodName);
    
	///////////////////////////////////////////////////////////
	//
	//	saveJSON(String, Map<String, Class>)
	//
	//	function that creates and saves classMap to a JSON file using 
	//		a prompted file name and the classMap.
	//
	///////////////////////////////////////////////////////////
	
	void saveJSON(String name) throws IOException;
	
	///////////////////////////////////////////////////////////
	//
	//loadJSON(String, Map<String, Class>)
	//
	//function that loads a JSON file using 
	//a prompted filepath.
	//
	///////////////////////////////////////////////////////////
	
	void loadJSON(String filepath) throws IOException;
}
