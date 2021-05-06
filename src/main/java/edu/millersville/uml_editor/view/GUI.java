package edu.millersville.uml_editor.view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;

import java.io.File;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.controller.*;

public class GUI implements ViewInterface{
	private JFrame Uml_Editor;
	private JFrame help;
	
	private JLabel classDupLabel = null;

	//Textfield declarations
	private JTextField textBoxClassAdd;
    private JTextField textBoxClassDel;
    private JTextField renameClassOld;
    private JTextField renameClassNew;
    
	private JTextField addMethodCN;
	private JTextField addMethodName;
    private JTextField addMethodType;
    private JTextField paramName;
    private JTextField paramType;
    private JTextField delMethodCN;
    private JTextField delMethodName;
    private JTextField renClassName;
    private JTextField renameMethodNewName;
    private JTextField renameMethodOldName;
    
    private JTextField addFieldCN;
	private JTextField addFieldName;
    private JTextField addFieldType;
	private JTextField deleteFieldClassName;
    private JTextField deleteFieldName;
    private JTextField renameFieldCN;
	private JTextField fieldCurrent;
    private JTextField fieldNew;
    
    private JTextField textBoxExportImage;
    
    private JTextField addRelID;
    private JTextField addRelSource;
    private JTextField addRelDest;
    private JTextField addRelType;
    private JTextField delRel;
    private JTextField changeRelID;
    private JTextField newRelType;
    
    private GroupLayout groupLayout;
    
    //JMenu declarations
    private JMenu classOption;
    private JMenu addClass;
    private JMenu deleteClass;
    private JMenu renameClass;
    private JMenu method;
    private JMenu addMethod;
    private JMenu deleteMethod;
    private JMenu renameMethod;
    private JMenu field;
    private JMenu addField;
    private JMenu deleteField;
    private JMenu renameField;
    private JMenu rel;
    private JMenu addRel;
    private JMenu deleteRel;
    private JMenu changeRelType;
    private JMenu exportImage;
    private JMenu menu;
    
    private Map<String, classBox> boxMap;
    private Map<String, Arrow> arrowMap;
    
    private Vector<String> paramListName = new Vector<String>();
    private Vector<String> paramListType = new Vector<String>();
    String[] nameArray;
    String[] typeArray;
    
    private UMLController controller;
    private UMLModel model;
    private classBox box;

    public GUI(UMLModel m) {
        this.model = m;
        this.controller = null;
        boxMap = new HashMap<String, classBox>();
        arrowMap = new HashMap<String, Arrow>();
    }

	/**
	 * Launch the application.
	 */
    public void drawGUI() {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
        // handle exception
        }

        UMLModel model = new UMLModel();
        GUI gui = new GUI(model);
        UMLController controller = new UMLController(model, gui);
        gui.setController(controller);
        gui.initialize();

    }

    private void setController(UMLController c) {
        this.controller = c;
    }

	/**
	 * Create the application.
	 */
	public GUI() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        /////////////////////////////////////
		//
        // Frame Initialization
		//
        /////////////////////////////////////
		Uml_Editor = new JFrame();
		Uml_Editor.setTitle("Uml_Editor");
		Uml_Editor.setBounds(100, 100, 1266, 683);
		Uml_Editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Uml_Editor.setVisible(true);
		
        classDupLabel = new JLabel("");
		classDupLabel.setFont(new Font("Serif", Font.BOLD, 16));
		classDupLabel.setForeground(Color.RED);

		////////////////////////////////////////
		//
        //MenuBar
		//
        ////////////////////////////////////////
		
		JMenuBar menuBar = new JMenuBar();
		Uml_Editor.setJMenuBar(menuBar);
		
		menu = new JMenu("Menu");
		menuBar.add(menu);
		JMenuItem load = new JMenuItem("Save");
		menu.add(load);
		JMenuItem save = new JMenuItem("Load");
		menu.add(save);
		JMenuItem help = new JMenuItem("Help");
		menu.add(help);
		help.addActionListener(controller.helpCommand());
		exportImage = new JMenu("Export as Image");
		
		////////////////////////////////
		//
		// Export Option
		//
		////////////////////////////////
		
		JLabel directoryLabel = new JLabel("Directory: ");
		directoryLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		textBoxExportImage = new JTextField();
		textBoxExportImage.setColumns(15);
		
		JButton exportButton = new JButton("Export");
		
		exportImage.add(directoryLabel);
		exportImage.add(textBoxExportImage);
		exportImage.add(exportButton);
		
		menu.add(exportImage);
		exportButton.addActionListener(controller.exportImageCall());
		
		////////////////////////////////
		//
		// Class Option
		//
		////////////////////////////////
		
		classOption = new JMenu("Class");
        menuBar.add(classOption);
        
		////////////////////////////////
		//
		// Add Class Option
		//
		////////////////////////////////
        
        JLabel classNameAdd = new JLabel("Enter Class Name:");
        classNameAdd.setFont(new Font("Serif", Font.BOLD, 12));
        
        JButton classAddButton = new JButton("Add");
        
        addClass = new JMenu("Add");
        classOption.add(addClass);
        
        addClass.add(classNameAdd);
        textBoxClassAdd = new JTextField();
		textBoxClassAdd.setColumns(15);
		addClass.add(textBoxClassAdd);
		addClass.add(classAddButton);
		addClass.add(classDupLabel);
		classAddButton.addActionListener(controller.addClassCall());
        
		////////////////////////////////
		//
		// Delete Class Option
		//
		////////////////////////////////
        
        JLabel classNameDel = new JLabel("Enter Class Name:");
        classNameDel.setFont(new Font("Serif", Font.BOLD, 12));
        
        JButton classDelButton = new JButton("Delete");
        
        deleteClass = new JMenu("Delete");
        classOption.add(deleteClass);
        
        deleteClass.add(classNameDel);
        textBoxClassDel = new JTextField();
		textBoxClassDel.setColumns(15);
		deleteClass.add(textBoxClassDel);
		deleteClass.add(classDelButton);
		deleteClass.add(classDupLabel);
		classDelButton.addActionListener(controller.deleteClassCall());
        
		////////////////////////////////
		//
		// Rename Class Option
		//
		////////////////////////////////
        
        JLabel oldClassName = new JLabel("Old Class Name:");
		oldClassName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel newClassName = new JLabel("New Class Name:");
		newClassName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton renameClassButton = new JButton("Rename");
		
        renameClass = new JMenu("Rename");
        classOption.add(renameClass);
        renameClassOld = new JTextField();
		renameClassOld.setColumns(15);
		renameClass.add(oldClassName);
		renameClass.add(renameClassOld);
		renameClass.add(newClassName);
		renameClassNew = new JTextField();
		renameClassNew.setColumns(15);
		renameClass.add(renameClassNew);
		renameClass.add(renameClassButton);
		renameClassButton.addActionListener(controller.renameClassCall());
		
		////////////////////////////////
		//
		// Method Option
		//
		////////////////////////////////
		
		method = new JMenu("Method");
        menuBar.add(method);
        
		////////////////////////////////
		//
		// Add Method Class Option
		//
		////////////////////////////////
		
		addMethod = new JMenu("Add");
		method.add(addMethod);
		
		JLabel addMethodClassName = new JLabel("Class Name:");
		addMethodClassName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel methodName = new JLabel("Method Name:");
		methodName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel methodType = new JLabel("Method Type:");
		methodType.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel paramNameLabel = new JLabel("Parameter Name:");
		paramNameLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel paramTypeLabel = new JLabel("Parameter Type:");
		paramTypeLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton paramList = new JButton("Add Parameter to List");
		JButton done = new JButton("Done");
		
		addMethod.add(addMethodClassName);
		addMethodCN = new JTextField();
		addMethodCN.setColumns(15);
		addMethod.add(addMethodCN);
		addMethodName = new JTextField();
		addMethodName.setColumns(15);
		addMethod.add(methodName);
		addMethod.add(addMethodName);
		addMethod.add(methodType);
		addMethodType = new JTextField();
		addMethodType.setColumns(15);
		addMethod.add(addMethodType);
		
		// Adding parameters to list
		addMethod.add(paramNameLabel);
		paramName = new JTextField();
		paramName.setColumns(15);
		addMethod.add(paramName);
		addMethod.add(paramTypeLabel);
		paramType = new JTextField();
		paramType.setColumns(15);
		addMethod.add(paramType);
		addMethod.add(paramList);
		addMethod.add(done);
		paramList.addActionListener(controller.addParamInMethodCall());
		done.addActionListener(controller.addMethodCall());
		
        
		////////////////////////////////
		//
		// Delete Method Option
		//
		////////////////////////////////
		
		deleteMethod = new JMenu("Delete");
        method.add(deleteMethod);
        
        JLabel delMethodClassName = new JLabel("Class Name:");
		delMethodClassName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel delMethodNameLabel = new JLabel("Method Name:");
		delMethodNameLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
        JButton methodDelButton = new JButton("Delete");
		
		delMethodCN = new JTextField();
		delMethodCN.setColumns(15);
		deleteMethod.add(delMethodClassName);
		deleteMethod.add(delMethodCN);
		deleteMethod.add(delMethodNameLabel);
		delMethodName = new JTextField();
		delMethodName.setColumns(15);
		deleteMethod.add(delMethodName);
		deleteMethod.add(methodDelButton);
		methodDelButton.addActionListener(controller.deleteMethodCall());
		
		////////////////////////////////
		//
		// Rename Method Option
		//
		////////////////////////////////
		
		renameMethod = new JMenu("Rename");
        method.add(renameMethod);
        
        JLabel renMethodClassName = new JLabel("Class Name:");
		renMethodClassName.setFont(new Font("Serif", Font.BOLD, 12));
		
        JLabel methodOldName = new JLabel("Current Method Name:");
		methodOldName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel methodNewName = new JLabel("New Method Name:");
		methodNewName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton rename = new JButton("Rename");
		
		renameMethod.add(renMethodClassName);
		renClassName = new JTextField();
		renClassName.setColumns(15);
		renameMethod.add(renClassName);
		renameMethodOldName = new JTextField();
		renameMethodOldName.setColumns(15);
		renameMethod.add(methodOldName);
		renameMethod.add(renameMethodOldName);
		renameMethod.add(methodNewName);
		renameMethodNewName = new JTextField();
		renameMethodNewName.setColumns(15);
		renameMethod.add(renameMethodNewName);
		renameMethod.add(rename);
		rename.addActionListener(controller.renameMethodCall());
		
		////////////////////////////////
		//
		// Field Option
		//
		////////////////////////////////
		
		field = new JMenu("Field");
        menuBar.add(field);
        
		////////////////////////////////
		//
		// Add Field Option
		//
		////////////////////////////////
		
		addField = new JMenu("Add");
        field.add(addField);
        
        JLabel addFieldClassLabel = new JLabel("Class Name:");
		addFieldClassLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
        JLabel addFieldNameLabel = new JLabel("Field Name:");
		addFieldNameLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel addFieldTypeLabel = new JLabel("Field Type:");
		addFieldTypeLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton createField = new JButton("Add");
		
		addField.add(addFieldClassLabel);
		addFieldCN = new JTextField();
		addFieldCN.setColumns(15);
		addField.add(addFieldCN);
		addFieldName = new JTextField();
		addFieldName.setColumns(15);
		addField.add(addFieldNameLabel);
		addField.add(addFieldName);
		addField.add(addFieldTypeLabel);
		addFieldType = new JTextField();
		addFieldType.setColumns(15);
		addField.add(addFieldType);
		addField.add(createField);
		createField.addActionListener(controller.createFieldCall());
		
		////////////////////////////////
		//
		// Delete Field Option
		//
		////////////////////////////////
		
		deleteField = new JMenu("Delete");
        field.add(deleteField);
        
        JLabel deleteFieldNameLabel = new JLabel("Class Name:");
		deleteFieldNameLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel deleteFieldTypeLabel = new JLabel("Field Name:");
		deleteFieldTypeLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton deleteFieldButton = new JButton("Delete");
		
		deleteFieldClassName = new JTextField();
		deleteFieldClassName.setColumns(15);
		deleteField.add(deleteFieldNameLabel);
		deleteField.add(deleteFieldClassName);
		deleteField.add(deleteFieldTypeLabel);
		deleteFieldName = new JTextField();
		deleteFieldName.setColumns(15);
		deleteField.add(deleteFieldName);
		deleteField.add(deleteFieldButton);
		deleteFieldButton.addActionListener(controller.deleteFieldCall());

		////////////////////////////////
		//
		// Rename Field Option
		//
		////////////////////////////////
		
		renameField = new JMenu("Rename");
        field.add(renameField);
        
        JLabel renameFieldClassLabel = new JLabel("Class Name:");
        renameFieldClassLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel fieldCurrentName = new JLabel("Current Field Name:");
		fieldCurrentName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel fieldNewName = new JLabel("New Field Name:");
		fieldNewName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton renameFieldButton = new JButton("Rename");
		
		renameField.add(renameFieldClassLabel);
		renameFieldCN = new JTextField();
		renameFieldCN.setColumns(15);
		renameField.add(renameFieldCN);
		fieldCurrent = new JTextField();
		fieldCurrent.setColumns(15);
		renameField.add(fieldCurrentName);
		renameField.add(fieldCurrent);
		renameField.add(fieldNewName);
		fieldNew = new JTextField();
		fieldNew.setColumns(15);
		renameField.add(fieldNew);
		renameField.add(renameFieldButton);
		renameFieldButton.addActionListener(controller.renameFieldCall());
        
		////////////////////////////////
		//
		// Relationship Option
		//
		////////////////////////////////
		
		rel = new JMenu("Relationship");
        menuBar.add(rel);
        
        addRel = new JMenu("Add");
		rel.add(addRel);
		deleteRel = new JMenu("Delete");
		rel.add(deleteRel);
		changeRelType = new JMenu("Change Type");
		rel.add(changeRelType);
		
		////////////////////////////////
		//
		// Add Relationship Option
		//
		////////////////////////////////
		
		JLabel relIDLabel = new JLabel("ID:");
		relIDLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel relSourceLabel = new JLabel("Source Class Name:");
		relSourceLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel relDestLabel = new JLabel("Destination Class Name:");
		relDestLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel relTypeLabel = new JLabel("Relationship Type: (A, C, I, R)");
		relTypeLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton relAddButton = new JButton("Add");
		
		addRelID = new JTextField();
		addRelID.setColumns(15);
		
		addRelSource = new JTextField();
		addRelSource.setColumns(15);
		
		addRelDest = new JTextField();
		addRelDest.setColumns(15);
		
		addRelType = new JTextField();
		addRelType.setColumns(15);
		
		addRel.add(relIDLabel);
		addRel.add(addRelID);
		addRel.add(relSourceLabel);
		addRel.add(addRelSource);
		addRel.add(relDestLabel);
		addRel.add(addRelDest);
		addRel.add(relTypeLabel);
		addRel.add(addRelType);
		addRel.add(relAddButton);
		relAddButton.addActionListener(controller.createRelCall());
		
		////////////////////////////////
		//
		// Delete Relationship Option
		//
		////////////////////////////////
		
		JLabel delRelIDLabel = new JLabel("ID:");
		delRelIDLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton relDelButton = new JButton("Delete Relationship");
		
		delRel = new JTextField();
		delRel.setColumns(15);
		
		deleteRel.add(delRelIDLabel);
		deleteRel.add(delRel);
		deleteRel.add(relDelButton);
		relDelButton.addActionListener(controller.deleteRelCall());
		
		////////////////////////////////
		//
		// Change Relationship Type Option
		//
		////////////////////////////////
		
		JLabel typeRelIDLabel = new JLabel("ID:");
		typeRelIDLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel newRelTypeLabel = new JLabel("New Type:");
		newRelTypeLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton relTypeButton = new JButton("Change Relationship Type");
		
		changeRelID = new JTextField();
		changeRelID.setColumns(15);
		
		newRelType = new JTextField();
		newRelType.setColumns(15);
		
		changeRelType.add(typeRelIDLabel);
		changeRelType.add(changeRelID);
		changeRelType.add(newRelTypeLabel);
		changeRelType.add(newRelType);
		changeRelType.add(relTypeButton);
		relTypeButton.addActionListener(controller.changeTypeCall());
		
        ////////////////////////////////
        //
		// addClassButton
        //
		////////////////////////////////
		
		JButton addClassButton = new JButton("Add Class");
		addClassButton.addActionListener(controller.printClassListener());

        GroupLayout gl_Uml_Panel = new GroupLayout(Uml_Editor.getContentPane());
		gl_Uml_Panel.setHorizontalGroup(
			gl_Uml_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Uml_Panel.createSequentialGroup()
					//.addComponent(addClassButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addComponent(classDupLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
		));
		gl_Uml_Panel.setVerticalGroup(
			gl_Uml_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Uml_Panel.createSequentialGroup()
					.addGroup(gl_Uml_Panel.createParallelGroup(Alignment.BASELINE)
						//.addComponent(addClassButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(classDupLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						
		)));
		Uml_Editor.setLayout(gl_Uml_Panel);
	}
	
    public void printClassBox(String newName){

		////////////////////////////////
    	//
		// Create class box display
    	//
		////////////////////////////////
    	
    	model.createNewClassGUI(newName);
    	box = new classBox(controller);
    	createBox(box);
    	boxMap.put(newName, box);
    	box.setClassName(newName);
    	JPanel panel = box.boxPanel();
    	panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		GroupLayout groupLayout = new GroupLayout(Uml_Editor.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 278, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(376, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
		);

		Uml_Editor.getContentPane().setLayout(groupLayout);
		
		Uml_Editor.repaint();
	}
    
    public Map<String, classBox> getBoxMap() {
        return boxMap;
    }
    
	///////////////////////////////////////////////////////////
	//
	//	createBox
	//
	///////////////////////////////////////////////////////////
	public void createBox(classBox box) 
	{
		boxMap.put(box.getClassName(), box);
	}
	
	////////////////////////////////
	//
	// Class Actions
	//
	////////////////////////////////
	
	public void addActionPerformed() {
		String newName = textBoxClassAdd.getText();
		classDupFalse();
		notExistFalse();
		printClassBox(newName);
		textBoxClassAdd.setText("");
		classOption.setPopupMenuVisible(false);
		addClass.setPopupMenuVisible(false);
	}
    
	public void deleteClassAction()
	{	
		String className = textBoxClassDel.getText();
		classDupFalse();
		notExistFalse();
		Uml_Editor.remove(boxMap.get(className).boxPanel());
		boxMap.remove(className);
		textBoxClassDel.setText("");
		
		Uml_Editor.repaint();
		classOption.setPopupMenuVisible(false);
		deleteClass.setPopupMenuVisible(false);
	}
	
	public void renameActionPerformed()
	{	
		String oldName = renameClassOld.getText();
		String newName = renameClassNew.getText();
		
		classDupFalse();
		if(model.hasClass(oldName) && !model.hasClass(newName))
        {
			boxMap.get(oldName).renameClassName(newName);
			boxMap.put(newName, boxMap.get(oldName));
			model.renameClassGUI(oldName, newName);
			boxMap.remove(oldName);
        }
		else{
			classDupTrue();
		}
		renameClassOld.setText("");
		renameClassNew.setText("");
		classOption.setPopupMenuVisible(false);
		renameClass.setPopupMenuVisible(false);
	}
	
	////////////////////////////////
	//
	// Method Actions
	//
	////////////////////////////////
	
	public void addMethodAction() {
		String className = addMethodCN.getText();
		String methodName = addMethodName.getText();
		String methodType = addMethodType.getText();
		
		classDupFalse();
		notExistFalse();
		if (!model.hasClass(className)) {
    		notExistTrue();
			return;
		}
    	else if (model.hasMethod(className, methodName)) {
			classDupTrue();
			return;
    	}
    	else
    	{
    		model.addMethod(className, methodName, methodType);
    	}
		
		if(!paramListName.isEmpty()) {
			String parName;
			String parType;
			nameArray = new String[paramListName.size()];
			typeArray = new String[paramListType.size()];
			paramListName.copyInto(nameArray);
			paramListType.copyInto(typeArray);
			
			for(int i = 0; i < paramListName.size(); i++) {
				parName = nameArray[i];
				parType = typeArray[i];
				model.addParameter(className, methodName, parName, parType);
			}
		}
		
		printMethod();
		paramListName.clear();
		paramListType.clear();
		addMethodCN.setText("");
		addMethodName.setText("");
		addMethodType.setText("");
		
		method.setPopupMenuVisible(false);
		addMethod.setPopupMenuVisible(false);
	}
	
	public void addParamToList() {
		String parName = paramName.getText();
		String parType = paramType.getText();
		
		paramListName.add(parName);
		paramListType.add(parType);
		
		paramName.setText("");
		paramType.setText("");
	}
	
	public void printMethod() {
		String className = addMethodCN.getText();
		String methodName = addMethodName.getText();
		String methodType = addMethodType.getText();
		
		classDupFalse();
		notExistFalse();
		if(!paramListName.isEmpty()) {
			String parName;
			String parType;
			nameArray = new String[paramListName.size()];
			typeArray = new String[paramListType.size()];
			paramListName.copyInto(nameArray);
			paramListType.copyInto(typeArray);
			
			boxMap.get(className).addMethod(methodName, methodType);
			for(int i = 0; i < paramListName.size(); i++) {
				parName = nameArray[i];
				parType = typeArray[i];
				boxMap.get(className).addParam(methodName, methodType, parName, parType);
			}
			return;
		}
		else {
			boxMap.get(className).addMethod(methodName, methodType);
		}
	}
	
	public void deleteMethodAction() {
		String delMethodClassName = delMethodCN.getText();
		String delMethodN = delMethodName.getText();
		
		classDupFalse();
		notExistFalse();
		if (!model.hasClass(delMethodClassName) || !model.hasMethod(delMethodClassName, delMethodN))
			notExistTrue();
		else
		{
			model.deleteMethod(delMethodClassName, delMethodN);
			Uml_Editor.remove(boxMap.get(delMethodClassName).deleteMethod(delMethodN));
			delMethodCN.setText("");
			delMethodName.setText("");
		}
		method.setPopupMenuVisible(false);
		deleteMethod.setPopupMenuVisible(false);
	}
	
	public void renameMethodAction() {
		String className = renClassName.getText();
		String methodName = renameMethodOldName.getText();
		String newMethodName = renameMethodNewName.getText();
		
		classDupFalse();
		notExistFalse();
		if (!model.hasClass(className))
			notExistTrue();
		else if (!model.hasMethod(className, methodName))
			notExistTrue();
		else if (model.hasMethod(className, newMethodName))
			classDupTrue();
		else
		{
			model.renameMethod(className, methodName, newMethodName);
			String methodType = model.getMethodType(className, newMethodName);
			boxMap.get(className).renameMethodName(methodName, newMethodName, methodType);
			boxMap.put(newMethodName, boxMap.get(methodName));
			boxMap.remove(methodName);			
		}
		renClassName.setText("");
		renameMethodOldName.setText("");
		renameMethodNewName.setText("");
		method.setPopupMenuVisible(false);
		renameMethod.setPopupMenuVisible(false);
	}
	
	////////////////////////////////
	//
	// Field Actions
	//
	////////////////////////////////
	
	public void createFieldAction() {
		String className = addFieldCN.getText();
		String fieldName = addFieldName.getText();
		String fieldType = addFieldType.getText();
		
		classDupFalse();
		notExistFalse();
    	if (!model.hasClass(className))
    	{
    		notExistTrue();
    		return;
    	}
    	
    	else if (model.hasField(className, fieldName))
    	{
			classDupTrue();
			return;
    	}
    	else
    	{
    		model.addField(className, fieldName, fieldType);
			boxMap.get(className).addField(fieldName, fieldType);
			addFieldCN.setText("");
			addFieldName.setText("");
			addFieldType.setText("");
    	}
    	
    	field.setPopupMenuVisible(false);
		addField.setPopupMenuVisible(false);
	}
	
	public void deleteFieldAction() {
		String className = deleteFieldClassName.getText();
		String fieldName = deleteFieldName.getText();
		
		classDupFalse();
		notExistFalse();
		if (!model.hasClass(className) || !model.hasField(className, fieldName))
			notExistTrue();
		else
		{
			model.deleteField(className, fieldName);
			boxMap.get(className).deleteField(fieldName);
			Uml_Editor.remove(boxMap.get(className).deleteField(fieldName));
			deleteFieldClassName.setText("");
			deleteFieldName.setText("");
		}
		field.setPopupMenuVisible(false);
		deleteField.setPopupMenuVisible(false);
	}
	
	public void renameFieldAction() {
		String className = renameFieldCN.getText();
		String fieldName = fieldCurrent.getText();
		String newFieldName = fieldNew.getText();
		
		classDupFalse();
		notExistFalse();
		if (!model.hasClass(className))
			notExistTrue();
		else if (!model.hasField(className, fieldName))
			notExistTrue();
		else if (model.hasField(className, newFieldName))
			classDupTrue();
		else
		{
			model.renameField(className, fieldName, newFieldName);
			String fieldType = model.getFieldType(className, newFieldName);
			boxMap.get(className).renameFieldName(fieldName, newFieldName, fieldType);
			renameFieldCN.setText("");
			fieldCurrent.setText("");
			fieldNew.setText("");
		}
		field.setPopupMenuVisible(false);
		renameField.setPopupMenuVisible(false);
	}
	
	////////////////////////////////
	//
	// Relationship Actions
	//
	////////////////////////////////
	
	public void createRelAction()
	{
		String ID = addRelID.getText();
        String sourceClass = addRelSource.getText();
        String destClass = addRelDest.getText();
        String type = addRelType.getText();
        
        classDupFalse();
		notExistFalse();
        if (!model.hasClass(sourceClass) || !model.hasClass(destClass))
        	notExistTrue();
        else if (model.hasRelID(ID))
        	classDupTrue();
        else if (!type.equals("A") && !type.equals("C") && !type.equals("I") && !type.equals("R"))
        	notExistTrue();
        else
        {
            model.createRelationshipGUI(sourceClass, destClass, ID, type);
            drawArrow(ID, sourceClass, destClass, type);
        }
        addRelID.setText("");
        addRelSource.setText("");
        addRelDest.setText("");
        addRelType.setText("");
        rel.setPopupMenuVisible(false);
		addRel.setPopupMenuVisible(false);
	}
	
	public void drawArrow(String ID, String sourceClass, String destClass, String type) {
		JPanel sourcePan = boxMap.get(sourceClass).boxPanel();
		JPanel destPan = boxMap.get(destClass).boxPanel();
		Arrow newArrow = new Arrow(sourcePan, destPan, type);
		
		arrowMap.put(ID, newArrow);
		newArrow.setVisible(true);
		newArrow.setOpaque(false);
        newArrow.setLocation(0, 0);
        newArrow.setSize(5, 15);
        Uml_Editor.add(newArrow);
		        
		Uml_Editor.repaint();
	}
	
	public void removeArrow() {
		String id = delRel.getText();
		
		classDupFalse();
		notExistFalse();
		if(model.hasRelID(id)){
            model.deleteRelationshipGUI(id);
        }
        else{
            notExistTrue();
        }
		
		delRel.setText("");
		rel.setPopupMenuVisible(false);
		deleteRel.setPopupMenuVisible(false);
	}
	
	public void changeRelTypeAction() {
	  	String ID = changeRelID.getText();
    	String type = newRelType.getText();
    	
    	classDupFalse();
		notExistFalse();
    	if (!model.hasRelID(ID))
    		notExistTrue();
    	else if (!type.equals("A") && !type.equals("C") && !type.equals("I") && !type.equals("R"))
    		notExistTrue();
    	else
    	{
    		model.changeRelationshipTypeGUI(ID, type);
    	}
    	
    	changeRelID.setText("");
    	newRelType.setText("");
    	rel.setPopupMenuVisible(false);
		changeRelType.setPopupMenuVisible(false);
	}
	
	////////////////////////////////
	//
	// Export Image Action
	//
	////////////////////////////////
	
	public void exportImageAction(){
		String path = textBoxExportImage.getText();
		String jpgPath = "";
		String pngPath = "";
		
		if (!path.equals(""))
		{
			jpgPath = path + "/UmlImage.jpg";
			pngPath = path + "/UmlImage.png";
		}
		else 
		{
			jpgPath = "UmlImage.jpg";
			pngPath = "UmlImage.png";
		}
		
		menu.setPopupMenuVisible(false);
		exportImage.setPopupMenuVisible(false);

		BufferedImage image = new BufferedImage(Uml_Editor.getWidth(), Uml_Editor.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		Uml_Editor.printAll(g);
		g.dispose();
		
		try {
			ImageIO.write(image, "jpg", new File(jpgPath));
			ImageIO.write(image, "png", new File(pngPath));
		} catch (IOException exp) {
			exp.printStackTrace();
		}
		textBoxExportImage.setText("");
	}
	
	////////////////////////////////
	//
	// helpPanel
	//
	////////////////////////////////
	
	public void helpPanel() {
		help = new JFrame();
		help.setTitle("Help Menu");
		help.setBounds(100, 100, 1266, 683);
		help.setLayout(new GridLayout(21,0));
		
		JLabel title = new JLabel("Help Menu", SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
		help.add(title);
		
		//CLASS HELP LABELS
		JLabel classTitle = new JLabel("Classes");
		classTitle.setFont(new Font("Serif", Font.BOLD, 20));
		help.add(classTitle);
		
		JLabel classAddHelp = new JLabel("ADD:  Hit the Add Class button at the top left of the frame.");
		classAddHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(classAddHelp);
		JLabel classDelHelp = new JLabel("DELETE:  Under 'Class' on the menu bar, click Delete. Enter the name of the class to delete.");
		classDelHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(classDelHelp);
		JLabel classRenHelp = new JLabel("RENAME:  Under 'Class' on the menu bar, click Rename. Enter the current name of the class, as well as the new name for that class.");
		classRenHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(classRenHelp);
		
		//METHOD HELP LABELS
		JLabel methodTitle = new JLabel("Methods");
		methodTitle.setFont(new Font("Serif", Font.BOLD, 20));
		help.add(methodTitle);
		
		JLabel methodAddHelp = new JLabel("ADD:  Under 'Method' on the menu bar, click Add. Enter the class name, as well as the method name and type. Parameters are optional, if you do not wish to add any parameters, hit the 'Done' button.");
		methodAddHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(methodAddHelp);
		JLabel methodAddParamHelp = new JLabel("If you would like to add parameters, Enter the parameter name and type, and hit the 'Add Parameter to list' button. Once finished, hit 'Done'.");
		methodAddParamHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(methodAddParamHelp);
		JLabel methodDelHelp = new JLabel("DELETE:  Under 'Method' on the menu bar, click Delete. Enter the name of the class as well as the name of the method to delete.");
		methodDelHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(methodDelHelp);
		JLabel methodRenHelp = new JLabel("RENAME:  Under 'Method' on the menu bar, click Rename. Enter the name of the class, the current name of the method and the new name for that method.");
		methodRenHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(methodRenHelp);
		
		//FIELD HELP LABELS
		JLabel fieldTitle = new JLabel("Fields");
		fieldTitle.setFont(new Font("Serif", Font.BOLD, 20));
		help.add(fieldTitle);
		
		JLabel fieldAddHelp = new JLabel("ADD:  Under 'Field' on the menu bar, click Add. Enter the class name and the field name along with the type for that field.");
		fieldAddHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(fieldAddHelp);
		JLabel fieldDelHelp = new JLabel("DELETE:  Under 'Field' on the menu bar, click Delete. Enter the name of the class as well as the name of the field to delete.");
		fieldDelHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(fieldDelHelp);
		JLabel fieldRenHelp = new JLabel("RENAME:  Under 'Field' on the menu bar, click Rename. Enter the name of the class, the current name of the field along with the new name for that field.");
		fieldRenHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(fieldRenHelp);
		
		//RELATIONSHIP HELP LABELS
		JLabel relTitle = new JLabel("Relationships");
		relTitle.setFont(new Font("Serif", Font.BOLD, 20));
		help.add(relTitle);
		
		JLabel relAddHelp = new JLabel("ADD:  Under 'Relationship' on the menu bar, click Add. Enter a distinct ID, the source and destination for the relationship, as well as the type the relationship is. (Either 'A', 'C', 'I', 'R')");
		relAddHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(relAddHelp);
		JLabel relDelHelp = new JLabel("DELETE:  Under 'Relationship' on the menu bar, click Delete. Enter the ID of the relationship to delete.");
		relDelHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(relDelHelp);
		JLabel relRenHelp = new JLabel("CHANGE TYPE:  Under 'Relationship' on the menu bar, click Change Type. Enter the ID of the relationship, as well as the new type for that relationship.");
		relRenHelp.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(relRenHelp);
		
		//EXPORT IMAGE HELP LABEL
		JLabel exportTitle = new JLabel("Export Image");
		exportTitle.setFont(new Font("Serif", Font.BOLD, 20));
		help.add(exportTitle);
		JLabel exportDesc = new JLabel("Under 'Menu' on the menu bar, click 'Export as Image'. Enter the directory to save the image in and click the 'Export' button. Both a jpg and png image will be saved.");
		exportDesc.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		help.add(exportDesc);
		
		help.setVisible(true);
		
		JButton close = new JButton("Close");
		close.setPreferredSize(new Dimension(1,1));
		help.add(close);
		close.addActionListener(controller.closeHelp());
	}
	
	public void closeHelpPanel() {
		help.setVisible(false);
	}
	
	////////////////////////////////
	//
	// Error Checking helpers
	//
	////////////////////////////////
	
	public void classDupTrue() {
		classDupLabel.setText("This is a duplicate name!");
	}
	
	public void classDupFalse() {
		classDupLabel.setText("");
	}
	
	public void notExistTrue() {
		classDupLabel.setText("This does not exist!");
	}
	
	public void notExistFalse() {
		classDupLabel.setText("");
	}
	
	public String delClassGet() {
		return textBoxClassDel.getText();
	}
	
	public String addClassGet() {
		return textBoxClassAdd.getText();
	}
}
