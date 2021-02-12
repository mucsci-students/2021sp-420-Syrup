package edu.millersville.uml_editor;

public class Attribute 
{
	private String uniqueName;
	

	public Attribute (String name) 
	{
		uniqueName = name;
	}
	
///////////////////////////////////////////////////////////
//
// toString()
//
// function that creates a string of the map. 
// 
//
///////////////////////////////////////////////////////////
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("\"");
		s.append(uniqueName);
		s.append("\"");
		return s.toString();
	}

	
}