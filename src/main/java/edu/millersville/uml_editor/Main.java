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
       
       uml.addParameter("class1", "newMethodName", "param1", "param1Type");
       uml.addParameter("class1", "newMethodName", "param2", "param2Type");
       uml.addParameter("class1", "newMethodName", "param3", "param3Type");

       System.out.println("add parameter test: ");
       System.out.println(uml.getClasses());
       
       uml.deleteParameter("class1", "newMethodName", "param1");
       System.out.println("delete param1 parameter test: ");
       System.out.println(uml.getClasses());
       
       uml.addParameter("class1", "newMethodName", "param1", "param1Type");
       uml.renameParameter("class1", "newMethodName", "param1", "newParam1");
       System.out.println("rename param1 to newParam1 parameter test: ");
       System.out.println(uml.getClasses());
       
       uml.changeParameterType("class1", "newMethodName", "newParam1", "param1Newtype");
       System.out.println("change parameter type test: ");
       System.out.println(uml.getClasses());
       
       
       Method method1 = new Method("method1", "method1type");
       method1.addParameter("diffparam1", "diffparam1type");
       method1.addParameter("diffparam2", "diffparam2type");
       ArrayList<Parameter> tempList = method1.getParameters();
       uml.changeParameterList("class1", "newMethodName", tempList);
       System.out.println("change parameter list test: ");
       System.out.println(uml.getClasses());
       
       uml.addClass("class3");
       uml.addClass("class4");
      
       uml.addRelationship("class1", "class2", "AGGREGATION");
       uml.addRelationship("class3", "class4", "COMPOSITION");
       System.out.println();
       System.out.println("add relatinship test: " + uml.getRelationships());
       

       uml.deleteRelationship("class1", "class2");
       System.out.println();
       System.out.println("delete relatinship test: " + uml.getRelationships());
       
       uml.addClass("class5");
       uml.addClass("class6");
       uml.addRelationship("class1", "class2", "AGGREGATION");
       uml.addRelationship("class5", "class6", "INHERITANCE");
       uml.changeRelationshipType("class1", "class2", "REALIZATION");
       System.out.println();
       System.out.println("change relatinship type test: " + uml.getRelationships());
       
       
       uml.addField("class2", "field1Name", "field1Type");
       uml.addField("class2", "field2Name", "field2Type");
       uml.addField("class2", "field3Name", "field3Type");
       System.out.println("add field test: ");
       System.out.println(uml.getClasses());

       uml.deleteField("class2", "field1Name");
       System.out.println("delete field test: ");
       System.out.println(uml.getClasses());
      
       
       uml.renameField("class2", "field2Name", "newfieldName");
       System.out.println("rename field test: ");
       System.out.println(uml.getClasses());
       
       
       uml.changeFieldType("class2", "newfieldName", "newType");
       System.out.println("change field type test: ");
       System.out.println(uml.getClasses());
    }
 
}
