package edu.millersville.uml_editor;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
// Updated upstream
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// Stashed changes

import org.json.JSONObject;


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
	private static Map<String, Relationships> relMap =
			new HashMap<String, Relationships>();
	private static Map <Integer, Relationships> relMap =
            new HashMap<Integer, Relationships>();
	private static Scanner console = new Scanner(System.in);

///////////////////////////////////////////////////////////
//
//	Main Method
//
///////////////////////////////////////////////////////////
	
    public static void main( String[] args ) throws IOException
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

        // ********** simple print line to print a map ***********
        // 
        // output should look like: 
        // { "class2": {}, "class1": {}}
    	System.out.println(new JSONObject(classMap));        
        
    	// filepath + new file name
    	// example: C:/Millersville/2020-2021/420/example.json
    	System.out.println("Enter filepath (filepath+filename): ");
    	String filename = console.next();
    	saveJSON(filename, classMap);
    	

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
  
    public static void renameClass(String name, String newName)
    {

       	if (classMap.containsKey(newName))
    	{
    		System.out.println("There is an class with the new name.");
    		return;
    	}

        if(!classMap.containsKey(name))
        {
           System.out.println("There is not an existing class with the name: " + name + ".");
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

    public static void deleteClass(String name)
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
    public static void createRelationship(String class1, String class2, String ID )
    {

        //checks to make sure the relationship is not already created
        if(relID.containsKey(ID))
        {
            System.out.println("This relationship already exists");
            break;
        }
        //create temp class to be able to create relationship
        Class source = classMap.get(class1);
        Class destination = classMap.get(class2);;

        //relID.put(ID, new Relationships(source, destination, ID)); 

        //relMap.put(ID, new Relationships(source, destination, ID)); 

    }

//////////////////////////////////////////////////////////
//
//	deleteRelationship
//
///////////////////////////////////////////////////////////

public static void deleteRelationship(String ID)
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
///////////////////////////////////////////////////////////
//
//	saveJSON(String, Map<String, Class>)
//
//	function that creates and saves classMap to a JSON file using 
//	a prompted file name and the classMap.
//
///////////////////////////////////////////////////////////

    public static void saveJSON(String name, Map<String, Class> map) throws IOException{
    	//converts map into JSON object
    	JSONObject jsonMap = new JSONObject(map);
    	// writing map to JSON file
    	try {
    		FileWriter file = new FileWriter(name);
    		file.write(jsonMap.toString());
    		file.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

}


