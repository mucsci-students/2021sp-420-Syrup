package edu.millersville.uml_editor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 *
 */
public class Main 
{

///////////////////////////////////////////////////////////
//
//	Private Variables
//
///////////////////////////////////////////////////////////
	
	private static Map<String, Class> classMap = 
			new HashMap<String, Class>();
	private static Map<Class, Class> relMap = 
			new HashMap<Class, Class>();
	private static Scanner console = new Scanner(System.in);
	
///////////////////////////////////////////////////////////
//
//	Main Method
//
///////////////////////////////////////////////////////////
	
    public static void main( String[] args )
    {
    	// testing stuff. IGNORE IT
    	
    	System.out.println("enter the name for a class");
    	String name = console.next();
        createNewClass(name);
        
        System.out.println("enter the name for a class");
        String output = console.next();
        createNewClass(output);
        
        System.out.println("enter the name for an attribute");
        output = console.next();
        
        classMap.get(name).addNewAttribute(output);
        
        System.out.println();
        
        printClass();
        classMap.get(name).printAttr();
    }
    
///////////////////////////////////////////////////////////
//
//	createClass
//
///////////////////////////////////////////////////////////

    public static void createNewClass(String className) 
    {
    	if (classMap.containsKey(className))
    	{
    		System.out.println("There is already a class with that name.");
    		return;
    	}
    	
    	classMap.put(className, new Class());
    }
  
///////////////////////////////////////////////////////////
//
//	renameClass
//
///////////////////////////////////////////////////////////
  
    public static void renameClass(Class name, String newName)
    {

       	if (classMap.containsKey(newName))
    	{
    		System.out.println("There is an class with the new name.");
    		return;
    	}

        if(classMap.containsKey(name))
        {
           System.out.println("There is not a class with the old name.");
    		return; 
        }
    	
    	if (classMap.equals(newName))
    	{
    		System.out.println("The new name is the same as the class name.");
    		return;
    	}
    classMap.put(newName, classMap.get(name));
    classMap.remove(name);
    }
  
///////////////////////////////////////////////////////////
//
//	deleteClass
//
///////////////////////////////////////////////////////////

    public static void deleteClass(Class name)
    {

        if (!classMap.containsKey(name))
    	{
    		System.out.println("There is not a class with that name.");
    		return;
    	}
        classMap.get(name).deleteAttributes();
        classMap.remove(name);
    }

//////////////////////////////////////////////////////////
//
//	createRelationship
//
///////////////////////////////////////////////////////////
    public static void createRelationship(String class1, String class2, int ID )
    {
        if (relMap.containsKey(ID))
    	    {
    		    System.out.println("There is already a relationship with that ID.");
    		    return;
    	}
    //create temp class to be able to create relationship
        Class source = classMap.get(class1);
        Class destination = classMap.get(class2);
        relMap.put(ID, new Relationships(source, destination, ID)); 
    }

//////////////////////////////////////////////////////////
//
//	deleteRelationship
//
///////////////////////////////////////////////////////////
    public static void deleteRelationship( int ID )
    {
        if (!relMap.containsKey(ID))
    	    {
    		    System.out.println("There is not a relationship with that ID.");
    		    return;
    	    }
        relMap.remove(ID); 
    }
    
///////////////////////////////////////////////////////////
//
//	printClass
//
///////////////////////////////////////////////////////////
      
    public static void printClass ()
    {
    	for (String key : classMap.keySet()) 
    	{
    		System.out.println(key);
    	} 
    }
}


