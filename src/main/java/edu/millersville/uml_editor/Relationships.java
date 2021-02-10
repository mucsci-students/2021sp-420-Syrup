package edu.millersville.uml_editor;

import java.util.*;

public class Relationships {

	private Class source;
	private Class destination;
	private Integer ID;

	
	public Relationships(Class class1, Class class2, Integer IDD) {
		source = class1;
		destination = class2;
		ID = IDD;
	}

}
