package edu.millersville.uml_editor;

import java.util.ArrayList;
/**
 * A method has a specific name, a type, and a list of parameters.
 *  
 * 
 * @author TeamSyrup
 *
 */
public class Method extends Formal {
	/**
	 * Parameters is an ArrayList of type Parameter(String, String).
	 */
	private ArrayList<Parameter> parameters;
	
	/**
	 * Initializes a method with a specific name and a type. 
	 * Takes the base from the Formal class. Also initializes 
	 * an empty new ArrayList of parameters. 
	 * @param name
	 * 		Name of the method.
	 * @param type
	 * 		Type of the method.
	 */
	public Method(String name, String type) {
		super(name, type);
		parameters = new ArrayList<Parameter>();
	}
	
	/**
	 * A helper method that adds a new parameter with a specific 
	 * name and type and returns true when it is added. Returns false
	 * if there is already a parameter or if there is nothing being added.
	 * @param name
 	 * 		Name of the new parameter.
	 * @param type
	 * 		Type of the new parameter.
	 * @return
	 * 		True when the new parameter is added or false when the 
	 * 		parameter is not added.
	 */
	public boolean addParameter(String name, String type) {
		// check if the parameter already exists
		if(!containsParameter(name)) {
			return false;
		}
		return parameters.add(new Parameter(name, type));
	}
	
	/**
	 * A method that removes the parameter from the ArrayList
	 * using the specified name of the parameter.
	 * @param name
	 * 		The name of the parameter to remove.
	 * @return
	 * 		True when there is a parameter with the specified name
	 */
	public boolean deleteParameter(String name) {
		for(Parameter param : parameters) {
			if(param.getName().equals(name)) {
				parameters.remove(param);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * A method to delete the whole ArrayList of parameters.
	 */
	public void deleteAllParameters() {
		parameters.clear();
	}
	
	/**
	 * A method to replace this method's parameter list with a different parameter list.
	 * @param newList
	 * 		The new parameter list.
	 */
	public void replaceParameterList(ArrayList<Parameter> newList) {
		parameters = newList;
	}
	
	/**
	 * A helper function that changes the parameter type of the given parameter.
	 * Parameters can be of the same type.
	 * @param name
	 * 		The name of the parameter.
	 * @param newType
	 * 		The new type of the parameter.
	 * @return
	 * 		True if the parameter's new type is not nothing and if
	 * 		the parameter's type is changed.
	 */
	public boolean changeParameterType(String name, String newType) {
		// look for the parameter and change the type
		for(Parameter param : parameters) {
			if(param.getName().equals(name)) {
				param.setType(newType);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Helper method that returns true if a parameter already exists. 
	 * If the parameter list exists for the method, then so does the method. 
	 * @param name
	 * 		The name of the parameter to search for.
	 * @return
	 * 		A boolean value true if the parameter already exits, or false 
	 * 		if the parameter does not exist.
	 */
	public boolean containsParameter(String name) {
		for(Parameter param : parameters) {
			if(param.getName().equals(name)) {
			return true;
			}
		}
		return false;
	}
	
	/**
	 * Accessor method to get a reference to the ArrayList of parameters
	 * @return
	 * 		A reference to the ArrayList of parameters.
	 */
	public ArrayList<Parameter> getParameters(){
		return parameters;
	}
}
