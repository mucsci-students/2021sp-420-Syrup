package edu.millersville.uml_editor;

public class Formal {
	private String name;
	private String type;
	
	public Formal(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setType(String newType) {
		this.type = newType;
	}
}
