package edu.millersville.uml_editor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UMLGUI implements ActionListener {
    private static JFrame umlEditor;
    private static JPanel menuPanel, classPanel, attrPanel, relPanel, printPanel;

    public static void menuPanel() {
public class UMLGUI {
    private JFrame umlEditor = null;
    private JPanel menuPanel = null;
    private JPanel classPanel = null;
    private JPanel attrPanel = null;
    private JPanel relPanel = null;
    private JPanel printPanel = null;
    private JPanel createClassPanel = null;
    private JPanel removeClassPanel = null;
    private JPanel renameClassPanel = null;
    private JPanel createRelPanel = null;
    private JPanel removeRelPanel = null;
    private JPanel changeRelTypePanel = null;
    private JPanel createdClassPanel = null;
    private JPanel removedClassPanel = null;
    private JPanel renamedClassPanel = null;
    private JPanel dupPanel = null;
    

    private UMLController controller;
    private UMLModel model;

    public UMLGUI(UMLModel m) {
        this.model = m;
        this.controller = null;
    }

    public void menuPanel() {
       //checks to see if the panel was already created
       panelCheck(menuPanel);

        // view
        JButton classButton = new JButton("Class");
        JButton attrButton = new JButton("Attribute");
        JButton relButton = new JButton("Relationship");
        JButton printButton = new JButton("Print");

        // register controller to view
        classButton.addActionListener(controller.getMainPageListener());
        attrButton.addActionListener(controller.getMainPageListener());
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
        // Buttons
        ///////////////
        JButton classButton = new JButton(new AbstractAction("Class") {
            @Override
            public void actionPerformed(ActionEvent e) {
                classPanel();

            }
        });

        JButton attrButton = new JButton(new AbstractAction("Attribute") {
            @Override
            public void actionPerformed(ActionEvent e) {
                attrPanel();
            }
        });

        JButton relButton = new JButton(new AbstractAction("Relationship") {
            @Override
            public void actionPerformed(ActionEvent e) {
                relPanel();
            }
        });
        JButton printButton = new JButton(new AbstractAction("Print") {
            @Override
            public void actionPerformed(ActionEvent e) {
                printPanel();
            }
        });

        ///////////////
        // Panel
        ///////////////
        JPanel menuPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        //adds everything to the panel

        // Panel
        ///////////////
        menuPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        menuPanel.add(welcome);
        menuPanel.add(select);
        menuPanel.add(classButton);
        menuPanel.add(attrButton);
        menuPanel.add(relButton);
        menuPanel.add(printButton);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));

        ///////////////
        // Frame
        ///////////////
        changePanel(menuPanel);
    }

    public static void classPanel() {
        //Class Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel classLabel = new JLabel("Class Functions:", SwingConstants.CENTER);
        classLabel.setFont(new Font("Serif", Font.BOLD, 20));

        classLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Buttons
        ///////////////
        JButton createClass = new JButton(new AbstractAction("Create a new Class") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton removeClass = new JButton(new AbstractAction("Remove a Class") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton renameClass = new JButton(new AbstractAction("Rename a Class") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton backButton = new JButton(new AbstractAction("<--") {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel();
            }
        });

        ///////////////
        // Panel
        ///////////////
        classPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        classPanel.add(classLabel);
        classPanel.add(createClass);
        classPanel.add(removeClass);
        classPanel.add(renameClass);
        classPanel.add(backButton);
        classPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(classPanel);

    }

    public static void attrPanel() {
        //Attribute Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel attrLabel = new JLabel("Attribute Functions:", SwingConstants.CENTER);
        attrLabel.setFont(new Font("Serif", Font.BOLD, 20));

        attrLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Buttons
        ///////////////
        JButton createAttr = new JButton(new AbstractAction("Create a new Attribute") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton removeAttr = new JButton(new AbstractAction("Remove a Attribute") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton renameAttr = new JButton(new AbstractAction("Rename a Attribute") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton backButton = new JButton(new AbstractAction("<--") {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel();
            }
        });

        ///////////////
        // Panel
        ///////////////
        attrPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        attrPanel.add(attrLabel);
        attrPanel.add(createAttr);
        attrPanel.add(removeAttr);
        attrPanel.add(renameAttr);
        attrPanel.add(backButton);
        attrPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(attrPanel);
    }

    public static void relPanel() {
        //Relationship Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel relLabel = new JLabel("Relationship Functions:", SwingConstants.CENTER);
        relLabel.setFont(new Font("Serif", Font.BOLD, 20));

        relLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Buttons
        ///////////////
        JButton createRel = new JButton(new AbstractAction("Create a new Relationship") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton removeRel = new JButton(new AbstractAction("Remove a Relationship") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton changeRelType = new JButton(new AbstractAction("Change a Relationship Type") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton backButton = new JButton(new AbstractAction("<--") {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel();
            }
        });

        ///////////////
        // Panel
        ///////////////
        relPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        relPanel.add(relLabel);
        relPanel.add(createRel);
        relPanel.add(removeRel);
        relPanel.add(changeRelType);
        relPanel.add(backButton);
        relPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(relPanel);

    }

    public static void printPanel() {
        //Print Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel printLabel = new JLabel("Print Functions:", SwingConstants.CENTER);
        printLabel.setFont(new Font("Serif", Font.BOLD, 20));

        printLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Buttons
        ///////////////
        JButton printClasses = new JButton(new AbstractAction("Print Classes") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton printClassesAttr = new JButton(new AbstractAction("Print Classes and Attributes") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton printRel = new JButton(new AbstractAction("Print Relationships") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implementation needed
            }
        });
        JButton backButton = new JButton(new AbstractAction("<--") {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel();

            }
        });

        ///////////////
        // Panel
        ///////////////
        printPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        printPanel.add(printLabel);
        printPanel.add(printClasses);
        printPanel.add(printClassesAttr);
        printPanel.add(printRel);
        printPanel.add(backButton);
        printPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(printPanel);
    }

    public static void changePanel(JPanel newPanel) {
        umlEditor.setContentPane(newPanel);
        umlEditor.validate();
        umlEditor.repaint();
    }

    public static void main(String[] args) {

        ///////////////
        // MENU
        ///////////////
        changePanel(menuPanel);
    }

    public void classPanel() {
        //checks to see if the panel was already created
        panelCheck(classPanel);
    
        // view
        JButton createClass = new JButton("Create a new Class");
        JButton removeClass = new JButton("Remove a Class");
        JButton renameClass = new JButton("Rename a Class");
        JButton backButton = new JButton("<--");

        //register controller to view
        createClass.addActionListener(controller.getClassPageListener());
        removeClass.addActionListener(controller.getClassPageListener());
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
        classPanel.add(removeClass);
        classPanel.add(renameClass);
        classPanel.add(backButton);
        classPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(classPanel);
    }

    public  void attrPanel() {
       //checks to see if the panel was already created
       panelCheck(attrPanel);

       //view
        JButton createAttr = new JButton("Create a new Attribute");
        JButton removeAttr = new JButton("Remove a Attribute");
        JButton renameAttr = new JButton("Rename a Attribute");
        JButton backButton = new JButton("<--");

        //register controller to view
        createAttr.addActionListener(controller.getAttrPageListener());
        removeAttr.addActionListener(controller.getAttrPageListener());
        renameAttr.addActionListener(controller.getAttrPageListener());
        backButton.addActionListener(controller.getAttrPageListener());

        //Attribute Page
        ///////////////
        // Heading/Labels
        ///////////////
        JLabel attrLabel = new JLabel("Attribute Functions:", SwingConstants.CENTER);
        attrLabel.setFont(new Font("Serif", Font.BOLD, 20));

        attrLabel.setVerticalAlignment(SwingConstants.BOTTOM);

        ///////////////
        // Panel
        ///////////////
        attrPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        attrPanel.add(attrLabel);
        attrPanel.add(createAttr);
        attrPanel.add(removeAttr);
        attrPanel.add(renameAttr);
        attrPanel.add(backButton);
        attrPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(attrPanel);
    }

    public void relPanel() {
        //checks to see if the panel was already created
        panelCheck(classPanel);

        //view
        JButton createRel = new JButton("Create a new Relationship");
        JButton removeRel = new JButton("Remove a Relationship");
        JButton changeRelType = new JButton("Change a Relationship Type");
        JButton backButton = new JButton("<--");

        //register the controller to view
        createRel.addActionListener(controller.getRelPageListener());
        removeRel.addActionListener(controller.getRelPageListener());
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
        relPanel.add(removeRel);
        relPanel.add(changeRelType);
        relPanel.add(backButton);
        relPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(relPanel);
    }

    public  void printPanel() {
        //checks to see if the panel was already created
        panelCheck(printPanel);

        //view
        JButton printClasses = new JButton("Print Classes");
        JButton printClassesAttr = new JButton("Print Classes and Attributes");
        JButton printRel = new JButton("Print Relationships");
        JButton backButton = new JButton("<--");

        //register the controller to view
        printClasses.addActionListener(controller.getPrintPageListener());
        printClassesAttr.addActionListener(controller.getPrintPageListener());
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
        printPanel.add(printClassesAttr);
        printPanel.add(printRel);
        printPanel.add(backButton);
        printPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(printPanel);
    }

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

    public void createClassPanel(){
        //checks to see if the panel was already created
        panelCheck(createClassPanel);

        JLabel create = new JLabel("Enter Class:");
        create.setFont(new Font("Serif", Font.BOLD, 16));

        JTextField newClass = new JTextField();
        newClass.addActionListener(controller.createClassCall());


        createClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        createClassPanel.add(create);
        createClassPanel.add(newClass);
        createClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createClassPanel);

    }
    public void createdClassPanel(){
        panelCheck(createdClassPanel);
        JLabel label = new JLabel("Created the class");
        createdClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));

        JButton backButton = new JButton ("<--");
        backButton.addActionListener(controller.getClassPageListener());

        createdClassPanel.add(label);
        createdClassPanel.add(backButton);
        createdClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createdClassPanel);
    }

    public void removeClassPanel(){
        //checks to see if the panel was already created
        panelCheck(removeClassPanel);

        JLabel remove = new JLabel("Delete Class:");
        remove.setFont(new Font("Serif", Font.BOLD, 16));

        JTextField removeClass = new JTextField();
        removeClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        removeClassPanel.add(remove);
        removeClassPanel.add(removeClass);
        removeClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(removeClassPanel);
    }

    public void renameClassPanel(){
        //checks to see if the panel was already created
        panelCheck(renameClassPanel);

        JLabel rename = new JLabel("The Class to be renamed: ");
        JLabel newName = new JLabel("The Class's new name: ");
        
        rename.setFont(new Font("Serif", Font.BOLD, 16));
        newName.setFont(new Font("Serif", Font.BOLD, 16));

        JTextField renameClass = new JTextField();
        JTextField newNameClass = new JTextField();
        
        renameClassPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        renameClassPanel.add(rename);
        renameClassPanel.add(renameClass);
        renameClassPanel.add(newName);
        renameClassPanel.add(newNameClass);
        renameClassPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(renameClassPanel);
    }

    public void createRelPanel(){
        //checks to see if the panel was already created
        panelCheck(createRelPanel);

        JLabel type = new JLabel("Enter Type:");
        type.setFont(new Font("Serif", Font.BOLD, 16));
        JLabel source = new JLabel("Enter Source:");
        type.setFont(new Font("Serif", Font.BOLD, 16));
        JLabel dest = new JLabel("Enter Destination:");
        type.setFont(new Font("Serif", Font.BOLD, 16));
        JLabel ID = new JLabel("Enter Destination:");
        type.setFont(new Font("Serif", Font.BOLD, 16));

        JTextField typeText = new JTextField();
        JTextField sourceText = new JTextField();
        JTextField destText = new JTextField();
        JTextField IDText = new JTextField();

        createRelPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        createRelPanel.add(type);
        createRelPanel.add(typeText);
        createRelPanel.add(source);
        createRelPanel.add(sourceText);
        createRelPanel.add(dest);
        createRelPanel.add(destText);
        createRelPanel.add(ID);
        createRelPanel.add(IDText);
        createRelPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(createRelPanel);
    }

    public void removeRelPanel(){
        //checks to see if the panel was already created
        panelCheck(removeRelPanel);

        JLabel ID = new JLabel("Enter ID:");
        ID.setFont(new Font("Serif", Font.BOLD, 16));

        JTextField IDText = new JTextField();
        
        removeRelPanel = new JPanel(new GridLayout(8, 1, 8, 8));
        removeRelPanel.add(ID);
        removeRelPanel.add(IDText);
        removeRelPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        changePanel(removeRelPanel);
    }

    public void changeRelTypePanel(){
        //checks to see if the panel was already created
        panelCheck(changeRelTypePanel);

        JLabel type = new JLabel("Enter New Type:");
        type.setFont(new Font("Serif", Font.BOLD, 16));
        JLabel ID = new JLabel("Enter ID:");
        type.setFont(new Font("Serif", Font.BOLD, 16));

        JTextField typeText = new JTextField();
        JTextField IDText = new JTextField();
        
       changeRelTypePanel = new JPanel(new GridLayout(8, 1, 8, 8));
       changeRelTypePanel.add(type);
       changeRelTypePanel.add(typeText);
       changeRelTypePanel.add(ID);
       changeRelTypePanel.add(IDText);
       changeRelTypePanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
       changePanel(changeRelTypePanel);
    }

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
        umlEditor.setSize(400, 600);
        umlEditor.setVisible(true);

        menuPanel();

    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }

}
    }

    public static void main(String[] args) {

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
