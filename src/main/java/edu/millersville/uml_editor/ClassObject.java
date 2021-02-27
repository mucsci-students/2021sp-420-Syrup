package edu.millersville.uml_editor;
import java.util.*;
import org.json.JSONObject;

public class ClassObject
{
	private ArrayList<Attribute> attrArray;
	private Map<String, Attribute> attrMap = 
			new HashMap<String, Attribute>();
	private String className;

///////////////////////////////////////////////////////////
//
//	Constructor
//
///////////////////////////////////////////////////////////
	
    public ClassObject(String name)
    {
    	className = name;
        //JSONObject obj = new JSONObject();
    }

///////////////////////////////////////////////////////////
//
//	addNewAttribute
//
///////////////////////////////////////////////////////////
    
    //Adds a new attribute to the class.
    public void addNewAttribute(String name) 
    {
    	// Checks to see if there is an attribute with the same name.
    	if (attrMap.containsKey(name))
    	{
    		System.out.println("There is already an attribute with this name.");
    		return;
    	}
		//Creates attribute by putting into the map
    	attrMap.put(name, new Attribute(name));
    	
    	System.out.println();
    	System.out.println("The attribute has been added!");
    }

///////////////////////////////////////////////////////////
//
//	deleteAttributes
//
///////////////////////////////////////////////////////////
    
    //Deletes all the  attributes.
    public void deleteAttributes()
	{
    	attrMap.clear();
    }
    
///////////////////////////////////////////////////////////
//
//	deleteAttribute
//
///////////////////////////////////////////////////////////
    
    //Deletes the attribute.
    public void deleteAttribute(String name)
    {
    	// Checks to see if the attribute exists.
    	if (!attrMap.containsKey(name))
    	{
    		System.out.println("There is not an attribute with this name.");
    		return;
    	}
		//Deletes the attribute by removing from the map
    	attrMap.remove(name);

    	System.out.println();
    	System.out.println("The attribute has been deleted!");
    }
    
///////////////////////////////////////////////////////////
//
//	renameAttribute
//
///////////////////////////////////////////////////////////
    
    public void renameAttribute(String attrName, String newName)
    {
    	//Checks to see if the new name is a duplicate.
    	if (attrMap.containsKey(newName))
    	{
    		System.out.println("There is an attribute with the new name.");
    		return;
    	}
		//Checks to see if the attirbute exists
		if(!attrMap.containsKey(attrName))
		{
			System.out.println("There is not an attribute with the current name.");
    		return;
		}
    	// Replaces the old name with the new name.
    	attrMap.put(newName, attrMap.get(attrName));
    	attrMap.remove(attrName);
    	
    	System.out.println();
    	System.out.println("The attribute has been renamed!");
    }
    
///////////////////////////////////////////////////////////
//
//	printAttr
//
///////////////////////////////////////////////////////////
	
    public void printAttr ()
    {
    	int attSize = attrMap.size();
    	for (String key : attrMap.keySet()) {
    		if (attSize > 1)
    		{
    			System.out.print(key + ", ");
    			--attSize;
    		}
    		else
    		{
    			System.out.println(key);
    		}
        } 
    }
    
///////////////////////////////////////////////////////////
//
//	getClassName
//
///////////////////////////////////////////////////////////

    public String getClassName()
    {
    	return className;
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
    	// goes through the Attributes of each Class
    	// calls Attribute.toString()
    	boolean firstRow = true;
    	for(String key : attrMap.keySet()) {
    		if (firstRow) {
    			firstRow = false;
    		} else {
    			s.append(",\n");
    		}
    		s.append("\"");
    		s.append(key);
    		s.append("\" : ");
    		s.append(attrMap.get(key).toString());
    	}
    	s.append("\n");
    	return s.toString();
    }
}
