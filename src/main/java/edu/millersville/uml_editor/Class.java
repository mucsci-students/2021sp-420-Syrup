package edu.millersville.uml_editor;

import java.util.*;

import edu.millersville.uml_editor.Class;

public class Class {
	private ArrayList<Attribute> attrArray;
	private Map<String, Attribute> attrMap = 
			new HashMap<String, Attribute>();

///////////////////////////////////////////////////////////
//
//	Constructor
//
///////////////////////////////////////////////////////////
	
    public Class()
    {
      
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
//	deleteAttributes
//
///////////////////////////////////////////////////////////
    
    // Deletes all the  attribute.
    public void deleteAttributes()
	{
    	attrMap.clear();
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
    	if (attrMap.containsKey(newName))
    	{
    		System.out.println("There is an attribute with the new name.");
    		return;
    	}
	if(!attrMap.containsKey(attrName))
	{
		System.out.println("There is not an attribute with the old name.");
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
    

///////////////////////////////////////////////////////////
//
// toString()
//
// function that creates a string of the map. 
// Look at the Attribute toString().
//
///////////////////////////////////////////////////////////
    
    @Override
    public String toString() {
    	StringBuffer s = new StringBuffer();
    	s.append(" : {");
    	// goes through the Attributes of each Class
    	// calls Attribute.toString()
    	for(String key : attrMap.keySet()) {
    		s.append(attrMap.get(key).toString());
    		s.append(",");
    	}
    	s.append("}");
    	return s.toString();
    	
    }
    
  

    
    
    
}