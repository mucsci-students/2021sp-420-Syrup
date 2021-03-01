package edu.millersville.uml_editor;

import java.util.*;

import edu.millersville.uml_editor.model.*;

/**
 * 
 *
 */
public class Main 
{
	
    public static void main(String[] args)
    {
       Model uml = new Model();
       uml.addClass("class1");
       uml.addClass("class2");
       System.out.println("print classes: " + uml.getClasses());
       System.out.println();
       uml.addMethod("class1", "methodName", "methodType");
       uml.addMethod("class1", "methodName2", "methodType2");
       uml.addMethod("class1", "methodName3", "methodType3");

       System.out.println("adding 3 methods test: ");
       
       System.out.println(uml.getClasses());
       uml.deleteMethod("class1", "methodName");
       System.out.println();

       System.out.println("Deleting methodName method test: ");
       System.out.println(uml.getClasses());
       uml.renameMethod("class1", "methodName3", "newMethodName");
       System.out.println();

       System.out.println("renaming methodName3 test: ");
       System.out.println(uml.getClasses());
       uml.changeMethodType("class1", "newMethodName", "newType");
       System.out.println();

       System.out.println("new method type test: ");
       System.out.println(uml.getClasses());
       uml.addRelationship("class1", "class2", "AGGREGATION");
       System.out.println();

       System.out.println("add relatinship test: " + uml.getRelationships());
       

    }
 
}
