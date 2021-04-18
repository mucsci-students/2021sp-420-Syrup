package edu.millersville.uml_editor.model;

import java.io.Serializable;

public class Relationships implements Serializable {

	private ClassObject source;
	private ClassObject destination;
	private static String ID;
	private String type;

///////////////////////////////////////////////////////////
//
//	Constructor
//
///////////////////////////////////////////////////////////

	public Relationships(ClassObject class1, ClassObject class2, String id, String type1) 
	{
		source = class1;
		destination = class2;
		ID = id;
		type = type1;
	}
	
///////////////////////////////////////////////////////////
//
//	sourceName
//
///////////////////////////////////////////////////////////

	public String sourceName()
	{
		return source.getName();
	}
	
	public String getSource() {
		return source.getName();
	}
///////////////////////////////////////////////////////////
//
//	destinatinoName
//
///////////////////////////////////////////////////////////

	public String destinationName()
	{
		return destination.getName();
	}

	
	public String getDestination()
	{
		return destination.getName();
	}
	
///////////////////////////////////////////////////////////
//
//	changeType
//
///////////////////////////////////////////////////////////

	public void changeType(String newType)
	{
		type = newType;
	}
	
	public String getType()
	{
		return type;
	}

	public String getID()
	{
		return ID;
	}
	
///////////////////////////////////////////////////////////
//
//	relType
//
///////////////////////////////////////////////////////////

	public String relType()
	{
		return type;
	}
	
///////////////////////////////////////////////////////////
//
// Printing
//
///////////////////////////////////////////////////////////
	
	public String printID() {
		return "Relationship ID: " + ID;
	}
	
	public String printSource() {
		return  " Relationship source: " + source.getName();
	}
	
	public String printDestination() {
		return " Relationship destination: " + destination.getName();
	}
	
	public String printType() {
		return " Relationship type: " + type;
	}
	
	public String toString() {
		return printID() + printSource() + printDestination()
				 + printType();
	}
}
