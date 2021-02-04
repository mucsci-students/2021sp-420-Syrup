package edu.millersville.uml_editor;

import java.util.*;

import org.json.JSONObject;

public class Classes {
	
	private Map<String, String[]> theClass;
    private String className;
    private String[] attribute;
    private String element;

    public Classes(String name, String[] attr){
        className = name;
        attribute = attr;
        theClass = new HashMap<String, String[]>();
        JSONObject obj = new JSONObject();
    }

    public void createNewClass(String className, String[] attribute) {
        theClass.put(className, attribute);
    }

    public void addNewAttribute(String name, String[] attribute, String element) {

    }
}
