import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UMLGUI implements ActionListener {
    private static JFrame umlEditor;
    private static JPanel menuPanel, classPanel, attrPanel, relPanel, printPanel;

    public static void menuPanel() {
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
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem help = new JMenuItem("Help");
        menu.add(save);
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