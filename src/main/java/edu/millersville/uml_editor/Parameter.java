package edu.millersville.uml_editor;

public class Parameter extends Formal {

	public Parameter(String name, String type) {
		super(name, type);
	}
	
	public String toString() {
		return getName() + " " + getType();
	}
}
