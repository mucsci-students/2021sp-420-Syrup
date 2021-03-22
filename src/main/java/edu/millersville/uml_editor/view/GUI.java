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
	
	private JLabel dup1, dup2, dup3 = null;
	private JLabel classDupLabel = null;
	
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

    public GUI(UMLModel m) {
        this.model = m;
        this.controller = null;
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

		////////////////////////////////////////
		//
        //MenuBar
		//
        ////////////////////////////////////////
		JMenuBar menuBar = new JMenuBar();
		Uml_Editor.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		JMenuItem mntmNewMenuItem = new JMenuItem("Save");
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Load");

        menuBar.add(mnNewMenu);
        mnNewMenu.add(mntmNewMenuItem);
        mnNewMenu.add(mntmNewMenuItem_1);
        
        classDupLabel = new JLabel("");
		classDupLabel.setFont(new Font("Serif", Font.BOLD, 16));
		classDupLabel.setForeground(Color.RED);
		
		
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
		JPanel panel = new JPanel();
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
		JPanel FieldPanel = new JPanel();
		FieldPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel methodPanel = new JPanel();
		methodPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
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
		
		dup3 = dup();
		
		JMenu renameClass = new JMenu("Class");
		renameOption.add(renameClass);
		textBox5 = new JTextField();
		textBox5.setColumns(15);
		renameClass.add(renameClassName);
		renameClass.add(textBox5);
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
		JLabel className = new JLabel("New Class");
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
		Uml_Editor.getContentPane().setLayout(groupLayout);
    }
    
	////////////////////////////////
	//
	// Popup menu Listeners
	//
	////////////////////////////////
    private void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
    
	////////////////////////////////
	//
	// Duplicate helpers
	//
	////////////////////////////////
    
	public JLabel dup(){
		JLabel dup = new JLabel("This is a duplicate!");
		dup.setFont(new Font("Serif", Font.BOLD, 12));
		dup.setForeground(Color.RED);	
		return dup;
	}
	
	public void classDupTrue() {
		classDupLabel.setText("This is a duplicate name!");
	}
	
	public void classDupFalse() {
		classDupLabel.setText("");
	}
}
