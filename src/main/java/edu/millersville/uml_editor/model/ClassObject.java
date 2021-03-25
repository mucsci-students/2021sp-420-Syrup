package edu.millersville.uml_editor.model;

import java.util.*;

/**
 * A class that creates a class object. The class object holds fields and methods.
 * This class has functions to modify fields, methods, and parameters.
 * 
 * @author TeamSyrup
 *
 */
public class ClassObject {
		
	private String className;
	private ArrayList<Field> fields;
	private ArrayList<Method> methods;
	
	/**
	 * Initializes the class object with a name.
	 * Fields and methods are automatically initialized since they 
	 * are a part of a class object.
	 * @param name
	 * 		The name of the class.
	 */
	public ClassObject(String name) {
		this.className = name;
		fields = new ArrayList<Field>();
		methods = new ArrayList<Method>();
		
	}
	
	
	/**
	 * Getter method to return the name of the class.
	 * @return
	 * 		The name of the class.
	 */
	public String getName() {
		return className;		
	}
	
	/**
	 * Mutator method that changes the name of the class.
	 * @param newName
	 * 		The new name of the class.
	 */
	public void setName(String newName) {
		this.className = newName;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	// Field Functions
	///////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A method to find an instance of a Field object
	 * that has the same name since Fields cannot have 
	 * the same names.
	 * @param name
	 * 		The name to search for.
	 * @return
	 * 		Returns true when there is not another instance
	 * 		of the object with the name "name".
	 */
	public boolean containsField(String name) {
		for(Field field : fields) {
			if(field.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Getter method that gets the ArrayList of fields.
	 * @return
	 * 		Returns fields.
	 */
	public ArrayList<Field> getFields(){
		return fields;
	}
	
	/**
	 * A method that adds a new field.
	 * @param name
	 * 		The name of the new field.
	 * @param type
	 * 		The type of the new field.
	 * @return
	 * 		Returns true when a new field is added.
	 */
	public boolean addField(String name, String type) {
		if(containsField(name)) {
			return false;
		}
		return fields.add(new Field(name, type));
	}

	/**
	 * A method that renames the specified field.
	 * @param original
	 * 		The name of the field to change.
	 * @param newName
	 * 		The new name of the field.
	 * @return
	 * 		Returns true when the field's name is changed.
	 */
	public boolean renameField(String original, String newName) {
		if(!containsField(original) && containsMethod(newName)) {
			return false;
		}
		for(Field field : fields) {
			if(field.getName().equals(original)) {
				field.setName(newName);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A method that changes the type of the specified field.
	 * @param name
	 * 		The field to search for.
	 * @param newType
	 * 		The new type to set the field to. 
	 * @return
	 * 		Returns true when the field's type is changed.
	 */
	public boolean changeFieldType(String name, String newType) {
		for(Field field : fields) {
			if(field.getName().equals(name)) {
				field.setType(newType);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A method that removes a field from the list.
	 * @param name
	 * 		The name of the field to delete.
	 * @return
	 * 		Returns true when the field is deleted.
	 */
	public boolean deleteField(String name) {
		if(!containsField(name)) {
			return false;
		}
		for(Field field : fields) {
			if(field.getName().equals(name)) {
				return fields.remove(field);
			}
		}
		return false;
	}
	
	/**
	 * A method that removes all the fields from the list.
	 * @param name
	 * 		The name of the field to delete.
	 * @return
	 * 		Returns true when the field is deleted.
	 */
	public boolean deleteFields() {
		if(fields.isEmpty()) {
			return false;
		}
		
		for(Field field : fields) {
			fields.remove(field);
		}
		return true;
	}
	
	////////////////////////////////////////////////////////////////////////////
	// Method Functions
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A function that finds a method.
	 * @param name
	 * 		The name of the method.
	 * @return
	 * 		Returns true when the method is found.
	 */
	public boolean containsMethod(String name) {
		for(Method method : methods) {
			if(method.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A getter function that gets the methods list.
	 * @return
	 * 		Returns methods.
	 */
	public ArrayList<Method> getMethods() {
		return methods;
	}
	
	/**
	 * A function that adds a method.
	 * @param name
	 * 		The name of the new method.
	 * @param type
	 * 		The type of the method.
	 * @return
	 * 		returns true when the new method is added.
	 */
	public boolean addMethod(String name, String type) {
		if(containsMethod(name)) {
			return false;
		}
		return methods.add(new Method(name, type));
	}
	
	/**
	 * A function that changes the name of an existing method.
	 * @param name
	 * 		The original name of the method.
	 * @param newName
	 * 		The new name of the method.
	 * @return
	 * 		Returns when the name is changed.
	 */
	public boolean renameMethod(String name, String newName) {
		if(!containsMethod(name) && containsMethod(newName)) {
			return false;
		}
		for(Method method : methods) {
			if(method.getName().equals(name)) {
				method.setName(newName);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A function that changes the type of a method.
	 * @param name
	 * 		The name of the method.
	 * @param type
	 * 		The new type of the method.
	 * @return
	 * 		Returns true when the type of the method has changed.
	 */
	public boolean changeMethodType(String name, String type) {
		for(Method method : methods) {
			if(method.getName().equals(name)) {
				method.setType(type);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A function that deletes a method.
	 * @param name
	 * 		The name of the method to delete.
	 * @return
	 * 		Returns true when the method has been deleted.
	 */
	public boolean deleteMethod(String name) {
		for(Method method : methods) {
			if(method.getName().equals(name)) {
				return methods.remove(method);
			}
		}
		return false;	
	}
	
	/**
	 * A method that removes all the methods from the list.
	 * @param name
	 * 		The name of the field to delete.
	 * @return
	 * 		Returns true when the methods are deleted.
	 */
	public boolean deleteMethods() {
		if(methods.isEmpty()) {
			return false;
		}
		
		for(Method method : methods) {
			methods.remove(method);
		}
		return true;
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	// Parameter Functions
	////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A function that adds a parameter to a method.
	 * @param methodName
	 * 		The name of the method.
	 * @param paramName
	 * 		The name of the parameter.
	 * @param type
	 * 		The type of the parameter.
	 * @return
	 * 		Returns true when the new parameter has been added. 
	 */
	public boolean addParameter(String methodName, String paramName, String type) {
		// finds the method then adds the parameter to the list of parameters.
		for(Method method : methods) {
			if(method.getName().equals(methodName)) {
				return method.addParameter(paramName, type);
			}
		}
		return false;
	}
	
	/**
	 * A function that renames a parameter in a specified method.
	 * @param methodName
	 * 		The name of the method to look for.
	 * @param originalName
	 * 		The name of the parameter.
	 * @param newName
	 * 		The new name of the parameter.
	 * @return
	 * 		Returns true when the parameter's name has been changed.
	 */
	public boolean renameParameter(String methodName, String originalName, String newName) {
		for(Method method : methods) {
			if(method.getName().equals(methodName)) {
				return method.renameParameter(originalName, newName);
			}
		}
		return false;
	}
	
	/**
	 * A function that changes the type of the parameter in a specified method.
	 * @param methodName
	 * 		The name of the method.
	 * @param paramName
	 * 		The name of the parameter.
	 * @param newType
	 * 		The new type of the parameter.
	 * @return
	 * 		Returns true when the parameter's type has been changed.
	 */
	public boolean changeParameterType(String methodName, String paramName, String newType) {
		for(Method method : methods) {
			if(method.getName().equals(methodName)) {
				return method.changeParameterType(paramName, newType);
			}
		}
		return false;
	}
	
	public boolean replaceParameterList(String methodName, ArrayList<Parameter> newParamList) {
		for(Method method : methods) {
			if(method.getName().equals(methodName)) {
				method.replaceParameterList(newParamList);
			}
		}
		return true;
	}
	
	/**
	 * A function that deletes a parameter from a specified method.
	 * @param methodName
	 * 		The name of the method.
	 * @param paramName
	 * 		The name of the parameter.
	 * @return
	 * 		Returns true when the parameter has been deleted.
	 */
	public boolean deleteParameter(String methodName, String paramName) {
		for(Method method : methods) {
			if(method.getName().equals(methodName)) {
				return method.deleteParameter(paramName);
			}
		}
		return false;
	}
	
	public String printMethods() {
		return " Methods:  " + methods;
	}
	
	public String printFields() {
		return " Fields:  " + fields;
	}
	
	
	public String toString() {
		
		return printFields() + printMethods();
	}
	
	public Method getMethod(String name)
	{
		for(Method method : methods) {
			if(method.getName().equals(name)) {
				return method;
			}
		}
		return null;
	}
	
	public Field getField(String name)
	{
		for(Field field : fields) {
			if(field.getName().equals(name)) {
				return field;
			}
		}
		return null;
	}
	
	public void deleteAllParams(String methodName) {
        for(Method method : methods) {
            if(method.getName().equals(methodName)) {
                method.deleteAllParameters();
                return;
            }
        }
    }
}
