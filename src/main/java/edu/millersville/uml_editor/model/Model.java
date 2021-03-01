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
	 * An accessor method that gets the classes.
	 * @return
	 * 		Returns the map of classes.
	 */
	public HashMap<String, ClassObject> getClasses(){
		return classes;
	}
	
	/**
	 * An accessor method that gets the list of relationships.
	 * @return
	 * 		Returns the list of relationships.
	 */
	public ArrayList<Relationships> getRelationships(){
		return new ArrayList<Relationships>(relationships);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// Class Functions
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	/**
	 * A function that deletes a class and the relationships of that class.
	 * @param className
	 * 		The name of the class to be deleted.
	 * @return
	 * 		Returns true when the class and the relationships of that class are deleted.
	 */
	public boolean deleteClass(String className) {
		// check if there is a class.
		if(!classes.containsKey(className)) {
			return false;
		}
		classes.remove(className);
		// remove relationships of that class.
		ArrayList<Relationships> newRel = new ArrayList<Relationships>();
		for(Relationships rel : relationships) {
			if(!rel.getSource().equals(className) || !rel.getDestination().equals(className)) {
				newRel.add(rel);
			}
		}
		relationships = newRel;
		return true;
	}
	
	/**
	 * A function that renames an already existing class.
	 * @param originalName
	 * 		The name of the class whose name to change.
	 * @param newName
	 * 		The new name of the class.
	 * @return
	 * 		Returns true when the class's name has been changed and the 
	 * 		class's name has been changed in the relationships.
	 */
	public boolean renameClass(String originalName, String newName) {
		if(classes.containsKey(newName)){
			return false;
		}
		for(String key : classes.keySet()) {
			if(key.equals(originalName)) {
				classes.put(newName, classes.remove(originalName));
				break;
			}
		}
		// renames the class in its relationships
		for(Relationships rel : relationships) {
			if(rel.getSource().equals(originalName)) {
				rel.setSource(newName);
			}
			if(rel.getDestination().equals(originalName)) {
				rel.setDestination(newName);
			}
		}
		return true;
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).addMethod(methodName, methodType);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).deleteMethod(methodName);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).renameMethod(originalName, newName);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).changeMethodType(methodName, newType);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	// Relationship Functions
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A function that converts a string value into type RelType.
	 * A string can only be: AGGREGATION, COMPOSITION, INHERITANCE, REALIZATION.
	 * @param rel
	 * 		The string relationship type.
	 * @return
	 * 		Returns the RelType of the string.
	 */
	public static RelType stringToRelType(String rel) {
		switch(rel) {
			case "AGGREGATION":
				return RelType.AGGREGATION;
			case "COMPOSITION":
				return RelType.COMPOSITION;
			case "INHERITANCE":
				return RelType.INHERITANCE;
			case "REALIZATION":
				return RelType.REALIZATION;
			default:
				return null;
		}
	}
	
	/**
	 * A function that adds a unique relationship between a source class and a destination class.
	 * @param source
	 * 		The source class of the relationship.
	 * @param destination
	 * 		The destination class of the relationship.
	 * @param relationshipType
	 * 		The type the relationship is.
	 * @return
	 * 		Returns true when the relationship has been added to its unique source and destination classes.
	 */
	public boolean addRelationship(String source, String destination, String relationshipType) {
		RelType realRelationship = stringToRelType(relationshipType);
		// if there are a source and destination class already present
		if(!classes.containsKey(source) || !classes.containsKey(destination)) {
			return false;
		}
		for(Relationships rel : relationships) {
			// there is already a relationship
			if(rel.getSource().equals(source) && rel.getDestination().equals(destination)) {
				return false;
			}
		}
		return relationships.add(new Relationships(source, destination, realRelationship));
	}
	
	/**
	 * A function that removes a relationship from the list.
	 * @param source
	 * 		The source class of the relationship.
	 * @param destination
	 * 		The destination class of the relationship.
	 * @return
	 * 		Returns true when the relationship has been removed.
	 */
	public boolean deleteRelationship(String source, String destination) {
		if(!classes.containsKey(source) || !classes.containsKey(destination)) {
			return false;
		}
		for(Relationships rel : relationships) {
			if(rel.getSource().equals(source) && rel.getDestination().equals(destination)) {
				return relationships.remove(rel);
			}
		}
		return false;
	}
	
	/**
	 * A function that changes the relationship type.
	 * @param source
	 * 		The source class.
	 * @param destination
	 * 		The destination class.
	 * @param newType
	 * 		The new type of the relationship.
	 * @return
	 * 		Returns when the relationship type has been changed.
	 */
	public boolean changeRelationshipType(String source, String destination, String newType) {
		RelType tempType = stringToRelType(newType);
		if(!classes.containsKey(source) || !classes.containsKey(destination)) {
			return false;
		}
		for(Relationships rel : relationships) {
			if(rel.getSource().equals(source) && rel.getDestination().equals(destination)) {
				rel.setType(tempType);
				return true;
			}
		}
		return false;
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).addParameter(methodName, paramName, paramType);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).deleteParameter(methodName, paramName);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).renameParameter(methodName, originalParam, newParam);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).changeParameterType(methodName, param, newtype);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).replaceParameterList(methodName, newParamList);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).addField(fieldName, fieldType);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).deleteField(fieldName);
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
		if(!classes.containsKey(classname)) {
			return false;
		}
		return classes.get(classname).renameField(fieldName, newName);
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
		if(!classes.containsKey(className)) {
			return false;
		}
		return classes.get(className).changeFieldType(fieldName, newType);
	}
}
