package edu.millersville.uml_editor;

import java.util.*;

//import org.json.JSONObject;

import edu.millersville.uml_editor.Class;

public class Class {
	
	private static Map<String, Attribute> attrMap = 
			new HashMap<String, Attribute>();

///////////////////////////////////////////////////////////
//
//	Constructor
//
///////////////////////////////////////////////////////////
	
    public Class()
    {
        //JSONObject obj = new JSONObject();
    }

///////////////////////////////////////////////////////////
//
//	addNewAttribute
//
///////////////////////////////////////////////////////////
    
    // Adds a new attribute to the class.
    public void addNewAttribute(String name) 
    {
    	// Checks to see if there is an attribute with the same name.
    	if (attrMap.containsKey(name))
    	{
    		System.out.println("There is already an attribute with this name.");
    		return;
    	}
    	
    	attrMap.put(name, new Attribute(name));
    }
    
///////////////////////////////////////////////////////////
//
//	deleteAttribute
//
///////////////////////////////////////////////////////////
    
    // Deletes the attribute.
    public void deleteAttribute(String name)
    {
    	// Checks to see if there is an attribute with the same name.
    	if (!attrMap.containsKey(name))
    	{
    		System.out.println("There is not an attribute with this name.");
    		return;
    	}
    	
    	attrMap.remove(name);
    }
    
///////////////////////////////////////////////////////////
//
//	renameAttribute
//
///////////////////////////////////////////////////////////
    
    public void renameAttribute(String attrName, String newName)
    {
    	// Checks to see if there is an attribute with the same name.
    	if (attrMap.containsKey(newName) || !attrMap.containsKey(attrName))
    	{
    		System.out.println("There is an attribute with the new name.");
    		return;
    	}
    	
    	if (attrName.equals(newName))
    	{
    		System.out.println("The new name is the same as the attribute name.");
    		return;
    	}
    	
    	// Replaces the old name with the new name.
    	attrMap.put(newName, attrMap.get(attrName));
    	attrMap.remove(attrName);
    	
    }
    
///////////////////////////////////////////////////////////
//
//	printAttr
//
///////////////////////////////////////////////////////////
    public void printAttr ()
    {
    	for (String key : attrMap.keySet()) {
            System.out.println(key);
        } 
    }
}
