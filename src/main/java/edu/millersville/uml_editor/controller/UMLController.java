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
                    gui.methPanel();
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
    public ActionListener getMethPageListener(){
        return(ActionEvent e) -> {
            switch(e.getActionCommand()){
                case "Create a new method":
                    //implementation needed
                    break;
                case "Delete a method":
                    //implementation needed
                    break;
                case "Rename a method":
                    //implementation needed
                    break;
                case "Add method parameter(s)":
                    //implementation needed
                    break;
                case "Delete method parameter(s)":
                    //implementation needed
                    break;
                case "Change method parameter(s)":
                    //implementation needed
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
