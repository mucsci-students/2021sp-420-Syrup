package edu.millersville.uml_editor;

public class Attribute 
{
	private String uniqueName;
	String attributeKey;
	String attributeValue;
	

	public Attribute (String name) 
	{
		uniqueName = name;
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("\"");
		s.append(uniqueName);
		s.append("\"");
		return s.toString();
	}

	
}