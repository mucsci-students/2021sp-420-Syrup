package edu.millersville.uml_editor;

import java.util.*;

public class Relationships {

	private Class source;
	private Class destination;
	private static String ID;

	
	public Relationships(Class class1, Class class2, String id) {
		source = class1;
		destination = class2;
		ID = id;
	}
	
	public String sourceName()
	{
		return source.getClassName();
	}
	
	public String destinationName()
	{
		return destination.getClassName();
	}

}
