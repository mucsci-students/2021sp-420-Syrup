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
import java.util.Map;

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
	
	private JPanel test = null;
	
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
    
    private Map<String, classBox> boxMap;
    
    private boolean isMethod = false;
    
    private UMLController controller;
    private UMLModel model;
    private classBox box;

    public GUI(UMLModel m, classBox b) {
        this.model = m;
        this.controller = null;
        this.box = b;
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
        classBox box = new classBox();
        GUI gui = new GUI(model, box);
        UMLController controller = new UMLController(model, box, gui);
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
    	
    	classBox newClassBox = new classBox();
    	//boxMap.put("New Class", newClassBox);
    	JPanel panel = newClassBox.boxPanel();
    	
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
