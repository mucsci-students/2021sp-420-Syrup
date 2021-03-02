package edu.millersville.uml_editor.model;

/**
 * Class that creates a parameter object that has a name and a type value
 * 
 * @author TeamSyrup
 *
 */
public class Parameter extends Formal {

	/**
	 * Initializes the parameter with a given name and type.
	 * @param name
	 * 		The name of the parameter.
	 * @param type
	 * 		The type of the parameter.
	 */
	public Parameter(String name, String type) {
		super(name, type);
	}
	
	/**
	 * A method that returns a string of the name and type of the parameter.
	 */
	public String toString() {
		return getName() + " " + getType();
	}
}
