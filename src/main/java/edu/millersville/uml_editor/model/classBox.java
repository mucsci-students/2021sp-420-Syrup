package edu.millersville.uml_editor.model;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JTextField;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.controller.*;

public class classBox extends JComponent {

	private JFrame Uml_Editor;
	
	private JLabel dup1, dup2, dup3 = null;
	private JLabel className = null;
	private JLabel classDupLabel = null;
	
	private JButton renameClassButton = null;
	
	private JPanel panel = null;
	
	private JTextField textBox1;
    private JTextField textBox2;
    private JTextField textBox3;
    private JTextField textBox4;
    private JTextField textBox5;
    private JTextField paramName;
    private JTextField paramType;
    
    private JMenu deleteMethod;
    private ArrayList<JButton> methodButtonList;
    private ArrayList<JButton> fieldButtonList;
    
    private boolean isMethod = false;
    
    private UMLController controller;
    private UMLModel model;

    public classBox() {
    	initialize();
    }
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		////////////////////////////////
		//
		// Create class box display
		//
		////////////////////////////////
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel FieldPanel = new JPanel();
		FieldPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel methodPanel = new JPanel();
		methodPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel.add(FieldPanel);
		panel.add(methodPanel);
		
		/////////////////////
		//
		// Add Method Labels
		//
		/////////////////////
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
		dup1 = dup();
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(panel, popupMenu);
		popupMenu.setLabel("Menu");
		popupMenu.setVisible(true);
		
		////////////////////////////////
		//
		// Popup menu: Add
		//
		////////////////////////////////
		JMenu addOption = new JMenu("Add");
		popupMenu.add(addOption);
		
		JMenu addMethod = new JMenu("Method");
		addOption.add(addMethod);
		textBox1 = new JTextField();
		textBox1.setColumns(15);
		addMethod.add(methodName);
		addMethod.add(textBox1);
		addMethod.add(methodType);
		textBox2 = new JTextField();
		textBox2.setColumns(15);
		addMethod.add(textBox2);
		addMethod.add(dup1);
		dup1.setVisible(false);
		
		///////////////////////////
		//
		// Add Parameters in Method
		//
		///////////////////////////
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
		
		
		///////////////////////////
		//
		// Add Field
		//
		///////////////////////////
		
		JLabel fieldName = new JLabel("Field Name:");
		fieldName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JLabel fieldType = new JLabel("Field Type:");
		fieldType.setFont(new Font("Serif", Font.BOLD, 12));
		
		dup2 = dup();
		
		JMenu addField = new JMenu("Field");
		addOption.add(addField);
		textBox3 = new JTextField();
		textBox3.setColumns(15);
		addField.add(fieldName);
		addField.add(textBox3);
		addField.add(fieldType);
		textBox4 = new JTextField();
		textBox4.setColumns(15);
		addField.add(textBox4);
		addField.add(dup2);
		dup2.setVisible(false);
		
		////////////////////////////////
		//
		// Popup menu: delete
		//
		////////////////////////////////
		
		
		JMenu deleteOption = new JMenu("Delete");
		popupMenu.add(deleteOption);
		
		JMenuItem deleteClass = new JMenuItem("Class");
		deleteOption.add(deleteClass);
		
		JMenu deleteMethod = new JMenu("Method");
		deleteOption.add(deleteMethod);
		
		JMenu deleteField = new JMenu("Field");
		deleteOption.add(deleteField);
		
		////////////////////////////////
		//
		// Popup menu: Rename
		//
		////////////////////////////////
		JMenu renameOption = new JMenu("Rename");
		popupMenu.add(renameOption);
		
		JLabel renameClassName = new JLabel("New Class Name:");
		renameClassName.setFont(new Font("Serif", Font.BOLD, 12));
		
		JButton renameClassButton = new JButton("Rename Class");
		
		dup3 = dup();
		
		JMenu renameClass = new JMenu("Class");
		renameOption.add(renameClass);
		textBox5 = new JTextField();
		textBox5.setColumns(15);
		renameClass.add(renameClassName);
		renameClass.add(textBox5);
		renameClass.add(renameClassButton);
		//textBox5.addActionListener(controller.renameClassCall());
		
		renameClass.add(dup3);
		dup3.setVisible(false);
		
		JMenu renameMethod = new JMenu("Method");
		renameOption.add(renameMethod);
		
		JMenu renameField = new JMenu("Field");
		renameOption.add(renameField);
		
		////////////////////////////////
		//
		// Popup menu/movement Listeners
		//
		////////////////////////////////
		panel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3)
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
		panel.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e) {
				e.translatePoint(e.getComponent().getLocation().x, e.getComponent()
				  .getLocation().y);
				panel.setLocation(e.getX(), e.getY());
			}
		});
		
			////////////////////////////////
			//
			// Default class label
			//
			////////////////////////////////
			
			className = new JLabel("New Class");
			className.setFont(new Font("Serif", Font.BOLD, 16));
			
			GroupLayout gl_panel = new GroupLayout(panel);
			
			gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(methodPanel, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(91)
					.addComponent(className, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addComponent(FieldPanel, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			
			gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
			.addComponent(className, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(FieldPanel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(methodPanel, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
			);
			
			panel.setVisible(true);
			panel.setLayout(gl_panel);
		}
		
		////////////////////////////////
		//
		// Popup menu Listeners
		//
		////////////////////////////////
		private void addPopup(Component component, final JPopupMenu popup) {
			component.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (e.isPopupTrigger())
						showMenu(e);
					}
				public void mouseReleased(MouseEvent e) {
					if (e.isPopupTrigger()) 
							showMenu(e);
				}
				private void showMenu(MouseEvent e) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			});

		}
		
	////////////////////////////////
	//
	// renameClass
	//
	////////////////////////////////
		
	public void renameClass(String newName) {
		className.setText(newName);
	}
	
	////////////////////////////////
	//
	// renameClassAction
	//
	////////////////////////////////
	
	public void renameActionPerformed(ActionEvent e)
	{
		String className1 = className.getText();
		String newClassName = textBox5.getText();
		
		model.renameClassGUI(className1, newClassName);
	}
		
		
		
	public JLabel dup(){
		JLabel dup = new JLabel("This is a duplicate!");
		dup.setFont(new Font("Serif", Font.BOLD, 12));
		dup.setForeground(Color.RED);	
		return dup;
	}
	
	public JPanel boxPanel() {
		return panel;
	}
}
