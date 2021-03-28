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

   /* public ActionListener getSaveJSON(){
        return(ActionEvent e) -> {
        	switch (e.getActionCommand()) {
            case "Save":
                gui.savePanel();
                break;
            case "<--":
                gui.methodPanel();
                break;
        	}
        };
    }

    public ActionListener getLoadJSON(){
    	 return(ActionEvent e) -> {
         	switch (e.getActionCommand()) {
             case "Load":
                 gui.loadPanel();
                 break;
             case "<--":
                 gui.methodPanel();
                 break;
         	}
         };
        
    }
    public ActionListener getHelp(){
        return(ActionEvent e) -> {
            if(e.getActionCommand() == "Help"){
            	gui.helpClassPanel();
            }
        };
    }*/
    
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
            //gui.deleteFieldAction();
        };
    }
    
    public ActionListener renameFieldCall(){
        return (ActionEvent e) -> {
            //gui.renameFieldAction();
        };
    }
    

	
////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////OLD CODE//////////////////////////////////////////////////////////
   /* public ActionListener getMainPageListener() {
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
                	gui.paramPanel();
                	break;
                case "<--":
                    gui.menuPanel();
                    break;
            }
        };
    }
    
    public ActionListener getParamPageListener(){
        return(ActionEvent e) -> {
            switch(e.getActionCommand()){
                case "Delete a parameter":
                	gui.deleteParamPanel();
                    break;
                case "Delete a parameter list":
                	gui.deleteAllParamPanel();
                    break;
                case "Change a parameter":
                	gui.changeParamPanel();
                    break;
                case "Change a parameter list":
                	gui.changeParamListPanel();
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
    
    public ActionListener createdMethodCall(){
        return (ActionEvent e) -> {
            gui.createdMethodPanel();
        };
    }
    
    public ActionListener addParamInMethodCall(){
        return (ActionEvent e) -> {
            gui.addMethodHelper();
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
	//	Parameter Calls
	//
	//////////////////////////////////
	   
    public ActionListener deleteParamCall(){
        return (ActionEvent e) -> {
            gui.deleteParamAction(e);
        };
    }
    
    public ActionListener deleteAllParamCall(){
        return (ActionEvent e) -> {
            gui.deleteAllParamAction(e);
        };
    }
    
    public ActionListener changeParamCall(){
        return (ActionEvent e) -> {
            gui.changeParamAction(e);
        };
    }
    
    public ActionListener changeAllParamCall(){
        return (ActionEvent e) -> {
            gui.changeParamListAction(e);
        };
    }
    
    public ActionListener addParamToListCall(){
        return (ActionEvent e) -> {
            gui.addParamHelper();
        };
    }
    
    public ActionListener doneParamCall(){
        return (ActionEvent e) -> {
            gui.changedParamListPanel();
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
    
	//////////////////////////////////
	//
	//	Help Listeners
	//
	//////////////////////////////////
	
	public ActionListener getClassHelpListener(){
		return(ActionEvent e) -> {
		switch(e.getActionCommand()){
			case "-->":
				gui.helpMethodPanel();
			break;
			case "<--":
				gui.menuPanel();
			break;
			}
		};
	}
	
	public ActionListener getMethodHelpListener(){
		return(ActionEvent e) -> {
			switch(e.getActionCommand()){
				case "-->":
					gui.helpFieldPanel();
				break;
				case "<--":
					gui.menuPanel();
				break;
			}
		};
	}
	
	public ActionListener getFieldHelpListener(){
		return(ActionEvent e) -> {
			switch(e.getActionCommand()){
				case "-->":
					gui.helpRelPanel();
				break;
				case "<--":
					gui.menuPanel();
				break;
			}
		};
	}
	
	public ActionListener getRelHelpListener(){
		return(ActionEvent e) -> {
			switch(e.getActionCommand()){
				case "-->":
					gui.helpPrintPanel();
				break;
				case "<--":
					gui.menuPanel();
				break;
			}
		};
	}
	
	public ActionListener getPrintHelpListener(){
		return(ActionEvent e) -> {
			switch(e.getActionCommand()){
				case "<--":
					gui.menuPanel();
				break;
			}
		};
	}
	
	//////////////////////////////////
	//
	//	Save Calls
	//
	//////////////////////////////////
	
	public ActionListener savePageCall(){
		return (ActionEvent e) -> {
			gui.saveAction();
		};
	}
	
	//////////////////////////////////
	//
	//	Load Calls
	//
	//////////////////////////////////
	
	public ActionListener loadPageCall(){
		return (ActionEvent e) -> {
			gui.loadAction();
	};
}
*/
}
