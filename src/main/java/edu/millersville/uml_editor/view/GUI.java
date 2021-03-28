package edu.millersville.uml_editor.view;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Canvas;
import javax.swing.JMenuBar;
import java.awt.Point;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.controller.*;


public class GUI {
	private JFrame Uml_Editor;
	
	private JLabel dup1, dup2, dup3, dup4, dup5, dup6 = null;
	private JLabel notEx1 = null;
	private JLabel classDupLabel = null;

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
    
    private Map<String, classBox> boxMap;
    
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
    }

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {

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
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		JMenuItem load = new JMenuItem("Save");
		menu.add(load);
		JMenuItem save = new JMenuItem("Load");
		menu.add(save);
		JMenuItem help = new JMenuItem("Help");
		menu.add(help);
		
		////////////////////////////////
		//
		// Class Option
		//
		////////////////////////////////
		
		JMenu classOption = new JMenu("Class");
        menuBar.add(classOption);
        
		////////////////////////////////
		//
		// Delete Class Option
		//
		////////////////////////////////
        
        JLabel classNameDel = new JLabel("Enter Class Name:");
        classNameDel.setFont(new Font("Serif", Font.BOLD, 12));
        
        JButton classDelButton = new JButton("Delete");
        
        JMenu deleteClass = new JMenu("Delete");
        classOption.add(deleteClass);
        
		notEx1 = notExist();	
        
        deleteClass.add(classNameDel);
        textBoxClassDel = new JTextField();
		textBoxClassDel.setColumns(15);
		deleteClass.add(textBoxClassDel);
		deleteClass.add(classDelButton);
		deleteClass.add(classDupLabel);
		//notEx1.setVisible(false);
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
		
		dup1 = dup();
		
        JMenu renameClass = new JMenu("Rename");
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
		renameClass.add(dup1);
		dup1.setVisible(false);
		renameClassButton.addActionListener(controller.renameClassCall());
		
		
		////////////////////////////////
		//
		// Method Option
		//
		////////////////////////////////
		
		JMenu method = new JMenu("Method");
        menuBar.add(method);
        
		////////////////////////////////
		//
		// Add Method Class Option
		//
		////////////////////////////////
		
		JMenu addMethod = new JMenu("Add");
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
		dup2 = dup();
		
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
		
		JMenu deleteMethod = new JMenu("Delete");
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
		
		JMenu renameMethod = new JMenu("Rename");
        method.add(renameMethod);
        
        JLabel renMethodClassName = new JLabel("Class Name:");
		renMethodClassName.setFont(new Font("Serif", Font.BOLD, 12));
		
        JLabel methodOldName = new JLabel("Current Method Name:");
		methodOldName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel methodNewName = new JLabel("New Method Name:");
		methodNewName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton rename = new JButton("Rename");
		
		dup3 = dup();
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
		renameMethod.add(dup3);
		dup3.setVisible(false);
		renameMethod.add(rename);
		rename.addActionListener(controller.renameMethodCall());
		
		////////////////////////////////
		//
		// Field Option
		//
		////////////////////////////////
		
		JMenu field = new JMenu("Field");
        menuBar.add(field);
        
		////////////////////////////////
		//
		// Add Field Option
		//
		////////////////////////////////
		
		JMenu addField = new JMenu("Add");
        field.add(addField);
        
        JLabel addFieldClassLabel = new JLabel("Class Name:");
		addFieldClassLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
        JLabel addFieldNameLabel = new JLabel("Field Name:");
		addFieldNameLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel addFieldTypeLabel = new JLabel("Field Type:");
		addFieldTypeLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		dup4 = dup();
		
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
		addField.add(dup4);
		dup4.setVisible(false);
		
		////////////////////////////////
		//
		// Delete Field Option
		//
		////////////////////////////////
		
		JMenu deleteField = new JMenu("Delete");
        field.add(deleteField);
        
        JLabel deleteFieldNameLabel = new JLabel("Class Name:");
		deleteFieldNameLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel deleteFieldTypeLabel = new JLabel("Field Name:");
		deleteFieldTypeLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		dup4 = dup();
		
		deleteFieldClassName = new JTextField();
		deleteFieldClassName.setColumns(15);
		deleteField.add(deleteFieldNameLabel);
		deleteField.add(deleteFieldClassName);
		deleteField.add(deleteFieldTypeLabel);
		deleteFieldName = new JTextField();
		deleteFieldName.setColumns(15);
		deleteField.add(deleteFieldName);
		deleteField.add(dup4);
		dup4.setVisible(false);
		
		////////////////////////////////
		//
		// Rename Field Option
		//
		////////////////////////////////
		
		JMenu renameField = new JMenu("Rename");
        field.add(renameField);
        
        JLabel renameFieldClassLabel = new JLabel("Class Name:");
        renameFieldClassLabel.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel fieldCurrentName = new JLabel("Current Field Name:");
		fieldCurrentName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel fieldNewName = new JLabel("New Field Name:");
		fieldNewName.setFont(new Font("Serif", Font.BOLD, 12));
		
		dup4 = dup();
		
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
		renameField.add(dup4);
		dup4.setVisible(false);
        
		////////////////////////////////
		//
		// Relationship Option
		//
		////////////////////////////////
		
		JMenu rel = new JMenu("Relationship");
        menuBar.add(rel);

		
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
					.addComponent(addClassButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addComponent(classDupLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
		));
		gl_Uml_Panel.setVerticalGroup(
			gl_Uml_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Uml_Panel.createSequentialGroup()
					.addGroup(gl_Uml_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addClassButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(classDupLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						
		)));
		Uml_Editor.setLayout(gl_Uml_Panel);
	}
	
    public void printClassBox(){

		////////////////////////////////
    	//
		// Create class box display
    	//
		////////////////////////////////
    	
    	
    	model.createNewClassGUI("New Class");
    	box = new classBox(controller);
    	createBox(box);
    	JPanel panel = box.boxPanel();
    	
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		GroupLayout groupLayout = new GroupLayout(Uml_Editor.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(376, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
		);
		Uml_Editor.getContentPane().setLayout(groupLayout);
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
    
	public void deleteClassAction()
	{	
		String className = textBoxClassDel.getText();
		
		Uml_Editor.remove(boxMap.get(className).boxPanel());
		boxMap.remove(className);
		textBoxClassDel.setText("");
		
		Uml_Editor.repaint();
	}
	
	public void renameActionPerformed()
	{	
		String oldName = renameClassOld.getText();
		String newName = renameClassNew.getText();
		
		classDupFalse();
		
		//NEED TO ADD ERROR CHECKS
		boxMap.get(oldName).renameClassName(newName);
		boxMap.put(newName, boxMap.get(oldName));
		model.renameClassGUI(oldName, newName);
		boxMap.remove(oldName);
		Uml_Editor.repaint();
		renameClassOld.setText("");
		renameClassNew.setText("");
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
				boxMap.get(className).addParam(parName, parType);
			}
			Uml_Editor.repaint();
			return;
		}
		else {
			boxMap.get(className).addMethod(methodName, methodType);
			Uml_Editor.repaint();
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
		}
		
		delMethodCN.setText("");
		delMethodName.setText("");
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
			//NEED TO FIX RENAME METHOD FUNCTION 
			boxMap.get(methodName).renameMethodName(methodName, newMethodName);
			boxMap.put(newMethodName, boxMap.get(methodName));
			boxMap.remove(methodName);
			Uml_Editor.repaint();
			renClassName.setText("");
			renameMethodOldName.setText("");
			renameMethodNewName.setText("");
		}
	}
	
	////////////////////////////////
	//
	// Error Checking helpers
	//
	////////////////////////////////
    
	public JLabel dup(){
		JLabel dup = new JLabel("This is a duplicate!");
		dup.setFont(new Font("Serif", Font.BOLD, 12));
		dup.setForeground(Color.RED);	
		return dup;
	}
	
	public JLabel notExist(){
		JLabel notExist = new JLabel("This does not exist!");
		notExist.setFont(new Font("Serif", Font.BOLD, 12));
		notExist.setForeground(Color.RED);	
		notExist.setVisible(false);
		return notExist;
	}
	
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
}
