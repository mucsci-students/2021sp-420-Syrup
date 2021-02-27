package edu.millersville.uml_editor.model;


import java.util.*;
/**
 * A class that creates a relationship object that stores a source, destination, and
 * a the type. 
 * 
 * @author TeamSyrup
 *
 */
public class Relationships {

	private String source;
	private String destination;
	private RelType type;
	
	/**
	 * Creates type RelType which can only be the values defined:
	 * aggregation, composition, inheritance, and realization.
	 *
	 */
	public enum RelType{
		AGGREGATION, COMPOSITION, INHERITANCE, REALIZATION
	}

	/**
	 * Initializes a relationship with a source, destination, and a type.
	 * Parameters must be in this order: 
	 * 1. source
	 * 2. destination
	 * 3. type
	 * @param class1
	 * 		The source class.
	 * @param class2
	 * 		The destination class.
	 * @param relType
	 * 		The relationship.
	 */
	public Relationships(String class1, String class2, RelType relType) 
	{
		source = class1;
		destination = class2;
		type = relType;
	}

	/**
	 * Getter function to get the source class.
	 * @return
	 * 		Returns the source class;
	 */
	public String getSource()
	{
		return source;
	}
	
	/**
	 * Getter function that gets the destination class.
	 * @return
	 * 		Returns the destinatino class.
	 */
	public String getDestination()
	{
		return destination;
	}

	/**
	 * Mutator function that changes the source class of the relationship.
	 * @param newSource
	 * 		The new source class.
	 */
	public void setSource(String newSource) {
		source = newSource;
	}
	
	/**
	 * Mutator function that changes the destination class of the relationship.
	 * @param newDestination
	 * 		The new destination class.
	 */
	public void setDestination(String newDestination) {
		destination = newDestination;
	}
	
	/**
	 * A function that gets the type of the relationship.
	 * @return
	 * 		Returns the type of the relationship.
	 */
	public RelType getType()
	{
		return type;
	}
	
	/**
	 * A function that changes the type of a relationship.
	 * @param newType
	 * 		The type the relationship will be changed to.
	 */
	public void setType(RelType newType) {
		type = newType;
	}
	
	/**
	 * A function that finds whether a class is a source or a destination.
	 * @param className
	 * 		The class to search for.
	 * @return
	 * 		Returns true if the class name is a source or destinatino of this
	 * 		relationship.
	 */
	public boolean containsClass(String className) {
		return (className.equals(source) || className.equals(destination));
	}
	
	/**
	 * A function that gets the relationship (including source, destination, and type).
	 * @return
	 * 		Returns the relationship.
	 */
	public Relationships getRelationship() {
		return new Relationships(source, destination, type);
	}
}
