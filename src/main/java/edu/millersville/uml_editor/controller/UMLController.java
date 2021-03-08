package edu.millersville.uml_editor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

import javax.swing.JLabel;

public class UMLController {
    private UMLGUI gui;
    private UMLModel model;

    public UMLController(UMLModel m, UMLGUI gui) {
        this.model = m;
        this.gui = gui;
    }

    public ActionListener getSaveJSON(){
        return(ActionEvent e) -> {
            if(e.getActionCommand() == "Save"){
                //needs implementation
            }
        };
    }

    public ActionListener getLoadJSON(){
        return(ActionEvent e) -> {
            if(e.getActionCommand() == "Load"){
                //needs implementation
            }
            
        };
        
    }
    public ActionListener getHelp(){
        return(ActionEvent e) -> {
            if(e.getActionCommand() == "Help"){
                //needs implementation
            }
        };
    }

    public ActionListener getMainPageListener() {
        return (ActionEvent e) -> {
            switch (e.getActionCommand()) {
                case "Class":
                    gui.classPanel();
                    break;
                case "Method":
                    gui.methodPanel();
                    break;
                case "Field":
                    gui.fieldPanel();
                    break;
                case "Relationship":
                    gui.relPanel();
                    break;
                case "Print":
                    gui.printPanel();
                    break;
            }
        };
    }

    public ActionListener getClassPageListener(){
        return(ActionEvent e) -> {
            switch(e.getActionCommand()){
                case "Create a new Class":
                    gui.createClassPanel();
                    break;
                case "Delete a Class":
                    gui.deleteClassPanel();
                    break;
                case "Rename a Class":
                    gui.renameClassPanel();
                    break;
                case "<--":
                    gui.menuPanel();
                    break;
            }
        };
    }
    
    
    
    public ActionListener getMethodPageListener(){
        return(ActionEvent e) -> {
            switch(e.getActionCommand()){
                case "Create a new method":
                    gui.createMethodPanel();
                    break;
                case "Delete a method":
                    gui.deleteMethodPanel();
                    break;
                case "Rename a method":
                    gui.renameMethodPanel();
                    break;
                case "Parameters":
                	// implementation needed
                	break;
                case "<--":
                    gui.menuPanel();
                    break;
            }
        };
    }
    
    public ActionListener getFieldPageListener(){
        return(ActionEvent e) -> {
            switch(e.getActionCommand()){
                case "Add a field":
                    gui.createFieldPanel();
                    break;
                case "Delete a field":
                	gui.deleteFieldPanel();
                    break;
                case "Rename a field":
                    gui.renameFieldPanel();
                    break;
                case "Change the type of a field":
                	//
                	break;
                case "<--":
                    gui.menuPanel();
                    break;
            }
        };
    }

    public ActionListener getRelPageListener(){
        return(ActionEvent e) -> {
            switch(e.getActionCommand()){
                case "Create a new Relationship":
                    gui.createRelPanel();
                    break;
                case "Delete a Relationship":
                    gui.deleteRelPanel();
                    break;
                case "Change a Relationship Type":
                    gui.changeRelTypePanel();
                    break;
                case "<--":
                    gui.menuPanel();
                    break;
            }
        };
    }

    public ActionListener getPrintPageListener(){
        return(ActionEvent e) -> {
            switch(e.getActionCommand()){
                case "Print Classes":
                    //implementation needed
                    break;
                case "Print Classes and Methods":
                    //implementation needed
                    break;
                case "Print Relationships":
                    //implementation needed
                    break;
                case "<--":
                    gui.menuPanel();
                    break;
            }
        };
    }
    
    //////////////////////////////////
    //
    //	Class Calls
    //
    //////////////////////////////////

    public ActionListener createClassCall(){
        return (ActionEvent e) -> {
            String className = e.getActionCommand();
            if(!model.hasClass(className)){
                model.createNewClassGUI(className);
                gui.createdClassPanel();
            }
            else{
                gui.dupPanel();
            }
        };
    }
    
    
    public ActionListener deleteClassCall(){
        return (ActionEvent e) -> {
            String className = e.getActionCommand();
            if(model.hasClass(className)){
                model.deleteClassGUI(className);
                gui.deletedClassPanel();
            }
            else{
                gui.notExistPanel();
            }
        };
    }
    
    public ActionListener renameClassCall(){
        return (ActionEvent e) -> {
            gui.renameActionPerformed(e);
        };
    }

	//////////////////////////////////
	//
	//	Method Calls
	//
	//////////////////////////////////
    
    public ActionListener createMethodCall(){
        return (ActionEvent e) -> {
            gui.createMethodAction(e);
        };
    }
    
    public ActionListener deleteMethodCall(){
        return (ActionEvent e) -> {
            gui.deleteMethodAction(e);
        };
    }
    
    public ActionListener renameMethodCall(){
        return (ActionEvent e) -> {
            gui.renameMethodAction(e);
        };
    }
	   
	    
	//////////////////////////////////
	//
	//	Field Calls
	//
	//////////////////////////////////
    
    public ActionListener createFieldCall(){
        return (ActionEvent e) -> {
            gui.createFieldAction(e);
        };
    }
    
    public ActionListener deleteFieldCall(){
        return (ActionEvent e) -> {
            gui.deleteFieldAction(e);
        };
    }
    
    public ActionListener renameFieldCall(){
        return (ActionEvent e) -> {
            gui.renameFieldAction(e);
        };
    }
	    
	//////////////////////////////////
	//
	//	Relationship Calls
	//
	//////////////////////////////////
    
    public ActionListener createRelCall(){
        return (ActionEvent e) -> {
            gui.createRelAction(e);
        };
    }
    
    public ActionListener deleteRelCall(){
        return (ActionEvent e) -> {
        	String ID = e.getActionCommand();
            if(model.hasRelID(ID)){
                model.deleteRelationshipGUI(ID);
                gui.deletedRelPanel();
            }
            else{
                gui.noIDPanel();
            }
        };
    }
    
    public ActionListener changeTypeCall(){
        return (ActionEvent e) -> {
            gui.changeRelTypeAction(e);
        };
    }
    
}