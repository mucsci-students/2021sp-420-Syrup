package edu.millersville.uml_editor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.controller.*;

public class GUIView {
    private JFrame umlEditor = null;
    private JPanel menuPanel = null;
    
    private JPanel classPanel = null;
    private JPanel methodPanel = null;
    private JPanel fieldPanel = null;
    private JPanel relPanel = null;
    private JPanel printPanel = null;
    private JPanel helpPanel = null;
    
    private JPanel createClassPanel = null;
    private JPanel deleteClassPanel = null;
    private JPanel renameClassPanel = null;
    private JPanel createdClassPanel = null;
    private JPanel deletedClassPanel = null;
    private JPanel renamedClassPanel = null;
    
    private JPanel createRelPanel = null;
    private JPanel deleteRelPanel = null;
    private JPanel changeRelTypePanel = null;
    private JPanel changedRelTypePanel = null;
    
    private JPanel createFieldPanel = null;
    private JPanel createdFieldPanel = null;
    private JPanel deleteFieldPanel = null;
    private JPanel deletedFieldPanel = null;
    private JPanel renameFieldPanel = null;
    private JPanel renamedFieldPanel = null;
    private JPanel changeFieldTypePanel = null;
    private JPanel changedFieldTypePanel = null;
    
    private JPanel createMethodPanel = null;
    private JPanel createdMethodPanel = null;
    private JPanel deleteMethodPanel = null;
    private JPanel deletedMethodPanel = null;
    private JPanel renameMethodPanel = null;
    private JPanel renamedMethodPanel = null;
    
    private JPanel dupPanel = null;
    private JPanel notExistPanel = null;
    private JPanel notType = null;
    private JPanel hasID = null;
    private JPanel noID = null;
    
    private JTextField textBox1;
    private JTextField textBox2;
    private JTextField textBox3;
    private JTextField textBox4;    

    private UMLController controller;
    private UMLModel model;

    public void UMLGUI(UMLModel m) {
        this.model = m;
        this.controller = null;
    }

    
    //////////////////////////////////////////////////////////
    //
    //	menuPanel
    //
    ///////////////////////////////////////////////////////////
    public void menuPanel() {
       //checks to see if the panel was already created
       panelCheck(menuPanel);

        // view
        JButton classButton = new JButton("Class");
        JButton methButton = new JButton("Method");
        JButton fieldButton = new JButton("Field");
        JButton relButton = new JButton("Relationship");
        JButton printButton = new JButton("Print");

        // register controller to view
        classButton.addActionListener(controller.getMainPageListener());
        methButton.addActionListener(controller.getMainPageListener());
        fieldButton.addActionListener(controller.getMainPageListener());
        relButton.addActionListener(controller.getMainPageListener());
        printButton.addActionListener(controller.getMainPageListener());

        //MAIN Menu Page
        ///////////////
        // Heading/Labels
        ///////////////
        //creates the first line of text and changes the font
        JLabel welcome = new JLabel("Welcome to our UML Editor!", SwingConstants.CENTER);
        welcome.setFont(new Font("Serif", Font.BOLD, 20));

        //creates the second line of text and changes the font
        JLabel select = new JLabel("Select an Option!", SwingConstants.CENTER);
        select.setFont(new Font("Serif", Font.BOLD, 16));

        welcome.setVerticalAlignment(SwingConstants.BOTTOM);
        select.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Panel
        ///////////////
        menuPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        menuPanel.add(welcome);
        menuPanel.add(select);
        menuPanel.add(classButton);
        menuPanel.add(methButton);
        menuPanel.add(fieldButton);
        menuPanel.add(relButton);
        menuPanel.add(printButton);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));

        changePanel(menuPanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	classPanel
    //
    ///////////////////////////////////////////////////////////
    
    public void classPanel() {
        //checks to see if the panel was already created
        panelCheck(classPanel);
    
        // view
        JButton createClass = new JButton("Create a new Class");
        JButton deleteClass = new JButton("Delete a Class");
        JButton renameClass = new JButton("Rename a Class");
        JButton backButton = new JButton("<--");

        //register controller to view
        createClass.addActionListener(controller.getClassPageListener());
        deleteClass.addActionListener(controller.getClassPageListener());
        renameClass.addActionListener(controller.getClassPageListener());
        backButton.addActionListener(controller.getClassPageListener());

         //Class Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel classLabel = new JLabel("Class Functions:", SwingConstants.CENTER);
        classLabel.setFont(new Font("Serif", Font.BOLD, 20));
        classLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Panel
        ///////////////
        classPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        classPanel.add(classLabel);
        classPanel.add(createClass);
        classPanel.add(deleteClass);
        classPanel.add(renameClass);
        classPanel.add(backButton);
        classPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(classPanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	methodPanel
    //
    ///////////////////////////////////////////////////////////
    
    public void methodPanel() {
       //checks to see if the panel was already created
       panelCheck(methodPanel);

       //view
        JButton createMethod = new JButton("Create a new method");
        JButton deleteMethod = new JButton("Delete a method");
        JButton renameMethod = new JButton("Rename a method");
        JButton paramButton = new JButton("Parameters");
        JButton backButton = new JButton("<--");

        //register controller to view
        createMethod.addActionListener(controller.getMethodPageListener());
        deleteMethod.addActionListener(controller.getMethodPageListener());
        renameMethod.addActionListener(controller.getMethodPageListener());
        paramButton.addActionListener(controller.getMethodPageListener());
        backButton.addActionListener(controller.getMethodPageListener());

        //Method Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel methodLabel = new JLabel("Method Functions:", SwingConstants.CENTER);
        methodLabel.setFont(new Font("Serif", Font.BOLD, 20));

        methodLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Panel
        ///////////////
        methodPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        methodPanel.add(methodLabel);
        methodPanel.add(createMethod);
        methodPanel.add(deleteMethod);
        methodPanel.add(renameMethod);
        methodPanel.add(paramButton);
        
        methodPanel.add(backButton);
        methodPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(methodPanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	fieldPanel
    //
    ///////////////////////////////////////////////////////////
    
    public void fieldPanel() {
        //checks to see if the panel was already created
        panelCheck(fieldPanel);
 
        //view
         JButton createField = new JButton("Add a field");
         JButton deleteField = new JButton("Delete a field");
         JButton renameField = new JButton("Rename a field");
         JButton typeField = new JButton("Change the type of a field");
         JButton backButton = new JButton("<--");
 
         //register controller to view
         createField.addActionListener(controller.getFieldPageListener());
         deleteField.addActionListener(controller.getFieldPageListener());
         renameField.addActionListener(controller.getFieldPageListener());
         typeField.addActionListener(controller.getFieldPageListener());
         backButton.addActionListener(controller.getFieldPageListener());
 
         //Method Page
         ///////////////
         // Heading/Labels
         ///////////////
         JLabel fieldLabel = new JLabel("Field Functions:", SwingConstants.CENTER);
         fieldLabel.setFont(new Font("Serif", Font.BOLD, 20));
 
         fieldLabel.setVerticalAlignment(SwingConstants.BOTTOM);
 
         ///////////////
         // Panel
         ///////////////
         fieldPanel = new JPanel(new GridLayout(8, 1, 8, 8));
         fieldPanel.add(fieldLabel);
         fieldPanel.add(createField);
         fieldPanel.add(deleteField);
         fieldPanel.add(renameField);
         
         /*
          * COMMENTED OUT FIELD TYPE BUITTON 
          * ONLY FOR THIS SPRINT
          */
         
         // fieldPanel.add(typeField);
         fieldPanel.add(backButton);
         fieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
         changePanel(fieldPanel);
     }


    //////////////////////////////////////////////////////////
    //
    //	relPanel
    //
    ///////////////////////////////////////////////////////////
    
    public void relPanel() {
        //checks to see if the panel was already created
        panelCheck(classPanel);

        //view
        JButton createRel = new JButton("Create a new Relationship");
        JButton deleteRel = new JButton("Delete a Relationship");
        JButton changeRelType = new JButton("Change a Relationship Type");
        JButton backButton = new JButton("<--");

        //register the controller to view
        createRel.addActionListener(controller.getRelPageListener());
        deleteRel.addActionListener(controller.getRelPageListener());
        changeRelType.addActionListener(controller.getRelPageListener());
        backButton.addActionListener(controller.getRelPageListener());

        //Relationship Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel relLabel = new JLabel("Relationship Functions:", SwingConstants.CENTER);
        relLabel.setFont(new Font("Serif", Font.BOLD, 20));

        relLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Panel
        ///////////////
        relPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        relPanel.add(relLabel);
        relPanel.add(createRel);
        relPanel.add(deleteRel);
        relPanel.add(changeRelType);
        relPanel.add(backButton);
        relPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(relPanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	printPanel
    //
    ///////////////////////////////////////////////////////////
    
    public  void printPanel() {
        //checks to see if the panel was already created
        panelCheck(printPanel);

        //view
        JButton printClasses = new JButton("Print Classes");
        JButton printClassesMeth = new JButton("Print Classes and Methods");
        JButton printRel = new JButton("Print Relationships");
        JButton backButton = new JButton("<--");

        //register the controller to view
        printClasses.addActionListener(controller.getPrintPageListener());
        printClassesMeth.addActionListener(controller.getPrintPageListener());
        printRel.addActionListener(controller.getPrintPageListener());
        backButton.addActionListener(controller.getPrintPageListener());

        //Print Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel printLabel = new JLabel("Print Functions:", SwingConstants.CENTER);
        printLabel.setFont(new Font("Serif", Font.BOLD, 20));

        printLabel.setVerticalAlignment(SwingConstants.BOTTOM);


        ///////////////
        // Panel
        ///////////////
        printPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        printPanel.add(printLabel);
        printPanel.add(printClasses);
        printPanel.add(printClassesMeth);
        printPanel.add(printRel);
        printPanel.add(backButton);
        printPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(printPanel);
    }
	    
	    
	//////////////////////////////////////////////////////////
	//
	//	Help Panels
	//
	///////////////////////////////////////////////////////////
    
    public void helpClassPanel() {
        //checks to see if the panel was already created
        panelCheck(helpPanel);

        JButton backButton = new JButton("<--");
        JButton nextButton = new JButton("-->");

        //register the controller to view
        backButton.addActionListener(controller.getClassHelpListener());
        nextButton.addActionListener(controller.getClassHelpListener());

        //Print Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel classHelpLabel = new JLabel("In the 'Classes' button, you'll be able to do the following: ", SwingConstants.CENTER);
        JLabel cClassLabel = new JLabel(" -> Create a class ", SwingConstants.CENTER);
        JLabel rClassLabel = new JLabel(" -> Rename a class", SwingConstants.CENTER);
        JLabel dClassLabel = new JLabel(" -> Delete a class", SwingConstants.CENTER);
        
        classHelpLabel.setFont(new Font("Serif", Font.BOLD, 14));
        classHelpLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        cClassLabel.setFont(new Font("Serif", Font.BOLD, 14));
        cClassLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        rClassLabel.setFont(new Font("Serif", Font.BOLD, 14));
        rClassLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        dClassLabel.setFont(new Font("Serif", Font.BOLD, 14));
        dClassLabel.setVerticalAlignment(SwingConstants.BOTTOM);


        ///////////////
        // Panel
        ///////////////
        printPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        printPanel.add(classHelpLabel);
        printPanel.add(cClassLabel);
        printPanel.add(rClassLabel);
        printPanel.add(dClassLabel);
        printPanel.add(backButton);
        printPanel.add(nextButton);
        printPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(printPanel);
    }
    
    public void helpMethodPanel() {
        //checks to see if the panel was already created
        panelCheck(helpPanel);

        JButton backButton = new JButton("<--");
        JButton nextButton = new JButton("-->");

        //register the controller to view
        backButton.addActionListener(controller.getMethodHelpListener());
        nextButton.addActionListener(controller.getMethodHelpListener());

        //Print Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel methodHelpLabel = new JLabel("In the 'Method' button, you'll be able to do the following:", SwingConstants.CENTER);
        JLabel cMethodLabel = new JLabel(" -> Create a method ", SwingConstants.CENTER);
        JLabel rMethodLabel = new JLabel(" -> Rename a method", SwingConstants.CENTER);
        JLabel dMethodLabel = new JLabel(" -> Delete a method", SwingConstants.CENTER);
        JLabel pMethodLabel = new JLabel(" -> Modify parameters in a method", SwingConstants.CENTER);
        
        methodHelpLabel.setFont(new Font("Serif", Font.BOLD, 14));
        methodHelpLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        cMethodLabel.setFont(new Font("Serif", Font.BOLD, 14));
        cMethodLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        rMethodLabel.setFont(new Font("Serif", Font.BOLD, 14));
        rMethodLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        dMethodLabel.setFont(new Font("Serif", Font.BOLD, 14));
        dMethodLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        pMethodLabel.setFont(new Font("Serif", Font.BOLD, 14));
        pMethodLabel.setVerticalAlignment(SwingConstants.BOTTOM);


        ///////////////
        // Panel
        ///////////////
        printPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        printPanel.add(methodHelpLabel);
        printPanel.add(cMethodLabel);
        printPanel.add(rMethodLabel);
        printPanel.add(dMethodLabel);
        printPanel.add(pMethodLabel);
        printPanel.add(backButton);
        printPanel.add(nextButton);
        printPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(printPanel);
    }
    
    public void helpFieldPanel() {
        //checks to see if the panel was already created
        panelCheck(helpPanel);

        JButton backButton = new JButton("<--");
        JButton nextButton = new JButton("-->");

        //register the controller to view
        backButton.addActionListener(controller.getFieldHelpListener());
        nextButton.addActionListener(controller.getFieldHelpListener());

        //Print Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel fieldHelpLabel = new JLabel("In the 'Field' button, you'll be able to do the following:", SwingConstants.CENTER);
        JLabel cFieldLabel = new JLabel(" -> Create a field", SwingConstants.CENTER);
        JLabel rFieldLabel = new JLabel(" -> Rename a field", SwingConstants.CENTER);
        JLabel dFieldLabel = new JLabel(" -> Delete a field", SwingConstants.CENTER);
        
        fieldHelpLabel.setFont(new Font("Serif", Font.BOLD, 14));
        fieldHelpLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        cFieldLabel.setFont(new Font("Serif", Font.BOLD, 14));
        cFieldLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        rFieldLabel.setFont(new Font("Serif", Font.BOLD, 14));
        rFieldLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        dFieldLabel.setFont(new Font("Serif", Font.BOLD, 14));
        dFieldLabel.setVerticalAlignment(SwingConstants.BOTTOM);


        ///////////////
        // Panel
        ///////////////
        printPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        printPanel.add(fieldHelpLabel);
        printPanel.add(cFieldLabel);
        printPanel.add(rFieldLabel);
        printPanel.add(dFieldLabel);
        printPanel.add(backButton);
        printPanel.add(nextButton);
        printPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(printPanel);
    }
    
    public void helpRelPanel() {
        //checks to see if the panel was already created
        panelCheck(helpPanel);

        JButton backButton = new JButton("<--");
        JButton nextButton = new JButton("-->");

        //register the controller to view
        backButton.addActionListener(controller.getRelHelpListener());
        nextButton.addActionListener(controller.getRelHelpListener());

        //Print Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel relHelpLabel = new JLabel("In the 'Relationship' button, you'll be able to do the following:", SwingConstants.CENTER);
        JLabel cRelLabel = new JLabel(" -> Create a relationship", SwingConstants.CENTER);
        JLabel dRelLabel = new JLabel(" -> Delete a relationship", SwingConstants.CENTER);
        JLabel tRelLabel = new JLabel(" -> Change a relationship type", SwingConstants.CENTER);
        
        relHelpLabel.setFont(new Font("Serif", Font.BOLD, 14));
        relHelpLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        cRelLabel.setFont(new Font("Serif", Font.BOLD, 14));
        cRelLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        tRelLabel.setFont(new Font("Serif", Font.BOLD, 14));
        tRelLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        dRelLabel.setFont(new Font("Serif", Font.BOLD, 14));
        dRelLabel.setVerticalAlignment(SwingConstants.BOTTOM);


        ///////////////
        // Panel
        ///////////////
        printPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        printPanel.add(relHelpLabel);
        printPanel.add(cRelLabel);
        printPanel.add(dRelLabel);
        printPanel.add(tRelLabel);
        printPanel.add(backButton);
        printPanel.add(nextButton);
        printPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(printPanel);
    }
    
    public void helpPrintPanel() {
        //checks to see if the panel was already created
        panelCheck(helpPanel);

        JButton backButton = new JButton("<--");

        //register the controller to view
        backButton.addActionListener(controller.getPrintHelpListener());

        //Print Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel printHelpLabel = new JLabel("In the 'Print' button, you'll be able to do the following:", SwingConstants.CENTER);
        JLabel cPrintLabel = new JLabel(" -> Print all classes with its attributes", SwingConstants.CENTER);
        JLabel aPrintLabel = new JLabel(" -> Print a specific class with its attributes", SwingConstants.CENTER);
        JLabel rPrintLabel = new JLabel(" -> Print the relationships", SwingConstants.CENTER);
        
        printHelpLabel.setFont(new Font("Serif", Font.BOLD, 14));
        printHelpLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        cPrintLabel.setFont(new Font("Serif", Font.BOLD, 14));
        cPrintLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        aPrintLabel.setFont(new Font("Serif", Font.BOLD, 14));
        aPrintLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        
        rPrintLabel.setFont(new Font("Serif", Font.BOLD, 14));
        rPrintLabel.setVerticalAlignment(SwingConstants.BOTTOM);


        ///////////////
        // Panel
        ///////////////
        printPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        printPanel.add(printHelpLabel);
        printPanel.add(cPrintLabel);
        printPanel.add(aPrintLabel);
        printPanel.add(rPrintLabel);
        printPanel.add(backButton);
        printPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(printPanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	changePanel
    //
    ///////////////////////////////////////////////////////////
    
    public void changePanel(JPanel newPanel) {
        umlEditor.setContentPane(newPanel);
        umlEditor.validate();
        umlEditor.repaint();
    }

    public void panelCheck(JPanel checkPanel){
         /*Checks to see if the panel is already created
         * If the panel is created go to that panel
         * If not then proceed and create the panel
         */
        if (checkPanel != null) {
            changePanel(checkPanel);
            return;
        }
    }
    
    //////////////////////////////////////////////////////////
    //
    //	Create Class Panels
    //
    ///////////////////////////////////////////////////////////

    // Create Panel
    public void createClassPanel(){
        //checks to see if the panel was already created
        panelCheck(createClassPanel);

        JLabel create = new JLabel("Enter Class:");
        create.setFont(new Font("Serif", Font.BOLD, 16));
        

        JTextField newClass = new JTextField();
        newClass.addActionListener(controller.createClassCall());
        
        JButton backButton = new JButton("<--");
        backButton.addActionListener(controller.getPrintPageListener());


        createClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        createClassPanel.add(create);
        createClassPanel.add(newClass);
        createClassPanel.add(backButton);
        createClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createClassPanel);

    }
    
    // Created Panel
    public void createdClassPanel(){
        panelCheck(createdClassPanel);
        JLabel label = new JLabel("The class has been added!");
        createdClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        createdClassPanel.add(label);
        createdClassPanel.add(backButton);
        createdClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createdClassPanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	Delete Class Panels
    //
    ///////////////////////////////////////////////////////////
    
    // Delete Panel
    public void deleteClassPanel(){
        //checks to see if the panel was already created
        panelCheck(deleteClassPanel);

        JLabel delete = new JLabel("Delete Class:");
        delete.setFont(new Font("Serif", Font.BOLD, 16));
        
        JTextField deleteClass = new JTextField();
        deleteClass.addActionListener(controller.deleteClassCall());
        
        JButton backButton = new JButton("<--");
        backButton.addActionListener(controller.getPrintPageListener());

        deleteClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        deleteClassPanel.add(delete);
        deleteClassPanel.add(deleteClass);
        deleteClassPanel.add(backButton);
        deleteClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(deleteClassPanel);
    }
    
    // Deleted Panel
    public void deletedClassPanel(){
        panelCheck(deletedClassPanel);
        JLabel label = new JLabel("The class has been deleted!");
        deletedClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        deletedClassPanel.add(label);
        deletedClassPanel.add(backButton);
        deletedClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(deletedClassPanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	Rename Class Panels
    //
    ///////////////////////////////////////////////////////////
    
    // Renamed Panel
    public void renameClassPanel(){
        //checks to see if the panel was already created
        panelCheck(renameClassPanel);

        JLabel rename = new JLabel("The Class to be renamed: ");
        JLabel newName = new JLabel("The Class's new name: ");
        
        rename.setFont(new Font("Serif", Font.BOLD, 16));
        newName.setFont(new Font("Serif", Font.BOLD, 16));

        textBox1 = new JTextField();
        textBox2 = new JTextField();
        
        JButton renameButton = new JButton("Rename");
        renameButton.addActionListener(controller.renameClassCall());
        
        JButton backButton = new JButton("<--");
        backButton.addActionListener(controller.getPrintPageListener());
        
        renameClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        renameClassPanel.add(rename);
        renameClassPanel.add(textBox1);
        renameClassPanel.add(newName);
        renameClassPanel.add(textBox2);
        renameClassPanel.add(renameButton);
        renameClassPanel.add(backButton);
        renameClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(renameClassPanel);
    }
    
    // Renamed Action 
    public void renameActionPerformed(ActionEvent e)
    {
    	String className = textBox1.getText();
    	String newClassName = textBox2.getText();
    	
    	if(model.hasClass(className) && !model.hasClass(newClassName))
    	{
    		model.renameClassGUI(className, newClassName);
    		renamedClassPanel();
    	}
    }
    
    // Renamed Panel
    public void renamedClassPanel(){
        panelCheck(renamedClassPanel);
        JLabel label = new JLabel("The class has been renamed!");
        renamedClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        renamedClassPanel.add(label);
        renamedClassPanel.add(backButton);
        renamedClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(renamedClassPanel);
    }
    
    //////////////////////////////////////////////////////////
    //
    //	Create Method Panels
    //
    ///////////////////////////////////////////////////////////

    // Create Panel
    public void createMethodPanel(){
        //checks to see if the panel was already created
        panelCheck(createMethodPanel);

        JLabel className = new JLabel("Enter Class:");
        className.setFont(new Font("Serif", Font.BOLD, 16));
        
        JLabel methodName = new JLabel("Enter Method Name:");
        methodName.setFont(new Font("Serif", Font.BOLD, 16));
        
        JLabel methodType = new JLabel("Enter Method Type:");
        methodType.setFont(new Font("Serif", Font.BOLD, 16));
        
        JButton createButton = new JButton("Create");
        createButton.addActionListener(controller.createMethodCall());
        
        JButton backButton = new JButton("<--");
        backButton.addActionListener(controller.getPrintPageListener());
        
        textBox1 = new JTextField();
        textBox2 = new JTextField();
        textBox3 = new JTextField();

        createMethodPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        
        createMethodPanel.add(className);
        createMethodPanel.add(textBox1);
        
        createMethodPanel.add(methodName);
        createMethodPanel.add(textBox2);
        
        createMethodPanel.add(methodType);
        createMethodPanel.add(textBox3);
        
        createMethodPanel.add(createButton);
        createMethodPanel.add(backButton);
        
        createMethodPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createMethodPanel);

    }
    
    public void createMethodAction(ActionEvent e)
    {
    	String className = textBox1.getText();
    	String methodName = textBox2.getText();
    	String methodType = textBox3.getText();
    	
    	if (!model.hasClass(className))
    		notExistPanel();
    	
    	else if (model.hasMethod(className, methodName))
			dupPanel();
    	else
    	{
    		model.addMethod(className, methodName, methodType);
    		createdMethodPanel();
    	}
    	
    }
    
    // Created Panel
    public void createdMethodPanel(){
        panelCheck(createdMethodPanel);
        JLabel label = new JLabel("The method has been added!");
        createdMethodPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getMethodPageListener());

        createdMethodPanel.add(label);
        createdMethodPanel.add(backButton);
        createdMethodPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createdMethodPanel);
    }
	    
	//////////////////////////////////////////////////////////
	//
	//	Delete Method Panels
	//
	///////////////////////////////////////////////////////////
	
	// delete Panel
	public void deleteMethodPanel(){
		//checks to see if the panel was already created
		panelCheck(deleteMethodPanel);
		
		JLabel className = new JLabel("Enter Class:");
		className.setFont(new Font("Serif", Font.BOLD, 16));
		
		JLabel methodName = new JLabel("Enter Method Name:");
		methodName.setFont(new Font("Serif", Font.BOLD, 16));
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(controller.deleteMethodCall());
		
		JButton backButton = new JButton("<--");
		backButton.addActionListener(controller.getPrintPageListener());
		
		textBox1 = new JTextField();
		textBox2 = new JTextField();
		
		deleteMethodPanel = new JPanel(new GridLayout(8, 1, 8, 8));
		
		deleteMethodPanel.add(className);
		deleteMethodPanel.add(textBox1);
		
		deleteMethodPanel.add(methodName);
		deleteMethodPanel.add(textBox2);
		
		deleteMethodPanel.add(deleteButton);
		deleteMethodPanel.add(backButton);
		
		deleteMethodPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
		changePanel(deleteMethodPanel);
		
	}
	
	public void deleteMethodAction(ActionEvent e)
	{
		String className = textBox1.getText();
		String methodName = textBox2.getText();
		
		if (!model.hasClass(className) || !model.hasMethod(className, methodName))
			notExistPanel();
		else
		{
			model.deleteMethod(className, methodName);
			deletedMethodPanel();
		}
		
	}
	
	// deleted Panel
	public void deletedMethodPanel(){
		panelCheck(deletedMethodPanel);
		JLabel label = new JLabel("The method has been deleted!");
		deletedMethodPanel = new JPanel(new GridLayout(8, 1, 8, 8));
		
		JButton backButton = new JButton ("<--");
		backButton.addActionListener(controller.getMethodPageListener());
		
		deletedMethodPanel.add(label);
		deletedMethodPanel.add(backButton);
		deletedMethodPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
		changePanel(deletedMethodPanel);
	}
	
	//////////////////////////////////////////////////////////
	//
	//	Rename Method Panels
	//
	///////////////////////////////////////////////////////////
	
	// Rename Panel
	public void renameMethodPanel(){
		//checks to see if the panel was already created
		panelCheck(renameMethodPanel);
		
		JLabel className = new JLabel("Enter Class:");
		className.setFont(new Font("Serif", Font.BOLD, 16));
		
		JLabel methodName = new JLabel("Enter Current Method Name:");
		methodName.setFont(new Font("Serif", Font.BOLD, 16));
		
		JLabel newMethodName = new JLabel("Enter New Method Name:");
		newMethodName.setFont(new Font("Serif", Font.BOLD, 16));
		
		JButton renameButton = new JButton("Rename");
		renameButton.addActionListener(controller.renameMethodCall());
		
		JButton backButton = new JButton("<--");
		backButton.addActionListener(controller.getPrintPageListener());
		
		textBox1 = new JTextField();
		textBox2 = new JTextField();
		textBox3 = new JTextField();
		
		renameMethodPanel = new JPanel(new GridLayout(8, 1, 8, 8));
		
		renameMethodPanel.add(className);
		renameMethodPanel.add(textBox1);
		
		renameMethodPanel.add(methodName);
		renameMethodPanel.add(textBox2);
		
		renameMethodPanel.add(newMethodName);
		renameMethodPanel.add(textBox3);
		
		renameMethodPanel.add(renameButton);
		renameMethodPanel.add(backButton);
		
		renameMethodPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
		changePanel(renameMethodPanel);
		
	}
	
	public void renameMethodAction(ActionEvent e)
	{
		String className = textBox1.getText();
		String methodName = textBox2.getText();
		String newMethodName = textBox3.getText();
		
		if (!model.hasClass(className))
			notExistPanel();
		else if (!model.hasMethod(className, methodName))
			notExistPanel();
		else if (model.hasMethod(className, newMethodName))
			dupPanel();
		else
		{
			model.renameMethod(className, methodName, newMethodName);
			renamedMethodPanel();
		}
	
	}
	
	// Renamed Panel
	public void renamedMethodPanel(){
		panelCheck(renamedMethodPanel);
		JLabel label = new JLabel("The method has been renamed!");
		renamedMethodPanel = new JPanel(new GridLayout(8, 1, 8, 8));
		
		JButton backButton = new JButton ("<--");
		backButton.addActionListener(controller.getMethodPageListener());
		
		renamedMethodPanel.add(label);
		renamedMethodPanel.add(backButton);
		renamedMethodPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
		changePanel(renamedMethodPanel);
	}
	    	
	    
    //////////////////////////////////////////////////////////
    //
    //	Create Field Panels
    //
    ///////////////////////////////////////////////////////////

    // Create Panel
    public void createFieldPanel(){
        //checks to see if the panel was already created
        panelCheck(createFieldPanel);

        JLabel className = new JLabel("Enter Class:");
        className.setFont(new Font("Serif", Font.BOLD, 16));
        
        JLabel fieldName = new JLabel("Enter Field Name:");
        fieldName.setFont(new Font("Serif", Font.BOLD, 16));
        
        JLabel fieldType = new JLabel("Enter Field Type:");
        fieldType.setFont(new Font("Serif", Font.BOLD, 16));
        
        JButton createButton = new JButton("Create");
        createButton.addActionListener(controller.createFieldCall());
        
        JButton backButton = new JButton("<--");
        backButton.addActionListener(controller.getPrintPageListener());
        
        textBox1 = new JTextField();
        textBox2 = new JTextField();
        textBox3 = new JTextField();

        createFieldPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        
        createFieldPanel.add(className);
        createFieldPanel.add(textBox1);
        
        createFieldPanel.add(fieldName);
        createFieldPanel.add(textBox2);
        
        createFieldPanel.add(fieldType);
        createFieldPanel.add(textBox3);
        
        createFieldPanel.add(createButton);
        createFieldPanel.add(backButton);
        
        createFieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createFieldPanel);

    }
    
    public void createFieldAction(ActionEvent e)
    {
    	String className = textBox1.getText();
    	String fieldName = textBox2.getText();
    	String fieldType = textBox3.getText();
    	
    	if (!model.hasClass(className))
    		notExistPanel();
    	
    	else if (model.hasField(className, fieldName))
			dupPanel();
    	else
    	{
    		model.addField(className, fieldName, fieldType);
    		createdFieldPanel();
    	}
    	
    }
    
    // Created Panel
    public void createdFieldPanel(){
        panelCheck(createdFieldPanel);
        JLabel label = new JLabel("The field has been added!");
        createdFieldPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getFieldPageListener());

        createdFieldPanel.add(label);
        createdFieldPanel.add(backButton);
        createdFieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createdFieldPanel);
    }
    
	//////////////////////////////////////////////////////////
	//
	//	Delete Field Panels
	//
	///////////////////////////////////////////////////////////
	
	// delete Panel
	public void deleteFieldPanel(){
		//checks to see if the panel was already created
		panelCheck(deleteFieldPanel);
		
		JLabel className = new JLabel("Enter Class:");
		className.setFont(new Font("Serif", Font.BOLD, 16));
		
		JLabel fieldName = new JLabel("Enter Field Name:");
		fieldName.setFont(new Font("Serif", Font.BOLD, 16));
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(controller.deleteFieldCall());
		
		JButton backButton = new JButton("<--");
		backButton.addActionListener(controller.getPrintPageListener());
		
		textBox1 = new JTextField();
		textBox2 = new JTextField();
		
		deleteFieldPanel = new JPanel(new GridLayout(8, 1, 8, 8));
		
		deleteFieldPanel.add(className);
		deleteFieldPanel.add(textBox1);
		
		deleteFieldPanel.add(fieldName);
		deleteFieldPanel.add(textBox2);
		
		deleteFieldPanel.add(deleteButton);
		deleteFieldPanel.add(backButton);
		
		deleteFieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
		changePanel(deleteFieldPanel);
		
	}
	
	public void deleteFieldAction(ActionEvent e)
	{
		String className = textBox1.getText();
		String fieldName = textBox2.getText();
		
		if (!model.hasClass(className) || !model.hasField(className, fieldName))
			notExistPanel();
		else
		{
			model.deleteField(className, fieldName);
			deletedFieldPanel();
		}
		
	}
	
	// deleted Panel
	public void deletedFieldPanel(){
		panelCheck(deletedFieldPanel);
		JLabel label = new JLabel("The field has been deleted!");
		deletedFieldPanel = new JPanel(new GridLayout(8, 1, 8, 8));
		
		JButton backButton = new JButton ("<--");
		backButton.addActionListener(controller.getFieldPageListener());
		
		deletedFieldPanel.add(label);
		deletedFieldPanel.add(backButton);
		deletedFieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
		changePanel(deletedFieldPanel);
	}
	
	//////////////////////////////////////////////////////////
	//
	//	Rename Field Panels
	//
	///////////////////////////////////////////////////////////
	
	// Rename Panel
	public void renameFieldPanel(){
		//checks to see if the panel was already created
		panelCheck(renameFieldPanel);
		
		JLabel className = new JLabel("Enter Class:");
		className.setFont(new Font("Serif", Font.BOLD, 16));
		
		JLabel fieldName = new JLabel("Enter Current Field Name:");
		fieldName.setFont(new Font("Serif", Font.BOLD, 16));
		
		JLabel newFieldName = new JLabel("Enter New Field Name:");
		newFieldName.setFont(new Font("Serif", Font.BOLD, 16));
		
		JButton renameButton = new JButton("Rename");
		renameButton.addActionListener(controller.renameFieldCall());
		
		JButton backButton = new JButton("<--");
		backButton.addActionListener(controller.getPrintPageListener());
		
		textBox1 = new JTextField();
		textBox2 = new JTextField();
		textBox3 = new JTextField();
		
		renameFieldPanel = new JPanel(new GridLayout(8, 1, 8, 8));
		
		renameFieldPanel.add(className);
		renameFieldPanel.add(textBox1);
		
		renameFieldPanel.add(fieldName);
		renameFieldPanel.add(textBox2);
		
		renameFieldPanel.add(newFieldName);
		renameFieldPanel.add(textBox3);
		
		renameFieldPanel.add(renameButton);
		renameFieldPanel.add(backButton);
		
		renameFieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
		changePanel(renameFieldPanel);
	
	}
	
	public void renameFieldAction(ActionEvent e)
	{
		String className = textBox1.getText();
		String fieldName = textBox2.getText();
		String newFieldName = textBox3.getText();
		
		if (!model.hasClass(className))
			notExistPanel();
		else if (!model.hasField(className, fieldName))
			notExistPanel();
		else if (model.hasField(className, newFieldName))
			dupPanel();
		else
		{
			model.renameField(className, fieldName, newFieldName);
			renamedFieldPanel();
		}
	
	}
	
	// Renamed Panel
	public void renamedFieldPanel(){
		panelCheck(renamedFieldPanel);
		JLabel label = new JLabel("The field has been renamed!");
		renamedFieldPanel = new JPanel(new GridLayout(8, 1, 8, 8));
		
		JButton backButton = new JButton ("<--");
		backButton.addActionListener(controller.getFieldPageListener());
		
		renamedFieldPanel.add(label);
		renamedFieldPanel.add(backButton);
		renamedFieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
		changePanel(renamedFieldPanel);
	}
	

    //////////////////////////////////////////////////////////
    //
    //	Create Relationship Panels
    //
    ///////////////////////////////////////////////////////////
    
    // Create Panel
    public void createRelPanel(){
        //checks to see if the panel was already created
        panelCheck(createRelPanel);
        
        JLabel ID = new JLabel("Enter ID:");
        ID.setFont(new Font("Serif", Font.BOLD, 16));
        
        JLabel source = new JLabel("Enter Source:");
        source.setFont(new Font("Serif", Font.BOLD, 16));
        JLabel dest = new JLabel("Enter Destination:");
        dest.setFont(new Font("Serif", Font.BOLD, 16));
        
        JLabel type = new JLabel("Enter Type: (A, C, I, R)");
        type.setFont(new Font("Serif", Font.BOLD, 16));
        
        JButton createButton = new JButton("Create");
        createButton.addActionListener(controller.createRelCall());
        
        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        textBox1 = new JTextField();
        textBox2 = new JTextField();
        textBox3 = new JTextField();
        textBox4 = new JTextField();
        

        createRelPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        
        
        createRelPanel.add(ID);
        createRelPanel.add(textBox1);
        
        createRelPanel.add(source);
        createRelPanel.add(textBox2);
        
        createRelPanel.add(dest);
        createRelPanel.add(textBox3);
        
        createRelPanel.add(type);
        createRelPanel.add(textBox4);
        
        createRelPanel.add(createButton);
        createRelPanel.add(backButton);
        createRelPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createRelPanel);
    }
    
    // Rel Action
    public void createRelAction(ActionEvent e)
    {
    	String ID = textBox1.getText();
    	String sourceClass = textBox2.getText();
    	String destClass = textBox3.getText();
    	String type = textBox4.getText();
    	
    	if (!model.hasClass(sourceClass) || !model.hasClass(destClass))
    		notExistPanel();
    	else if (model.hasRelID(ID))
    		hasIDPanel();
    	else if (!type.equals("A") && !type.equals("C") && !type.equals("I") && !type.equals("R"))
    		notTypePanel();
    	else
    	{
    		model.createRelationshipGUI(sourceClass, destClass, ID, type);
			createdRelPanel();
    	}
    	
    }
    
    // Created Panel
    public void createdRelPanel(){
        panelCheck(renamedClassPanel);
        JLabel label = new JLabel("The relationship has been added!");
        renamedClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        renamedClassPanel.add(label);
        renamedClassPanel.add(backButton);
        renamedClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(renamedClassPanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	Delete Relationship Panels
    //
    ///////////////////////////////////////////////////////////
    
    // Delete Panel
    public void deleteRelPanel(){
        //checks to see if the panel was already created
        panelCheck(deleteRelPanel);

        JLabel ID = new JLabel("Enter ID:");
        ID.setFont(new Font("Serif", Font.BOLD, 16));

        JTextField IDText = new JTextField();
        IDText.addActionListener(controller.deleteRelCall());

        JButton backButton = new JButton("<--");
        backButton.addActionListener(controller.getPrintPageListener());
        
        deleteRelPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        deleteRelPanel.add(ID);
        deleteRelPanel.add(IDText);
        deleteRelPanel.add(backButton);
        deleteRelPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(deleteRelPanel);
    }
    
    // Created Panel
    public void deletedRelPanel(){
        panelCheck(renamedClassPanel);
        JLabel label = new JLabel("The relationship has been deleted!");
        renamedClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        renamedClassPanel.add(label);
        renamedClassPanel.add(backButton);
        renamedClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(renamedClassPanel);
    }
    
    //////////////////////////////////////////////////////////
    //
    //	Change Relationship Type Panels
    //
    ///////////////////////////////////////////////////////////

    public void changeRelTypePanel(){
        //checks to see if the panel was already created
        panelCheck(changeRelTypePanel);

        
        JLabel ID = new JLabel("Enter ID:");
        ID.setFont(new Font("Serif", Font.BOLD, 16));
        
        JLabel type = new JLabel("Enter New Type:");
        type.setFont(new Font("Serif", Font.BOLD, 16));

        textBox1 = new JTextField();
        textBox2 = new JTextField();
        
        JButton changeButton = new JButton("Change");
        changeButton.addActionListener(controller.changeTypeCall());
        
        JButton backButton = new JButton("<--");
        backButton.addActionListener(controller.getPrintPageListener());
        
       changeRelTypePanel = new JPanel(new GridLayout(8, 1, 8, 8));
       changeRelTypePanel.add(ID);
       changeRelTypePanel.add(textBox1);
       
       changeRelTypePanel.add(type);
       changeRelTypePanel.add(textBox2);
       
       changeRelTypePanel.add(changeButton);
       changeRelTypePanel.add(backButton);
       
       changeRelTypePanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
       changePanel(changeRelTypePanel);
    }
    
    // changed Relationship Action 
    public void changeRelTypeAction(ActionEvent e)
    {
    	String ID = textBox1.getText();
    	String type = textBox2.getText();
    	
    	if (!model.hasRelID(ID))
    		noIDPanel();
    	else if (!type.equals("A") && !type.equals("C") && !type.equals("I") && !type.equals("R"))
    		notTypePanel();
    	else
    	{
    		model.changeRelationshipTypeGUI(ID, type);
			changedRelTypePanel();
    	}
    }
    
    // Changed Type Panel
    public void changedRelTypePanel(){
        panelCheck(changedRelTypePanel);
        JLabel label = new JLabel("The type has been changed!");
        changedRelTypePanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        changedRelTypePanel.add(label);
        changedRelTypePanel.add(backButton);
        changedRelTypePanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(changedRelTypePanel);
    }

    //////////////////////////////////////////////////////////
    //
    //	Error Panels
    //
    ///////////////////////////////////////////////////////////
    
    // Duplicate Error
    public void dupPanel(){
        panelCheck(dupPanel);
        JLabel dup = new JLabel("This is a duplicate name");
        dupPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        dupPanel.add(dup);
        dupPanel.add(backButton);
        dupPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(dupPanel);

    }
    
    // Not Exist Error
    public void notExistPanel(){
        panelCheck(notExistPanel);
        JLabel dup = new JLabel("Name does not exist");
        notExistPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        notExistPanel.add(dup);
        notExistPanel.add(backButton);
        notExistPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(notExistPanel);

    }
    
    // Not a Type Error
    public void notTypePanel(){
        panelCheck(notType);
        JLabel type = new JLabel("This is not a type");
        notExistPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        notExistPanel.add(type);
        notExistPanel.add(backButton);
        notExistPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(notExistPanel);

    }
    
    // Has ID Error
    public void hasIDPanel(){
        panelCheck(hasID);
        JLabel type = new JLabel("ID already exists");
        notExistPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        notExistPanel.add(type);
        notExistPanel.add(backButton);
        notExistPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(notExistPanel);

    }
    
    // No ID Error
    public void noIDPanel(){
        panelCheck(noID);
        JLabel type = new JLabel("ID doesn't exists");
        notExistPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        notExistPanel.add(type);
        notExistPanel.add(backButton);
        notExistPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(notExistPanel);

    }
    
    //////////////////////////////////////////////////////////
    //
    //	Show
    //
    ///////////////////////////////////////////////////////////

    public void show() {
        
        ///////////////
        // MENU
        ///////////////

        //View
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem help = new JMenuItem("Help");
        menu.add(save);

        //registering the view to controller
        save.addActionListener(controller.getSaveJSON());
        load.addActionListener(controller.getLoadJSON());
        help.addActionListener(controller.getHelp());

        menu.add(load);
        menu.add(help);
        menuBar.add(menu);

        ///////////////
        // Frame
        ///////////////
        umlEditor = new JFrame("UML Editor");
        umlEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        umlEditor.setJMenuBar(menuBar);
        umlEditor.setSize(450, 600);
        umlEditor.setVisible(true);

        menuPanel();
    }
    
    //////////////////////////////////////////////////////////
    //
    //	Main
    //
    ///////////////////////////////////////////////////////////

    public static void drawGUI() {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
        // handle exception
        }

        UMLModel model = new UMLModel();
        UMLGUI gui = new UMLGUI(model);
        UMLController controller = new UMLController(model, gui);
        gui.setController(controller);
        gui.show();

    }

    private void setController(UMLController c) {
        this.controller = c;
    }

}