package edu.millersville.uml_editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                case "Attribute":
                    gui.attrPanel();
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
    public ActionListener getAttrPageListener(){
        return(ActionEvent e) -> {
            switch(e.getActionCommand()){
                case "Create a new Attribute":
                    //implementation needed
                    break;
                case "Delete a Attribute":
                    //implementation needed
                    break;
                case "Rename a Attribute":
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
                case "Print Classes and Attributes":
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
                model.createNewClass(className);
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
                model.deleteClass(className);
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
    
    
    
}
