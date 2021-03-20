package edu.millersville.uml_editor.view;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JMenuItem;
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
	private static JFrame Uml_Editor;
    
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
		));
		gl_Uml_Panel.setVerticalGroup(
			gl_Uml_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Uml_Panel.createSequentialGroup()
					.addGroup(gl_Uml_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addClassButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
		)));
		Uml_Editor.setLayout(gl_Uml_Panel);
	}
	
    public static void printClassBox(){

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
		
		JMenuItem addMethod = new JMenuItem("Method");
		addOption.add(addMethod);
		
		JMenuItem addField = new JMenuItem("Field");
		addOption.add(addField);
		
		////////////////////////////////
		//
		// Popup menu: delete
		//
		////////////////////////////////
		JMenu deleteOption = new JMenu("Delete");
		popupMenu.add(deleteOption);
		
		JMenuItem deleteClass = new JMenuItem("Class");
		deleteOption.add(deleteClass);
		
		JMenuItem deleteMethod = new JMenuItem("Method");
		deleteOption.add(deleteMethod);
		
		JMenuItem deleteField = new JMenuItem("Field");
		deleteOption.add(deleteField);
		
		////////////////////////////////
		//
		// Popup menu: Rename
		//
		////////////////////////////////
		JMenu renameOption = new JMenu("Rename");
		popupMenu.add(renameOption);
		
		JMenuItem renameClass = new JMenuItem("Class");
		renameOption.add(renameClass);
		
		JMenuItem renameMethod = new JMenuItem("Method");
		renameOption.add(renameMethod);
		
		JMenuItem renameField = new JMenuItem("Field");
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
		JLabel className = new JLabel();
		className.setText("New Class");
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
		
		panel.setLayout(gl_panel);
		Uml_Editor.getContentPane().setLayout(groupLayout);
    }
    
		////////////////////////////////
		//
		// Popup menu Listeners
		//
		////////////////////////////////
    private static void addPopup(Component component, final JPopupMenu popup) {
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
}
