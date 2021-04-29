package edu.millersville.uml_editor.model;


import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

import java.awt.Color;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextField;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.GUI;
import edu.millersville.uml_editor.controller.*;

public class classBox extends JComponent {

	private JLabel className = null;
	
	private JPanel panel = null;
	private JPanel methodPanel = null;
	private JPanel fieldPanel = null;
	
    private JTextField textBox5;
    private JTextField textBox6;
    
    private HashMap<String, JLabel> methodMap = new HashMap();
    private HashMap<String, ArrayList<JLabel>> paramMap = new HashMap();
    private HashMap<String, JLabel> fieldMap = new HashMap();
    
    private UMLController controller;

    public classBox(UMLController c) {
    	className = new JLabel("New Class");
    	controller = c;
    	initialize();
    }
    
    
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
		
		}
		
		////////////////////////////////
		//
		// Create class box display
		//
		////////////////////////////////
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		fieldPanel = new JPanel();
		fieldPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		fieldPanel.setLayout(new GridLayout(5, 2));
		
		methodPanel = new JPanel();
		methodPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		methodPanel.setLayout(new GridLayout(5, 2));
		
		panel.add(fieldPanel);
		panel.add(methodPanel);
		
		////////////////////////////////
		//
		// Movement Listener
		//
		////////////////////////////////
		MouseInputAdapter l = new MouseInputAdapter (){
			private int x;
			private int y;
			public void mousePressed(MouseEvent e) {
				this.x = e.getX();
				this.y = e.getY();
			}
			public void mouseDragged(MouseEvent e) {
				panel.setLocation(panel.getX() + (e.getX() - this.x), panel.getY() + (e.getY() - this.y));
			}
		};
	
		panel.addMouseListener(l);
		panel.addMouseMotionListener(l);
		
		////////////////////////////////
		//
		// Default class label
		//
		////////////////////////////////
	
		className.setFont(new Font("Serif", Font.BOLD, 16));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		
		gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
		.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
			.addComponent(methodPanel, GroupLayout.DEFAULT_SIZE, 275, GroupLayout.DEFAULT_SIZE)
			.addGroup(gl_panel.createSequentialGroup()
				.addGap(100)
				.addComponent(className, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE))
			.addComponent(fieldPanel, GroupLayout.DEFAULT_SIZE, 275, GroupLayout.DEFAULT_SIZE))
		.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
		.addComponent(className, GroupLayout.DEFAULT_SIZE, 28, GroupLayout.DEFAULT_SIZE)
		.addPreferredGap(ComponentPlacement.UNRELATED)
		.addComponent(fieldPanel, GroupLayout.DEFAULT_SIZE, 78, GroupLayout.DEFAULT_SIZE)
		.addPreferredGap(ComponentPlacement.UNRELATED)
		.addComponent(methodPanel, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
		);
		
		panel.setVisible(true);
		panel.setLayout(gl_panel);
	}
		
	////////////////////////////////
	//
	// Getters
	//
	////////////////////////////////
		
	public String getOldName() {
		return textBox5.getText();
	}	
	
	public String getNewName() {
		return textBox6.getText();
	}
	
	public String getClassName() {
		return className.getText();
	}
	
	public classBox getClassBox() {
		return this;
	}
	
	public JPanel boxPanel() {
		return panel;
	}
	
	public JPanel methodPanel() {
		return methodPanel;
	}
	
	public JPanel fieldPanel() {
		return fieldPanel;
	}
	
	////////////////////////////////
	//
	// renameClass
	//
	////////////////////////////////
	
	public void renameClassName(String newName) {
		className.setText(newName);
	}
		
	public JLabel dup(){
		JLabel dup = new JLabel("This is a duplicate!");
		dup.setFont(new Font("Serif", Font.BOLD, 12));
		dup.setForeground(Color.RED);	
		return dup;
	}
	
	////////////////////////////////
	//
	// Method functions
	//
	////////////////////////////////
	public void addMethod(String methodName, String methodType) {
		JLabel method = new JLabel();
		methodMap.put(methodName, method);
		methodPanel.add(method);
		methodPanel.repaint();
		methodMap.get(methodName).setText(methodName + " : " + methodType);
	}
	
	public void addParam(String methodName, String paramName, String paramType) {
		JLabel param = new JLabel("(" + paramName + ", " + paramType + ")");
		if(paramMap.containsKey(methodName)) {
			ArrayList<JLabel> temp = paramMap.get(methodName);
			temp.add(param);
			paramMap.put(methodName, temp);
		}
		else {
			ArrayList<JLabel> temp = new ArrayList<JLabel>();
			temp.add(param);
			paramMap.put(methodName, temp);
		}
		methodPanel.add(param);
		methodPanel.repaint();
	}
	
	public JPanel deleteMethod(String methodName) {
		methodPanel.remove(methodMap.get(methodName));
		if(paramMap.containsKey(methodName)) {
			ArrayList<JLabel> temp = paramMap.get(methodName);
			if(temp != null) {
				for(int i = 0; i < temp.size(); i++) {
					methodPanel.remove(temp.get(i));
				}
			}
		}
		methodPanel.repaint();
		return methodPanel;
	}
	
	public void renameMethodName(String methodName, String methodNewName, String methodType) {
		methodMap.get(methodName).setText(methodNewName + " : " + methodType);
	}
	
	////////////////////////////////
	//
	// Field Functions
	//
	////////////////////////////////
	
	public void addField(String fieldName, String fieldType) {
		JLabel field = new JLabel();
		fieldMap.put(fieldName, field);
		fieldPanel.add(field);
		fieldPanel.repaint();
		fieldMap.get(fieldName).setText(fieldName + " : " + fieldType);
	}

	public JPanel deleteField(String fieldName) {
		fieldPanel.remove(fieldMap.get(fieldName));
		fieldPanel.repaint();
		return fieldPanel;
	}
	
	public void renameFieldName(String fieldName, String newFieldName, String fieldType) {
		fieldMap.get(fieldName).setText(newFieldName + " : " + fieldType);
	}
}
