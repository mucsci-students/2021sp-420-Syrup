package edu.millersville.uml_editor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//import org.apache.commons.io.FileUtils;
//import com.fasterxml.jackson.databind.ObjectMapper;
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

		public static String jsonFor(UMLModel m) {
            Map<String, ClassObject> classes = m.getClasses();
	    	StringBuffer s = new StringBuffer();
	    	s.append("{");
	    	s.append(System.lineSeparator());
	    	boolean firstRow = true;
	    	for (String key: classes.keySet()) {
	    		if (firstRow) {
	    			firstRow = false;

	    		} else {
	    			s.append(",\n");
	    		}
	    		s.append("\"" + key + "\" : ");
	    		s.append("{");
	    		s.append(System.lineSeparator());
	    		s.append(classes.get(key).toString());
	    		s.append("}");
	    	}
	    	s.append("\n");
	    	s.append("}\n");
	    	System.out.println(s.toString());
	    	return s.toString();
	    }

	private static UMLModel model = new UMLModel();
	private static Scanner console = new Scanner(System.in);

///////////////////////////////////////////////////////////
//
//	Main Method
//
///////////////////////////////////////////////////////////
	
    public static void main(String[] args) throws IOException
    {
        boolean loop = true;
        //Loop that controls the entire program
        while(loop)
        {
            int number = 0;

        //Display menu
            System.out.println();
            System.out.println("1. Classes");
            System.out.println("2. Attributes");
            System.out.println("3. Relationships");
            System.out.println("4. List Classes/Attributes/Relationships");
	        System.out.println("5. Create JSON file");
            System.out.println("6. Load from a JSON file");
            System.out.println("7. Help");
            System.out.println("8. Exit the program");
            System.out.println();
            System.out.print("Please select a menu option: ");
            
            boolean isNumber = false;
            
            //****While loop that considers string input...repeated throughout the program for each switch statement****\\
            while (!isNumber)
            {
            	String temp = console.next();
            	try {
            		number = Integer.parseInt(temp);
            		isNumber = true;
            	}
            	catch (NumberFormatException ex) {
            		System.out.println();
            		System.out.println("This is not a number. Use a number when selecting a menu option.");
            		System.out.println();
            		System.out.print("Please select a menu option: ");
            	}
            }
            
            switch(number){
                //Case for Classes
                case 1: 
                int classNum = 0;

                //Class menu
                System.out.println();
                System.out.println("1. Add a class");
                System.out.println("2. Delete a class");
                System.out.println("3. Rename a class");
                System.out.println("4. Go back to main menu");
                System.out.println();
                System.out.print("What would you like to do with classes? ");
                
                isNumber = false;
                
                while (!isNumber)
                {
                	String temp = console.next();
                	try {
                		classNum = Integer.parseInt(temp);
                		isNumber = true;
                	}
                	catch (NumberFormatException ex) {
                		System.out.println();
                		System.out.println("This is not a number. Use a number when selecting a menu option.");
                		System.out.println();
                		System.out.print("Please select a menu option: ");
                	}
                }

                //Switch statement within the class menu
                switch(classNum){
                    //Asks for class name and adds
                    case 1:
                    System.out.println();
                    System.out.print("Enter the new class name: ");
                    String nameAdd = console.next();

                    model.createNewClass(nameAdd);
                    break;

                    //Asks for class name and deletes
                    case 2:
                    String nameDel = "";
                    System.out.println();
                    System.out.print("Enter the class to delete: ");
                    nameDel = console.next();

                    model.deleteClass(nameDel);
                    break;

                    //Asks for class name, new class name and renames
                    case 3: 
                    String className = "";
                    String newName = "";
                    System.out.println();
                    System.out.print("Enter the class to rename: ");
                    className = console.next();
                    System.out.println();
                    System.out.print("Enter the new name for the class: ");
                    newName = console.next();

                    model.renameClass(className, newName);
                    break;
                    
                    case 4:
                    break;
                    
                    //Default case that sends user back to main menu if a number not on the menu is entered
                    default:
                    System.out.println();
                    System.out.print("That is not a menu option! Please try again.");
                    System.out.println();
                    break;
                }
                break;

                //Case for Attributes
                case 2:
                int attrNum = 0;

                //Attribute menu
                System.out.println();
                System.out.println("1. Add an attribute");
                System.out.println("2. Delete an attribute");
                System.out.println("3. Rename an attribute");
                System.out.println("4. Go back to main menu");
                System.out.println();
                System.out.print("What would you like to do with attributes? ");
                
                isNumber = false;
                
                while (!isNumber)
                {
                	String temp = console.next();
                	try {
                		attrNum = Integer.parseInt(temp);
                		isNumber = true;
                	}
                	catch (NumberFormatException ex) {
                		System.out.println();
                		System.out.println("This is not a number. Use a number when selecting a menu option.");
                		System.out.println();
                		System.out.print("Please select a menu option: ");
                	}
                }

                //Switch statement within attribute menu
                switch(attrNum){
                    case 1:
                    String classAdd = "";
                    String attrAdd = "";
                    System.out.println();
                    System.out.print("Enter the class name for the attribute: ");
                    classAdd = console.next();
                    //Checks to see if the class name exists
                    if(!model.hasClass(classAdd))
                    {
                        System.out.println("There is not a class with this name.");
    		            break;
                    }
                    //If it does, prompts for attribute name and adds
                    else
                    {
                        ClassObject classCall = model.getClassFor(classAdd);
                        System.out.print("Enter the name of the attribute to add: ");
                        attrAdd = console.next();
                        classCall.addNewAttribute(attrAdd);
                    }
                    break;
                    
                    case 2:
                    String classDel = "";
                    String attrDel = "";
                    System.out.println();
                    System.out.print("Enter the class name for the attribute: ");
                    classDel = console.next();
                    //Checks to see if the class exists
                    if(!model.hasClass(classDel))
                    {
                        System.out.println("There is not a class with this name.");
    		            break;
                    }
                    //If it does, ask for attribute name and delete
                    else 
                    {
                        ClassObject classCall = model.getClassFor(classDel);
                        System.out.print("Enter the name of the attribute to delete: ");
                        attrDel = console.next();
                        classCall.deleteAttribute(attrDel);
                    }
                    break;

                    case 3: 
                    String classRen = "";
                    String attrOld = "";
                    String attrNew = "";
                    System.out.println();
                    System.out.print("Enter the class for the attribute: ");
                    classRen = console.next();
                    //Checks to see if the class exists
                    if(!model.hasClass(classRen))
                    {
                        System.out.println("There is not a class with this name.");
    		            break;
                    }
                    //If it does, ask for current and new name for attribute and renames
                    else 
                    {
                        ClassObject classCall = model.getClassFor(classRen);
                        System.out.print("Enter the current name for the attribute: ");
                        attrOld = console.next();
                        System.out.print("Enter the new name for the attribute: ");
                        attrNew = console.next();
                        classCall.renameAttribute(attrOld, attrNew);
                    }
                    break;
                    
                    case 4:
                    break;

                    //Default case that sends user back to main menu if a number not on the menu is entered
                    default:
                    System.out.println();
                    System.out.print("That is not a menu option! Please try again.");
                    System.out.println();
                    break;
                }
                break;

                //Case for Relationships
                case 3:
                int relNum = 0;

                //Relationship menu
                System.out.println();
                System.out.println("1. Add a relationship");
                System.out.println("2. Delete a relationship");
                System.out.println("3. Change Relationship Type");
                System.out.println("4. Go back to main menu");
                System.out.println();
                System.out.print("What would you like to do with relationships? ");
                
                isNumber = false;
                
                while (!isNumber)
                {
                	String temp = console.next();
                	try {
                		relNum = Integer.parseInt(temp);
                		isNumber = true;
                	}
                	catch (NumberFormatException ex) {
                		System.out.println();
                		System.out.println("This is not a number. Use a number when selecting a menu option.");
                		System.out.println();
                		System.out.print("Please select a menu option: ");
                	}
                }

                //Switch statement within relationship menu
                switch(relNum){
                    //Case to add relationship
                    case 1:
                    String sourceAdd = "";
                    String destAdd = "";
                    String ID = "";
                    System.out.println();
                    System.out.print("Enter the source of the relationship: ");
                    sourceAdd = console.next();
                    System.out.print("Enter the destination of the relationship: ");
                    destAdd = console.next();
                    //If statements that check to see if the classes entered for source and destination exist
                    if(!model.hasClass(sourceAdd))
                    {
                        System.out.println("There is not a class with the source name.");
    		            break;
                    }
                    else if(!model.hasClass(destAdd))
                    {
                        System.out.println("There is not a class with the destination name.");
    		            break;
                    }
                    //If they do, ask for ID and adds relationship
                    else 
                    {
                        System.out.print("Enter an ID for the relationship: ");
                        ID = console.next();

                        System.out.print("Please enter Aggregation, Composition, Inheritance, Realiztion: ");
                        String newType = console.next();
                        if(newType.equals("Aggregation") || newType.equals("Composition") || newType.equals("Inheritance") || newType.equals("Realization"))
                            model.createRelationship(sourceAdd, destAdd, ID, newType);
                            else
                            {
                                System.out.println();
                                System.out.println("This is not a proper type");
                                break;
                            }
                    }
                    break;
                    
                    //Case to delete relationship
                    case 2:
                    String delID = "";
                    System.out.println();
                    System.out.print("Enter the ID of the relationship: ");
                    delID = console.next();
                    //Checks if ID exists
                    if(!model.getRelationships().containsKey(delID))
                    {
                        System.out.println("There is not a relationship with this ID.");
    		            break;
                    }
                    //If it does, delete relationship
                    model.deleteRelationship(delID);
                    break;
                    
                    case 3:
                    System.out.print("Enter the relationship ID: ");
                    String relID = console.next();

                    if(!model.getRelationships().containsKey(relID))
                    {
                        System.out.println("There is not a relationship with this ID.");
    		            break;
                    }
                    System.out.print("Please enter: Aggregation, Composition, Inheritance, Realization: ");
                    String newType = console.next();
                    if(newType.equals("Aggregation") || newType.equals("Composition") || newType.equals("Inheritance") || newType.equals("Realization"))
                        model.changeRelationshipType(relID, newType);
                        else 
                        {
                            System.out.println();
                            System.out.println("This is not a proper type");
                            break;
                        }

                    case 4:
                    break;

                    //Default case that sends user back to main menu if a number not on the menu is entered
                    default:
                    System.out.println();
                    System.out.print("That is not a menu option! Please try again.");
                    System.out.println();
                    break;
                }
                break;

                //Case to list data
                case 4:
                int listNum = 0;

                //List menu
                System.out.println();
                System.out.println("1. List classes");
                System.out.println("2. List attributes");
                System.out.println("3. List relationships");
                System.out.println("4. Go back to main menu");
                System.out.println();
                System.out.print("What would you like to list? ");
                
                isNumber = false;
                
                while (!isNumber)
                {
                	String temp = console.next();
                	try {
                		listNum = Integer.parseInt(temp);
                		isNumber = true;
                	}
                	catch (NumberFormatException ex) {
                		System.out.println();
                		System.out.println("This is not a number. Use a number when selecting a menu option.");
                		System.out.println();
                		System.out.print("Please select a menu option: ");
                	}
                }

                //Switch statement with the list option
                switch(listNum){
                    //List classes with their attributes
                    case 1:
                    System.out.println();
                    printClasses();
                    break;

                    //List a specific class with its attributes
                    case 2:
                    String listAttr = "";
                    System.out.println();
                    System.out.print("Enter the class name: ");
                    listAttr = console.next();
                    //Checks to see if the class exists
                    if(!model.hasClass(listAttr))
                    {
                        System.out.println("There is not a class with this name.");
    		            break;
                    }
                    //If it does, print it and its attributes
                    else 
                    {
                        System.out.println();
                        System.out.println("Class Name: " + listAttr);
                        System.out.print("Attributes: ");
                        model.getClassFor(listAttr).printAttr();
                    }
                    break;

                    //List relationships
                    case 3: 
                    System.out.println();
                    listRelationships();
                    break;
                    
                    case 4:
                    break;

                    //Default case that sends user back to main menu if a number not on the menu is entered
                    default:
                    System.out.println();
                    System.out.println("That is not a menu option! Please try again.");
                    break;
                }
                break;
		
                //Save JSON case
		        case 5:
		        System.out.println();   
            	System.out.print("Enter filepath (filepath+filename): ");
            	String filename = console.next();
            	saveJSON(filename, model);
            	System.out.println();
            	System.out.println("JSON file saved to: " + filename);
            	break;
			    
                //Load JSON case
		        case 6:
		        System.out.println();        
              	System.out.println("Enter filepath (filepath+filename) of file to open: ");
            	String filepath = console.next();
            	File jsonFile = new File(filepath);
            	if (jsonFile.exists()) {
            		//System.out.println(loadJSON(filepath));
            		System.out.println();
            	} else {
            		System.out.println("No such file exists. Please enter filepath again.");
            	}
                break;
                
                //Case that displays help instructions
                case 7:
                System.out.println();
                System.out.println("The menu options accept numbers only. Any words while selecting a menu option will have you try again.");
                System.out.println();
                
                System.out.println("In the Classes command, you'll be able to do the following: ");
                System.out.println(" -> Create a class");
                System.out.println(" -> Delete a class");
                System.out.println(" -> Rename a class");
                System.out.println();

                System.out.println("In the Attribute command, you'll be able to do the following: ");
                System.out.println(" -> Create an attribute");
                System.out.println(" -> Delete an attribute");
                System.out.println(" -> Rename an attribute");
                System.out.println();
                
                System.out.println("In the Relationships command, you'll be able to do the following: ");
                System.out.println(" -> Create a relationship");
                System.out.println(" -> Delete a relationship");
                System.out.println();
                
                System.out.println("In the List command, you'll be able to do the following: ");
                System.out.println(" -> List all the classes with their attributes");
                System.out.println(" -> List a specific class with its attributes");
                System.out.println(" -> List all the existing relationships");
                System.out.println();
                
                System.out.println("Once you are finished, you may exit the program by selecting 'Exit the program'");
                break;

                //Case that exists the program
                case 8:
                loop = false;
                break;

                //Default case that sends user back to main menu if a number not on the menu is entered
                default:
                System.out.println();
                System.out.print("That is not a menu option! Please try again.");
                System.out.println();
                break;
            }
        }
    }
    
///////////////////////////////////////////////////////////
//
//	printClass
//
///////////////////////////////////////////////////////////
      
    public static void printClass(String className) 
    {
        System.out.println("Class Name: " + className);  
        System.out.print("Attributes: ");
        model.getClassFor(className).printAttr();
    }

    public static void printClasses() 
    {
        for (String key : model.getClasses().keySet()) 
    	{
            printClass(key);
    	}
    }

///////////////////////////////////////////////////////////
//
//	listRelationships
//
///////////////////////////////////////////////////////////

	public static void listRelationships()	
    {
		for (String key : model.getRelationships().keySet())
		{
			System.out.print(key + ": ");
			System.out.println(model.getRelationships().get(key).sourceName() + ", " + model.getRelationships().get(key).destinationName());
		}
	}
	
///////////////////////////////////////////////////////////
//
//	saveJSON(String, Map<String, Class>)
//
//	function that creates and saves model.getClasses() to a JSON file using 
//	a prompted file name and the model.getClasses().
//
///////////////////////////////////////////////////////////

    public static void saveJSON(String name, UMLModel model) throws IOException{
    	//converts map into JSON object
    	String s = jsonFor(model);
    	// writing map to JSON file
    	try {
    		FileWriter file = new FileWriter(name);
    		file.write(s.toString());
    		file.close();
    	} catch (IOException e) {
    		e.printStackTrace();
            System.out.println("The filepath does not exist. Enter a correct filepath.");
    	}
    }
    
///////////////////////////////////////////////////////////
//
// loadJSON(String, Map<String, Class>)
//
// function that loads a JSON file using 
// a prompted filepath.
//
///////////////////////////////////////////////////////////
    

    /*public static Map<String, Class> loadJSON(String filepath) throws IOException, FileNotFoundException {
        // added JAR file
    	String file = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	Map<String, Class> newObj = objectMapper.readValue(file, HashMap.class);
    	model.getClasses() = newObj;
    	return newObj;
    }*/
}
