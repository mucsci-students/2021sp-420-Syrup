package edu.millersville.uml_editor;

import java.util.ArrayList;

public class Method extends Formal {
	private ArrayList<Parameter> parameters;
	
	public Method(String name, String type) {
		super(name, type);
		parameters = new ArrayList<Parameter>();
	}
	
	public boolean addParameter(String name, String type) {
		// check if the parameter already exists
		if(!containsParameter(name)) {
			return false;
		}
		return parameters.add(new Parameter(name, type));
	}
	
	public boolean deleteParameter(String name) {
		for(Parameter param : parameters) {
			if(param.getName().equals(name)) {
				parameters.remove(param);
			}
			return true;
		}
		return false;
	}
	
	public void deleteAllParameters() {
		parameters.clear();
	}
	
	public void replaceParameterList(ArrayList<Parameter> newList) {
		parameters = newList;
	}
	
	public boolean changeParameterType(String name, String newType) {
		// look for the parameter and change the type
		for(Parameter param : parameters) {
			if(param.getName().equals(name)) {
				param.setType(newType);
			}
			return true;
		}
		return false;
	}
	
	public boolean containsParameter(String name) {
		for(Parameter param : parameters) {
			if(param.getName().equals(name)) {
			return true;
			}
		}
		return false;
	}
	
	public ArrayList<Parameter> getParameters(){
		return parameters;
	}
}
