package edu.millersville.uml_editor;

import java.util.HashMap;
import java.util.Map;

public class UMLModel {
    private Map<String, ClassObject> classMap;
    private Map<String, Relationships> relMap;
    
    public UMLModel() {
		classMap = new HashMap<String, ClassObject>();
		relMap = new HashMap<String, Relationships>();
    }

    public  Map<String, ClassObject> getClasses() {
        return classMap;
    }

    public Map<String, Relationships> getRelationships() {
        return relMap;
    }

    public boolean hasClass(String className) {
        return classMap.containsKey(className);
    }

    public ClassObject getClassFor(String className) {
        return classMap.get(className);
    }
}
