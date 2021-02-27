package edu.millersville.uml_editor.model;

import java.util.*;
import edu.millersville.uml_editor.model.Relationships.RelType;

/**
 * A model that represents a UML diagram. This model brings together all of the other
 * models. Model initializes a hashmap of classes with its parameters being the name 
 * of the class, and the attributes of the class which is implemented by fields and methods.
 * Model also initializes relationships by creating an arraylist of relationships
 * that have type RelType. RelType can be of type AGGREGATION, COMPOSITION, INHERITANCE, and 
 * REALIZATION. 
 * 
 * @author TeamSyrup
 *
 */
public class Model {
	private HashMap<String, ClassObject> classes;
	private ArrayList<Relationships> relationships;
	
	/**
	 * Initializes a model with a hashmap of classes and an arraylist of relationships.
	 */
	public Model() {
		classes = new HashMap<>();
		relationships = new ArrayList<>();
	}
	
	/**
	 * Destructor that deletes the whole project.
	 */
	public void deleteUML() {
		classes.clear();
		relationships.clear();
	}
	
	/**
	 * A function to add a class if there is not an already existing class
	 * with the new name.
	 * @param className
	 * 		The name of the new class.
	 * @return
	 * 		Returns true when a new class is added.
	 */
	public boolean addClass(String className) {
		// if there is not a class with the name classname
		if(!classes.containsKey(className)) {
			classes.put(className, new ClassObject(className));
			return true;
		}
		return false;
	}
	
	public boolean deleteClass(String className) {
		if(classes.containsKey(className)) {
			classes.remove(className);
			return true;
		}
		return false;
	}
	
	
	
	
}
