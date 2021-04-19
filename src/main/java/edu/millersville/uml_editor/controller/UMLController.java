package edu.millersville.uml_editor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

import javax.swing.JLabel;

public class UMLController {
    private UMLModel model;
    private GUI gui;

    public UMLController(UMLModel m, GUI newGUI) {
        this.model = m;
        this.gui = newGUI;
    }
    
	////////////////////////////////
	//
	// Menu drop down 
	//
	////////////////////////////////
    
    public ActionListener helpCommand(){
        return(ActionEvent e) -> {
            if(e.getActionCommand() == "Help"){
            	gui.helpPanel();
            }
        };
    }
    
    public ActionListener closeHelp(){
        return(ActionEvent e) -> {
            if(e.getActionCommand() == "Close"){
            	gui.closeHelpPanel();
            }
        };
    }
    
    public ActionListener exportImageCall(){
        return (ActionEvent e) -> {
            gui.exportImageAction();
        };
    }
	////////////////////////////////
	//
	// Print class box
	//
	////////////////////////////////
    public ActionListener printClassListener(){
        return(ActionEvent e) -> {
            if(e.getActionCommand() == "Add Class"){
            	String className = "New Class";
            	if(!model.hasClass(className)){
            		gui.classDupFalse();
                    model.createNewClassGUI(className);
                    gui.printClassBox();
            	}
            	else
            		gui.classDupTrue();
            }
        };
    }
    
	////////////////////////////////
	//
	// Popup menu: Class
	//
	////////////////////////////////
    
    public ActionListener deleteClassCall(){
        return (ActionEvent e) -> {
        	String className = gui.delClassGet();
            if(model.hasClass(className)){
            	gui.notExistFalse();
                model.deleteClassGUI(className);
                gui.deleteClassAction();
            }
            else{
                gui.notExistTrue();
            }
        };
    }
    
    public ActionListener renameClassCall(){
        return (ActionEvent e) -> {
            gui.renameActionPerformed();
        };
    }
    
	////////////////////////////////
	//
	// Popup menu: Method
	//
	////////////////////////////////
    
    public ActionListener addMethodCall(){
        return (ActionEvent e) -> {
            gui.addMethodAction();
        };
    }
    
    public ActionListener addParamInMethodCall(){
        return (ActionEvent e) -> {
            gui.addParamToList();
        };
    }
    
    public ActionListener deleteMethodCall(){
        return (ActionEvent e) -> {
            gui.deleteMethodAction();
        };
    }
    
    public ActionListener renameMethodCall(){
        return (ActionEvent e) -> {
            gui.renameMethodAction();
        };
    }
	    
	////////////////////////////////
	//
	// Popup menu: Field
	//
	////////////////////////////////
    
    public ActionListener createFieldCall(){
        return (ActionEvent e) -> {
            gui.createFieldAction();
        };
    }
    
    public ActionListener deleteFieldCall(){
        return (ActionEvent e) -> {
            gui.deleteFieldAction();
        };
    }
    
    public ActionListener renameFieldCall(){
        return (ActionEvent e) -> {
            gui.renameFieldAction();
        };
    }
    
    ////////////////////////////////
	//
	// Popup menu: Relationship
	//
	////////////////////////////////
    
    public ActionListener createRelCall(){
        return (ActionEvent e) -> {
            gui.createRelAction();
        };
    }
    
    public ActionListener deleteRelCall(){
        return (ActionEvent e) -> {
        	gui.removeArrow();
        };
    }
    
    public ActionListener changeTypeCall(){
        return (ActionEvent e) -> {
            gui.changeRelTypeAction();
        };
    }
}